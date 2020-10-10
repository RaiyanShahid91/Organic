package com.application.organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

import conn.config;
import utils.MasterFunction;
import utils.RequestList;
import SharedPreferences.SessionManager;


public class Profile_fragment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
   // private Context mContext=Profile_fragment.this;
    //private MasterFunction masterFunction;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView membercode;
    TextView oldpw;
    EditText oldpwet;
    private RequestQueue requestQueue;
    SessionManager session;

    // private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        session = new SessionManager(getApplicationContext());

        //   masterFunction=new MasterFunction(mContext);
        //checkPermission(masterFunction.permissions);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.sidenavigation_view);
        toolbar = findViewById(R.id.toolbarclick);
        final TextView membercodeque=findViewById(R.id.membercode);
        membercode=findViewById(R.id.membercodeans);
        final Button changepw=findViewById(R.id.pwchange);
        oldpw=findViewById(R.id.oldpassword);
        oldpwet=findViewById(R.id.oldpasswordet);
        final TextView newpw=findViewById(R.id.newpassword);
        final EditText newpwet=findViewById(R.id.newpasswordet);
        final TextView confirmpw=findViewById(R.id.confirmpassword);
        final EditText confirmpwet=findViewById(R.id.confirmpasswordet);
        final Button save=findViewById(R.id.confirm);

       // requestQueue=Volley.newRequestQueue(this);
       // parsedate();
     //  membercodeque.setOnClickListener(new View.OnClickListener() {
       //    @Override
         //  public void onClick(View view) {
          //     parsedate();
          // }
      // });
//        session.checkLogin();
//
//        // get user data from session
//        HashMap<String, String> user = session.getUserDetails();
//
//        // name
//        String name = user.get(SessionManager.KEY_NAME);
//
//        // email
//        String email = user.get(SessionManager.KEY_PASSWORD);
//        membercode.setText(name);
//        oldpwet.setText(email);

        changepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changepw.setVisibility(View.GONE);
                oldpw.setVisibility(View.VISIBLE);
                oldpwet.setVisibility(View.VISIBLE);
                newpw.setVisibility(View.VISIBLE);
                newpwet.setVisibility(View.VISIBLE);
                confirmpw.setVisibility(View.VISIBLE);
                confirmpwet.setVisibility(View.VISIBLE);
                save.setVisibility(View.VISIBLE);
            }
        });


        navigationView.bringToFront();
        //memberinfo();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

//    private void parsedate() {
//        String url="https://memberapi.saveecoorganic.com/api.aspx?request_id=854151&username=20507&password=2211";
//        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray=response.getJSONArray("success");
//                            for (int i=0;i<jsonArray.length();i++)
//                            {
//                                JSONObject success=jsonArray.getJSONObject(i);
//                                int memcode=success.getInt("membercode");
//                                int pw=success.getInt("password");
//                                membercode.append(memcode+"");
//                                oldpwet.append(pw+"");
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//                membercode.setText("Error");
//
//            }
//        });requestQueue.add(request);
//    }
//

//    private boolean checkPermission(String[] permissions) {
//    return true;
//    }
//
//
//    private void memberinfo()
//    {
//        try {
//            HashMap<String, String> hashMap = new HashMap<>();
//            masterFunction.request(mContext, config.LOGIN, hashMap, true, new Response.Listener<String>() {
//                @Override
//                public void onResponse(String status) {
//                    //Toast.makeText(mContext, status, Toast.LENGTH_LONG).show();
//                    ArrayList<RequestList> requestLists = masterFunction.jsontoList(status);
//                    Profile_fragment.gridViewListAdapter listAdapter = new Profile_fragment.gridViewListAdapter(mContext, requestLists);
//                    gridView.setAdapter(listAdapter);
//
//                }
//            }, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static class gridViewListAdapter extends BaseAdapter {
//        Context context;
//        ArrayList<RequestList> requestLists;
//
//        public gridViewListAdapter(Context context, ArrayList<RequestList> requestLists) {
//            this.context = context;
//            this.requestLists = requestLists;
//        }
//
//        @Override
//        public int getCount() {
//            return requestLists.size();
//        }
//
//        @Override
//        public RequestList getItem(int i) {
//            return requestLists.get(i);
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return i;
//        }
//
//        static class ViewHolder {
//
//            TextView membercode;
//        }
//
//        @Override
//        public View getView(int position, View view, ViewGroup viewGroup) {
//            final Profile_fragment.gridViewListAdapter.ViewHolder holder;
//            if (view == null) {
//                LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//                view = mInflater.inflate(R.layout.fragment_profile, null);
//                holder = new Profile_fragment.gridViewListAdapter.ViewHolder();
//                /*holder.txt_name = (TextView) view.findViewById(R.id.txt_name);
//                holder.txt_id = (TextView)view.findViewById(R.id.txt_id);
//                holder.iv_cat_pic = (ImageView) view.findViewById(R.id.iv_cat_pic);*/
//
//                holder.membercode= (TextView)view.findViewById(R.id.membercode);
//
//                view.setTag(holder);
//            } else {
//                holder = (Profile_fragment.gridViewListAdapter.ViewHolder) view.getTag();
//            }
//
//            final RequestList obj = requestLists.get(position);
//
//
//            SharedPreferences sp=context.getSharedPreferences("Settings",MODE_PRIVATE);
//            String lang= sp.getString("My_Lang","");
//
//            holder.membercode.setText(obj.hasmap.get("siteid"));
//                String text = obj.hasmap.get("sitenamehn");
//            return view;
//        }
//
//
//    }

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
                Toast.makeText(Profile_fragment.this,"Home",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_profile:
                Intent intent=new Intent(Profile_fragment.this,Profile_fragment.class);
                Toast.makeText(Profile_fragment.this,"Profile",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                break;
            case R.id.nav_genealogy:
                startActivity(new Intent(getApplicationContext(),Genealog_fragment.class));
                Toast.makeText(Profile_fragment.this,"Genealogy",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nav_epin:
                Intent intent2=new Intent(Profile_fragment.this,EpinCategory.class);
                Toast.makeText(Profile_fragment.this,"E Pin",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_myaccount:
                Intent intent3=new Intent(Profile_fragment.this,Myacoount_fragment.class);
                Toast.makeText(Profile_fragment.this,"My Account",Toast.LENGTH_SHORT).show();
                startActivity(intent3);
                finish();
                break;
            case R.id.epurchase:
                Intent intent4=new Intent(Profile_fragment.this,Epurchase_fragment.class);
                Toast.makeText(Profile_fragment.this,"E Purchase",Toast.LENGTH_SHORT).show();
                startActivity(intent4);
                finish();
                break;
            case R.id.refer_earn:
                startActivity(new Intent(getApplicationContext(),ReferEarn_fragment.class));
                Toast.makeText(Profile_fragment.this,"Refer & Earn",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.logout:
                Intent intent6=new Intent(Profile_fragment.this,Second_Main_Activity.class);
                Toast.makeText(Profile_fragment.this,"Successfully Logout",Toast.LENGTH_SHORT).show();
                startActivity(intent6);
                finish();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}