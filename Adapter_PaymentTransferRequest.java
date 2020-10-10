package com.application.organic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_PaymentTransferRequest extends RecyclerView.Adapter<Adapter_PaymentTransferRequest.ViewHolder>
{

    LayoutInflater inflater;
    List<Model_PaymentPurchaseRequest>modelclasslists;

    public Adapter_PaymentTransferRequest(Context ctx, List<Model_PaymentPurchaseRequest> modelclasslists)
    {
        this.inflater=LayoutInflater.from(ctx);
        this.modelclasslists=modelclasslists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=inflater.inflate(R.layout.layout_paymenttransferrequest,parent,false);
        return new Adapter_PaymentTransferRequest.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_PaymentTransferRequest.ViewHolder holder, int position) {
        holder.id.setText(modelclasslists.get(position).getFirst());
        holder.memberid.setText(modelclasslists.get(position).getSecond());
        holder.description.setText(modelclasslists.get(position).getThird());
        holder.amount.setText(modelclasslists.get(position).getFourth());
        holder.date.setText(modelclasslists.get(position).getFifth());
        holder.idate.setText(modelclasslists.get(position).getSixth());
        holder.type.setText(modelclasslists.get(position).getSeventh());
        holder.amountnp.setText(modelclasslists.get(position).getEighth());

    }

    @Override
    public int getItemCount() {return modelclasslists.size(); }

    public class  ViewHolder extends RecyclerView.ViewHolder
{
    TextView id,memberid,description,amount,date,idate,type,amountnp;

    public ViewHolder(@NonNull View itemView)
    {
        super(itemView);
        id=itemView.findViewById(R.id.firsttext);
        memberid=itemView.findViewById(R.id.secondtext);
        description=itemView.findViewById(R.id.first);
        amount=itemView.findViewById(R.id.second);
        date=itemView.findViewById(R.id.third);
        idate=itemView.findViewById(R.id.fourth);
        type=itemView.findViewById(R.id.fifth);
        amountnp=itemView.findViewById(R.id.sixth);
    }
}
}
