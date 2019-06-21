package com.example.ejadaapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ejadaapp.R;
import com.example.ejadaapp.event.RepoClickedEvent;
import com.example.ejadaapp.event.UserClickedEvent;
import com.example.ejadaapp.ui.main.repos.RepositoryFragment;
import com.example.ejadaapp.ui.main.users.UserFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.container)
    FrameLayout frameLayout;

    // default fragment
    private UserFragment userFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // set title
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ejada");

        // init default fragment
        userFragment = new UserFragment(null, null); // no username and repo_name for default user fragment

        // set default fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, userFragment)
                .commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        userFragment = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserClickedEvent userClicked){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new RepositoryFragment(userClicked.getLogin()))
                .addToBackStack("Repo" + userClicked.getLogin())
                .commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(RepoClickedEvent repoClicked){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new UserFragment(repoClicked.getUsername(), repoClicked.getRepo_name()))
                .addToBackStack("Repo" + repoClicked.getUsername())
                .commit();
    }
}
