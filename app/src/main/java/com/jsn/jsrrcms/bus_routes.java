package com.jsn.jsrrcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bus_routes extends AppCompatActivity
{
    // public Button bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_routes);
        Button newBtn,newBtn1;
        newBtn=(Button)findViewById(R.id.button22);
        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(bus_routes.this,bus1.class);
                startActivity(i);
            }
        });
        newBtn1=(Button)findViewById(R.id.button27);
        newBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(bus_routes.this,bus5.class);
                startActivity(i);
            }
        });
    }
}
