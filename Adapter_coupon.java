package com.application.organic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_coupon extends RecyclerView.Adapter<Adapter_coupon.Viewholder>
{
    private List<Model_Coupon> modelClassList;

    public  Adapter_coupon(List<Model_Coupon> modelClassList )
    {
        this.modelClassList=modelClassList;
    }

    @NonNull
    @Override
    public Adapter_coupon.Viewholder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int i)
    {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_coupon,viewGroup,false);
        return new Adapter_coupon.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_coupon.Viewholder viewholder, int position)
    {
        String textstatus=modelClassList.get(position).getFirsttxt();
        String textdate=modelClassList.get(position).getSecondtxt();
        String textproduct=modelClassList.get(position).getThirdtxt();
        int codeimage=modelClassList.get(position).getImagefirst();

        viewholder.setdata(textstatus,textdate,textproduct,codeimage);
    }

    @Override
    public int getItemCount() {
      return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder
    {
        private TextView firsttext,secondtext,thirdtext;
        private ImageView imageView;

        public Viewholder(View itemview)
        {
            super(itemview);
            firsttext=itemview.findViewById(R.id.status);
            secondtext=itemview.findViewById(R.id.date);
            thirdtext=itemview.findViewById(R.id.firsttext);
            imageView=itemview.findViewById(R.id.barcodeimage);
        }
        private void setdata(String firsttxt,String secondtxt, String thirdtxt, int image)
        {
            firsttext.setText(firsttxt);
            secondtext.setText(secondtxt);
            thirdtext.setText(thirdtxt);
            imageView.setImageResource(image);
        }
    }
}
