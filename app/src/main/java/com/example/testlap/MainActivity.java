package com.example.testlap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
Button b;
int j=0;
Button Tests;
    private DatabaseReference mRef;
    StorageReference Folder;
    private static final int Imageback=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

Folder=FirebaseStorage.getInstance().getReference().child("ImageFolder");
Tests=findViewById(R.id.Test);
Tests.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent n=new Intent(Intent.ACTION_GET_CONTENT);
        n.setType("image/*");
        startActivityForResult(n,Imageback);





    }


});}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
if(requestCode==Imageback)
    if (resultCode == RESULT_OK) {
    Uri ImageData = data.getData();
    final StorageReference Imagename = Folder.child("image" + ImageData.getLastPathSegment());
    Imagename.putFile(ImageData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            Imagename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {

                    DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
                    HashMap<String,String> hashmap=new HashMap<>();
                    hashmap.put("sender",String.valueOf(uri));
                    reference.child("Chats").push().setValue(hashmap);

                } });



                                }


                            });
                }
            }
        }





