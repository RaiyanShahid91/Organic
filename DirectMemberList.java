package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class DirectMemberList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directmember_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ImageView previous = findViewById(R.id.back);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EpinCategory.class));
            }
        });

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<Model_DirectMemberList> modelclassList=new ArrayList<>();
        modelclassList.add(new Model_DirectMemberList("205266",
                "Kalki Sarkar","02/02/2020","03/02/2020",
                "self","self","12","30"));
        modelclassList.add(new Model_DirectMemberList("205267",
                "Kalki Sarkar","02/02/2020","03/02/2020",
                "self","self","12","30"));
        modelclassList.add(new Model_DirectMemberList("205268",
                "Kalki Sarkar","02/02/2020","03/02/2020",
                "self","self","12","30"));
        modelclassList.add(new Model_DirectMemberList("205269",
                "Kalki Sarkar","02/02/2020","03/02/2020",
                "self","self","12","30"));
        modelclassList.add(new Model_DirectMemberList("205270",
                "Kalki Sarkar","02/02/2020","03/02/2020",
                "self","self","12","30"));
        modelclassList.add(new Model_DirectMemberList("205271",
                "Kalki Sarkar","02/02/2020","03/02/2020",
                "self","self","12","30"));

         Adapter_DirectMemberList adapter=new Adapter_DirectMemberList(modelclassList);
    recyclerView.setAdapter(adapter);
    adapter.notifyDataSetChanged();
    }
}