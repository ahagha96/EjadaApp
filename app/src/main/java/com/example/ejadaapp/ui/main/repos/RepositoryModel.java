package com.example.ejadaapp.ui.main.repos;

import com.example.ejadaapp.common.ViewModelInterface;
import com.example.ejadaapp.data.Repo;
import com.example.ejadaapp.event.ErrorEvent;
import com.example.ejadaapp.network.ApiProvider;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryModel {

    private ViewModelInterface viewModelInterface;

    public RepositoryModel(ViewModelInterface viewModelInterface) {
        this.viewModelInterface = viewModelInterface;
    }

    public void getRepo(String username){
        ApiProvider
                .getProvider()
                .getRepos(username)
                .enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        if (response.isSuccessful())
                            viewModelInterface.onResponse(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        EventBus.getDefault().post(new ErrorEvent());
                    }
                });
    }
}
