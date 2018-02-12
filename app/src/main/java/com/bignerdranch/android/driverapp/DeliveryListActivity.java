package com.bignerdranch.android.driverapp;


import android.support.v4.app.Fragment;
import android.util.Log;

public class DeliveryListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        Log.d("DeliveryListActivity", "creating DeliveryListFragment");
        return new DeliveryListFragment();
    }
}
