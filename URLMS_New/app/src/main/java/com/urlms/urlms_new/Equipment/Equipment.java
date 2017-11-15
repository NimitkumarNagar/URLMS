package com.urlms.urlms_new.Equipment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.urlms.urlms_new.R;

public class Equipment extends AppCompatActivity implements View.OnClickListener{

    private Button removeEquipmentBtn;
    private Button addEquipmentBtn;
    private Button trackEquipmentBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);



        trackEquipmentBtn = (Button) findViewById(R.id.trackEquipmentButton);


        trackEquipmentBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Equipment.this, TrackEquipment.class));
            }
        });

        addEquipmentBtn = (Button) findViewById(R.id.addEquipmentButton);


        addEquipmentBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Equipment.this, AddEquipment.class));
            }
        });

        removeEquipmentBtn = (Button) findViewById(R.id.removeEquipmentButton);


        removeEquipmentBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Equipment.this, RemoveEquipment.class));
            }
        });
    }
    @Override
    public void onClick(View view) {

    }
}
