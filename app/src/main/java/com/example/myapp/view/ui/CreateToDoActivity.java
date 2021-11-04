package com.example.myapp.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.model.ToDoRepository;
import com.example.myapp.model.network.WebServiceAPI;
import com.example.myapp.R;
import com.example.myapp.model.models.ToDoModel;
import com.example.myapp.view.adapters.ToDoAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateToDoActivity extends AppCompatActivity {
    private ToDoRepository toDoRepository;

    private EditText desc;
    private EditText name;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_to_do);

        desc = findViewById(R.id.textView1);
        name = findViewById(R.id.textView2);
        send = findViewById(R.id.button);

        toDoRepository = new ToDoRepository();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createList();
            }
        });
    }

    public void createList(){

        ToDoModel toDoModel = new ToDoModel();
        toDoModel.setmDesc(desc.getText().toString());
        toDoModel.setmTaskName(name.getText().toString());

        toDoRepository.createList(toDoModel);
    }
}