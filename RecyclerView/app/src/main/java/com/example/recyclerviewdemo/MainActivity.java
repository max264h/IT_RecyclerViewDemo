package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private MyListAdapter myListAdapter;
    private ArrayList<HashMap<String,String>> arrayList;
    //這裡我宣告ArrayList裡面要放入HashMap，HashMap就相當於"字典"，要往裡面放入Key跟Value
    //透過這種方式我就可以輸入大量不同的資料，後面要使用時我在去找到對應的Key就好
    private String[] students_data = {"A","B","C","D","E","F","G","H"
                                     ,"I","J","K","L","M","N","O","P"
                                     ,"Q","R","S","T","U","V","W","X"
                                     ,"Y","Z"};//學生的假資料
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        makeData();
        setRecyclerView();
    }

    private void makeData() {//建立假資料
        for (int i = 0; i < 26; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("students",students_data[i]);
            arrayList.add(hashMap);//用add的方式把HashMap加入到ArrayList裡
            Log.d("test", "makeData: "+arrayList);
        }
    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));//綁定RecyclerView
        myListAdapter = new MyListAdapter(arrayList);//將我的ArrayList丟入ListAdapter
        recyclerView.setAdapter(myListAdapter);
    }
}