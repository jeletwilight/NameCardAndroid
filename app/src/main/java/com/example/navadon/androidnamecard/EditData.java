package com.example.navadon.androidnamecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EditData extends AppCompatActivity {

    DatabaseReference dref ;

    public String edit;
    EditText name,nickName,address,email,phone,line;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        Button save = findViewById(R.id.save);
        Button back = findViewById(R.id.back);
        Button add = findViewById(R.id.add);

        name = findViewById(R.id.name);
        nickName = findViewById(R.id.nickName);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        line = findViewById(R.id.line);



        dref = FirebaseDatabase.getInstance().getReference();





        Intent intent = getIntent();
        edit = intent.getExtras().getString("nameEdit");

        if(getIntent().getExtras() != null){
            Query userQuery = dref.child("Users");
            userQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        if (dataSnapshot.child(edit).exists()) {
                            String nickname1 = dataSnapshot.child(edit).getKey();
                            String add1 = dataSnapshot.child(edit).child("Address").getValue(String.class);
                            String email1 = dataSnapshot.child(edit).child("Email").getValue(String.class);
                            String line1 = dataSnapshot.child(edit).child("Line").getValue(String.class);
                            String name1 = dataSnapshot.child(edit).child("Name").getValue(String.class);
                            String phone1 = dataSnapshot.child(edit).child("Phone").getValue(String.class);

                            name.setText(name1);
                            nickName.setText(nickname1);
                            address.setText(add1);
                            email.setText(email1);
                            phone.setText(phone1);
                            line.setText(line1);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "NOT EXIS",Toast.LENGTH_SHORT).show();
                        }
                    }


                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    databaseError.getMessage();
                }
            });

        }


    }

    public void toEdit(){
        EditText name = findViewById(R.id.name_search);
        String nameSearch = name.getText().toString();

        Intent intent = new Intent(EditData.this,MainActivity.class);
        intent.putExtra("search",nameSearch);
        startActivity(intent);



    }

    public void toSave(View v){
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


    public void toAdd(View v){
        Intent intent = new Intent(this,AddNew.class);
        startActivity(intent);
    }

    public void toBack(View v){
        Intent intent = new Intent(this,Kuy.class);
        startActivity(intent);
    }
}
