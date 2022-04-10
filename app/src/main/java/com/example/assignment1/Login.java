package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    ImageView img_login;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
        img_login = findViewById(R.id.img_login);

        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        img_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = username.getText().toString();
                pass = password.getText().toString();

                if(user.length() < 5 && pass.length() < 8) {
                    Toast.makeText(Login.this, "Username and Password not of sufficient length", Toast.LENGTH_SHORT).show();
                }
                else if(user.length() < 5) {
                    Toast.makeText(Login.this, "Username is not of sufficient length", Toast.LENGTH_SHORT).show();
                }
                else if(pass.length() < 8) {
                    Toast.makeText(Login.this, "Password is not of sufficient length", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}