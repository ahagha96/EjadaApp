package com.example.ejadaapp.network;

import com.example.ejadaapp.data.Repo;
import com.example.ejadaapp.data.User;
import com.example.ejadaapp.data.UserInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCalls {

    @GET("users")
    Observable<List<User>> getAllUsers(@Query("per_page") int page_size,
                                       @Query("since") int page);

    @GET("users/{username}")
    Observable<UserInfo> getUserInfo(@Path("username") String username);

    @GET("users/{username}/repos")
    Call<List<Repo>> getRepos(@Path("username") String username);

    @GET("repos/{username}/{repo}/forks")
    Observable<List<Repo>> getForkedUsers(@Path("username") String username,
                                          @Path("repo") String repo_name,
                                          @Query("per_page") int page_size,
                                          @Query("since") int page);
}
