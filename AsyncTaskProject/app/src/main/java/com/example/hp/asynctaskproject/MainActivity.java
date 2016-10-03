package com.example.hp.asynctaskproject;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.asynctaskproject.asynctask.CadastrarAluno;
import com.example.hp.asynctaskproject.entidade.Aluno;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCadastrar = (Button) findViewById(R.id.cadastrarButton);
        buttonCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        EditText enderecoEditText = (EditText) findViewById(R.id.enderecoEditText);
        EditText cpfEditText = (EditText) findViewById(R.id.cpfEditText);

        String nome = nomeEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String endereco = enderecoEditText.getText().toString();
        String cpf = cpfEditText.getText().toString();

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setEndereco(endereco);
        aluno.setCpf(cpf);

        CadastrarAluno cadastrarAluno = new CadastrarAluno();
        cadastrarAluno.execute(aluno);
    }
}
