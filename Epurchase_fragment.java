package com.application.organic;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Epurchase_fragment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    CardView paymentbtn,epurchasebtn,epurchasereportbtn,couponbtn;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_epurchase);


        paymentbtn=findViewById(R.id.paymenttransferrequest);
        epurchasebtn=findViewById(R.id.cardviewbutton);
        epurchasereportbtn=findViewById(R.id.epurchasereport);
        couponbtn=findViewById(R.id.couponcardview);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.sidenavigation_view);
        toolbar=findViewById(R.id.toolbarclick);


        paymentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PaymenttransferrequestActivity.class));
            }
        });

        epurchasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),E_purchase.class));
            }
        });

        epurchasereportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Epurchasereport.class));
            }
        });

        couponbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Coupon_Activity.class));
            }
        });
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
                Toast.makeText(Epurchase_fragment.this,"Home",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_profile:
                Intent intent=new Intent(Epurchase_fragment.this,Profile_fragment.class);
                Toast.makeText(Epurchase_fragment.this,"Profile",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                break;
            case R.id.nav_genealogy:
                startActivity(new Intent(getApplicationContext(),Genealog_fragment.class));
                Toast.makeText(Epurchase_fragment.this,"Genealogy",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_epin:
                Intent intent2=new Intent(Epurchase_fragment.this,EpinCategory.class);
                Toast.makeText(Epurchase_fragment.this,"E Pin",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_myaccount:
                Intent intent3=new Intent(Epurchase_fragment.this,Myacoount_fragment.class);
                Toast.makeText(Epurchase_fragment.this,"My Account",Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                finish();
                break;
            case R.id.epurchase:
                Intent intent4=new Intent(Epurchase_fragment.this,Epurchase_fragment.class);
                Toast.makeText(Epurchase_fragment.this,"E Purchase",Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                finish();
                break;
            case R.id.refer_earn:
                startActivity(new Intent(getApplicationContext(),ReferEarn_fragment.class));
                Toast.makeText(Epurchase_fragment.this,"Refer & Earn",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.logout:
                Intent intent6=new Intent(Epurchase_fragment.this,Second_Main_Activity.class);
                Toast.makeText(Epurchase_fragment.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
                startActivity(intent6);
                finish();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    }
