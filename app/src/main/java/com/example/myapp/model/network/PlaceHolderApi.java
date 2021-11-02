package com.example.myapp.model.network;

import com.example.myapp.model.models.ToDoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PlaceHolderApi {

    @GET("todo/{tagPortalUserId}")
    Call<List<ToDoModel>> getList(@Path("tagPortalUserId") int tagPortalId);

    @FormUrlEncoded
    @POST("todo/{tagPortalUserId}")
    Call<ToDoModel> createList(
            @Field("taskName") String taskName,
            @Field("desc") String desc
    );

    @DELETE("todo/{tagPortalUserId}")
    Call<Void> deleteList(@Path("tagPortalUserId") int id);


    @PUT("todo/{tagPortalUserId}")
    Call<ToDoModel> putListy(@Body String name, @Body String des );


}
