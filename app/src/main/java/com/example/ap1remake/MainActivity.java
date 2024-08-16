package com.example.ap1remake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ap1remake.dao.TarefaDao;
import com.example.ap1remake.database.AppDataBase;
import com.example.ap1remake.models.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    Button btn_CriarNova;

    private List<Tarefa> tarefasList;

    ItemAdapter itensAdapter;
    String valorTitulo, valorDesc;

    private AppDataBase appDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_CriarNova = findViewById(R.id.btn_criarNova);

        recyclerView = findViewById(R.id.rv_itens);

        tarefasList = new ArrayList<>();


        //Pega os dados enviados da Activity CadastrarTarefa
        Intent dado_enviado = getIntent();
        valorTitulo = dado_enviado.getStringExtra("valorPassadoTitulo");
        valorDesc = dado_enviado.getStringExtra("valorPassadoDesc");


        appDatabase = Room.databaseBuilder(this, AppDataBase.class, "db_tarefas")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        TarefaDao tarefaDao = appDatabase.tarefaDao();

        List<Tarefa> tarefasDoBd = tarefaDao.getAllTarefas();
        for(Tarefa t : tarefasDoBd){
            Log.d("sid-tag", t.toString());
        }


        tarefasList = tarefasDoBd;

        itensAdapter = new ItemAdapter(tarefasList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itensAdapter);

        //Confere se os dados estão vazios, se não estiverem insere-os na lista e no banco de dados
        if (valorTitulo != null && valorDesc != null){
            Tarefa ta = new Tarefa(valorTitulo, valorDesc);
            tarefasList.add(ta);
            tarefaDao.insertAll(ta);
            itensAdapter.notifyDataSetChanged();
        }


        //Botão que leva à Activy CadastrarTarefa
        btn_CriarNova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamaCadastrarTarefa = new Intent(MainActivity.this, CadastrarTarefa.class);
                startActivity(chamaCadastrarTarefa);
            }
        });
    }
}