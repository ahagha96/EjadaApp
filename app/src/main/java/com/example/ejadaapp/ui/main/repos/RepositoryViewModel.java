package com.example.ejadaapp.ui.main.repos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ejadaapp.common.ViewModelInterface;
import com.example.ejadaapp.data.Repo;

import java.util.List;

public class RepositoryViewModel extends AndroidViewModel implements ViewModelInterface {

    private MutableLiveData<List<Repo>> listLiveData;
    private RepositoryModel model;

    public RepositoryViewModel(@NonNull Application application) {
        super(application);
        listLiveData = new MutableLiveData<>();
        model = new RepositoryModel(this);
    }

    public void getListOfRepository(String username){
        model.getRepo(username);
    }

    @Override
    public void onResponse(List<Repo> repoList) {
        listLiveData.postValue(repoList);
    }

    public MutableLiveData<List<Repo>> getRepoLiveData(){
        return listLiveData;
    }
}
