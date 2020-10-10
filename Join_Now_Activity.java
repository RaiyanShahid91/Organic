package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Join_Now_Activity extends AppCompatActivity {

    TextView sponsorcode,sponsorname,sponsormobile;
    EditText codeans,nameans,mobileans;
    Button join;
    RadioGroup radioGroup;
   // RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinnow);

        sponsorcode=findViewById(R.id.sponsorcode);
        sponsorname=findViewById(R.id.sponsorname);
        sponsormobile=findViewById(R.id.sponsormobile);
        codeans=findViewById(R.id.sponsorcodeans);
        nameans=findViewById(R.id.sponsornameans);
        mobileans=findViewById(R.id.sponsormobileans);
        radioGroup=findViewById(R.id.radiogroup);
        join=findViewById(R.id.join);
        ImageView previous=findViewById(R.id.back);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Second_Main_Activity.class));
            }
        });

        codeans.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if(s.toString().trim().length() == 10)
                {

                    sponsorname.setVisibility(View.GONE);
                    nameans.setVisibility(View.GONE);
                    sponsormobile.setVisibility(View.GONE);
                    mobileans.setVisibility(View.GONE);
                }
                else
                {
                    sponsorname.setVisibility(View.VISIBLE);
                    nameans.setVisibility(View.VISIBLE);
                    sponsormobile.setVisibility(View.VISIBLE);
                    mobileans.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code=codeans.getText().toString().trim();
                String name=nameans.getText().toString().trim();
                String mobile=mobileans.getText().toString().trim();

                if (TextUtils.isEmpty(code))
                {
                    Toast.makeText(Join_Now_Activity.this, "Enter Sponsor Code", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name))
                {
                    Toast.makeText(Join_Now_Activity.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(mobile))
                {
                    Toast.makeText(Join_Now_Activity.this, "Enter Your Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Intent intent=new Intent(Join_Now_Activity.this,RegistrationForm.class);
                    intent.putExtra("sponsorcode",code);
                    intent.putExtra("sponsorname",name);
                    startActivity(intent);
                }

            }
        });
    }
}