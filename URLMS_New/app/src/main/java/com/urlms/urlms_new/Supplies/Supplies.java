package com.urlms.urlms_new.Supplies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.urlms.urlms_new.R;

public class Supplies extends AppCompatActivity implements View.OnClickListener{


    private Button removeSuppliesBtn;
    private Button addSuppliesBtn;
    private Button trackSuppliesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplies);



        trackSuppliesBtn = (Button) findViewById(R.id.trackSuppliesButton);


        trackSuppliesBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Supplies.this, TrackSupplies.class));
            }
        });

        addSuppliesBtn = (Button) findViewById(R.id.addSuppliesButton);


        addSuppliesBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Supplies.this, AddSupplies.class));
            }
        });

        removeSuppliesBtn = (Button) findViewById(R.id.removeSuppliesButton);


        removeSuppliesBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Supplies.this, RemoveSupplies.class));
            }
        });
    }
    @Override
    public void onClick(View view) {

    }
    }

