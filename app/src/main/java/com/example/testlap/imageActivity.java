package com.example.testlap;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class imageActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<describtion> describtions;

    TextView username;
    DatabaseReference reference;
    ImageButton send;

    ArrayList<describtion> chats;

    EditText textsend;
    TextView usercontact;
    Intent intent;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        describtions= new ArrayList<>();
        chats= new ArrayList<>();
recyclerView=findViewById(R.id.resycler);
        reference = FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                chats.clear();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    describtion Chat = snapshot.getValue(describtion.class);
                        chats.add(Chat);
                    }


                Adbterdescribtion d=new Adbterdescribtion(getApplicationContext(),chats);
                final LinearLayoutManager mLayoutManager;
                mLayoutManager = new LinearLayoutManager(imageActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);

                recyclerView.setAdapter(d);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });}}
