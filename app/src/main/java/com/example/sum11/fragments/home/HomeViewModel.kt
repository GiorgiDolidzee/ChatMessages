package com.example.sum11.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sum11.model.Users
import com.example.sum11.network.Resource
import com.example.sum11.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: UsersRepository) : ViewModel() {

    private var _usersData = MutableSharedFlow<Resource<Users>>()
    var usersData: SharedFlow<Resource<Users>> = _usersData

    suspend fun loadUser() {
        viewModelScope.launch {
            repository.getUser().onEach {
                _usersData.emit(it)
            }.launchIn(viewModelScope)
        }
    }

}