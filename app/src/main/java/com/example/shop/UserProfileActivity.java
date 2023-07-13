package com.example.shop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shop.Home.HomeActivity;
import com.example.shop.Regestration.SignInActivity;
import com.example.shop.Regestration.SignUpActivity;
import com.google.android.material.imageview.ShapeableImageView;

import java.io.IOException;

public class UserProfileActivity extends AppCompatActivity {
    ImageView select_img,IVPreviewImage,back_to_home;
    Button save;
    EditText sourname_pr,password_pr,login_pr,name_pr;
    int SELECT_PICTURE = 200;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        initView();
        onClickBtn();
    }
    private void initView(){
        select_img = findViewById(R.id.select_img);
        IVPreviewImage = findViewById(R.id.IVPreviewImage);
        sourname_pr = findViewById(R.id.sourname);
        password_pr = findViewById(R.id.password);
        login_pr = findViewById(R.id.login);
        back_to_home = findViewById(R.id.back_to_home);
        name_pr = findViewById(R.id.name);
        save = findViewById(R.id.save);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
    }
    private void onClickBtn(){
        select_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sourname_pr.getText().toString().trim().isEmpty() && !login_pr.getText().toString().trim().isEmpty() && !password_pr.getText().toString().trim().isEmpty() && !name_pr.getText().toString().trim().isEmpty()) {
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("sourname_pr", sourname_pr.getText().toString());
                    myEdit.putString("login_pr", login_pr.getText().toString());
                    myEdit.putString("password_pr", password_pr.getText().toString());
                    myEdit.putString("name_pr", name_pr.getText().toString());
                    myEdit.putString("img",IVPreviewImage.toString());
                    myEdit.apply();
                    Intent intent = new Intent(UserProfileActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Log.d("sourname_pr", sourname_pr.getText().toString());
                    Log.d("login_pr", login_pr.getText().toString());
                    Log.d("password_pr", password_pr.getText().toString());
                    Log.d("name_pr", name_pr.getText().toString());
                    Toast.makeText(UserProfileActivity.this, "Your Data has been saved", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(UserProfileActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sourname_pr.getText().toString().trim().isEmpty() || login_pr.getText().toString().trim().isEmpty() || password_pr.getText().toString().trim().isEmpty() || name_pr.getText().toString().trim().isEmpty()  ){
                
                }
                onBackPressed();
            }
        });
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }

}