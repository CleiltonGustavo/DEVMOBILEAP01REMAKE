package com.example.ap1remake.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.ap1remake.dao.TarefaDao;
import com.example.ap1remake.models.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract TarefaDao tarefaDao();
}
