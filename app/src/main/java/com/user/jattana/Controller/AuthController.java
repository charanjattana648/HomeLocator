package com.user.jattana.Controller;

import android.content.Context;

import com.user.jattana.DAO.UserDAOImpl;
import com.user.jattana.Model.User;

public class AuthController {
    Context context;
    String databaseName;
    public AuthController(Context context,String databaseName)
    {
        this.context=context;
        this.databaseName=databaseName;
    }
    public boolean checkUser(String email, String password,String userType)
    {
        UserDAOImpl userDAOImpl=new UserDAOImpl(context,databaseName);
        User user=userDAOImpl.getUser(email);
        if(user.getPassword()!=null && user.getPassword().equalsIgnoreCase(password) && userType.equalsIgnoreCase(user.getUserType()))
        {
            return true;
        }
        return false;
    }
}
