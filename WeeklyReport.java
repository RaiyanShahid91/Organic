package com.application.organic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class WeeklyReport extends AppCompatActivity {
    String[] startingdate={"01/02/2020","01/03/2020","01/04/2020"};
    String[] endingdate={"28/02/2020","30/03/2020","30/03/2020"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_report);
        ListView listView=findViewById(R.id.listview);
        ImageView previous = findViewById(R.id.back);

       final MyAdapter adapter=new MyAdapter(this,startingdate,endingdate);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent intent=new Intent(WeeklyReport.this,Matching_Report_List.class);
                    Toast.makeText(WeeklyReport.this,"Opening",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                if(i==1)
                {
                    Intent intent=new Intent(WeeklyReport.this,Matching_Report_List.class);
                    Toast.makeText(WeeklyReport.this,"Opening",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                if(i==2)
                {
                    Intent intent=new Intent(WeeklyReport.this,Matching_Report_List.class);
                    Toast.makeText(WeeklyReport.this,"Opening",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Myacoount_fragment.class));
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String[] startingdatenew;
        String[] endingdatenew;

        MyAdapter(Context c,String[] startdate,String[] enddate)
        {
            super(c,R.layout.layout_weeklyreport_list,startdate);
            this.context=c;
            this.startingdatenew=startdate;
            this.endingdatenew=enddate;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.layout_weeklyreport_list,parent,false);
            final TextView startd=row.findViewById(R.id.startdateans);
            final TextView endd=row.findViewById(R.id.enddateans);

            startd.setText(startingdatenew[position]);
            endd.setText(endingdate[position]);

            return row;
        }
    }
}