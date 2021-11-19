package com.codingambitions.androidrecyclerviewexamplekotlin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codingambitions.androidrecyclerviewexamplekotlin.databinding.UserBinding

class UsersRecyclerAdapter: ListAdapter<User, UsersRecyclerAdapter.UsersRecyclerViewHolder>(UsersDiffutilCallback()) {

    class UsersRecyclerViewHolder(val binding: UserBinding) : RecyclerView.ViewHolder(binding.root)

    class UsersDiffutilCallback: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersRecyclerViewHolder {
        val inflater = ContextCompat.getSystemService(parent.context,LayoutInflater::class.java) as LayoutInflater
        val binding  = UserBinding.inflate(inflater,parent,false)
        return UsersRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersRecyclerViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.userImageView.setImageDrawable(holder.binding.root.context.getDrawable(item.profilePic))
        holder.binding.userNameTextView.text = item.name
    }
}