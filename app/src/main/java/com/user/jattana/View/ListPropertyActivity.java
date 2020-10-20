package com.user.jattana.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.user.jattana.DAO.EstateDAOImpl;
import com.user.jattana.Model.EstateProperty;
import com.user.jattana.R;

import java.util.ArrayList;
import java.util.List;

public class ListPropertyActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    EstateDAOImpl estateDAOImpl;
    private final String DATABASE_NAME="Estate_property_db";
    SearchView searchView_filterList;
    ArrayList<EstateProperty> estatePropertyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_property);

        recyclerView=findViewById(R.id.estateProperty_recyclerView);
        searchView_filterList=findViewById(R.id.searchView_filterList);

        estateDAOImpl=new EstateDAOImpl(getApplicationContext(),DATABASE_NAME);
        estatePropertyList=estateDAOImpl.getEstatePropertyList();

        customAdapter=new CustomAdapter(ListPropertyActivity.this,estatePropertyList);
        recyclerView.setAdapter(customAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

//        adapter=new ListViewAdapter(this,estatePropertyList);
//        recyclerView.setAdapter(adapter);
        searchView_filterList.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(">>>>>>>", "onQueryTextChange: enteringg....");
        customAdapter.filter(newText);
        return false;
    }
}