package com.example.sum11.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.sum11.R
import com.example.sum11.databinding.UserItemBinding
import com.example.sum11.extensions.setImage
import com.example.sum11.model.UsersItem

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var users = mutableListOf<UsersItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UsersViewHolder (
        UserItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = users.size

    inner class UsersViewHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: UsersItem
        @SuppressLint("SetTextI18n")
        fun onBind() {
            model = users[adapterPosition]
            binding.ivProfile.setImage(model.avatar)
            binding.tvName.text = model.firstName.plus(" ").plus(model.lastName)

            // Message type
            if(model.messageType == "text") {
                binding.tvMessage.text = model.lastMessage
            } else if (model.messageType == "attachment") {
                binding.ivAction.setImageResource(R.drawable.ic_attachment)
                binding.tvNoTextType.text = "Sent an attachment"
            } else {
                binding.ivAction.setImageResource(R.drawable.ic_recorder)
                binding.tvNoTextType.text = "Sent a voice message"
            }

            if(model.isTyping == false) {
                if(model.unreaMessage == 0) {
                    binding.tvMessageCount.isVisible = false
                    binding.ivUnreadMsgCount.isVisible = false
                } else {
                    binding.tvMessageCount.isVisible = true
                    binding.ivUnreadMsgCount.isVisible = true
                    binding.tvMessageCount.text = model.unreaMessage.toString()
                }
            } else {
                binding.tvMessageCount.isVisible = false
                binding.ivUnreadMsgCount.isVisible = false
                binding.tvMessage.setTextColor(Color.LTGRAY)
                binding.ivType1.setImageResource(R.color.typing)
                binding.ivType2.setImageResource(R.color.typing)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUsersData(users: MutableList<UsersItem>) {
        this.users.clear()
        this.users.addAll(users)
        notifyDataSetChanged()
    }
}