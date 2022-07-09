package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ChangePassword extends AppCompatActivity {

    EditText oldPassword, password, confirmPassword;
    Button btnChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        password = findViewById(R.id.txt_password);
        oldPassword = findViewById(R.id.txt_oldpass);
        confirmPassword = findViewById(R.id.txt_password_confirm);
        btnChangePassword = findViewById(R.id.btn_changepassword);

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = password.getText().toString();
                String oldPass = oldPassword.getText().toString();
                String confirmPass = confirmPassword.getText().toString();

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                if (pass.length() < 8) {
                    Toast.makeText(ChangePassword.this, "Password is not of sufficient length", Toast.LENGTH_SHORT).show();
                } else if (confirmPass.length() < 8) {
                    Toast.makeText(ChangePassword.this, "Confirm password is not of sufficient length", Toast.LENGTH_SHORT).show();
                } else if (!(pass.equals(confirmPass))) {
                    Toast.makeText(ChangePassword.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else if(!(oldPass.toString().equals(User.getInstance("u", "p", "e").password))) {
                    Toast.makeText(ChangePassword.this, "The old password is not correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.collection("User").document(User.getInstance("u", "p", "e").username).set(new User(User.getInstance("u", "p", "e").username, pass, User.getInstance("u", "p", "e").email));
                    Intent intent = new Intent(ChangePassword.this, StartScreen.class);
                    startActivity(intent);
                }


            }
        });
    }
}