package com.user.jattana.DAO;

import com.user.jattana.Model.EstateProperty;

import java.util.List;

public interface EstateDAO {
    public long addEstateProperty(EstateProperty estateProperty);
    public int updateEstateProperty(EstateProperty estateProperty);
    public int deleteEstateProperty(int id);
    public List<EstateProperty> getEstatePropertyListByEmail(String email);
    public EstateProperty getEstateProperty(int id);
    public List<EstateProperty> getEstatePropertyList();
}
