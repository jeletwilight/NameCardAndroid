package com.example.navadon.androidnamecard;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navadon.androidnamecard.databinding.ActivityMainBindingImpl;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity {

    ActivityMainBindingImpl binding;
    DatabaseReference dref ;
    
    private MyModel viewModel;
    private int state = 0;
    public String kuy;
    public boolean change = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.start);
        dref = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        kuy = intent.getExtras().getString("search");
        initView();

        if(getIntent().getExtras() != null){
            change();
        }
    }

    public void onClick(View v) {
        Intent intend = new Intent(MainActivity.this,Kuy.class);
        startActivity(intend);
    }


    private void initView(){
        viewModel = new MyModel();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(viewModel);
    }

    public void change(){
        Query userQuery = dref.child("Users");
        userQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                   //String kuy = binding.EditName.getText().toString();
                    if (dataSnapshot.child(kuy).exists()) {
                        String nickname = dataSnapshot.child(kuy).getKey();
                        String add = dataSnapshot.child(kuy).child("Address").getValue(String.class);
                        String email = dataSnapshot.child(kuy).child("Email").getValue(String.class);
                        String line = dataSnapshot.child(kuy).child("Line").getValue(String.class);
                        String name = dataSnapshot.child(kuy).child("Name").getValue(String.class);
                        String phone = dataSnapshot.child(kuy).child("Phone").getValue(String.class);
                        int color = (int)((Math.random()*1000)%3) ;
                        switch (color) {
                            case 0 : viewModel.setColorSrc1(R.color.bluejele);
                                     break;
                            case 1 : viewModel.setColorSrc1(R.color.pinkjane);
                                    break;
                            case 2 : viewModel.setColorSrc1(R.color.black);
                                    break;
                        }
                        viewModel.setImgSrc1(R.drawable.male);
                        viewModel.setNickname(nickname);
                        viewModel.setName(name);
                        viewModel.setAddress(add);
                        viewModel.setPhone(phone);
                        viewModel.setEmail(email);
                        viewModel.setLine(line);

                        binding.imageView.setImageResource(viewModel.getImgSrc1());
                        binding.imageView3.setImageResource(viewModel.getColorSrc1());
                        binding.imageView4.setImageResource(viewModel.getColorSrc1());
                        binding.nickname.setText(viewModel.getNickname());
                        binding.name.setText(viewModel.getName());
                        binding.address.setText(viewModel.getAddress());
                        binding.phone.setText(viewModel.getPhone());
                        binding.email.setText(viewModel.getEmail());
                        binding.line.setText(viewModel.getLine());
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

    public void back(View v){
        Intent intent = new Intent(this,OptionPage.class);
        startActivity(intent);
    }

}
