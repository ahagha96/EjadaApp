package com.example.ejadaapp.ui.main.users.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ejadaapp.R
import com.example.ejadaapp.data.UserInfo
import com.example.ejadaapp.event.UserClickedEvent
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*
import org.greenrobot.eventbus.EventBus

class UserPagedAdapter: PagedListAdapter<UserInfo, UserPagedAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserInfo>() {
            override fun areItemsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
                return oldItem.id === newItem.id
            }

            override fun areContentsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
                return oldItem.id.equals(newItem.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // load info
        holder.itemView.user_name.text = getItem(position)!!.login
        holder.itemView.follower_count.text = getItem(position)!!.followers.toString()
        holder.itemView.repo_count.text = getItem(position)!!.public_repos.toString()
        // load image
        Picasso
                .get()
                .load(getItem(position)!!.avatar_url)
                .noFade()
                .placeholder(R.drawable.ic_person_grey_24dp)
                .into(holder.itemView.user_avatar)

        // click listener
        holder.itemView.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                EventBus.getDefault().post(UserClickedEvent(getItem(position)!!.login))
            }
        })
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}