package com.example.mytry.util;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;

public class AplClient {
    public static  final String Base_URL="http://192.168.43.99:4000/graphql";
    private static ApolloClient mApolloClient;

    public static ApolloClient getmApolloClient() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .build();

        mApolloClient=ApolloClient.builder()
                .serverUrl(Base_URL)
                .okHttpClient(okHttpClient)
                .build();

        return mApolloClient;
    }
}
