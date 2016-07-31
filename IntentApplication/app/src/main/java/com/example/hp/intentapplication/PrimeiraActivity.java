package com.example.hp.intentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrimeiraActivity extends AppCompatActivity {

    private EditText nomeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        Button enviarButton = (Button) findViewById(R.id.enviarButton);
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executar();
            }

        });
    }

    private void executar() {

        Toast.makeText(PrimeiraActivity.this, "Ola " + nomeEditText.getText(), Toast.LENGTH_SHORT).show();

        Intent novaTela = new Intent(this,SegundaActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("informa",nomeEditText.getText().toString());
        novaTela.putExtras(bundle);

        startActivity(novaTela);
    }

}






