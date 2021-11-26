package com.example.sum11.fragments.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sum11.adapter.UsersAdapter
import com.example.sum11.databinding.FragmentHomeBinding
import com.example.sum11.fragments.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeViewModel : HomeViewModel by viewModels()
    private lateinit var usersAdapter: UsersAdapter

    override fun start() {
        initRecycler()
        observes()
    }

    private fun initRecycler() {
        usersAdapter = UsersAdapter()
        binding.usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = usersAdapter
        }
    }

    private fun observes() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.loadUser()
                homeViewModel.usersData.collect {
                    usersAdapter.setUsersData(it.data!!.toMutableList())
                }
            }
        }
    }

}