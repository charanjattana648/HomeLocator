package com.user.jattana.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.user.jattana.Controller.AuthController;
import com.user.jattana.DAO.UserDAOImpl;
import com.user.jattana.Model.User;
import com.user.jattana.R;

public class LoginActivity extends AppCompatActivity {

    private final String DATABASE_NAME="Estate_property_db";
    String[] userType_array={"User", "Agent", "Owner"};
    EditText email,password;
    Button signIn_btn,signUp_btn;
    Spinner userType_spinner;
    TextView txt_forgotPassword;
    AuthController authController;
    UserDAOImpl userDAOImpl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.et_email_login);
        password=findViewById(R.id.et_password_login);
        signIn_btn=findViewById(R.id.btn_login);
        signUp_btn=findViewById(R.id.btn_signUp);
        userType_spinner=findViewById(R.id.spinner_userType_login);
        txt_forgotPassword=findViewById(R.id.tv_forgotPassword);

        ArrayAdapter userType_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,userType_array);
        userType_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userType_spinner.setAdapter(userType_adapter);

        authController=new AuthController(getApplicationContext(),DATABASE_NAME);
        userDAOImpl=new UserDAOImpl(getApplicationContext(),DATABASE_NAME);
//        for(User u:userDAOImpl.getUserList())
//        {
//            Log.d(">>>>>>user ", "onCreate: "+u.toString());
//        }

        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_i=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(register_i);
            }
        });

        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                boolean isValidUser=authController.checkUser(email.getText().toString(),password.getText().toString(),userType_spinner.getSelectedItem().toString());
                if(isValidUser==true)
                {
                    Intent main_intent=new Intent(getApplicationContext(),MainActivity.class);
                    Log.d(">>>>>>>>>>>", "onClick: passing from login to main .... "+email.getText().toString());
                    main_intent.putExtra("currentUser",email.getText().toString());
                    main_intent.putExtra("currentUserType",userType_spinner.getSelectedItem().toString());
                    startActivity(main_intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Email Id or Password is wrong!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}