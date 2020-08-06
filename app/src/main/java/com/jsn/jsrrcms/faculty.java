package com.jsn.jsrrcms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;

public class faculty extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        //Student Details
        b1 = (Button) findViewById(R.id.button17);
        //add attendance
        b2 = (Button) findViewById(R.id.button18);
        //timetable
        b3 = (Button) findViewById(R.id.button19);
        //add student
        b4 = (Button) findViewById(R.id.button20);
        //upload
        b5 = (Button) findViewById(R.id.button21);
        b6 = (Button) findViewById(R.id.button26);
    }

    public void fn(View view) {
        //student details
        if (view == b1) {
            Intent intent = new Intent(faculty.this, select_roll_no.class);
            startActivity(intent);
        }
        //add student
        else if (view == b2) {
            Intent intent = new Intent(faculty.this, subject_list.class);
            startActivity(intent);
        }
        //uplload
        else if (view == b5) {
            Intent intent = new Intent(faculty.this, upload.class);
            startActivity(intent);
        }
        //add student
        else if (view == b4) {
            Intent intent = new Intent(faculty.this, add_student.class);
            startActivity(intent);
        } else if (view == b6) {
            Intent intent=new Intent(faculty.this,notification.class);
            startActivity(intent);
           // b6.setOnClickListener(new View.OnClickListener() {
                //@Override
                //public void onClick(View v) {
                  //  addNotification();
                //}
            //});
        } else {
            Intent intent = new Intent(faculty.this, time_table.class);
            startActivity(intent);
        }
    }

}
