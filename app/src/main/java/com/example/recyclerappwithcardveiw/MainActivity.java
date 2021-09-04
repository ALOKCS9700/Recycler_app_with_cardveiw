package com.example.recyclerappwithcardveiw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addbtn,removebtn;
    private EditText addedit,removeedit;

    ArrayList<exampleitem> itemlist;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbtn=findViewById(R.id.btnadd);
        removebtn=findViewById(R.id.btnremove);
        addedit=findViewById(R.id.editadd);
        removeedit=findViewById(R.id.editremove);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(addedit.getText().toString())){
                    addedit.setError("Empty not allowed");
                }else{
                    int position=Integer.parseInt(addedit.getText().toString());
                    addcard(position);
                }



            }
        });
        removebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(removeedit.getText().toString())){
                    removeedit.setError("Empty not allowed");
                }else{
                    int position=Integer.parseInt(removeedit.getText().toString());
                    remcard(position);
                }


            }
        });



        itemlist=new ArrayList();
        listdata();
        recyclerviewconfig();






    }
    public void listdata(){

        itemlist.add(new exampleitem(R.drawable.phla,"This is a image one"));
        itemlist.add(new exampleitem(R.drawable.tw,"This is a image two"));
        itemlist.add(new exampleitem(R.drawable.thre,"This is a image three"));
        itemlist.add(new exampleitem(R.drawable.fou,"This is a image four"));
        itemlist.add(new exampleitem(R.drawable.fiv,"This is a image five"));
        itemlist.add(new exampleitem(R.drawable.si,"This is a image six"));
        itemlist.add(new exampleitem(R.drawable.seve,"This is a image seven"));
        itemlist.add(new exampleitem(R.drawable.eigh,"This is a image eight"));
        itemlist.add(new exampleitem(R.drawable.nin,"This is a image nine"));

    }
    public void recyclerviewconfig(){
        recyclerView= findViewById(R.id.recyclerView);
        // for performance
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(this);
        adapter = new ExampleAdapter(itemlist);//eseme problem hoga agar hona hoga to
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void addcard(int position){
        itemlist.add(position,new exampleitem(R.drawable.phla," image added"));
        adapter.notifyItemInserted(position);

    }
    public void remcard(int position){
        itemlist.remove(position);
        adapter.notifyItemRemoved(position);
    }

}