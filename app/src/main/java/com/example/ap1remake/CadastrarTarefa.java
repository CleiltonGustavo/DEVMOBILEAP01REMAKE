package com.example.ap1remake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ap1remake.database.AppDataBase;
import com.example.ap1remake.models.Tarefa;

import java.util.List;

public class CadastrarTarefa extends AppCompatActivity {

    private EditText et_Tarefa, et_Desc;
    Button btn_Salvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_tarefa);

        btn_Salvar = findViewById(R.id.btn_Salvar);
        et_Tarefa = findViewById(R.id.et_Tarefa);
        et_Desc = findViewById(R.id.et_Desc);

        //Botão que leva de volta à MainActivy com os dados inseridos pelo usuário
        btn_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorParaTitulo = et_Tarefa.getText().toString();
                String valorParaDesc = et_Desc.getText().toString();
                Intent chamaMainActivity = new Intent(CadastrarTarefa.this, MainActivity.class);
                chamaMainActivity.putExtra("valorPassadoTitulo", valorParaTitulo);
                chamaMainActivity.putExtra("valorPassadoDesc", valorParaDesc);
                startActivity(chamaMainActivity);
            }
        });
    }
}