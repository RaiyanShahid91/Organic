package com.application.organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Epin_Listview extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    SearchView searchview;
    ListView listView;
    String[] status ={"Given To Member","Given To Member","Given To Member"};
    String[] date ={"20/02/2020","10/02/2020","01/02/2020"};
    String[] epin ={"6101777","6199185","6200991"};
    String[] account ={"INWB060229","INWB060229","INWB060229"};
    String[] value ={"2000","1000","3000"};
    int[] image ={R.drawable.copied,R.drawable.copied,R.drawable.copied};
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epin__listview);
        searchview = findViewById(R.id.searchview);
        listView = findViewById(R.id.listview);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.sidenavigation_view);
        toolbar=findViewById(R.id.toolbarclick);



        final MyAdapter adapter=new MyAdapter(this,status,date,epin,account,value,image);
        listView.setAdapter(adapter);


        //search filter
      //  searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        //    @Override
          //  public boolean onQueryTextSubmit(String s) {
          //
            //    return false;
           // }
//
  //          @Override
    //        public boolean onQueryTextChange(String s) {
      //          adapter.getFilter().filter(s);
        //        return false;
         //  }
        //});


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent intent=new Intent(Epin_Listview.this,Member_details_First.class);
                    Toast.makeText(Epin_Listview.this,"Opening",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                if(i==1)
                {
                    Intent intent=new Intent(Epin_Listview.this,Member_details_Second.class);
                    Toast.makeText(Epin_Listview.this,"Opening",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                if(i==2)
                {
                    Intent intent=new Intent(Epin_Listview.this,Member_details_Third.class);
                    Toast.makeText(Epin_Listview.this,"Opening",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }
        class  MyAdapter extends ArrayAdapter<String>{
            Context context;
            String[] statusnew;
            String[] datenew;
            String[] epinnew;
            String[] accountnew;
            String valuenew[];
            int imagenew[];

            MyAdapter(Context c, String[] status, String[] date, String[] epin, String[] account, String[] value, int[] image)
            {
                super(c,R.layout.epin_row_listview,status);
                this.context=c;
                this.statusnew=status;
                this.datenew=date;
                this.epinnew=epin;
                this.accountnew=account;
                this.valuenew=value;
                this.imagenew=image;
            }

            public View getView(int position, View convertView, ViewGroup parent)
            {
                LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View row=layoutInflater.inflate(R.layout.epin_row_listview,parent,false);
                final TextView text=row.findViewById(R.id.statusans);
                TextView text2=row.findViewById(R.id.dateans);
                final TextView text3=row.findViewById(R.id.epinans);
                TextView text4=row.findViewById(R.id.epinaccountno);
                ImageView image=row.findViewById(R.id.copyimage);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String epin=text3.getText().toString();
                        searchview.setActivated(true);
                        searchview.onActionViewExpanded();
                        searchview.setIconified(false);
                        searchview.clearFocus();
                        searchview.setQuery(epin,false);
                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();


                    }
                });

                TextView text5=row.findViewById(R.id.pinvalueans);

                text.setText(statusnew[position]);
                text2.setText(datenew[position]);
                text3.setText(epinnew[position]);
                text4.setText(accountnew[position]);
                image.setImageResource(imagenew[position]);
                text5.setText(valuenew[position]);

                return row;

            }

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
                Toast.makeText(Epin_Listview.this,"Home",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_profile:
                Intent intent=new Intent(Epin_Listview.this,Profile_fragment.class);
                Toast.makeText(Epin_Listview.this,"Profile",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                break;
            case R.id.nav_genealogy:
                startActivity(new Intent(getApplicationContext(),Genealog_fragment.class));
                Toast.makeText(Epin_Listview.this,"Genealogy",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_epin:
                Intent intent2=new Intent(Epin_Listview.this,Epin_Listview.class);
                Toast.makeText(Epin_Listview.this,"E Pin",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_myaccount:
                Intent intent3=new Intent(Epin_Listview.this,Myacoount_fragment.class);
                Toast.makeText(Epin_Listview.this,"My Account",Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                finish();
                break;
            case R.id.epurchase:
                Intent intent4=new Intent(Epin_Listview.this,Epurchase_fragment.class);
                Toast.makeText(Epin_Listview.this,"E Purchase",Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                finish();
                break;
            case R.id.refer_earn:
                startActivity(new Intent(getApplicationContext(),ReferEarn_fragment.class));
                Toast.makeText(Epin_Listview.this,"Refer & Earn",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.logout:
                Intent intent6=new Intent(Epin_Listview.this,Second_Main_Activity.class);
                Toast.makeText(Epin_Listview.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
                startActivity(intent6);
                finish();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }}
