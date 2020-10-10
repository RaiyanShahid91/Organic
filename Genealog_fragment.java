package com.application.organic;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class Genealog_fragment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Spinner snipper_clicknew;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_genealogy);


        snipper_clicknew=findViewById(R.id.spinner);
        recyclerView=findViewById(R.id.recyclerview);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.sidenavigation_view);
        toolbar=findViewById(R.id.toolbarclick);


        ArrayAdapter<String> myadapter=new ArrayAdapter<String>
                (Genealog_fragment.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.newname));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        snipper_clicknew.setAdapter(myadapter);

        snipper_clicknew.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
            if(position==6)
            {
                Intent intent=new Intent(Genealog_fragment.this,DirectMemberList.class);
                Toast.makeText(Genealog_fragment.this,"Opening",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        List<Model_Genealogy> modelClassList=new ArrayList<>();
        modelClassList.add(new Model_Genealogy("Status :  Pending","Activation Date :  08/02/2020",
                "Member Name  :  AJIMA KHATUN (INWB061752)",
                "Sponsor Name  :  SK SELIM (INWB061752)","Joinnig Date  :  08/09/2020"));
        modelClassList.add(new Model_Genealogy("Status :  Pending","Activation Date :  08/02/2020",
                "Member Name  :  AJIMA KHATUN (INWB061752)",
                "Sponsor Name  :  SK SELIM (INWB061752)","Joinnig Date  :  08/09/2020"));
        modelClassList.add(new Model_Genealogy("Status :  Pending","Activation Date :  08/02/2020",
                "Member Name  :  AJIMA KHATUN (INWB061752)",
                "Sponsor Name  :  SK SELIM (INWB061752)","Joinnig Date  :  08/09/2020"));
        modelClassList.add(new Model_Genealogy("Status :  Pending","Activation Date :  08/02/2020",
                "Member Name  :  AJIMA KHATUN (INWB061752)",
                "Sponsor Name  :  SK SELIM (INWB061752)","Joinnig Date  :  08/09/2020"));
        modelClassList.add(new Model_Genealogy("Status :  Pending","Activation Date :  08/02/2020",
                "Member Name  :  AJIMA KHATUN (INWB061752)",
                "Sponsor Name  :  SK SELIM (INWB061752)","Joinnig Date  :  08/09/2020"));
        modelClassList.add(new Model_Genealogy("Status :  Pending","Activation Date :  08/02/2020",
                "Member Name  :  AJIMA KHATUN (INWB061752)",
                "Sponsor Name  :  SK SELIM (INWB061752)","Joinnig Date  :  08/09/2020"));
        modelClassList.add(new Model_Genealogy("Status :  Pending","Activation Date :  08/02/2020",
                "Member Name  :  AJIMA KHATUN (INWB061752)",
                "Sponsor Name  :  SK SELIM (INWB061752)","Joinnig Date  :  08/09/2020"));

        Adapter_Genealogy adapter=new Adapter_Genealogy(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        navigationView.bringToFront();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

        switch(menuitem.getItemId()){
            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(),Home.class));
                Toast.makeText(Genealog_fragment.this,"Home",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_profile:
                Intent intent=new Intent(Genealog_fragment.this,Profile_fragment.class);
                Toast.makeText(Genealog_fragment.this,"Profile",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                break;
            case R.id.nav_genealogy:
                startActivity(new Intent(getApplicationContext(),Genealog_fragment.class));
                Toast.makeText(Genealog_fragment.this,"Genealogy",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_epin:
                Intent intent2=new Intent(Genealog_fragment.this,EpinCategory.class);
                Toast.makeText(Genealog_fragment.this,"E Pin",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_myaccount:
                Intent intent3=new Intent(Genealog_fragment.this,Myacoount_fragment.class);
                Toast.makeText(Genealog_fragment.this,"My Account",Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                finish();
                break;
            case R.id.epurchase:
                Intent intent4=new Intent(Genealog_fragment.this,Epurchase_fragment.class);
                Toast.makeText(Genealog_fragment.this,"E Purchase",Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                finish();
                break;
            case R.id.refer_earn:
                startActivity(new Intent(getApplicationContext(),ReferEarn_fragment.class));
                Toast.makeText(Genealog_fragment.this,"Refer & Earn",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.logout:
                Intent intent6=new Intent(Genealog_fragment.this,Second_Main_Activity.class);
                Toast.makeText(Genealog_fragment.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
                startActivity(intent6);
                finish();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }}