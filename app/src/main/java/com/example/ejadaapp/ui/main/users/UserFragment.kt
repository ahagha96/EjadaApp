package com.example.ejadaapp.ui.main.users

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.ejadaapp.R
import com.example.ejadaapp.data.UserInfo
import com.example.ejadaapp.event.ErrorEvent
import com.example.ejadaapp.event.LoadingFinishEvent
import com.example.ejadaapp.ui.main.users.paging.UserPagedAdapter
import kotlinx.android.synthetic.main.user_fragment.*
import kotlinx.android.synthetic.main.user_fragment.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class UserFragment(var username: String?, var repo_name: String?) : Fragment() {

    private lateinit var viewModel: UserViewModel
    private var pagedAdapter: UserPagedAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.user_fragment, container, false)

        // init adapter
        pagedAdapter = UserPagedAdapter()
        // init recyclerview
        view.user_recyclerview.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        view.user_recyclerview.adapter = pagedAdapter

        return view
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
        pagedAdapter = null
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onEvent(errorEvent: ErrorEvent) {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        progressBar.visibility = GONE
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onEvent(finishEvent: LoadingFinishEvent) {
        progressBar.visibility = GONE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.setupPagedList(username, repo_name)

        viewModel.getUserPagedList().observe(this, object : Observer<PagedList<UserInfo>> {
            override fun onChanged(list: PagedList<UserInfo>?) {
                pagedAdapter!!.submitList(list)
            }
        })
    }
}
