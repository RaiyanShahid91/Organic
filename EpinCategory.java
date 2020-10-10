package com.application.organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class EpinCategory extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener   {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epin_category);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.sidenavigation_view);
        toolbar=findViewById(R.id.toolbarclick);
        CardView epin=findViewById(R.id.myepin);
        CardView purchasepin=findViewById(R.id.purchasepin);
        CardView purchaselist=findViewById(R.id.purchaselist);
        CardView used=findViewById(R.id.used);

        purchasepin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PurchasePin.class);
                startActivity(intent);
            }
        });
        purchaselist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PurchasHistory.class);
                startActivity(intent);
            }
        });
        used.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),UsedPinHistory.class);
                startActivity(intent);
            }
        });
        navigationView.bringToFront();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        epin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Epin_Listview.class);
                startActivity(intent);
            }
        });
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
                Toast.makeText(EpinCategory.this,"Home",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_profile:
                Intent intent=new Intent(EpinCategory.this,Profile_fragment.class);
                Toast.makeText(EpinCategory.this,"Profile",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                break;
            case R.id.nav_genealogy:
                startActivity(new Intent(getApplicationContext(),Genealog_fragment.class));
                Toast.makeText(EpinCategory.this,"Genealogy",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_epin:
                Intent intent2=new Intent(EpinCategory.this,EpinCategory.class);
                Toast.makeText(EpinCategory.this,"E Pin",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_myaccount:
                Intent intent3=new Intent(EpinCategory.this,Myacoount_fragment.class);
                Toast.makeText(EpinCategory.this,"My Account",Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                finish();
                break;

            case R.id.epurchase:
                Intent intent4=new Intent(EpinCategory.this,Epurchase_fragment.class);
                Toast.makeText(EpinCategory.this,"E Purchase",Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                finish();
                break;
            case R.id.refer_earn:
                startActivity(new Intent(getApplicationContext(),ReferEarn_fragment.class));
                Toast.makeText(EpinCategory.this,"Refer & Earn",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.logout:
                Intent intent6=new Intent(EpinCategory.this,Second_Main_Activity.class);
                Toast.makeText(EpinCategory.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
                startActivity(intent6);
                finish();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

