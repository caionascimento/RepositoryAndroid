package com.example.hp.gsaplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LoadActivity extends AppCompatActivity /*implements Runnable*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        /*
        Handler handler = new Handler();
        handler.postDelayed(this, 4000);
        ImageView load = (ImageView) findViewById(R.id.loadGIF);
        Glide.with(this).load(R.drawable.giphy).asGif().into(load);
        */
    }

    /*
    @Override
    public void run() {
        startActivity(new Intent(this, WebActivity.class));
        finish();
    }
    */
}
