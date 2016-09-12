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

import java.util.ArrayList;

public class TextWatcherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_watcher);

        //Informa os valores a serem inseridos no ListView
        ListView listview = (ListView) findViewById(R.id.alunosListView);
        String[] values = new String[] {"João", "Maria", "José", "Emanuel", "Joaquin"};

        //Usa um laço "for" para adicionar os valores do array no ListView
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        //Cria o adapter, que serve para atualizar a lista
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                list);
        listview.setAdapter(adapter);

        //Recupera o que foi digitado no EditText e joga no filtro da lista para verificar os alunos
        EditText busca = (EditText) findViewById(R.id.buscaEditText);
        busca.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s.toString());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
    }
}
