package com.example.hp.listviewexample.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.listviewexample.R;
import com.example.hp.listviewexample.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public class PessoasCustomAdapter extends BaseAdapter {

    Context context;
    List<Pessoa> pessoas;
     
    public PessoasCustomAdapter(Context context, List<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {

        //ViewHolder - metodo criado para recuperar somente uma vez o nome e email
        ViewHolder holder = null;

        //linha de codigo padrão, prepara para abrir conforme o layout direcionado na linha 38
        LayoutInflater mInflater = (LayoutInflater)  context.getSystemService(
                Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            //recupera qual o layout para utilizar como exemplo
            convertView = mInflater.inflate(R.layout.item_pessoa, null);

            //recupera os nome e email
            holder = new ViewHolder();
            holder.nomeTextView = (TextView) convertView.findViewById(R.id.nomeTextView);
            holder.emailTextView = (TextView) convertView.findViewById(R.id.emailTextView);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Pessoa pessoaItem = (Pessoa) getItem(position);

        holder.nomeTextView.setText(pessoaItem.getNome());
        holder.emailTextView.setText(pessoaItem.getEmail());
         
        return convertView;
    }
 
    @Override
    public int getCount() {     
        return pessoas.size();
    }
 
    @Override
    public Object getItem(int position) {
        return pessoas.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return pessoas.indexOf(getItem(position));
    }



    /*private view holder class*/
    private class ViewHolder {
        TextView nomeTextView;
        TextView emailTextView;
    }
}