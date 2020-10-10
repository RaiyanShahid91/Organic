package com.application.organic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class Adapter_EPurchase_Report extends RecyclerView.Adapter<Adapter_EPurchase_Report.Viewholder> {

    private List<Model_EPurchase_Report> modelClassList;

    Context context;

    public Adapter_EPurchase_Report(List<Model_EPurchase_Report> modelClassList, Context context) {
        this.modelClassList = modelClassList;
        this.context=context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_epurchase_report,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {
        String firsttext=modelClassList.get(position).getFirst();
        String secondtext=modelClassList.get(position).getSecond();
        String thirdttext=modelClassList.get(position).getThird();
        String fourthtext=modelClassList.get(position).getFourth();
        String fifthtext=modelClassList.get(position).getFifth();
        String sixthtext=modelClassList.get(position).getSixth();

        viewholder.setdata(firsttext,secondtext,thirdttext,fourthtext,fifthtext,sixthtext);

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView firsttxt,secondtxt,thirdtxt,fourthtxt,fifthtxt,sixthtxt;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            firsttxt=itemView.findViewById(R.id.membername);
            secondtxt=itemView.findViewById(R.id.text2);
            thirdtxt=itemView.findViewById(R.id.text3);
            fourthtxt=itemView.findViewById(R.id.text4);
            fifthtxt=itemView.findViewById(R.id.text5);
            sixthtxt=itemView.findViewById(R.id.text6);
            itemView.setOnClickListener(this);
        }
        private void setdata(String frtext, String setext, String thrtext, String foutext, String fiftext, String sixtext)
        {
            firsttxt.setText(frtext);
            secondtxt.setText(setext);
            thirdtxt.setText(thrtext);
            fourthtxt.setText(foutext);
            fifthtxt.setText(fiftext);
            sixthtxt.setText(sixtext);

        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            Toast.makeText(context, "Opening Report", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(context,saveecoorganicappActivity.class);
        // for getting item name use this code:=    intent.putExtra("name",modelClassList.get(position).getFirst());
            context.startActivity(intent);
        }
    }

}
