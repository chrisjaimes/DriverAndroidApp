package com.bignerdranch.android.driverapp;

/**
 * Created by Owner on 2/11/2018.
 */

public class Delivery {
    private long id;
    private String address;
    private String customerName;
    private long driver_id;

    public Delivery() {
        id = 132;
        address = "lksdjf";
        customerName = "lskdfjssss";
        driver_id = 4324;
    }
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
        return driver_id;
    }
}
