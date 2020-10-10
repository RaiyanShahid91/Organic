package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Member_details_First extends AppCompatActivity {
    EditText membercode;
    Button activatebtn,activatesecondbutton;
    TextView textbtn1,textbtn2,textbtn3,textbtn4,textbtn5,textbtn6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details_first);
        ImageView previous=findViewById(R.id.back);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Epin_Listview.class));
            }
        });

        membercode=findViewById(R.id.activatemembercode);
        activatebtn=findViewById(R.id.activate);
        textbtn1=findViewById(R.id.membername);
        textbtn2=findViewById(R.id.text2);
        textbtn3=findViewById(R.id.text3);
        textbtn4=findViewById(R.id.text4);
        textbtn5=findViewById(R.id.text5);
        textbtn6=findViewById(R.id.text6);
        activatesecondbutton=findViewById(R.id.activatesecondbtn);

        activatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=membercode.getText().toString();

                if(TextUtils.isEmpty(text))
                {
                    Toast.makeText(Member_details_First.this,"Enter your member Code",Toast.LENGTH_SHORT).show();
                }

                if(text.length()>5)
                {
                    activatebtn.setVisibility(View.GONE);
                    textbtn1.setVisibility(View.VISIBLE);
                    textbtn2.setVisibility(View.VISIBLE);
                    textbtn3.setVisibility(View.VISIBLE);
                    textbtn4.setVisibility(View.VISIBLE);
                    textbtn5.setVisibility(View.VISIBLE);
                    textbtn6.setVisibility(View.VISIBLE);
                    activatesecondbutton.setVisibility(View.VISIBLE);
                    Toast.makeText(Member_details_First.this,"Here are all your Details",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}