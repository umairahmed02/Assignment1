package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Subject3 extends AppCompatActivity {

    Button btnAdd, btnEdit;
    ArrayList <Note> noteArrayList = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Query query = db.collection("Note").whereEqualTo("subject", "Subject3");

    /*ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for(DataSnapshot ds : snapshot.getChildren()) {

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject3);

        btnAdd = findViewById(R.id.btn_add);
        btnEdit = findViewById(R.id.btn_edit);
        db.collection("Note")
                .whereEqualTo("subject", "Subject3")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                           @Override
                                           public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                               Log.v("Arraysize", task.getResult().getDocuments().toString());
                                               for(int i = 0; i < task.getResult().getDocuments().size(); i++) {
                                                   DocumentSnapshot document = task.getResult().getDocuments().get(i);
                                                   Note note = new Note(document.getString("body"), document.getString("author"), document.getString("subject"), document.getString("title"), document.getString("dateCreated"));

                                                   Log.v("Arraysnote", note.getBody());
                                                   RecyclerView recyclerView = findViewById(R.id.recycler_view);
                                                   Log.v("Arraysnotesize", noteArrayList.toString());
                                                   Log.v("Arraysfinal", noteArrayList.toString());
                                                   noteArrayList.add(note);
                                                   RecyclerViewAdapter adapter = new RecyclerViewAdapter(Subject3.this, noteArrayList);
                                                   recyclerView.setAdapter(adapter);
                                                   recyclerView.setLayoutManager(new LinearLayoutManager(Subject3.this));
                                               }

                                           }
                                       }
                );

        getSupportActionBar().setTitle("Subject3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subject3.this, NotePublish.class);
                intent.putExtra("Activity", "Subject3");
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subject3.this, NoteEdit.class);
                intent.putExtra("Activity", "Subject3");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            Intent intent = new Intent(Subject3.this, Home.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}