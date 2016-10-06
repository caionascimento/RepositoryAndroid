package com.example.hp.asynctaskproject.acticity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.asynctaskproject.R;
import com.example.hp.asynctaskproject.asynctask.CadastrarAluno;
import com.example.hp.asynctaskproject.asynctask.ListarAluno;
import com.example.hp.asynctaskproject.entidade.Aluno;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recupera os botoes
        Button buttonListar = (Button) findViewById(R.id.listarSplashButton);
        buttonListar.setOnClickListener(this);

        Button buttonCadastrar = (Button) findViewById(R.id.cadastrarSplashButton);
        buttonCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Testa qual o botão que seja clicado e faz a inteção de nova tela
        int id = view.getId();

        if (id == R.id.listarSplashButton) {
            Intent intent = new Intent(this, ListarActivity.class);
            startActivity(intent);

        } else if (id == R.id.cadastrarSplashButton) {
            Intent intent = new Intent(this, CadastrarActivity.class);
            startActivity(intent);
        }

    }
}
