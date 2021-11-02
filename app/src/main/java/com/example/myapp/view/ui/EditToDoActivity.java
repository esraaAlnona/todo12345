package com.example.myapp.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.model.network.PlaceHolderApi;
import com.example.myapp.R;
import com.example.myapp.model.models.ToDoModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditToDoActivity extends AppCompatActivity {
private PlaceHolderApi placeHolderApi;
    private TextView txt1;
    private TextView txt2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put);
        txt1= (TextView) findViewById(R.id.textView4);
        txt2 = (TextView) findViewById(R.id.textView5);
        button = (Button) findViewById(R.id.button3);


        String userTask = getIntent().getStringExtra("task");
        txt1.setText(userTask);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             putListy();
            }
        });

    }

    public void putListy() {
        ToDoModel toDo = new ToDoModel("esraa","eeee",1,7);
        Call<ToDoModel> call = placeHolderApi.putListy("esraa","ssss");
        call.enqueue(new Callback<ToDoModel>() {
            @Override
            public void onResponse(Call<ToDoModel> call, Response<ToDoModel> response) {
                if(!response.isSuccessful()){
                    ToDoModel tOdo = response.body();
                    txt1.append(tOdo.getmTaskName());
                    txt2.append(tOdo.getmDesc());
                }

            }

            @Override
            public void onFailure(Call<ToDoModel> call, Throwable t) {

            }
        });


    }
}