package com.jsn.jsrrcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity
        implements View.OnClickListener {

        //private Button mButton1,mButton2,mButton3;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            //mButton1=findViewById(R.id.button2);
            //mButton2=findViewById(R.id.button3);
            // mButton3=findViewById(R.id.button4);
            //mButton.setOnClickListener(this);
            //}
            //@Override
            // public void onClick(View view)
            // {
            //switch (view.getId()) {
            // case R.id.button2:
            // Do something
            //     startActivity(new Intent(Login.this,student_login.class));
            // case R.id.button3:
            // Do something
            //   startActivity(new Intent(Login.this,FacultyLogin.class));
            //case R.id.button4:
            // Do something
            //  startActivity(new Intent(Login.this,general_info.class));
            // }
            //}
            //  }
/*Button btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent myIntent = new Intent(Login.this, student_login.class);
        MainActivity.this.startActivity(myIntent);
        }
        });*/
            //super.onCreate(savedInstanceState);

            //setContentView(R.layout.activity_main);
            Button btn1;
            Button btn2;
            Button btn3;
            btn1= (Button)findViewById(R.id.button2);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Login.this,student_login.class);
                    startActivity(intent);
                }
            });

            btn2=(Button) findViewById(R.id.button3);

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Login.this,FacultyLogin.class);
                    startActivity(intent);
                }
            });
            btn3=(Button) findViewById(R.id.button4);

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Login.this,general_info.class);
                    startActivity(intent);
                }
            });

        }

    @Override
    public void onClick(View v) {


    }
}