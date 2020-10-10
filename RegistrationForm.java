package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class RegistrationForm extends AppCompatActivity {
    Spinner state,relation,qestion;
    TextView sponsorname,sponsorcode,sponsormobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sponsor_regitration_form);

        state=findViewById(R.id.state);
        relation=findViewById(R.id.relationspineer);
        qestion=findViewById(R.id.secretquestionspineer);
        sponsorcode=findViewById(R.id.sponsorcodeans);
        sponsorname=findViewById(R.id.sponsornameans);

        ImageView previous=findViewById(R.id.back);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Join_Now_Activity.class));
            }
        });

        ArrayAdapter<String> myadapter=new ArrayAdapter<String>
                (RegistrationForm.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.state));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(myadapter);

        ArrayAdapter<String> myadaptersecond=new ArrayAdapter<String>
                (RegistrationForm.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.relation));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       relation.setAdapter(myadaptersecond);

        ArrayAdapter<String> myadapterthird=new ArrayAdapter<String>
                (RegistrationForm.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.question));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qestion.setAdapter(myadapterthird);

        String code=getIntent().getStringExtra("sponsorcode");
        String name=getIntent().getStringExtra("sponsorname");

        sponsorcode.setText(code);
        sponsorname.setText(name);




    }
}