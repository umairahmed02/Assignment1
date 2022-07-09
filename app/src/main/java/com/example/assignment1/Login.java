package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

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
                /*if(user.equals("umair")) {
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }*/
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                if(user.equals("")) {
                    Toast.makeText(Login.this, "Do not keep username field empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.collection("User")
                            .whereEqualTo("username", user)
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        DocumentSnapshot document = task.getResult().getDocuments().get(0);
                                        User newUser = new User(document.getString("username"), document.getString("password"), document.getString("email"));
                                        if(newUser.getPassword().equals(pass)) {
                                            User user = User.getInstance(newUser.username, newUser.password, newUser.email);
                                            Intent intent = new Intent(Login.this, Home.class);
                                            //intent.putExtra("user", (Parcelable) newUser);
                                            startActivity(intent);
                                        }
                                        else {
                                            Toast.makeText(Login.this, "Username and password do not match", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else {
                                        Toast.makeText(Login.this, "No user with the username " + user + " was found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
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