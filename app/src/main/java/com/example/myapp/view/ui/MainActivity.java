package com.example.myapp.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapp.model.ToDoRepository;
import com.example.myapp.model.api.TodoImplementation;
import com.example.myapp.model.network.WebServiceAPI;
import com.example.myapp.R;
import com.example.myapp.view.adapters.ToDoAdapter;
import com.example.myapp.model.models.ToDoModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;
    private TodoImplementation todoImplementation;

    private ToDoRepository toDoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toDoRepository = new ToDoRepository();

        textView = (TextView) findViewById(R.id.txt1);



        mrecyclerView = findViewById(R.id.recyclerView);
        mrecyclerView.setHasFixedSize(true);
        mLayoutmanager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLayoutmanager);








        getList();




    }



    //////////////delete
   /* private void deleteList(int i) {
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
*/
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

        mAdapter = new ToDoAdapter((ArrayList<ToDoModel>) toDoRepository.getList(), this);
        mAdapter.notifyDataSetChanged();
    }


}

