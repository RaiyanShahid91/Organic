package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import utils.MasterFunction;

public class PaymenttransferrequestActivity extends AppCompatActivity {


    RecyclerView recyclerview;
    ProgressBar progress;
    List<Model_PaymentPurchaseRequest>modelclasslists;
    private static String JSON_URL="https://memberapi.saveecoorganic.com/api.aspx?request_id=854169&MemberID=20507";
    Adapter_PaymentTransferRequest adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymenttransferrequest);
        recyclerview=findViewById(R.id.recyclerview);
        progress=findViewById(R.id.progressBar);
        modelclasslists=new ArrayList<>();
        extractModelclassList();


        ImageView previous=findViewById(R.id.back);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Epurchase_fragment.class));
            }
        });
    }

    private void extractModelclassList() {
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                {
                    try {
                        JSONArray jsonArray=response.getJSONArray("success");
                        for (int i=0;i<jsonArray.length();i++)
                        {

                            JSONObject jsonobject = jsonArray.getJSONObject(i);
                        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerview.setLayoutManager(layoutManager);

                        Model_PaymentPurchaseRequest modelClassList = new Model_PaymentPurchaseRequest();
                        progress.setVisibility(View.GONE);
                        modelClassList.setFirst(jsonobject.getString("Id").toString());
                        modelClassList.setSecond(jsonobject.getString("memberId").toString());
                        modelClassList.setThird(jsonobject.getString("Description").toString());
                        modelClassList.setFourth(jsonobject.getString("Amount").toString());
                        modelClassList.setFifth(jsonobject.getString("date").toString());
                        modelClassList.setSixth(jsonobject.getString("idate").toString());
                        modelClassList.setSeventh(jsonobject.getString("type").toString());
                        modelClassList.setEighth(jsonobject.getString("AmountNP").toString());
                        modelclasslists.add(modelClassList);
                        }
                        adapter=new Adapter_PaymentTransferRequest(getApplicationContext(),modelclasslists);
                        recyclerview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","onErrorResponse: "+error.getMessage());
            }
        });
        queue.add(jsonObjectRequest);
    }
}