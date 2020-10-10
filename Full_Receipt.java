package com.application.organic;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Full_Receipt extends AppCompatActivity {
    Button pdfcoverter;
    LinearLayout fullreceipt;
    TextView customertitle,customername,customerpackage,customeraddress,customerphoneno;
    TextView sendertitle,senderaddress,senderpincode,senderstate,sendermobileno;
    Bitmap bmt,scalebmp;
    int pagewidth=1800;
    Date dateobj;
    DateFormat dateformat;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_receipt);
        pdfcoverter=findViewById(R.id.pdf);
        fullreceipt=findViewById(R.id.receipt);
        customertitle=findViewById(R.id.innovative);
        customername=findViewById(R.id.membername);
        customerpackage=findViewById(R.id.text2);
        customeraddress=findViewById(R.id.text3);
        customerphoneno=findViewById(R.id.text4);
        sendertitle=findViewById(R.id.buyereco);
        senderaddress=findViewById(R.id.buyer);
        senderpincode=findViewById(R.id.buyeraddress);
        senderstate=findViewById(R.id.buyergst);
        sendermobileno=findViewById(R.id.buyeremail);

        bmt= BitmapFactory.decodeResource(getResources(),R.drawable.saveco);
        scalebmp=Bitmap.createScaledBitmap(bmt,160,78,false);
        ImageView previous = findViewById(R.id.back);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Myacoount_fragment.class));
            }
        });

        pdfcoverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMyPdf();
                Toast.makeText(Full_Receipt.this, " Successfully Saved Pdf File in File Manager", Toast.LENGTH_SHORT).show();
            }
        });

        //Downloading
//        pdfcoverter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
//                {
//                    if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED)
//                    {
//                        String[] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE};
//                        requestPermissions(permission,PERMISSION_STROAGE_CODE);
//                    }
//                    else
//                    {
//                        startDownloading();
//                    }
//                }
//                else
//                {
//                    startDownloading();
//                }
//            }
//        });
//PDF converter
       ActivityCompat.requestPermissions(Full_Receipt.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
               PackageManager.PERMISSION_GRANTED);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createMyPdf() {
        dateobj=new Date();

        PdfDocument myPdfDocument= new PdfDocument();
        Paint myPaint=new Paint();
        Paint titlepaint=new Paint();

        PdfDocument.PageInfo mypafeinfo=new PdfDocument.PageInfo.Builder(1800,2500,3).create();
        PdfDocument.Page mypage=myPdfDocument.startPage(mypafeinfo);
        Canvas canvas=mypage.getCanvas();

        //image
        canvas.drawBitmap(scalebmp,40,70,myPaint);

        //title text
        titlepaint.setTextAlign(Paint.Align.CENTER);
        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        titlepaint.setTextSize(50);
        canvas.drawText("INVOICE",pagewidth/2,270,titlepaint);

        //anothertext
//        myPaint.setColor(Color.rgb(0,113,100));
//        myPaint.setTextSize(30f);
//        myPaint.setTextAlign(Paint.Align.RIGHT);
//        canvas.drawText("0215155",1100,60,myPaint);
//        canvas.drawText("0215155",1100,80,myPaint);

        //title
        titlepaint.setTextAlign(Paint.Align.LEFT);
        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        titlepaint.setTextSize(32f);
        canvas.drawText(""+customertitle.getText(),20,360,titlepaint);

        //customer info
        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(24f);
        myPaint.setColor(Color.BLACK);
        canvas.drawText(""+customername.getText(),20,400,myPaint);
        canvas.drawText(""+customerpackage.getText(),20,440,myPaint);
        canvas.drawText(""+customeraddress.getText(),20,480,myPaint);
        canvas.drawText(""+customerphoneno.getText(),20,520,myPaint);
        dateformat=new SimpleDateFormat("dd/mm/yy");
        canvas.drawText("Date: "+dateformat.format(dateobj),20,560,myPaint);
        dateformat=new SimpleDateFormat("HH:mm:ss");
        canvas.drawText("Time: "+dateformat.format(dateobj),20,600,myPaint);

        //title
        titlepaint.setTextAlign(Paint.Align.RIGHT);
        titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        titlepaint.setTextSize(32f);
        canvas.drawText(""+sendertitle.getText(),1500,360,titlepaint);

        //sender info
        myPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(""+senderaddress.getText(),1500,400,myPaint);
        canvas.drawText(""+senderpincode.getText(),1500,440,myPaint);
        canvas.drawText(""+senderstate.getText(),1500,480,myPaint);
        canvas.drawText(""+sendermobileno.getText(),1500,520,myPaint);




//        myPaint.setStyle(Paint.Style.STROKE);
//        myPaint.setStrokeWidth(2);
//        canvas.drawRect(20,780,pagewidth-20,860,myPaint);

//        myPaint.setTextAlign(Paint.Align.LEFT);
//        myPaint.setStyle(Paint.Style.FILL);
//        canvas.drawText("Si. No",20,900,myPaint);
//        canvas.drawText("ammount",20,940,myPaint);
//
//        canvas.drawLine(180,790,180,840,myPaint);
//        canvas.drawLine(180,790,180,840,myPaint);

        // String receiptlinear=fullreceipt.getDisplay().toString();
//        String receipt=text.getText().toString();
//        String receipt1=text2.getText().toString();
//        String receipt2=text3.getText().toString();
//        String receipt3=text4.getText().toString();
//        String receipt4=text5.getText().toString();
//        mypage.getCanvas().drawText(receipt,15,15,myPaint);
//        mypage.getCanvas().drawText(receipt1,20,20,myPaint);
//        mypage.getCanvas().drawText(receipt2,25,25,myPaint);
//        mypage.getCanvas().drawText(receipt3,30,30,myPaint);
//        mypage.getCanvas().drawText(receipt4,35,35,myPaint);
//        myPdfDocument.finishPage(mypage);


        myPdfDocument.finishPage(mypage);
        File myfile=new File(Environment.getExternalStorageDirectory(),"ecoorganic.pdf");

        try {
            myPdfDocument.writeTo(new FileOutputStream(myfile));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        myPdfDocument.close();
    }
    }
//Downloading
//    private void startDownloading() {
//
//        DownloadManager.Request request=new DownloadManager.Request(Uri.parse(String.valueOf(fullreceipt)));
//        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
//        request.setTitle("Download");
//        request.setDescription("Downloading Files..");
//        request.allowScanningByMediaScanner();
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+ System.currentTimeMillis());
//        DownloadManager manager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
//        manager.enqueue(request);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode){
//            case PERMISSION_STROAGE_CODE:{
//                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                    startDownloading();
//                }
//                else
//                {
//                    Toast.makeText(this, "Permission Denied...!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//    }

