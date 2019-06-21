package com.example.ejadaapp.ui.main.users.paging

import android.util.Log
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

class UserDataSource: PageKeyedDataSource<Int, UserInfo>() {

    companion object {
        val PAGE_SIZE: Int = 10
        val SINCE: Int = 0
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UserInfo>) {
        ApiProvider
                .getProvider()
                .getAllUsers(PAGE_SIZE, SINCE)
                .flatMap { users ->
                    Observable.fromIterable(users)
                            .map { ApiProvider.getProvider().getUserInfo(it.login).blockingFirst() }
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

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserInfo>) {
        ApiProvider
                .getProvider()
                .getAllUsers(PAGE_SIZE, params.key)
                .flatMap { users ->
                    Observable.fromIterable(users)
                            .map { ApiProvider.getProvider().getUserInfo(it.login).blockingFirst() }
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

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserInfo>) {
        ApiProvider
                .getProvider()
                .getAllUsers(PAGE_SIZE, params.key)
                .flatMap { users ->
                    Observable.fromIterable(users)
                            .map { ApiProvider.getProvider().getUserInfo(it.login).blockingFirst() }
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