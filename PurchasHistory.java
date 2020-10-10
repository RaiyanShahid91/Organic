package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PurchasHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchas_history);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final SearchView searchepin=findViewById(R.id.searchepin);
        final SearchView searchdate=findViewById(R.id.searchdate);
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

        List<Model_PurchaseHistory> modelclassList=new ArrayList<>();
        modelclassList.add(new Model_PurchaseHistory("215685","24","22/01/2020",
                "Rs.4000","Rs.4000","Active"));
        modelclassList.add(new Model_PurchaseHistory("215686","24","22/01/2019",
                "Rs.4000","Rs.4000","Active"));
        modelclassList.add(new Model_PurchaseHistory("215687","24","22/01/2020",
                "Rs.4000","Rs.4000","Active"));
        modelclassList.add(new Model_PurchaseHistory("215688","24","10/01/2020",
                "Rs.4000","Rs.4000","Active"));
        modelclassList.add(new Model_PurchaseHistory("215689","24","05/02/2020",
                "Rs.4000","Rs.4000","Active"));
        modelclassList.add(new Model_PurchaseHistory("215690","24","08/02/2020",
                "Rs.4000","Rs.4000","Active"));
        modelclassList.add(new Model_PurchaseHistory("215691","24","25/03/2020",
                "Rs.4000","Rs.4000","Active"));
        modelclassList.add(new Model_PurchaseHistory("215691","24","20/12/2019",
                "Rs.4000","Rs.4000","Active"));

     final   Adapter_PurchaseHistory adapter=new Adapter_PurchaseHistory(modelclassList,getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        searchepin.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newtext) {
                adapter.getFilter().filter(newtext);
                return false;
            }
        });
        searchdate.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newtext) {
                adapter.getFilter().filter(newtext);
                return false;
            }
        });

        final ImageView filterimg = findViewById(R.id.filter);
        filterimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu popupMenu = new PopupMenu(PurchasHistory.this, filterimg);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.epinclick:
                                searchepin.setVisibility(view.VISIBLE);
                                return true;

                            case R.id.dateclick:
                                searchdate.setVisibility(view.VISIBLE);
                                return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}