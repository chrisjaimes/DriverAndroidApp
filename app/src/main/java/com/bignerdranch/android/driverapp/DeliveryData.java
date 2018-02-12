package com.bignerdranch.android.driverapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Owner on 2/11/2018.
 */

public class DeliveryData {
    private static DeliveryData deliveryData;
    private List<Delivery> deliveries;

    private DeliveryData(Context context) {
        deliveries = new ArrayList<>();
        for(int i = 0; i < 40; i++) {
            Delivery d = new Delivery();
            d.setAddress("Address #" + i);
            d.setId(1);
            deliveries.add(d);
        }
    }

    public static DeliveryData get(Context context) {
        if(deliveryData == null) {
            deliveryData = new DeliveryData(context);
        }
        return deliveryData;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public Delivery getDelivery(long id) {
        for(Delivery delivery : deliveries) {
            if(delivery.getId() == id) {
                return delivery;
            }
        }
        return null;
    }
}
