package com.example.myapp.model.api;

import com.example.myapp.model.models.ToDoModel;

import java.util.List;

public interface TodoInterface {

    public List<ToDoModel> getList();

    public void createList(ToDoModel toDoModel);

    public void updateList(ToDoModel toDoModel);

    public void deleteList(int id);
}
