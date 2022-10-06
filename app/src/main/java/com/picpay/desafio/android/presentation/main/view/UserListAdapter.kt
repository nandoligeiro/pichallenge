package com.picpay.desafio.android.presentation.main.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.picpay.desafio.android.presentation.main.model.UiUser

class UserListAdapter : ListAdapter<UiUser, UserListItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UiUser>() {
            override fun areItemsTheSame(
                oldItem: UiUser, newItem: UiUser
            ) = oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: UiUser, newItem: UiUser
            ) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = UserListItemViewHolder.create(parent)

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
