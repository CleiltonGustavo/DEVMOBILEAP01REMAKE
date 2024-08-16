package com.example.ap1remake;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ap1remake.models.Tarefa;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItensViewHolder> {
    private List<Tarefa> tarefasList;

    public ItemAdapter(List<Tarefa> tarefasList) { this.tarefasList = tarefasList; } //Construtor do Adapter

    public ItensViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItensViewHolder(itemView);
    }

    public void onBindViewHolder(ItensViewHolder holder, int position){
        Tarefa tarefas = tarefasList.get(position); //Pego um item da minha lista de entradas, e abaixo associarei valores aos campos de texto da tela de itens com a ajuda dos gets
        holder.tv_titulo.setText(tarefas.getTitulo());
        holder.tv_desc.setText(tarefas.getDescricao());
    }

    public int getItemCount() { return tarefasList.size(); }

    public static class ItensViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_titulo, tv_desc;

        public ItensViewHolder(View itemView) {
            super(itemView);

            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_desc = itemView.findViewById(R.id.tv_desc);


            tv_titulo.setOnClickListener(this);
            tv_desc.setOnClickListener(this);
        }

        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Você clicou no item: " + tv_titulo.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}