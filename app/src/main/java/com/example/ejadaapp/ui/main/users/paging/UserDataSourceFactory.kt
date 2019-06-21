package com.example.ejadaapp.ui.main.users.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.ejadaapp.data.UserInfo

class UserDataSourceFactory(var username: String?, var repo_name: String?): DataSource.Factory<Int, UserInfo>() {

    val userListLiveData: MutableLiveData<PageKeyedDataSource<Int, UserInfo>> = MutableLiveData()

    override fun create(): DataSource<Int, UserInfo> {
        var userDataSource: PageKeyedDataSource<Int, UserInfo>? = null;

        if (username == null || repo_name == null) {
            userDataSource = UserDataSource() // starting page
        } else {
            userDataSource = UserForkedDataSource(username!!, repo_name!!) // forked users
        }
        userListLiveData.postValue(userDataSource)
        return userDataSource
    }

    fun getLiveData(): MutableLiveData<PageKeyedDataSource<Int, UserInfo>> {
        return userListLiveData
    }

}
