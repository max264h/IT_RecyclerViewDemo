package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private ArrayList<HashMap<String,String>> mArrayList;
    public MyListAdapter(ArrayList<HashMap<String,String>> arrayList){
        //這裡創建了一個建構元，接收從外面丟進來的陣列
        this.mArrayList = arrayList;
        //可以用this.來代表這裡建立的變數
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        //這裡宣告物件
        TextView classes,student,number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //這裡綁定物件ID
            classes = itemView.findViewById(R.id.classes);
            student = itemView.findViewById(R.id.student);
            number = itemView.findViewById(R.id.number);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //這裡綁定RecyclerView的Item布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //這裡是放控制物件的方法，比如設定TextView
        //這邊是接收OnCreateViewHolder傳進來的布局，用ViewHolder接收後座使用，後面的變數當然可以改掉，媒改的話就是用holder起手控制物件
        if(position < (mArrayList.size()/2)){
            holder.classes.setText("1 班");
            holder.classes.setBackgroundResource(R.color.red);
        }
        else {
            holder.classes.setText("2 班");
            holder.classes.setBackgroundResource(R.color.blue);
        }
        holder.student.setText(mArrayList.get(position).get("students"));
        holder.number.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
        //這裡通常就會寫傳入的陣列的大小
    }
}
