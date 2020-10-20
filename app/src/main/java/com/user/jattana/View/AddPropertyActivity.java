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
import android.widget.Toast;

import com.user.jattana.Controller.Validations;
import com.user.jattana.DAO.EstateDAOImpl;
import com.user.jattana.Model.EstateProperty;
import com.user.jattana.R;
import com.user.jattana.config.TableDefinitions;

public class AddPropertyActivity extends AppCompatActivity {

    Spinner spinnerAdd_type,spinnerAdd_leaseType;
    EditText et_propertyName,et_propertyNumber,et_location,et_num_of_bedrooms,et_num_of_bathrooms,et_size,et_askingPrice,et_localAmenities,et_description;
    String[] type_array={"Apartment", "House", "Bungalow", "Basement", "Room"};
    String[] leaseType_array={"Freehold", "Leasehold", "Shortlet", "Longlet", "Room"};
    Button btn_add;
    private final String DATABASE_NAME="Estate_property_db";
    String userEmail="",userType="";
    Validations validations;
    EstateProperty estateProperty;
    EstateDAOImpl estateDAOImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);

        et_propertyName=findViewById(R.id.txt_propertyName);
        et_propertyNumber=findViewById(R.id.et_propertyNumber_add);
        spinnerAdd_type=findViewById(R.id.spinner_type_add);
        spinnerAdd_leaseType=findViewById(R.id.spinner_leaseType_add);
        et_location=findViewById(R.id.et_location_add);
        et_num_of_bedrooms=findViewById(R.id.et_numBedrooms_add);
        et_num_of_bathrooms=findViewById(R.id.et_numBathrooms_add);
        et_size=findViewById(R.id.et_size_add);
        et_askingPrice=findViewById(R.id.et_askingPrice_add);
        et_localAmenities=findViewById(R.id.et_localAmenities_add);
        et_description=findViewById(R.id.et_description_add);
        btn_add=findViewById(R.id.btn_addProperty);

        validations=new Validations();
        estateDAOImpl=new EstateDAOImpl(getApplicationContext(),DATABASE_NAME);
        Intent intent=getIntent();
        if(intent!=null)
        {
            Log.d(">>>>>>>>>", "onCreate: intent entering.......... "+intent.getStringExtra("currentUser"));
            if(intent.getStringExtra("currentUser")!=null) {
                Log.d(">>>>>>>>>", "onCreate: intent entering current user.......... "+intent.getStringExtra("currentUser"));
                userEmail = intent.getStringExtra("currentUser");
                userType = intent.getStringExtra("currentUserType");
            }
        }

        ArrayAdapter type_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,type_array);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdd_type.setAdapter(type_adapter);
        ArrayAdapter leaseType_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,leaseType_array);
        leaseType_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdd_leaseType.setAdapter(leaseType_adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estateProperty=new EstateProperty();
                estateProperty.setEmail(userEmail);
                estateProperty.setPropertyName(et_propertyName.getText().toString());
                estateProperty.setPropertyNumber(et_propertyNumber.getText().toString());
                estateProperty.setType(spinnerAdd_type.getSelectedItem().toString());
                estateProperty.setLeaseType(spinnerAdd_leaseType.getSelectedItem().toString());
                estateProperty.setLocation(et_location.getText().toString());
                estateProperty.setNum_of_bedrooms(Integer.parseInt(et_num_of_bedrooms.getText().toString()));
                estateProperty.setNum_of_bathrooms(Integer.parseInt(et_num_of_bathrooms.getText().toString()));
                estateProperty.setSize(et_size.getText().toString());
                estateProperty.setAskingPrice(Double.parseDouble(et_askingPrice.getText().toString()));
                estateProperty.setLocalAmenities(et_localAmenities.getText().toString());
                estateProperty.setDescription(et_description.getText().toString());
                String isValid=validations.checkAddPropertyValidations(estateProperty);
                if(isValid=="")
                {
                    estateDAOImpl.addEstateProperty(estateProperty);
                    Intent listProperty_intent=new Intent(getApplicationContext(),MainActivity.class);
                    listProperty_intent.putExtra("currentUser",userEmail);
                    listProperty_intent.putExtra("currentUserType",userType);
                    startActivity(listProperty_intent);
                }else{
                    Toast.makeText(AddPropertyActivity.this, ""+isValid, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}