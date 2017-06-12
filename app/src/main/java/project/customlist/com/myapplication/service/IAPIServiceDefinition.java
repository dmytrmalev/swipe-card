package project.customlist.com.myapplication.service;

/**
 * Created by Admin on 3/20/2016.
 */

import project.customlist.com.myapplication.card.CardResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface IAPIServiceDefinition {
    @GET("/v1/orgs/56edbcbf7330d803004a7f2a/users/me/feed")
    void getFeed(Callback<CardResponse> response);
}
