package com.example.spinner_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    TextView tv;
    EditText et;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.sp1);
        tv=findViewById(R.id.tv2);
        et=findViewById(R.id.et);
        b1=findViewById(R.id.b1);
        // final String op=et.getText().toString();
        // final int size=String.valueOf(et.length());

        String avi[]={"no. of char","no. of words","show words"};
        ArrayAdapter<String> aa= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,avi);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String s=sp.getSelectedItem().toString();

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(s.equals("no. of char"))
                        {
                            int length = et.length();
                            String convert = String.valueOf(length);
                            Toast.makeText(MainActivity.this,"No of characters = "+convert,Toast.LENGTH_LONG).show();

                        }
                        else if (s.equals("no. of words"))
                        {
                            String text = et.getText().toString();
                            text=text.replace("\n"," ");
                            String[] textarray=text.split(" ");
                            Toast.makeText(MainActivity.this,"No of words = "+(textarray).length,Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            String text = et.getText().toString();
                            text=text.replace(" ",",");
                            Toast.makeText(MainActivity.this,"Words = "+text,Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}

