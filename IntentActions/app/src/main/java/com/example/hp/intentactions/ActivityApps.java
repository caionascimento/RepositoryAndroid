package com.example.hp.intentactions;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.net.URI;

public class ActivityApps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_apps);

        final EditText URLTexto = (EditText) findViewById(R.id.URLEditText);
        Button URLButton = (Button) findViewById(R.id.URLButton);

        URLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URLTexto.getText().toString()));
                startActivity(intent);
            }
        });

        final EditText SMS = (EditText) findViewById(R.id.SMSEditText);
        Button SMSB = (Button) findViewById(R.id.SMSButton);
        SMSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new  Intent ( Intent.ACTION_VIEW );
                intent.setData ( Uri.parse ( "sms:" ));
                intent.setType ( "vnd.android-dir/mms-sms" );
                intent.putExtra ( Intent.EXTRA_TEXT ,  "" );
                intent.putExtra ( "address", SMS.getText().toString() );
                startActivity(intent);
            }
        });

        Button config = (Button) findViewById(R.id.configButton);
        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            }
        });

        Button music = (Button) findViewById(R.id.musicButton);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        Button maps = (Button) findViewById(R.id.MapButton);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.br/maps"));
                startActivity(intent);
            }
        });

        final EditText hour = (EditText) findViewById(R.id.hourEditText);
        final EditText minute = (EditText) findViewById(R.id.minuteEditText);
        Button alarm = (Button) findViewById(R.id.alarmButton);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm");
                i.putExtra(AlarmClock.EXTRA_HOUR, 10);
                i.putExtra(AlarmClock.EXTRA_MINUTES, 30);
                startActivity(i);
            }
        });
    }
}



