package com.urlms.urlms_new.Funding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.urlms.urlms_new.R;

public class Funding extends AppCompatActivity implements View.OnClickListener{

    private Button showBalanceBtn;
    private Button updateBalanceBtn;
    private Button compileReportBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding);


        showBalanceBtn = (Button) findViewById(R.id.showBalanceButton);


        showBalanceBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Funding.this, ShowBalance.class));
            }
        });

        updateBalanceBtn = (Button) findViewById(R.id.updateBalanceButton);


        updateBalanceBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Funding.this, UpdateBalance.class));
            }
        });

        compileReportBtn = (Button) findViewById(R.id.compileReportButton);


        compileReportBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Funding.this, CompileReport.class));
            }
        });
    }
    @Override
    public void onClick(View view) {

    }

}
