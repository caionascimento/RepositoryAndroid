package com.example.hp.asynctaskexample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView imagemCarregadaImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button carregarImagemButton = (Button) findViewById(R.id.carregarImagemButton);
        carregarImagemButton.setOnClickListener(this);
        imagemCarregadaImageView = (ImageView) findViewById(R.id.imagemCarregadaImageView);
    }

    @Override
    public void onClick(View view) {
        SyncTaskClass syncTaskClass = new SyncTaskClass(imagemCarregadaImageView);
        syncTaskClass.execute("http://br.web.img1.acsta.net/r_640_600/b_1_d6d6d6/pictures/15/05/06/16/13/020977.jpg");
    }
}
