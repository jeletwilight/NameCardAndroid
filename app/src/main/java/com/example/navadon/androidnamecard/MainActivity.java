package com.example.navadon.androidnamecard;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBindingImpl binding;
    DatabaseReference dref ;


    private MyModel viewModel;

    public boolean change = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dref = FirebaseDatabase.getInstance().getReference();
        initView();

    }



    private void initView(){
        viewModel = new MyModel();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(viewModel);
    }

    public void changed(View view){
        Query userQuery = dref.child("Users");
        userQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String kuy = binding.EditName.getText().toString();
                    String nickname = dataSnapshot.child(kuy).getKey();
//                    String  h = dataSnapshot.child(kuy).child("Name").getValue(String.class);
//                    String name = dataSnapshot.child(kuy).child("Name").getValue(String.class);
//                    String name = dataSnapshot.child(kuy).child("Name").getValue(String.class);
//                    String name = dataSnapshot.child(kuy).child("Name").getValue(String.class);


                    viewModel.setImgSrc1(R.drawable.male);
                    viewModel.setColorSrc1(R.color.bluejele);
                    viewModel.setNickname(nickname);
                    viewModel.setName(getString(R.string.jj_name));
                    viewModel.setAddress(getString(R.string.jj_address));
                    viewModel.setPhone(getString(R.string.jj_phone));
                    viewModel.setEmail(getString(R.string.jj_email));
                    viewModel.setLine(getString(R.string.jj_line));

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
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                databaseError.getMessage();
            }
        });


    }


}
