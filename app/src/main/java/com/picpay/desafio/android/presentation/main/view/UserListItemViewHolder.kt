package com.picpay.desafio.android.presentation.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.presentation.main.model.UiUser
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class UserListItemViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): UserListItemViewHolder {
            val binding =
                ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return UserListItemViewHolder(binding)
        }
    }

    fun bind(user: UiUser) {
        binding.run {
            name.text = user.name
            username.text = user.username
            progressBar.visibility = View.VISIBLE

            Picasso.get()
                .load(user.img)
                .error(R.drawable.ic_round_account_circle)
                .into(picture, object : Callback {
                    override fun onSuccess() {
                        progressBar.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        progressBar.visibility = View.GONE
                    }
                })
        }
    }
}