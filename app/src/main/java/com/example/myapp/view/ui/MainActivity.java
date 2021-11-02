package com.example.myapp.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapp.model.network.PlaceHolderApi;
import com.example.myapp.R;
import com.example.myapp.view.adapters.ToDoAdapter;
import com.example.myapp.model.models.ToDoModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private PlaceHolderApi placeHolderApi;
    private TextView textView;
    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.txt1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tagapps.tag.global/TAGPortal/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mrecyclerView = findViewById(R.id.recyclerView);
        mrecyclerView.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLayoutmanager);




        placeHolderApi = retrofit.create(PlaceHolderApi.class);
        getList();




    }
//////////////delete
    private void deleteList(int i) {
        Call<Void> call = placeHolderApi.deleteList(1);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("DELETE!");
                builder.setTitle("Alert !");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { finish(); }});builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) { dialog.cancel(); }});

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.goToPost:
                Intent intent = new Intent(MainActivity.this, CreateToDoActivity.class);
                startActivity(intent);
                return true;
        }

        return false;
    }

    private void getList() {
        Call<List<ToDoModel>>call = placeHolderApi.getList(7726);
        call.enqueue(new Callback<List<ToDoModel>>() {
            @Override
            public void onResponse(Call<List<ToDoModel>> call, Response<List<ToDoModel>> response) {
                if(response.isSuccessful()){
                    mAdapter = new ToDoAdapter((ArrayList<ToDoModel>) response.body(), MainActivity.this);
                    mrecyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    return;
                }
            }

            @Override
            public void onFailure(Call<List<ToDoModel>> call, Throwable t) {

            }
        });
    }


}

