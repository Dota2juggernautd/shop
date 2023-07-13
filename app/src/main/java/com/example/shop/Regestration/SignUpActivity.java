package com.example.shop.Regestration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shop.R;

public class SignUpActivity extends AppCompatActivity {
    EditText email_user,full_name,password;
    Button sign_in;


    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
        onClick();


    }
    public void onClick (){
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email_user.getText().toString().trim().isEmpty() && !password.getText().toString().trim().isEmpty() && !full_name.getText().toString().trim().isEmpty() ) {
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("email_user", email_user.getText().toString());
                    myEdit.putString("full_name", full_name.getText().toString());
                    myEdit.putString("password", password.getText().toString());
                    myEdit.apply();
                    Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(intent);
                    Log.d("email",email_user.getText().toString());
                    Log.d("password",password.getText().toString());
                    Log.d("full name",full_name.getText().toString());
                }else {
                    Toast.makeText(SignUpActivity.this, "Please write all  poly", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private  void initView(){
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        email_user = findViewById(R.id.email);
        full_name = findViewById(R.id.full_name);
        password = findViewById(R.id.password);
        sign_in = findViewById(R.id.sign_in);


    }

}