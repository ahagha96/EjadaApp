package com.example.ejadaapp.network;

public class ApiProvider {

    public static ApiCalls provider = null ;

    public static ApiCalls getProvider(){
        if (provider == null)
            provider = ApiClient.getApiClient().create(ApiCalls.class);
        return provider;
    }

}
