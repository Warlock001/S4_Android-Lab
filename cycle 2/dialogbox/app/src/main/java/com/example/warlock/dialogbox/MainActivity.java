package com.example.warlock.dialogbox;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.Calendar;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    EditText bdob,corse;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bdob=findViewById(R.id.dob);
        corse=findViewById(R.id.course);


        bdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentdate = Calendar.getInstance();
                int mYear = mcurrentdate.get(Calendar.YEAR);
                int mMonth = mcurrentdate.get(Calendar.MONTH);
                int mDay = mcurrentdate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker;
                mDatePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        selectedmonth = selectedmonth + 1;
                        bdob.setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();
            }
        });


        corse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog;

                final String[] items = {"DBMS", "FP", "AJP"};

                final String[] topics=new String[3]; //String Array Declared
                topics[0]="DBMS"; // Value intialized
                topics[1]="FP";
                topics[2]="AJP";



                final ArrayList itemsSelected = new ArrayList();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Select Elective");

                builder.setMultiChoiceItems(items, null,
                        new DialogInterface.OnMultiChoiceClickListener() {


                            @Override
                            public void onClick(DialogInterface dialog, int selectedItemId,
                                                boolean isSelected) {
                                if (isSelected) {

                                    itemsSelected.add(selectedItemId);
                                } else if (itemsSelected.contains(selectedItemId)) {

                                    itemsSelected.remove(Integer.valueOf(selectedItemId));
                                }
                            }
                        })
                        .setPositiveButton("Done!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String a=valueOf(itemsSelected.get(0));
                                int b=Integer.parseInt(a);
                                corse.append(topics[b]);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {


                            }
                        });

                dialog = builder.create();

                dialog.show();

            }
        });

      /*  btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Confirm all form data?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Form data submitted.", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Form data cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        }); */

    }
}
