package com.example.myapp.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.myapp.model.network.PlaceHolderApi;
import com.example.myapp.R;
import com.example.myapp.model.models.ToDoModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateToDoActivity extends AppCompatActivity {
    private PlaceHolderApi placeHolderApi;
    private EditText txt1;
    private EditText txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_to_do);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tagapps.tag.global/TAGPortal/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        placeHolderApi = retrofit.create(PlaceHolderApi.class);


        txt1= (EditText) findViewById(R.id.textView1);
        txt2 = (EditText) findViewById(R.id.textView2);
        createPost();



    }
    public void createPost(){

        ToDoModel toDo = new ToDoModel("esraa","new title",2,6654);// what i want to send to server

        Call<ToDoModel> call = placeHolderApi.createList("esraa","ssssss");
        call.enqueue(new Callback<ToDoModel>() {
            @Override
            public void onResponse(Call<ToDoModel> call, Response<ToDoModel> response) {
                if(response.isSuccessful()){

                ToDoModel myTodoResponse = response.body();

                String content1 = "";
                String content2 = "";

                content1 += "Task Name        " + myTodoResponse.getmTaskName() + "\n";
                content2 += "Desc             " + myTodoResponse.getmDesc() + "\n";
                txt1.append(content1);
                txt2.append(content2);

            }}

            @Override
            public void onFailure(Call<ToDoModel> call, Throwable t) {

            }
        });

    }
}