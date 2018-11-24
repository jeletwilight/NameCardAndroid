package com.example.navadon.androidnamecard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean change = false;
    private TextView outputName,outputNickName,outputAddress,outputPhone,outputEmail,outputLine;
    private ImageView image,topBar,btmBar;

    // Only one OnclickListener is created to handle all onClick events.
    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn:
                    change = !change;
                    changed();
                    break;
            }
            hideKeyboardInput(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        initView();
    }

    private void bindView() {
        outputName = findViewById(R.id.name);
        outputNickName = findViewById(R.id.nickname);
        outputAddress = findViewById(R.id.address);
        outputEmail = findViewById(R.id.email);
        outputPhone = findViewById(R.id.phone);
        outputLine = findViewById(R.id.line);
        image = findViewById(R.id.imageView);
        topBar = findViewById(R.id.imageView3);
        btmBar = findViewById(R.id.imageView4);
    }

    private void initView(){
        findViewById(R.id.btn).setOnClickListener(onClickListener);
    }

    private void changed(){
        if(change == true) {
            outputName.setText(getResources().getString(R.string.jane_name));
            outputNickName.setText(getResources().getString(R.string.jane_nickname));
            outputAddress.setText(getResources().getString(R.string.jane_address));
            outputEmail.setText(getResources().getString(R.string.jane_email));
            outputPhone.setText(getResources().getString(R.string.jane_phone));
            outputLine.setText(getResources().getString(R.string.jane_line));
            image.setImageResource(R.drawable.female);
            topBar.setBackgroundColor(getResources().getColor(R.color.pinkjane));
            btmBar.setBackgroundColor(getResources().getColor(R.color.pinkjane));
        }else{
            outputNickName.setText(getResources().getString(R.string.jj_nickname));
            outputName.setText(getResources().getString(R.string.jj_name));
            outputAddress.setText(getResources().getString(R.string.jj_address));
            outputEmail.setText(getResources().getString(R.string.jj_email));
            outputPhone.setText(getResources().getString(R.string.jj_phone));
            outputLine.setText(getResources().getString(R.string.jj_line));
            image.setImageResource(R.drawable.male);
            topBar.setBackgroundColor(getResources().getColor(R.color.bluejele));
            btmBar.setBackgroundColor(getResources().getColor(R.color.bluejele));
        }
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

}
