package com.example.ap1remake.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tarefa")
public class Tarefa {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "titulo")
    public String titulo;

    @ColumnInfo(name = "descricao")
    public String descricao;

    public Tarefa(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @NonNull
    @Override
    public String toString() {
        String nomeRetorno = this.titulo + " | " + this.descricao;
        return nomeRetorno;
    }
}
