package com.example.hp.listviewexample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AdicionaPessoaActivity extends Activity {

    public ArrayList<String> list;
    public ArrayAdapter adapter;
    public ListView listview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_pessoa);

        listview = (ListView) findViewById(R.id.contactListView);
        list = new ArrayList<String>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
    }

    //Metodo para onClick do button
    public void add (View view){

        //Recupera o que foi digitado no EditText (no caso o nome do contato)
        EditText contact = (EditText) findViewById(R.id.contactEditText);
        String name = contact.getText().toString();

        //Testa se ha algo escrito do EditText, se não tiver seta um erro, se não salva na lista
        if (name == null || (name.length() == 0)){
            contact.setError("Digite o nome do contato");
        } else {
            list.add(name);
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
            listview.setAdapter(adapter);
        }
    }
}
