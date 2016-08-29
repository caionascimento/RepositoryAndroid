package com.example.hp.validationapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    String E="teste@mail.com";
    String S="12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // Metodo para o botão "Login", valida os dados
    public void logar (View view){

        // Recupera os valores digitados para validação dos dados
        EditText emailLogin = (EditText) findViewById(R.id.emailLoginEditText);
        String emailTest = emailLogin.getText().toString();

        EditText senhaLogin = (EditText) findViewById(R.id.senhaLoginEditText);
        String senhaTest = senhaLogin.getText().toString();

        // Testa se o email e senha estão corretos
        // Se estiver correto abre nova Activity
        if (emailTest.equals(E) && senhaTest.equals(S)) {
            Intent intent = new Intent(this, BemVindoActivity.class);
            startActivity(intent);}

        // Se estiver incorreto informa o erro
        else {
            if (!emailTest.equals("teste@mail.com")){
                emailLogin.setError("Email Incorreto");}
            if (!senhaTest.equals("12345")){
                senhaLogin.setError("Senha Incorreta");}
        }
    }

    // Metodo para o botão "Cadastro", abre Activity
    public void cadastrar (View view){
        Intent intent = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(intent);
    }
}
