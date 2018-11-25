package com.example.navadon.androidnamecard;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navadon.androidnamecard.databinding.ActivityMainBindingImpl;

public class MainActivity extends AppCompatActivity {

    ActivityMainBindingImpl binding;

    private MyModel viewModel;

    public boolean change = false;
    //private TextView outputName,outputNickName,outputAddress,outputPhone,outputEmail,outputLine;
    //private ImageView image,topBar,btmBar;

    // Only one OnclickListener is created to handle all onClick events.
    /*private final View.OnClickListener onClickListener = new View.OnClickListener() {
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
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bindView();
        initView();

    }

    private void bindView() {
        /*outputName = findViewById(R.id.name);
        outputNickName = findViewById(R.id.nickname);
        outputAddress = findViewById(R.id.address);
        outputEmail = findViewById(R.id.email);
        outputPhone = findViewById(R.id.phone);
        outputLine = findViewById(R.id.line);
        image = findViewById(R.id.imageView);
        topBar = findViewById(R.id.imageView3);
        btmBar = findViewById(R.id.imageView4);
        */
    }

    private void initView(){
        viewModel = new MyModel();
        //findViewById(R.id.btn).setOnClickListener(onClickListener);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(viewModel);
    }

    public void changed(View view){
        change = !change;
        if(this.change) {
            /*outputName.setText(getResources().getString(R.string.jane_name));
            outputNickName.setText(getResources().getString(R.string.jane_nickname));
            outputAddress.setText(getResources().getString(R.string.jane_address));
            outputEmail.setText(getResources().getString(R.string.jane_email));
            outputPhone.setText(getResources().getString(R.string.jane_phone));
            outputLine.setText(getResources().getString(R.string.jane_line));
            image.setImageResource(R.drawable.female);
            topBar.setBackgroundColor(getResources().getColor(R.color.pinkjane));
            btmBar.setBackgroundColor(getResources().getColor(R.color.pinkjane));*/
            viewModel.setImgSrc1(R.drawable.female);
            viewModel.setColorSrc1(R.color.pinkjane);
            viewModel.setNickname(getString(R.string.jane_nickname));
            viewModel.setName(getString(R.string.jane_name));
            viewModel.setAddress(getString(R.string.jane_address));
            viewModel.setPhone(getString(R.string.jane_phone));
            viewModel.setEmail(getString(R.string.jane_email));
            viewModel.setLine(getString(R.string.jane_line));
        }else{
            /*outputNickName.setText(getResources().getString(R.string.jj_nickname));
            outputName.setText(getResources().getString(R.string.jj_name));
            outputAddress.setText(getResources().getString(R.string.jj_address));
            outputEmail.setText(getResources().getString(R.string.jj_email));
            outputPhone.setText(getResources().getString(R.string.jj_phone));
            outputLine.setText(getResources().getString(R.string.jj_line));
            image.setImageResource(R.drawable.male);
            topBar.setBackgroundColor(getResources().getColor(R.color.bluejele));
            btmBar.setBackgroundColor(getResources().getColor(R.color.bluejele));*/
            viewModel.setImgSrc1(R.drawable.male);
            viewModel.setColorSrc1(R.color.bluejele);
            viewModel.setNickname(getString(R.string.jj_nickname));
            viewModel.setName(getString(R.string.jj_name));
            viewModel.setAddress(getString(R.string.jj_address));
            viewModel.setPhone(getString(R.string.jj_phone));
            viewModel.setEmail(getString(R.string.jj_email));
            viewModel.setLine(getString(R.string.jj_line));
        }
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

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

}
