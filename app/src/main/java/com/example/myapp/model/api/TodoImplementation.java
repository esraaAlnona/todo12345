package com.example.myapp.model.api;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.TagPortalApp;
import com.example.myapp.model.ToDoRepository;
import com.example.myapp.model.models.ToDoModel;
import com.example.myapp.model.network.ApiClient;
import com.example.myapp.model.network.WebServiceAPI;
import com.example.myapp.view.adapters.ToDoAdapter;
import com.example.myapp.view.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class TodoImplementation implements TodoInterface {
    private EditText txt1;
    private EditText txt2;
    private RecyclerView.Adapter mAdapter;
    private ToDoRepository toDoRepository;
    private Context context;



    @Override
    public List<ToDoModel> getList() {
        ArrayList<ToDoModel> myList = new ArrayList<ToDoModel>();


        Call<List<ToDoModel>> call = ApiClient.apiClient(TagPortalApp.getInstance().getApplicationContext()).getList(7726);

        call.enqueue(new Callback<List<ToDoModel>>() {
            @Override
            public void onResponse(Call<List<ToDoModel>> call, Response<List<ToDoModel>> response) {
                if(response.isSuccessful()){
                    myList.addAll(response.body());
                    return;
                }
            }

            @Override
            public void onFailure(Call<List<ToDoModel>> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });
        return myList;

    }

    @Override
    public void createList(ToDoModel toDoModel) {
        Call<ToDoModel> call = ApiClient.apiClient(TagPortalApp.getInstance().getApplicationContext()).createList(toDoModel);
        call.enqueue(new Callback<ToDoModel>() {
            @Override
            public void onResponse(Call<ToDoModel> call, Response<ToDoModel> response) {
               if(response.isSuccessful()){



               }}

           @Override
            public void onFailure(Call<ToDoModel> call, Throwable t) {

           }
       });

    }

    @Override
    public void updateList(ToDoModel toDoModel) {
        Call<ToDoModel> call = ApiClient.apiClient(TagPortalApp.getInstance().getApplicationContext()).putListy(toDoModel);
       call.enqueue(new Callback<ToDoModel>() {
           @Override
            public void onResponse(Call<ToDoModel> call, Response<ToDoModel> response) {
               if(response.isSuccessful()){
                }

         }

            @Override
           public void onFailure(Call<ToDoModel> call, Throwable t) {

           }
        });

    }

    @Override
    public void deleteList(int id) {


    }
}
