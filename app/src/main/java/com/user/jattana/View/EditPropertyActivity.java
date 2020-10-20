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

import com.user.jattana.Controller.Validations;
import com.user.jattana.DAO.EstateDAOImpl;
import com.user.jattana.Model.EstateProperty;
import com.user.jattana.R;

import java.util.ArrayList;

public class EditPropertyActivity extends AppCompatActivity {

    Spinner spinnerEdit_type,spinnerEdit_leaseType;
    EditText et_propertyName,et_propertyNumber,et_location,et_num_of_bedrooms,et_num_of_bathrooms,et_size,et_askingPrice,et_localAmenities,et_description;
    String[] type_array={"Apartment", "House", "Bungalow", "Basement", "Room"};
    String[] leaseType_array={"Freehold", "Leasehold", "Shortlet", "Longlet", "Room"};
    Button btn_update,btn_delete;
    TextView txt_id,txt_email;
    private final String DATABASE_NAME="Estate_property_db";

    Validations validations;
    EstateProperty estateProperty;
    EstateDAOImpl estateDAOImpl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_property);
        Intent intent = getIntent();

        txt_id=findViewById(R.id.txt_id_edit);
        txt_email=findViewById(R.id.txt_email_edit);
        et_propertyName=findViewById(R.id.txt_propertyName_edit);
        et_propertyNumber=findViewById(R.id.et_propertyNumber_edit);
        spinnerEdit_type=findViewById(R.id.spinner_type_edit);
        spinnerEdit_leaseType=findViewById(R.id.spinner_leaseType_edit);
        et_location=findViewById(R.id.et_location_edit);
        et_num_of_bedrooms=findViewById(R.id.et_numBedrooms_edit);
        et_num_of_bathrooms=findViewById(R.id.et_numBathrooms_edit);
        et_size=findViewById(R.id.et_size_edit);
        et_askingPrice=findViewById(R.id.et_askingPrice_edit);
        et_localAmenities=findViewById(R.id.et_localAmenities_edit);
        et_description=findViewById(R.id.et_description_edit);
        btn_update=findViewById(R.id.btn_updateProperty);
        btn_delete=findViewById(R.id.btn_deleteProperty);

        ArrayAdapter type_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,type_array);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdit_type.setAdapter(type_adapter);
        ArrayAdapter leaseType_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,leaseType_array);
        leaseType_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdit_leaseType.setAdapter(leaseType_adapter);

        if(intent!=null)
        {
            EstateProperty estateProperty = (EstateProperty)intent.getParcelableExtra("estateProperty");
            Log.d(">>>>>>>edit_intent", "onCreate: "+estateProperty.toString());
            txt_id.setText(estateProperty.getId()+"");
            txt_email.setText(estateProperty.getEmail());
            et_propertyName.setText(estateProperty.getPropertyName());
            et_propertyNumber.setText(estateProperty.getPropertyNumber());
            int type_pos=type_adapter.getPosition(estateProperty.getType());
            spinnerEdit_type.setSelection(type_pos);
            int leaseType_pos=leaseType_adapter.getPosition(estateProperty.getLeaseType());
            spinnerEdit_leaseType.setSelection(leaseType_pos);
            et_location.setText(estateProperty.getLocation());
            et_num_of_bedrooms.setText(estateProperty.getNum_of_bedrooms()+"");
            et_num_of_bathrooms.setText(estateProperty.getNum_of_bathrooms()+"");
            et_size.setText(estateProperty.getSize());
            et_askingPrice.setText(estateProperty.getAskingPrice()+"");
            et_localAmenities.setText(estateProperty.getLocalAmenities());
            et_description.setText(estateProperty.getDescription());

        }
        validations=new Validations();
        estateDAOImpl=new EstateDAOImpl(getApplicationContext(),DATABASE_NAME);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estateDAOImpl.deleteEstateProperty(Integer.parseInt(txt_id.getText().toString()));
                Intent showListProperty_intent=new Intent(EditPropertyActivity.this,ListPropertyActivity.class);
                startActivity(showListProperty_intent);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estateProperty=new EstateProperty();
                estateProperty.setEmail(txt_email.getText().toString());
                estateProperty.setId(Integer.parseInt(txt_id.getText().toString()));
                estateProperty.setPropertyName(et_propertyName.getText().toString());
                estateProperty.setPropertyNumber(et_propertyNumber.getText().toString());
                estateProperty.setType(spinnerEdit_type.getSelectedItem().toString());
                estateProperty.setLeaseType(spinnerEdit_leaseType.getSelectedItem().toString());
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
                    Log.d(">>>>>>>>>>>", "onClick: updating.............");
                    estateDAOImpl.updateEstateProperty(estateProperty);
                    Intent showListProperty_intent=new Intent(EditPropertyActivity.this,ListPropertyActivity.class);
                    startActivity(showListProperty_intent);

                }else{
                    Toast.makeText(EditPropertyActivity.this, ""+isValid, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}