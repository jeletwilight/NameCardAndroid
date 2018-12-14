package com.example.navadon.androidnamecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNew extends AppCompatActivity {

    EditText name,nickName,address,email,phone,line;
    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        dref = FirebaseDatabase.getInstance().getReference();

        name = findViewById(R.id.name);
        nickName = findViewById(R.id.nickName);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        line = findViewById(R.id.line);


    }

    public void save(View v){

        String n = name.getText().toString();
        String nn = nickName.getText().toString();
        String a = address.getText().toString();
        String e = email.getText().toString();
        String p = phone.getText().toString();
        String l = line.getText().toString();

        if(TextUtils.isEmpty(n)){
            Toast.makeText(this,"Please Fill your name ",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(nn)){
            Toast.makeText(this,"Please Fill your nickname ",Toast.LENGTH_SHORT).show();
            return;
        }if(TextUtils.isEmpty(a)){
            Toast.makeText(this,"Please Fill your address ",Toast.LENGTH_SHORT).show();
            return;
        }if(TextUtils.isEmpty(e)){
            Toast.makeText(this,"Please Fill your e-mail ",Toast.LENGTH_SHORT).show();
            return;
        }if(TextUtils.isEmpty(p)){
            Toast.makeText(this,"Please Fill your phone number ",Toast.LENGTH_SHORT).show();
            return;
        }if(TextUtils.isEmpty(l)){
            Toast.makeText(this,"Please Fill your line ID ",Toast.LENGTH_SHORT).show();
            return;
        }


        dref.child("Users").child(nn).child("Address").setValue(a);
        dref.child("Users").child(nn).child("Email").setValue(e);
        dref.child("Users").child(nn).child("Line").setValue(l);
        dref.child("Users").child(nn).child("Name").setValue(n);
        dref.child("Users").child(nn).child("Phone").setValue(p);

        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("search",nn);
        startActivity(intent);

    }

    public void back(View v){
        Intent intent = new Intent(this,OptionPage.class);
        startActivity(intent);
    }

}
