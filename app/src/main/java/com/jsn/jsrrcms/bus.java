package com.jsn.jsrrcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        Button bus_routes;
        Button btn2;
        Button btn3;
        Button btn4;
        bus_routes= (Button)findViewById(R.id.button13);

        bus_routes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bus.this,bus_routes.class);
                startActivity(intent);
            }
        });

        btn2= (Button)findViewById(R.id.button14);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bus.this,driver.class);
                startActivity(intent);
            }
        });

        btn3= (Button)findViewById(R.id.button15);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bus.this,contact.class);
                startActivity(intent);
            }
        });

        btn4= (Button)findViewById(R.id.button16);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bus.this,complaints.class);
                startActivity(intent);
            }
        });
    }

}
