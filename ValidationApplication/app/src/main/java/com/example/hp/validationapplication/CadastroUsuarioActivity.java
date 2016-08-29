package com.example.hp.validationapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroUsuarioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
    }

    public static boolean testeEmail (String emailTest) {
        if (emailTest == null) {
            return false;}
        else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(emailTest).matches();}
    }

    // Metodo para o botão "Cadastrar", valida os dados
    public void cadastrar (View view) {

        // Recupera os valores digitados para validação dos dados
        EditText emailCadastro = (EditText) findViewById(R.id.emailCadastroEditText);
        String emailTest = emailCadastro.getText().toString();

        EditText cpfCadastro = (EditText) findViewById(R.id.cpfCadastroEditText);
        String cpfTest = cpfCadastro.getText().toString();

        EditText senhaCadastro = (EditText) findViewById(R.id.senhaCadastroEditText);
        String senhaTest = senhaCadastro.getText().toString();

        // Testa a validação do email, senha e cpf
        if (testeEmail(emailTest)) {
            if (cpfTest == null || (cpfTest.length() == 0) || (cpfTest.length() > 11)) {
                cpfCadastro.setError("CPF inválido");
            } else {
                if (senhaTest == null || (senhaTest.length() == 0) || (senhaTest.length() < 5)) {
                    senhaCadastro.setError("Senha incorreta");
                } else {
                    Intent intent = new Intent(this, BemVindoActivity.class);
                    startActivity(intent);
                }
            }
        }

    }
}
