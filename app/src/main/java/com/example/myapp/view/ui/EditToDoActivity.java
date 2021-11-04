package com.example.myapp.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.model.ToDoRepository;
import com.example.myapp.model.network.WebServiceAPI;
import com.example.myapp.R;
import com.example.myapp.model.models.ToDoModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditToDoActivity extends AppCompatActivity {

    private TextView txt1;
    private TextView txt2;
    private Button button;
    private ToDoRepository toDoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put);
        txt1 = (TextView) findViewById(R.id.textView4);
        txt2 = (TextView) findViewById(R.id.textView5);
        button= (Button) findViewById(R.id.button3);


        toDoRepository = new ToDoRepository();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putList();
            }
        });

    }

    public void putList() {


        ToDoModel toDoModel = new ToDoModel();
        toDoModel.setmTaskName(txt1.getText().toString());
        toDoModel.setmDesc(txt2.getText().toString());
        toDoRepository.updateList(toDoModel);


    }
}