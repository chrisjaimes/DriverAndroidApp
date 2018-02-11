package com.bignerdranch.android.driverapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.android.driverapp.Delivery;
import com.bignerdranch.android.driverapp.R;

public class DeliveryFragment extends Fragment {
    private Delivery delivery;
    private TextView id_field, address_field, customer_field;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delivery = new Delivery();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_delivery, container, false);

        id_field = (TextView) v.findViewById(R.id.delivery_id_field);
        customer_field = (TextView) v.findViewById(R.id.delivery_customer_field);
        address_field = (TextView) v.findViewById(R.id.delivery_address_field);

        return v;
    }
}
