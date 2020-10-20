package com.user.jattana.Controller;

import com.user.jattana.Model.EstateProperty;
import com.user.jattana.Model.User;

public class Validations {

    public String checkUserLoginValidations(User user)
    {
        if(user.getEmail()=="")
        {
            return "Please enter Email!";
        }else if(user.getPassword()=="")
        {
            return "Please enter Password!!";
        }
        return "";
    }
    public String checkUserRegistrationValidations(User user)
    {
        if(user.getEmail()=="")
        {
            return "Please enter Email!";
        }else if(user.getFName()=="")
        {
            return "Please enter FirstName!";
        }else if(user.getLName()=="")
        {
            return "Please enter LastName!";
        }else if(user.getPassword()=="")
        {
            return "Please enter Password!!";
        }
        return "";
    }
    public String checkAddPropertyValidations(EstateProperty estateProperty)
    {
        if(estateProperty.getPropertyName()=="")
        {
            return "Please enter Property Name!";
        }else if(estateProperty.getPropertyNumber()=="")
        {
            return "Please enter Property Number!";
        }else if(estateProperty.getType()=="")
        {
            return "Please select Property Type!";
        }else if(estateProperty.getLeaseType()=="")
        {
            return "Please enter Lease Type!!";
        }else if(estateProperty.getLocation()=="")
        {
            return "Please enter Location!";
        }else if(estateProperty.getSize()=="")
        {
            return "Please enter size!!";
        }
        return "";
    }
}
