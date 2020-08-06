package com.jsn.jsrrcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class student extends AppCompatActivity {
    Button atte;
    Button inter;
    Button note;
    Button tt;
    EditText email;
    Button comp;
    Button fd;
    Button learn;
    Button down;
    Button upload;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        atte = (Button) findViewById(R.id.button45);
        //inter = (Button) findViewById(R.id.button47);
        note = (Button) findViewById(R.id.button48);
        tt = (Button) findViewById(R.id.button49);
        fd = (Button) findViewById(R.id.button51);
        learn = (Button) findViewById(R.id.button50);
        //btn7 = (Button) findViewById(R.id.button52);
        comp = (Button) findViewById(R.id.button53);
        down = findViewById(R.id.button49);
        email = (EditText) findViewById(R.id.editText3);


        atte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(student.this,studentInfo.class);
                startActivity(intent);
            }
        });


        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(student.this,download.class);
                startActivity(intent);
            }
        });

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(student.this,time_table.class);
                startActivity(intent);
            }
        });

        fd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(student.this,fdetails.class);
                startActivity(intent);
            }
        });

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(student.this,e_learning.class);
                startActivity(intent);
            }
        });

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(student.this,complaints.class);
                startActivity(intent);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new download();
            }
        });

    }
}