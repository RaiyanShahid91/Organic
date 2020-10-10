
package com.application.organic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Coupon_Activity extends AppCompatActivity {
    Spinner spinner_click;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        recyclerView=findViewById(R.id.recyclerview);

        ImageView previous=findViewById(R.id.back);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Epurchase_fragment.class));
                finish();
            }
        });

        spinner_click=findViewById(R.id.spinner);
        ArrayAdapter<String> myadapter=new ArrayAdapter<String>
                (Coupon_Activity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_click.setAdapter(myadapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<Model_Coupon> modelClassList=new ArrayList<>();
        modelClassList.add(new Model_Coupon("Used","Expires on  :  23/03/2020","Product Purchase coupon for Rs. 1000",R.drawable.barcode));
        modelClassList.add(new Model_Coupon("Used","Expires on  23/03/2020","Product Purchase coupon for Rs. 1000",R.drawable.barcode));
        modelClassList.add(new Model_Coupon("Used","Expires on  23/03/2020","Product Purchase coupon for Rs. 1000",R.drawable.barcode));
        modelClassList.add(new Model_Coupon("Used","Expires on  23/03/2020","Product Purchase coupon for Rs. 1000",R.drawable.barcode));
        modelClassList.add(new Model_Coupon("Used","Expires on  23/03/2020","Product Purchase coupon for Rs. 1000",R.drawable.barcode));
        modelClassList.add(new Model_Coupon("Used","Expires on  23/03/2020","Product Purchase coupon for Rs. 1000",R.drawable.barcode));
        modelClassList.add(new Model_Coupon("Used","Expires on  23/03/2020","Product Purchase coupon for Rs. 1000",R.drawable.barcode));

        Adapter_coupon adapter=new Adapter_coupon(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}