package com.application.organic;

import android.content.Context;
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

public class Adapter_PurchaseHistory extends RecyclerView.Adapter<Adapter_PurchaseHistory.Viewholder> implements Filterable
{
private List<Model_PurchaseHistory> modelclassList;
    private List<Model_PurchaseHistory> modelclassListall;
    Context context;

    public Adapter_PurchaseHistory(List<Model_PurchaseHistory> modelclassList , Context context)
    {
        this.modelclassList=modelclassList;
        this.modelclassListall=modelclassList;
        this.context=context;

    }

    @NonNull
    @Override
    public Adapter_PurchaseHistory.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_purchase_history,viewGroup,false);
        return new Adapter_PurchaseHistory.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_PurchaseHistory.Viewholder viewholder, int position)
    {
        final  Model_PurchaseHistory temp=modelclassListall.get(position);

        String membercodeque=modelclassListall.get(position).getMembercode();
        String noofpinque=modelclassListall.get(position).getNofofpin();
        String purchasedateque=modelclassListall.get(position).getPurchasedate();
        String pinvalueque=modelclassListall.get(position).getPinvalue();
        String purchasevalue=modelclassListall.get(position).getPurchasevalue();
        String statusque=modelclassListall.get(position).getStatus();

        viewholder.setdata(membercodeque,noofpinque,purchasedateque,pinvalueque,purchasevalue,statusque);
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
                    List<Model_PurchaseHistory> filterList=new ArrayList<>();
                    for (Model_PurchaseHistory row:modelclassList){
                        if(row.getMembercode().toLowerCase().contains(character.toLowerCase())){
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
                modelclassListall=(ArrayList<Model_PurchaseHistory>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    class Viewholder extends RecyclerView.ViewHolder
    {
        private TextView first,second,third,fourth,fifth,sixth;

        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            first=itemView.findViewById(R.id.membercodeans);
            second=itemView.findViewById(R.id.noofpinans);
            third=itemView.findViewById(R.id.purchasedateans);
            fourth=itemView.findViewById(R.id.pinvalueans);
            fifth=itemView.findViewById(R.id.purchasevalueans);
            sixth=itemView.findViewById(R.id.statusans);
        }

        public void setdata(String membercodeque, String noofpinque, String purchasedateque, String pinvalueque, String purchasevalue, String statusque) {
            first.setText(membercodeque);
            second.setText(noofpinque);
            third.setText(purchasedateque);
            fourth.setText(pinvalueque);
            fifth.setText(purchasevalue);
            sixth.setText(statusque);
        }
    }
}
