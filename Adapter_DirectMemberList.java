package com.application.organic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_DirectMemberList extends RecyclerView.Adapter<Adapter_DirectMemberList.Viewholder>
{
    private List<Model_DirectMemberList> modelclassList;

    public  Adapter_DirectMemberList(List<Model_DirectMemberList> modelclassList)
    {
        this.modelclassList=modelclassList;
    }

    @NonNull
    @Override
    public Adapter_DirectMemberList.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_directmember_list,viewGroup,false);
       return  new Adapter_DirectMemberList.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_DirectMemberList.Viewholder viewholder, int position) {
        String membercode=modelclassList.get(position).getMmebercode();
        String memebername=modelclassList.get(position).getMemebername();
        String joinigdate=modelclassList.get(position).getJoiningdate();
        String activationdate=modelclassList.get(position).getActivationdate();
        String currentself=modelclassList.get(position).getCurrentself();
        String accumulatedself=modelclassList.get(position).getAccumulatedself();
        String accumulatedgroup=modelclassList.get(position).getAccumulategroup();
        String currentgroup=modelclassList.get(position).getCurrentgroup();

        viewholder.setdata(membercode,memebername,joinigdate,activationdate,currentself,accumulatedself,accumulatedgroup,currentgroup);
    }

    @Override
    public int getItemCount() {
        return modelclassList.size();
    }
    class Viewholder extends RecyclerView.ViewHolder
    {
        private TextView first,second,third,fourth,fifth,sixth,seventh,eighth;

        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            first=itemView.findViewById(R.id.membercodeans);
            second=itemView.findViewById(R.id.membernameans);
            third=itemView.findViewById(R.id.joiningdateans);
            fourth=itemView.findViewById(R.id.activationdateans);
            fifth=itemView.findViewById(R.id.currentselfans);
            sixth=itemView.findViewById(R.id.accumulatedselfans);
            seventh=itemView.findViewById(R.id.accumulatedgroupans);
            eighth=itemView.findViewById(R.id.currentgroupans);
        }
        private void setdata(String firstque,String secondque,String thirdque,
                             String fourthque,String fifthque,String sixthque, String seventhque,String eightque)
        {
            first.setText(firstque);
            second.setText(secondque);
            third.setText(thirdque);
            fourth.setText(fourthque);
            fifth.setText(fifthque);
            sixth.setText(sixthque);
            seventh.setText(seventhque);
            eighth.setText(eightque);
        }
    }
}
