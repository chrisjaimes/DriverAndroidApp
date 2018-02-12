package com.bignerdranch.android.driverapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DeliveryListFragment extends Fragment {

    private RecyclerView recyclerView;
    private DeliveryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflator, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflator.inflate(R.layout.fragment_delivery_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.delivery_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI() {
        DeliveryData deliveryData = DeliveryData.get(getActivity());
        List<Delivery> deliveries = deliveryData.getDeliveries();

        adapter = new DeliveryAdapter(deliveries);
        recyclerView.setAdapter(adapter);
    }

    private class DeliveryHolder extends RecyclerView.ViewHolder {

        private Delivery delivery;
        private TextView delivery_id;
        private TextView delivery_address;

        public DeliveryHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_delivery, parent, false));

            delivery_id = (TextView) itemView.findViewById(R.id.delivery_title);
            delivery_address = (TextView) itemView.findViewById(R.id.delivery_subtitle);
        }

        public void bind(Delivery d) {
            delivery = d;
            delivery_id.setText("#"+delivery.getId());
            delivery_address.setText(delivery.getAddress());
        }
    }

    private class DeliveryAdapter extends RecyclerView.Adapter<DeliveryHolder> {
        private List<Delivery> deliveries;

        public DeliveryAdapter(List<Delivery> deliveries) {
            this.deliveries = deliveries;
        }

        @Override
        public DeliveryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new DeliveryHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(DeliveryHolder holder, int position) {
            Delivery d = deliveries.get(position);
            holder.bind(d);
        }

        @Override
        public int getItemCount() {
            return deliveries.size();
        }
    }
}
