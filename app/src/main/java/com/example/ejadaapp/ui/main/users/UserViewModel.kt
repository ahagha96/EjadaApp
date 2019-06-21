package com.example.ejadaapp.ui.main.users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.ejadaapp.data.UserInfo
import com.example.ejadaapp.ui.main.users.paging.UserDataSource
import com.example.ejadaapp.ui.main.users.paging.UserDataSourceFactory

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var userPagedList: LiveData<PagedList<UserInfo>>? = null
    private var liveDataSource: LiveData<PageKeyedDataSource<Int, UserInfo>>? = null

    fun setupPagedList(username: String?, repo_name: String?) {
        val factory = UserDataSourceFactory(username, repo_name)
        liveDataSource = factory.getLiveData()

        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(UserDataSource.PAGE_SIZE)
                .build()

        userPagedList = LivePagedListBuilder(factory, config).build()
    }

    fun getUserPagedList(): LiveData<PagedList<UserInfo>> {
        return userPagedList!!
    }

}
