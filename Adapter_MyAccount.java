package com.application.organic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_MyAccount extends RecyclerView.Adapter<Adapter_MyAccount.Viewholder>
{
    private List<Model_MyAccount> modelClassList;

    public Adapter_MyAccount(List<Model_MyAccount> modelClassList) {
        this.modelClassList = modelClassList;
    }
    @NonNull
    @Override
    public Adapter_MyAccount.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_myaccount,viewGroup,false);
        return new Adapter_MyAccount.Viewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter_MyAccount.Viewholder viewholder, int position) {
        String firsttext=modelClassList.get(position).getFirst();
        String thirdttext=modelClassList.get(position).getSecond();
        String fourtttext=modelClassList.get(position).getThird();

        viewholder.setdata(firsttext,thirdttext,fourtttext);
    }
    @Override
    public int getItemCount() {
        return modelClassList.size();
    }
    class Viewholder extends RecyclerView.ViewHolder{

        private TextView first,third,fourth;
        private ImageView image;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            first = itemView.findViewById(R.id.date);
            third = itemView.findViewById(R.id.pinpurchase);
            fourth = itemView.findViewById(R.id.rupess);
        }
            private void setdata(String firtext, String thirtext, String foutext)
            {
                first.setText(firtext);
                third.setText(thirtext);
                fourth.setText(foutext);
            }
        }

    }
