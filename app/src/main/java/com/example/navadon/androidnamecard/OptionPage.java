package com.example.navadon.androidnamecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class OptionPage extends AppCompatActivity {
    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_page);

    }

    public void changed(View view){
        EditText name = findViewById(R.id.name_search);
        final String nameSearch = name.getText().toString();

        if (TextUtils.isEmpty(nameSearch)){
            Toast.makeText(this,"Please Fill your name ",Toast.LENGTH_SHORT).show();
            return;
        }



        Intent intent = new Intent(OptionPage.this,MainActivity.class);
        intent.putExtra("search",nameSearch);
        startActivity(intent);

    }

    public void add(View v){
        Intent intent = new Intent(this,AddNew.class);
        startActivity(intent);
    }

    public void back(View v){
        Intent intent = new Intent(this,Kuy.class);
        startActivity(intent);
    }
}
