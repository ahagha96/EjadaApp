package com.example.ejadaapp.ui.main.repos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ejadaapp.R;
import com.example.ejadaapp.data.Repo;
import com.example.ejadaapp.event.ErrorEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoryFragment extends Fragment {

    //----- views -----//
    @BindView(R.id.repo_recyclerview)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private RepositoryViewModel mViewModel;
    private String username;
    private RepositoryAdapter adapter;

    public RepositoryFragment(String username) {
        this.username = username;
    }

    // empty constructor
    public RepositoryFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repository_fragment, container, false);
        ButterKnife.bind(this, view);

        // init recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ErrorEvent errorEvent) {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RepositoryViewModel.class);
        mViewModel.getListOfRepository(username);

        mViewModel.getRepoLiveData().observe(this, new Observer<List<Repo>>() {
            @Override
            public void onChanged(List<Repo> repoList) {
                if (adapter == null) {
                    adapter = new RepositoryAdapter(repoList);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        adapter = null;
        progressBar = null;
        recyclerView = null;
    }
}
