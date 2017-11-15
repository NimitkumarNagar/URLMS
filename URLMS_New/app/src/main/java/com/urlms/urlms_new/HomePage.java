package com.urlms.urlms_new;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.urlms.urlms_new.Equipment.Equipment;
import com.urlms.urlms_new.Funding.Funding;
import com.urlms.urlms_new.Staff.StaffMobile;
import com.urlms.urlms_new.Supplies.Supplies;

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    private Button equipmentBtn;
    private Button staffBtn;
    private Button fundingBtn;
    private Button suppliesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        equipmentBtn = (Button) findViewById(R.id.equipmentButton);


        equipmentBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(HomePage.this, Equipment.class));
            }
        });


        staffBtn = (Button) findViewById(R.id.staffButton);


        staffBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(HomePage.this, StaffMobile.class));
            }
        });

        fundingBtn = (Button) findViewById(R.id.fundingButton);


        fundingBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(HomePage.this, Funding.class));
            }
        });

        suppliesBtn = (Button) findViewById(R.id.suppliesButton);


        suppliesBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(HomePage.this, Supplies.class));
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
    }

