package com.user.jattana.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class EstateProperty implements Parcelable {
    public int id;
    public String email;
    public String propertyName;
    public String propertyNumber;
    public String type;
    public String leaseType;
    public String location;
    public int num_of_bedrooms;
    public int num_of_bathrooms;
    public String size;
    public double askingPrice;
    public String localAmenities;
    public String description;

    public EstateProperty() {
    }

    public EstateProperty(int id, String email, String propertyName, String propertyNumber, String type, String leaseType, String location, int num_of_bedrooms, int num_of_bathrooms, String size, double askingPrice, String localAmenities, String description) {
        this.id = id;
        this.email=email;
        this.propertyName = propertyName;
        this.propertyNumber = propertyNumber;
        this.type = type;
        this.leaseType = leaseType;
        this.location = location;
        this.num_of_bedrooms = num_of_bedrooms;
        this.num_of_bathrooms = num_of_bathrooms;
        this.size = size;
        this.askingPrice = askingPrice;
        this.localAmenities = localAmenities;
        this.description = description;
    }

    protected EstateProperty(Parcel in) {
        id = in.readInt();
        email = in.readString();
        propertyName = in.readString();
        propertyNumber = in.readString();
        type = in.readString();
        leaseType = in.readString();
        location = in.readString();
        num_of_bedrooms = in.readInt();
        num_of_bathrooms = in.readInt();
        size = in.readString();
        askingPrice = in.readDouble();
        localAmenities = in.readString();
        description = in.readString();
    }

    public static final Creator<EstateProperty> CREATOR = new Creator<EstateProperty>() {
        @Override
        public EstateProperty createFromParcel(Parcel in) {
            return new EstateProperty(in);
        }

        @Override
        public EstateProperty[] newArray(int size) {
            return new EstateProperty[size];
        }
    };

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNum_of_bedrooms(int num_of_bedrooms) {
        this.num_of_bedrooms = num_of_bedrooms;
    }

    public void setNum_of_bathrooms(int num_of_bathrooms) {
        this.num_of_bathrooms = num_of_bathrooms;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }

    public void setLocalAmenities(String localAmenities) {
        this.localAmenities = localAmenities;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public String getType() {
        return type;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public String getLocation() {
        return location;
    }

    public int getNum_of_bedrooms() {
        return num_of_bedrooms;
    }

    public int getNum_of_bathrooms() {
        return num_of_bathrooms;
    }

    public String getSize() {
        return size;
    }

    public double getAskingPrice() {
        return askingPrice;
    }

    public String getLocalAmenities() {
        return localAmenities;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "EstateProperty{" +
                "id:" + id +
                ", email:'" + email + '\'' +
                ", propertyName:'" + propertyName + '\'' +
                ", propertyNumber:'" + propertyNumber + '\'' +
                ", type='" + type + '\'' +
                ", leaseType:'" + leaseType + '\'' +
                ", location:'" + location + '\'' +
                ", num_of_bedrooms:" + num_of_bedrooms +
                ", num_of_bathrooms:" + num_of_bathrooms +
                ", size:'" + size + '\'' +
                ", askingPrice:" + askingPrice +
                ", localAmenities:'" + localAmenities + '\'' +
                ", description:'" + description + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(email);
        parcel.writeString(propertyName);
        parcel.writeString(propertyNumber);
        parcel.writeString(type);
        parcel.writeString(leaseType);
        parcel.writeString(location);
        parcel.writeInt(num_of_bedrooms);
        parcel.writeInt(num_of_bathrooms);
        parcel.writeString(size);
        parcel.writeDouble(askingPrice);
        parcel.writeString(localAmenities);
        parcel.writeString(description);
    }

}
