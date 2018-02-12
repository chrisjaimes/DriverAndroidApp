package com.bignerdranch.android.driverapp;


import android.support.v4.app.Fragment;

public class DeliveryListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DeliveryListFragment();
    }
}
