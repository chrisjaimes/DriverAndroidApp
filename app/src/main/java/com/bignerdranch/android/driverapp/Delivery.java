package com.bignerdranch.android.driverapp;

public class Delivery {
    private long id;
    private String address;
    private String customerName;
    private long driverId;

//    public Delivery() {
//        id = 132;
//        address = "lksdjf";
//        customerName= "lskdfjssss";
//        driverId = 4324;
//    }
    public long getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getCustomerName() {
        return customerName;
    }
    public long getDriverId() {
        return driverId;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setCustomer_name(String name) {
        this.customerName = name;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setDriver_id(long id) {
        this.driverId = id;
    }

}
