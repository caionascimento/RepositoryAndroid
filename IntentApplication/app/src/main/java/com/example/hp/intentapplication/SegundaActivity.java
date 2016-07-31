package com.example.hp.intentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        TextView resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);
        Bundle bundle = getIntent().getExtras();
        resultadoTextView.setText(bundle.getString("informa"));
    }
}
