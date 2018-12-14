package com.example.navadon.androidnamecard;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Kuy extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuy);
//        TextView nextPage = findViewById(R.id.namecard);

    }

    public void nextPage(View v){
        Intent intent = new Intent(Kuy.this,OptionPage.class);
        startActivity(intent);
    }



}
