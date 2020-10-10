package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Epurchasereport extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epurchasereport);

        recyclerView=findViewById(R.id.epurchase_recyclerview);
        ImageView previous=findViewById(R.id.back);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Epurchase_fragment.class));
            }
        });

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        List<Model_EPurchase_Report> modelClassList=new ArrayList<>();
        modelClassList.add(new Model_EPurchase_Report("Purchase Type  Transaction Date  : 15/02/2020",
                "Store Name  :  ALPANA ORGANIC CENTER","Order Id  :  1431",
                "Store Id  :  20251","Total Price  :  6998","CV  :  44.5"));
        modelClassList.add(new Model_EPurchase_Report("Purchase Type  Transaction Date  : 15/02/2020",
                "Store Name  :  ALPANA ORGANIC CENTER","Order Id  :  1431",
                "Store Id  :  20252","Total Price  :  6998","CV  :  44.5"));
        modelClassList.add(new Model_EPurchase_Report("Purchase Type  Transaction Date  : 15/02/2020",
                "Store Name  :  ALPANA ORGANIC CENTER","Order Id  :  1431",
                "Store Id  :  20253","Total Price  :  6998","CV  :  44.5"));
        modelClassList.add(new Model_EPurchase_Report("Purchase Type  Transaction Date  : 15/02/2020",
                "Store Name  :  ALPANA ORGANIC CENTER","Order Id  :  1431",
                "Store Id  :  20254","Total Price  :  6998","CV  :  44.5"));
        modelClassList.add(new Model_EPurchase_Report("Purchase Type  Transaction Date  : 15/02/2020",
                "Store Name  :  ALPANA ORGANIC CENTER","Order Id  :  1431",
                "Store Id  :  20255","Total Price  :  6998","CV  :  44.5"));
        modelClassList.add(new Model_EPurchase_Report("Purchase Type  Transaction Date  : 15/02/2020",
                "Store Name  :  ALPANA ORGANIC CENTER","Order Id  :  1431",
                "Store Id  :  20256","Total Price  :  6998","CV  :  44.5"));
        modelClassList.add(new Model_EPurchase_Report("Purchase Type  Transaction Date  : 15/02/2020",
                "Store Name  :  ALPANA ORGANIC CENTER","Order Id  :  1431",
                "Store Id  :  20257","Total Price  :  6998","CV  :  44.5"));

        Adapter_EPurchase_Report adapter=new Adapter_EPurchase_Report(modelClassList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}