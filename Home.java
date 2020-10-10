package com.application.organic;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import SharedPreferences.SessionManager;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView leftpoints,rightpoints,currentlpoints,currentrpoints,currentleftcv,currentrightcv,leftcv,rightcv;
    ListView listView;
    SessionManager session;
    private RequestQueue requestQueue;
    private String JSON_URL="https://memberapi.saveecoorganic.com/api.aspx?request_id=854221&MemberID=20507";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        session = new SessionManager(getApplicationContext());


        /*-----Hooks----------*/
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.sidenavigation_view);
        toolbar=findViewById(R.id.toolbarclick);
        leftpoints=findViewById(R.id.membername);
        rightpoints=findViewById(R.id.text2);
        currentlpoints=findViewById(R.id.text3);
        currentrpoints=findViewById(R.id.text4);
        currentleftcv=findViewById(R.id.text5);
        currentrightcv=findViewById(R.id.text6);
        leftcv=findViewById(R.id.text7);
        rightcv=findViewById(R.id.text8);

        requestQueue= Volley.newRequestQueue(this);
        parsedate();


        listView=findViewById(R.id.firstListView);
        ArrayList<String> datawithdate=new ArrayList<>();
        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        datawithdate.add("Rs. 60 Pin Purchase Rewards      18/02/2020");

        ArrayAdapter<String> adapterfirst=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,datawithdate);
        listView.setAdapter(adapterfirst);

        /*------------Navigation Drawer Menu---------------*/
        /* if item is not clickable then add*/
        navigationView.bringToFront();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


    }

    private void parsedate() {
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("success");
                            for (int i=0;i<jsonArray.length();i++)
                          {
                                JSONObject success=jsonArray.getJSONObject(i);
                                String lpoints=success.getString("lpoint");
                                String rpoints=success.getString("RPoint");
                                String clpoints=success.getString("clpoint");
                                String crpoints=success.getString("cRPoint");
                                String clcv=success.getString("cLCV");
                                String crcv=success.getString("cRCV");
                                String lcv=success.getString("aLCV");
                                String rcv=success.getString("aRCV");
                               leftpoints.setText(lpoints);
                               rightpoints.setText(rpoints);
                               currentlpoints.setText(clpoints);
                               currentrpoints.setText(crpoints);
                               currentleftcv.setText(clcv);
                               currentrightcv.setText(crcv);
                               leftcv.setText(lcv);
                               rightcv.setText(rcv);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","onErrorResponse: "+error.getMessage());

            }
        });requestQueue.add(jsonObjectRequest);

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
                Toast.makeText(Home.this,"Home",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_profile:
                Intent intent=new Intent(Home.this,Profile_fragment.class);
                Toast.makeText(Home.this,"Profile",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.nav_genealogy:
                startActivity(new Intent(getApplicationContext(),Genealog_fragment.class));
                Toast.makeText(Home.this,"Genealogy",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_epin:
                Intent intent2=new Intent(Home.this,EpinCategory.class);
                Toast.makeText(Home.this,"E Pin",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                break;
            case R.id.nav_myaccount:
                Intent intent3=new Intent(Home.this,Myacoount_fragment.class);
                Toast.makeText(Home.this,"My Account",Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                break;
            case R.id.epurchase:
                Intent intent4=new Intent(Home.this,Epurchase_fragment.class);
                Toast.makeText(Home.this,"E Purchase",Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                break;
            case R.id.refer_earn:
                startActivity(new Intent(getApplicationContext(),ReferEarn_fragment.class));
                Toast.makeText(Home.this,"Refer & Earn",Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                session.logoutUser();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
