package com.urlms.urlms_new;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.mcgill.ecse321.P6.URLMS.desktop.model.Director;
import ca.mcgill.ecse321.P6.URLMS.desktop.model.FundAccount;
import ca.mcgill.ecse321.P6.URLMS.desktop.model.Lab;
import ca.mcgill.ecse321.P6.URLMS.desktop.model.LabManagement;
import ca.mcgill.ecse321.P6.URLMS.desktop.model.Staff;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
        private EditText Username;
        private EditText Password;
        private Button signInBtn;
        private int signInAttempts = 3;

        //public MainActivity(){}



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
       /* Director d = new Director("admin","admin");
        Lab l = new Lab("lab1",new FundAccount(0,0));
        LabManagement lm = LabManagement.getInstance();
        lm.addDirector(d);
        lm.getDirector(0).setLab(l);
        Staff s = new Staff("A","Research Assistant", "Progress 1", 1000,1000);
        l.addStaff(s);*/

            //Persistence.initialize("URLMS.xml");
            Username = (EditText) findViewById(R.id.editText4);
            Password = (EditText) findViewById(R.id.editText5);
            signInBtn = (Button) findViewById(R.id.signInButton);

            signInBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validate(Username.getText().toString(), Password.getText().toString());
                }

            });

        }


        private void validate(String userName, String userPassword) {

            if ((userName == "Admin") && (userPassword == "1234")) {
                startActivity(new Intent(MainActivity.this, HomePage.class));
            } else {
                signInAttempts--;
                if (signInAttempts == 0) {
                    signInBtn.setEnabled(false);
                }
            }
        }


    }

