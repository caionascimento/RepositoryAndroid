package com.example.hp.gsaplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PublicKey;

import static com.example.hp.gsaplication.R.id.txtEmail;
import static com.example.hp.gsaplication.R.id.txtSenha;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enter(View view){
        EditText txtEmail= (EditText) findViewById(R.id.txtEmail);
        EditText txtSenha= (EditText) findViewById(R.id.txtSenha);

        if(txtEmail.getText().length() == 0){
            txtEmail.setError("Campo vazio");

            if(txtSenha.getText().length() == 0){
                txtSenha.setError("Campo vazio");
            }
            else {
                Intent gstrocas = new Intent(this, WebActivity.class);
                startActivity(gstrocas);
            }
        }
        else {
            if(txtSenha.getText().length() == 0){
                txtSenha.setError("Campo vazio");
            }
            else {
                Intent gstrocas = new Intent(this, WebActivity.class);
                startActivity(gstrocas);
            }
        }
    }
}





