package com.example.ejadaapp.ui.main.users.paging

import androidx.paging.PageKeyedDataSource
import com.example.ejadaapp.data.UserInfo
import com.example.ejadaapp.event.ErrorEvent
import com.example.ejadaapp.event.LoadingFinishEvent
import com.example.ejadaapp.network.ApiProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.EventBus

class UserForkedDataSource(var username: String, var repo_name: String): PageKeyedDataSource<Int, UserInfo>() {

    companion object {
        val PAGE_SIZE: Int = 10
        var SINCE: Int = 0
    }

    override fun loadInitial(params: PageKeyedDataSource.LoadInitialParams<Int>, callback: PageKeyedDataSource.LoadInitialCallback<Int, UserInfo>) {
        ApiProvider
                .getProvider()
                .getForkedUsers(username, repo_name, PAGE_SIZE, SINCE)
                .flatMap { repos ->
                    Observable.fromIterable(repos)
                            .map { ApiProvider.getProvider().getUserInfo(it.owner.login).blockingFirst() }
                }
                .toList()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<List<UserInfo>>(){
                    override fun onComplete() {
                        EventBus.getDefault().post(LoadingFinishEvent())
                    }

                    override fun onNext(t: List<UserInfo>) {
                        callback.onResult(t, null, SINCE + PAGE_SIZE)
                    }

                    override fun onError(e: Throwable) {
                        EventBus.getDefault().post(ErrorEvent())
                    }
                })

    }

    override fun loadBefore(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, UserInfo>) {
        ApiProvider
                .getProvider()
                .getForkedUsers(username, repo_name, PAGE_SIZE, SINCE)
                .flatMap { users ->
                    Observable.fromIterable(users)
                            .map { ApiProvider.getProvider().getUserInfo(it.owner.login).blockingFirst() }
                }
                .toList()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<List<UserInfo>>(){
                    override fun onComplete() {
                    }

                    override fun onNext(t: List<UserInfo>) {
                        val key = if (params.key > PAGE_SIZE) params.key - PAGE_SIZE else null
                        callback.onResult(t, key)
                    }

                    override fun onError(e: Throwable) {
                        EventBus.getDefault().post(ErrorEvent())
                    }
                })
    }

    override fun loadAfter(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, UserInfo>) {
        ApiProvider
                .getProvider()
                .getForkedUsers(username, repo_name, PAGE_SIZE, SINCE)
                .flatMap { users ->
                    Observable.fromIterable(users)
                            .map { ApiProvider.getProvider().getUserInfo(it.owner.login).blockingFirst() }
                }
                .toList()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<List<UserInfo>>(){
                    override fun onComplete() {
                    }

                    override fun onNext(t: List<UserInfo>) {
                        val key = if (!t.isEmpty()) params.key - PAGE_SIZE else null
                        callback.onResult(t, key)
                    }

                    override fun onError(e: Throwable) {
                        EventBus.getDefault().post(ErrorEvent())
                    }
                })
    }

}