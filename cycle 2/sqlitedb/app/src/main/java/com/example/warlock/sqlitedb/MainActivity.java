package com.example.warlock.sqlitedb;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener
{
    EditText id,Name,salary;
    Button Insert,Delete,Update,View,ViewAll;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=(EditText)findViewById(R.id.Id);
        Name=(EditText)findViewById(R.id.Name);
        salary=(EditText)findViewById(R.id.Salary);
        Insert=(Button)findViewById(R.id.Insert);
        Delete=(Button)findViewById(R.id.Delete);
        Update=(Button)findViewById(R.id.Update);
        View=(Button)findViewById(R.id.View);
        ViewAll=(Button)findViewById(R.id.ViewAll);

        Insert.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Update.setOnClickListener(this);
        View.setOnClickListener(this);
        ViewAll.setOnClickListener(this);
        db=openOrCreateDatabase("Employee", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS employee(id VARCHAR,name VARCHAR,salary VARCHAR);");
    }
    public void onClick(View view)
    {

        if(view==Insert)
        {

            if(id.getText().toString().trim().length()==0||
                    Name.getText().toString().trim().length()==0||
                    salary.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO employee VALUES('"+id.getText()+"','"+Name.getText()+
                    "','"+salary.getText()+"');");
            showMessage("Success", "Record added");
            clearText();
        }

        if(view==Delete)
        {

            if(id.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter  Empid");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM employee WHERE id='"+id.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM employee WHERE id='"+id.getText()+"'");
                showMessage("Success", "Record Deleted");
            }
            else
            {
                showMessage("Error", "Invalid Id");
            }
            clearText();
        }

        if(view==Update)
        {

            if(id.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter id");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM employee WHERE id='"+id.getText()+"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE employee SET name='" + Name.getText() + "',salary='" + salary.getText() +
                        "' WHERE id='"+id.getText()+"'");
                showMessage("Success", "Record Modified");
            }
            else {
                showMessage("Error", "Invalid id");
            }
            clearText();
        }

        if(view==View)
        {

            if(id.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter id");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM employee WHERE id='"+id.getText()+"'", null);
            if(c.moveToFirst())
            {
                Name.setText(c.getString(1));
                salary.setText(c.getString(2));
            }
            else
            {
                showMessage("Error", "Invalid id");
                clearText();
            }
        }

        if(view==ViewAll)
        {
            Cursor c=db.rawQuery("SELECT * FROM employee", null);
            if(c.getCount()==0)
            {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Id: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Salary: "+c.getString(2)+"\n\n");
            }
            showMessage("Employee Details", buffer.toString());
        }
    }
    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        id.setText("");
        Name.setText("");
        salary.setText("");
        id.requestFocus();
    }
}