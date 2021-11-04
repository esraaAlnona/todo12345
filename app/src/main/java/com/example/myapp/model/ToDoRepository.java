package com.example.myapp.model;

import com.example.myapp.model.api.TodoImplementation;
import com.example.myapp.model.models.ToDoModel;

import java.util.List;

public class ToDoRepository extends TodoImplementation {


    public List<ToDoModel> getToDoList() {
        return getList();
    }

    public void addList(ToDoModel toDoModel){

        createList(toDoModel);
    }
    public void updateList(ToDoModel toDoModel){
        super.updateList(toDoModel);
    }



}
