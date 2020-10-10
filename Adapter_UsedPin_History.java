package com.application.organic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter_UsedPin_History extends RecyclerView.Adapter<Adapter_UsedPin_History.Viewholder> implements Filterable
{
   private List<Model_UsedPinHistory> modelclassList;
    private List<Model_UsedPinHistory> modelclassListall;
    Context context;

    public Adapter_UsedPin_History(List<Model_UsedPinHistory> modelclassList , Context context)
    {
        this.modelclassList=modelclassList;
        this.modelclassListall=modelclassList;
        this.context=context;

    }


    @NonNull
    @Override
    public Adapter_UsedPin_History.Viewholder onCreateViewHolder(@NonNull ViewGroup viewgroup, int i) {
        View view= LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.layout_usedpin_history,viewgroup,false);
        return  new Adapter_UsedPin_History.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_UsedPin_History.Viewholder viewholder, int position) {
        final  Model_UsedPinHistory temp=modelclassListall.get(position);

        String firsttext=modelclassListall.get(position).getEpin();
        String secondtext=modelclassListall.get(position).getMembercode();
        String thirdtext=modelclassListall.get(position).getPurchasedate();
        String fourthtext=modelclassListall.get(position).getPinvalue();
        String fifthtext=modelclassListall.get(position).getActivatedmember();
        String sixthtext=modelclassListall.get(position).getActivatedmembername();
        String seventhtext=modelclassListall.get(position).getStatus();


        viewholder.setdata(firsttext,secondtext,thirdtext,fourthtext,fifthtext,sixthtext,seventhtext);
    }

    @Override
    public int getItemCount() {
        return modelclassListall.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String character=constraint.toString();
                if (character.isEmpty())
                {
                    modelclassListall=modelclassList;
                }
                else
                {
                    List<Model_UsedPinHistory> filterList=new ArrayList<>();
                    for (Model_UsedPinHistory row:modelclassList){
                        if(row.getEpin().toLowerCase().contains(character.toLowerCase())){
                            filterList.add(row);
                        }
                        if(row.getPurchasedate().toLowerCase().contains(character.toLowerCase())){
                            filterList.add(row);
                        }
                    }
                    modelclassListall=filterList;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=modelclassListall;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence contraints, FilterResults results) {
                modelclassListall=(ArrayList<Model_UsedPinHistory>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    class Viewholder extends RecyclerView.ViewHolder
    {
        private TextView epin,membercode,purchasedate,pinvalue,activatedmemeber,activatedmemebername,status;

        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            epin=itemView.findViewById(R.id.epinans);
            membercode=itemView.findViewById(R.id.membercodeans);
            purchasedate=itemView.findViewById(R.id.purchasedateans);
            pinvalue=itemView.findViewById(R.id.pinvalueans);
            activatedmemeber=itemView.findViewById(R.id.activatedmemberans);
            activatedmemebername=itemView.findViewById(R.id.activatedmembernameans);
            status=itemView.findViewById(R.id.statusans);
        }
        private void setdata(String epinans,String memcodeans,String purdateans,String pinans,String actmem,String actimemname,String statusans)
        {
            epin.setText(epinans);
            membercode.setText(memcodeans);
            purchasedate.setText(purdateans);
            pinvalue.setText(pinans);
            activatedmemeber.setText(actmem);
            activatedmemebername.setText(actimemname);
            status.setText(statusans);
        }
    }
}
