package com.application.organic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Genealogy extends RecyclerView.Adapter<Adapter_Genealogy.Viewholder>
{
    private List<Model_Genealogy> modelClassList;

    public Adapter_Genealogy(List<Model_Genealogy> modelClassList) {
        this.modelClassList = modelClassList;
    }
    @NonNull
    @Override
    public Adapter_Genealogy.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_genealogy,viewGroup,false);
        return new Adapter_Genealogy.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Genealogy.Viewholder viewholder, int position) {
        String firsttext=modelClassList.get(position).getFirsttxt();
        String secondtext=modelClassList.get(position).getSecondtxt();
        String thirdttext=modelClassList.get(position).getThirdtxt();
        String fourtttext=modelClassList.get(position).getFourthtxt();
        String fifthtext=modelClassList.get(position).getFifthtxt();

        viewholder.setdata(firsttext,secondtext,thirdttext,fourtttext,fifthtext);

    }
    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView first,second,third,fourth,fifth;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            first=itemView.findViewById(R.id.firsttextinput);
            second=itemView.findViewById(R.id.firstsecondtextinput);
            third=itemView.findViewById(R.id.secondtextinput);
            fourth=itemView.findViewById(R.id.thirdtextinput);
            fifth=itemView.findViewById(R.id.fourthtextinput);

        }
        private void setdata(String firtext, String sectext, String thirtext,String foutext,String fiftext)
        {
            first.setText(firtext);
            second.setText(sectext);
            third.setText(thirtext);
            fourth.setText(foutext);
            fifth.setText(fiftext);
        }
    }

}
