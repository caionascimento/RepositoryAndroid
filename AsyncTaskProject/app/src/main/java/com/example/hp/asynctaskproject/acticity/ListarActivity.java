package com.example.hp.asynctaskproject.acticity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.hp.asynctaskproject.R;
import com.example.hp.asynctaskproject.asynctask.CadastrarAluno;
import com.example.hp.asynctaskproject.asynctask.ListarAluno;

public class ListarActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
    }

    @Override
    public void onClick(View v) {
        //Chama a AsyncTask para conexão com a lista
        final String url = "http://ladoss.info:8773/Convite_SERVICE/convidado/listar";
        new ListarAluno().execute(url);
    }
}
