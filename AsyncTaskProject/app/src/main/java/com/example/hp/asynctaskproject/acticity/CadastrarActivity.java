package com.example.hp.asynctaskproject.acticity;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.asynctaskproject.R;
import com.example.hp.asynctaskproject.asynctask.CadastrarAluno;
import com.example.hp.asynctaskproject.entidade.Aluno;

public class CadastrarActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        //Recupera o botão
        Button buttonCadastrar = (Button) findViewById(R.id.cadastrarButton);
        buttonCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Recupera todos os campos de EditText da CadastrarActivity
        EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        EditText enderecoEditText = (EditText) findViewById(R.id.enderecoEditText);
        EditText cpfEditText = (EditText) findViewById(R.id.cpfEditText);

        String nome = nomeEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String endereco = enderecoEditText.getText().toString();
        String cpf = cpfEditText.getText().toString();

        //Set os atributos na entidade Aluno
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setEndereco(endereco);
        aluno.setCpf(cpf);

        //Chama classe para realizar a conexão com o servidor
        CadastrarAluno cadastrarAluno = new CadastrarAluno();
        cadastrarAluno.execute(aluno);
    }
}
