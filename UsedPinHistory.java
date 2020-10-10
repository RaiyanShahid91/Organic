package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UsedPinHistory extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usedpin_history);
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

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<Model_UsedPinHistory> modelclasslist = new ArrayList<>();
        modelclasslist.add(new Model_UsedPinHistory("213164", "2015245", "01/01/2020", "Rs.1000", "12", "Kakli sarkar", "Success"));
        modelclasslist.add(new Model_UsedPinHistory("213165", "2015245", "02/01/2020", "Rs.3000", "10", "Vishu Yadav", "Pending"));
        modelclasslist.add(new Model_UsedPinHistory("213166", "2015245", "10/01/2020", "Rs.4000", "15", "Himat Sethi", "Success"));
        modelclasslist.add(new Model_UsedPinHistory("213167", "2015245", "25/01/2020", "Rs.5000", "20", "Kushal Tiyagi", "Success"));
        modelclasslist.add(new Model_UsedPinHistory("213168", "2015245", "02/02/2020", "Rs.10000", "05", "Minto Prasad", "Pending"));
        modelclasslist.add(new Model_UsedPinHistory("213169", "2015245", "25/02/2020", "Rs.500", "22", "Bhumi Yadav", "Seccess"));
        modelclasslist.add(new Model_UsedPinHistory("213170", "2015245", "10/03/2020", "Rs.1500", "05", "Nirmal Kumari", "Pending"));
        modelclasslist.add(new Model_UsedPinHistory("213171", "2015245", "20/05/2020", "Rs.2500", "11", "Chotu ", "Seccess"));

      final  Adapter_UsedPin_History adapter = new Adapter_UsedPin_History(modelclasslist,getApplicationContext());
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
                final PopupMenu popupMenu = new PopupMenu(UsedPinHistory.this, filterimg);
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
    }}
