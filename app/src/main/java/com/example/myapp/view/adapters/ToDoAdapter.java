package com.example.myapp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.model.ToDoRepository;
import com.example.myapp.model.models.ToDoModel;
import com.example.myapp.view.ui.CreateToDoActivity;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoAdapterViewHolder> {
    private ArrayList<ToDoModel> mTodo;
    private Context context;
    private ToDoModel mtoDoModel;
    ToDoRepository mtoDoRepository;

    public ToDoAdapter(ArrayList<ToDoModel> tasksList, Context context){
        mTodo = tasksList;
        this.context = context;
    }


    @NonNull
    @Override
    public ToDoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout,parent,false);
        ToDoAdapterViewHolder newsAdapterViewHolder = new ToDoAdapterViewHolder (view);
        return newsAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoAdapterViewHolder holder, int position) {
        ToDoModel toDo= mTodo.get(position);
        holder.mUserId.setText(toDo.getmUserId());
        holder.mTaskName.setText(toDo.getmTaskName());
        holder.mDesc.setText(toDo.getmDesc());
        holder.mStatus.setText(toDo.getmStatus());

        /////////Delete
        holder.dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleteList(5);

            }
        });

        /////////Update
        holder.uButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String task = textView.getText().toString();
//                Intent intent = new Intent(MainActivity.this,PutActivity.class);
//                intent.putExtra("task",task);
//                startActivity(intent);
//                finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTodo.size();
    }

    public static class ToDoAdapterViewHolder extends RecyclerView.ViewHolder{

        public TextView mUserId;
        public TextView mTaskName;
        public TextView mDesc;
        public TextView mStatus;
        private Button uButton;
        private Button dButton;

        public ToDoAdapterViewHolder(View view){
            super(view);
            mUserId = view.findViewById(R.id.txt1);
            dButton =  view.findViewById(R.id.btn1);
            uButton =  view.findViewById(R.id.btn2);

        }
    }
}
