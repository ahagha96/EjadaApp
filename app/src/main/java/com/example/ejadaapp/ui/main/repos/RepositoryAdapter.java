package com.example.ejadaapp.ui.main.repos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejadaapp.R;
import com.example.ejadaapp.data.Repo;
import com.example.ejadaapp.event.RepoClickedEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

    private List<Repo> repoList;

    public RepositoryAdapter(List<Repo> repoList) {
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public RepositoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryAdapter.ViewHolder holder, int position) {
        // load data
        holder.name.setText(repoList.get(position).name);
        holder.description.setText(repoList.get(position).description == null ? "" : repoList.get(position).description);
        holder.fork_count.setText(String.valueOf(repoList.get(position).forksCount));
        holder.license.setText(repoList.get(position).license == null ? "" : repoList.get(position).license.name);

        // click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new RepoClickedEvent(repoList.get(position).owner.login, repoList.get(position).name));
            }
        });
    }

    @Override
    public int getItemCount() {
        return (repoList == null) ? 0 : repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.repo_name)
        TextView name;

        @BindView(R.id.repo_desc)
        TextView description;

        @BindView(R.id.license)
        TextView license;

        @BindView(R.id.fork_count)
        TextView fork_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
