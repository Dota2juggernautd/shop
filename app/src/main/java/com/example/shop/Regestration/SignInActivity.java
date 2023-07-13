package com.example.shop.Regestration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.example.shop.Home.HomeActivity;
import com.example.shop.R;

public class SignInActivity extends AppCompatActivity {
    Button sing_in;
    ImageView sign_up_btn;
    EditText email,password;
    SharedPreferences preferences;
    private String email_pref,full_name,password_pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        findBy();
        onClick();
        getData();

    }
    public void findBy(){
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        sing_in = findViewById(R.id.sign_in);
        sign_up_btn = findViewById(R.id.sign_up_btn);
        preferences = getSharedPreferences("MySharedPref",0);
    }
    public void onClick(){
        sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty()){
                    Toast.makeText(SignInActivity.this, "Please write Login or Password", Toast.LENGTH_SHORT).show();
                }else {
                    if (email.getText().toString().equals(email_pref)||password.getText().toString().equals(password_pref)){
                        Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SignInActivity.this, "Login or Password incorect", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    private void getData(){
        email_pref = preferences.getString("email_user","-1");
        full_name = preferences.getString("full_name","-1");
        password_pref = preferences.getString("password","-1");

    }
}