package com.ilkaygunel.jpaandmongodb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Address implements Serializable{
    @Basic
    private String street;
    
    @Basic
    private String neighborhood;
    
    @Basic
    private String district;
    
    @Basic
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
