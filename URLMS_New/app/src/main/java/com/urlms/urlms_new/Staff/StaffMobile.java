package com.urlms.urlms_new.Staff;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.urlms.urlms_new.Persistence;
import com.urlms.urlms_new.R;

import java.io.File;

import ca.mcgill.ecse321.P6.URLMS.desktop.controller.InvalidInputException;
import ca.mcgill.ecse321.P6.URLMS.desktop.controller.URLMSController;
import ca.mcgill.ecse321.P6.URLMS.desktop.model.Staff;


public class StaffMobile extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = Staff.class.getSimpleName();
    private Button searchStaffMemButton;
    private EditText txtInputTheName;
    private TextView textPane;

    private URLMSController control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        txtInputTheName = (EditText) findViewById(R.id.editText3);
        textPane = (TextView) findViewById(R.id.staffMemInfo);
        searchStaffMemButton = (Button) findViewById(R.id.searchStaffButton);
        searchStaffMemButton.setOnClickListener(StaffMobile.this);

        //Persistence.initialize("test_data_persistence.json");


    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        /*
        //String loc = Environment.getExternalStorageDirectory() + File.separator + "test_data_persistence_2.json";
        String loc = getExternalFilesDir("/") + File.separator + "test_data_persistence.xml";
        showToast(loc);
        System.out.println("\n\n\t\t"+loc+"\n\n");
        Persistence.initialize(loc, loc);

        //Log.d(TAG, "Staff Member Searched");
        //Toast.makeText(getBaseContext(), "Staff Member Searched", Toast.LENGTH_LONG).show();
        if (!LabManagement.getInstance().hasDirectors()){
            showToast("No Data Found!");
        }else {
            control = new URLMSController(LabManagement.getInstance().getDirector(0));

            ca.mcgill.ecse321.P6.URLMS.desktop.model.Staff staff;


            try {
                staff = control.getComponent(txtInputTheName.getText(),"Staff");
                //String name = txtInputTheName.getText().toString();

                if (staff == null) {

                    textPane.setBackgroundColor(getResources().getColor(R.color.cardview_light_background));
                    textPane.setText("This person does not work in this lab");
                    //Toast.makeText(getBaseContext(), "This person does not work in this lab", Toast.LENGTH_LONG).show();
                } else {

                    textPane.setBackgroundColor(getResources().getColor(R.color.cardview_light_background));
                    textPane.setText(
                            "Associated lab: " + LabManagement.getInstance().getDirector(0).getLab().getName() + "\n" +
                                    "Name: " + staff.getName() + "\n" +
                                    "Role: " + staff.getRole() + "\n" +
                                    "Progress report:  " + staff.getProgress() + "\n" +
                                    "Payment by month: " + staff.getPayment() + "\n" +
                                    "Travel cost: " + staff.getTravelCost() + "\n"
                    );
                }
                txtInputTheName.setText(txtInputTheName.getText());
            } catch (InvalidInputException e1) {
                textPane.setText(e1.getMessage());
            }

        }*/
        //String loc = Environment.getExternalStorageDirectory() + File.separator + "test_data_persistence_2.json";
        String loc = getExternalFilesDir("/") + File.separator + "test_data_persistence.xml";
        showToast(loc);
        System.out.println("\n\n\t\t"+loc+"\n\n");
        Persistence.initialize(loc);

        ca.mcgill.ecse321.P6.URLMS.desktop.model.Staff staff;
        try {
            staff = (Staff) control.getComponent(txtInputTheName.getText().toString(), "Staff");
            if (staff == null) {
                textPane.setBackgroundColor(getResources().getColor(R.color.cardview_light_background));
                textPane.setText("This person does not work in this lab");
            } else {
                textPane.setBackgroundColor(getResources().getColor(R.color.cardview_light_background));
                textPane.setText(
                        "Associated lab: " + control.getDirector().getLab().getName() + "\n" +
                                "Name: " + staff.getName() + "\n" +
                                "Role: " + staff.getRole() + "\n" +
                                "Progress report:  " + staff.getProgress() + "\n" +
                                "Payment by month: " + staff.getPayment() + "\n" +
                                "Travel cost: " + staff.getTravelCost() + "\n"
                );
            }
            txtInputTheName.setText(txtInputTheName.getText());
        } catch (InvalidInputException e1) {
            textPane.setText(e1.getMessage());
        }

    }

}

