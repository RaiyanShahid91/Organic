package com.application.organic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Pattern;

import SharedPreferences.SessionManager;
import conn.config;
import utils.MasterFunction;

public class LoginActivity extends AppCompatActivity {

    private Context mContext=LoginActivity.this;
    private MasterFunction masterFunction;
    ProgressDialog pd;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailbtn=findViewById(R.id.email);
        final EditText passwordbtn=findViewById(R.id.password);
        TextView forgetpw=findViewById(R.id.forgetpassword);
        Button login=findViewById(R.id.join);
        TextView donthave=findViewById(R.id.donthave);
        ImageView back=findViewById(R.id.back);
        session = new SessionManager(getApplicationContext());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Second_Main_Activity.class));
                finish();

            }
        });
        donthave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Join_Now_Activity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=emailbtn.getText().toString().trim();
                String password=passwordbtn.getText().toString().trim();
                if(TextUtils.isEmpty(username))
                {
                    emailbtn.setError("Email can't be Empty");
                    emailbtn.setFocusable(true);
                }

                if (TextUtils.isEmpty(password))
                {
                    passwordbtn.setError("Password Can't be empty");
                    passwordbtn.setFocusable(true);
                }
                if(passwordbtn.length()<3)
                {
                    passwordbtn.setError("Password Should not be less than 6 character");
                    passwordbtn.setFocusable(true);
                }
                else {
                    HashMap<String, String> hashMap = new HashMap<>();
                    String userRegType = "";
                    hashMap.put("username", username);
                    hashMap.put("password", password);
                    userRegType = config.LOGIN;

                    masterFunction.request(mContext, userRegType, hashMap, true, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String status) {
                           // Toast.makeText(mContext, status.trim(), Toast.LENGTH_SHORT).show();
//                            String temWord = status.replaceAll("success#pram#", "");
//                            Toast.makeText(mContext, temWord, Toast.LENGTH_SHORT).show();
//
//                            Toast.makeText(mContext, status, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(mContext, status, Toast.LENGTH_SHORT).show();

                            String[] membercode;

                            try {
                                String jsonString = status;
                                JSONObject jsonResult = new JSONObject(jsonString);


                                JSONArray data = jsonResult.getJSONArray("success");
                                if (data != null) {
                                     membercode = new String[data.length()];
//                                    for (int i = 0; i < data.length(); i++) {
//                                        membercode[i] = data.getString(1);
//                                    }
                                    if (data.length()>0){
                                        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
                                        session.createLoginSession("membercode","password");
                                        startActivity(new Intent(mContext, Home.class));
                                        finish();
                                        //membercode[0] = data.getString(1);
                                    }
                                    else {
                                      masterFunction.alert(mContext, "Invalid Username & Password");
                                     }




                                }
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }



                           //if (status.trim().equals("2")) {

                           // }
                            //else {
                              //  masterFunction.alert(mContext, "Oops!! Somthing Went Wrong. Try Again");
                           // }


                        }
                    }, false);
//                    startActivity(new Intent(getApplicationContext(), Home.class));
//                    finish();
                }}
        });

        forgetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRecoverPasswordDialog();
            }
        });
        pd=new ProgressDialog(this);
    }

    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");

        //set layout linear layout
        LinearLayout linearLayout=new LinearLayout(this);

        //views to set in dialog
        final EditText emailEt=new EditText(this);
        emailEt.setHint("Mobile Number");
        emailEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        // set the minmum width of edit text to fit a text of n 'M' letters regarless of the actual text extension and text size
        emailEt.setMinEms(16);

        linearLayout.addView(emailEt);
        linearLayout.setPadding(10,10,10,10);

        builder.setView(linearLayout);

        //buttons recover
        builder.setPositiveButton("Get Password", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //input email
                String email=emailEt.getText().toString().trim();
            }
        });
        //button cancel
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //dismiss dialog
                dialog.dismiss();

            }
        });

        //show dialog
        builder.create().show();
    }

//    public void LoginNow(View view) {
//        String mobile = txtuser.getText().toString();
//        String Password = txtpassword.getText().toString();
//
//        if (mobile == null || mobile == "") {
//            masterFunction.alert(mContext, "Enter Mobile No");
//        } else if (Password == null || Password == "") {
//            masterFunction.alert(mContext, "Enter Password");
//        } else {
//            HashMap<String, String> hashMap = new HashMap<>();
//            String userRegType = "";
//            hashMap.put("mobile", mobile);
//            hashMap.put("Password", Password);
//            userRegType = config.Login;
//
//            masterFunction.request(mContext, userRegType, hashMap, true, new Response.Listener<String>() {
//                @Override
//                public void onResponse(String status) {
//                    //Toast.makeText(mContext, status, Toast.LENGTH_SHORT).show();
//                    if (status.trim().equals("2")) {
//                        startActivity(new Intent(mContext, EmployerProfile.class));
//                    } else if (status.trim().equals("3")) {
//                        startActivity(new Intent(mContext, ApplicantProfile.class));
//                    } else if (status.trim().equals("4")) {
//                        startActivity(new Intent(mContext, GuestDashboard.class));
//                    } else if (status.trim().equals("Invalid")) {
//                        masterFunction.alert(mContext, "Invalid Mobile No. OR Password");
//                    } else {
//                        masterFunction.alert(mContext, "Oops!! Somthing Went Wrong. Try Again");
//                    }
//
//
//                }
//            }, false);
//        }
//    }

}