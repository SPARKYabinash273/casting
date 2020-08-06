package com.jsn.jsrrcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class general_info extends AppCompatActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);
        Button btn1;
        Button btn2;
        Button btn3;
        Button btn4;
        Button btn5;
        Button btn6;
        Button btn7;
        Button btn8;

        //Admission
        btn1= (Button)findViewById(R.id.button8);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(general_info.this,admission.class);
                startActivity(intent);
            }
        });
        //Campus Life
        btn2= (Button)findViewById(R.id.button11);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(general_info.this,campus.class);
                startActivity(intent);
            }
        });
        //Departments
        btn3= (Button)findViewById(R.id.button7);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(general_info.this,departments.class);
                startActivity(intent);
            }
        });
        //contact us
        btn4= (Button)findViewById(R.id.button10);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(general_info.this,contact.class);
                startActivity(intent);
            }
        });
        //Bus
        btn5= (Button)findViewById(R.id.button5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(general_info.this,bus.class);
                startActivity(intent);
            }
        });
        //Mess
        btn6= (Button)findViewById(R.id.button6);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(general_info.this,mess.class);
                startActivity(intent);
            }
        });
        //Placement
        btn7= (Button)findViewById(R.id.button9);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(general_info.this,placement.class);
                startActivity(intent);
            }
        });
        //about
        btn8= (Button)findViewById(R.id.button12);

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(general_info.this,about.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
