package com.example.navadon.androidnamecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class OptionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_page);


    }

    public void changed(View view){
        EditText name = findViewById(R.id.name_search);
        String nameSearch = name.getText().toString();

        Intent intent = new Intent(OptionPage.this,MainActivity.class);
        intent.putExtra("search",nameSearch);
        startActivity(intent);
    }

    public void add(View v){
        Intent intent = new Intent(this,AddNew.class);
        startActivity(intent);
    }

    public void back(){
        Intent intent = new Intent(this,Kuy.class);
        startActivity(intent);
    }
}
