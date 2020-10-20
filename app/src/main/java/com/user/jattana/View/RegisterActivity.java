package com.user.jattana.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.user.jattana.DAO.UserDAOImpl;
import com.user.jattana.Model.User;
import com.user.jattana.R;

public class RegisterActivity extends AppCompatActivity {

    private final String DATABASE_NAME="Estate_property_db";
    EditText fName,lName,email,password,confirm_password;
    Button signIn_btn,register_btn;
    Spinner userType;
    String[] userType_array={"User", "Agent", "Owner"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fName=findViewById(R.id.et_firstName);
        lName=findViewById(R.id.et_lName);
        email=findViewById(R.id.et_email_register);
        userType=findViewById(R.id.spinner_userType);
        password=findViewById(R.id.et_password_register);
        confirm_password=findViewById(R.id.et_confirmPassword_register);
        signIn_btn=findViewById(R.id.btn_register_login);
        register_btn=findViewById(R.id.btn_register);

        ArrayAdapter userType_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,userType_array);
        userType_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userType.setAdapter(userType_adapter);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDAOImpl userDAOImpl=new UserDAOImpl(getApplicationContext(),DATABASE_NAME);
                User user=new User();
                user.setFName(fName.getText().toString());
                user.setLName(lName.getText().toString());
                user.setEmail(email.getText().toString());
                user.setUserType(userType.getSelectedItem().toString());
                user.setPassword(password.getText().toString());
                if(user.getPassword().equals(confirm_password.getText().toString()))
                {
                long rowId=userDAOImpl.addUser(user);
                if(rowId>0)
                {
                    Toast.makeText(getApplicationContext(),"User is registered with email: "+email.getText().toString(),Toast.LENGTH_LONG);
                    Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }}else{
                    Toast.makeText(getApplicationContext(),"Password and Confirm Password not matching!!! ",Toast.LENGTH_LONG);
                }
            }
        });

        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}