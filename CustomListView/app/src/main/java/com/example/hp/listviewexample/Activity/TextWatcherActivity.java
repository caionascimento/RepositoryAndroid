package com.example.hp.listviewexample.Activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hp.listviewexample.R;
import com.example.hp.listviewexample.adapter.PessoasCustomAdapter;
import com.example.hp.listviewexample.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class TextWatcherActivity extends Activity implements TextWatcher {

    //adpter customizado criado para pessoas
    PessoasCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_watcher);

        //instanciar e adiciona os valores de pessoa
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("João", "joao@email.com"));
        pessoas.add(new Pessoa("Caio", "caio@email.com"));

        //Cria o adapter, que serve para atualizar a lista
        adapter = new PessoasCustomAdapter(this, pessoas);

        ListView listview = (ListView) findViewById(R.id.alunosListView);
        listview.setAdapter(adapter);

        //Recupera o que foi digitado no EditText e joga no filtro da lista para verificar os alunos
        EditText buscaEditText = (EditText) findViewById(R.id.buscaEditText);

        buscaEditText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
    }
}
