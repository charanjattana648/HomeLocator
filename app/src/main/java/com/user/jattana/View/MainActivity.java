package com.user.jattana.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.user.jattana.R;

public class MainActivity extends AppCompatActivity {

    Button btn_addProperty,btn_showListProperty;
    String userEmail,userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_addProperty=findViewById(R.id.btn_propertyAdd);
        btn_showListProperty=findViewById(R.id.btn_propertyListShow);
        Intent intent=getIntent();
        if(intent!=null)
        {

            Log.d(">>>>>>>>>", "onCreate: intent entering.main......... "+intent.getStringExtra("currentUser"));
            if(intent.getStringExtra("currentUser")!=null) {
                userEmail = intent.getStringExtra("currentUser");
                userType = intent.getStringExtra("currentUserType");
            }
        }

        btn_addProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addProperty_intent=new Intent(MainActivity.this,AddPropertyActivity.class);
                Log.d(">>>>>>>>>>>", "onClick: useremail ..... "+userEmail);
                addProperty_intent.putExtra("currentUser",userEmail);
                addProperty_intent.putExtra("currentUserType",userType);
                startActivity(addProperty_intent);
            }
        });
        btn_showListProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showListProperty_intent=new Intent(MainActivity.this,ListPropertyActivity.class);
                intent.putExtra("currentUser",userEmail);
                intent.putExtra("currentUserType",userType);
                startActivity(showListProperty_intent);
            }
        });
    }
}