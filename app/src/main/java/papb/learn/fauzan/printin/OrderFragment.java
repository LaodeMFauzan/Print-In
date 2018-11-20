package papb.learn.fauzan.printin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import papb.learn.fauzan.printin.adapter.OrderHistoryAdapter;
import papb.learn.fauzan.printin.model.OrderModel;

public class OrderFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton myFab;

    private RecyclerView rvOrderHistory;
    private RecyclerView.LayoutManager layoutManager;
    private OrderHistoryAdapter orderHistoryAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order,container, false);
        createRecyclerView(rootView,inflater,container);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myFab = view.findViewById(R.id.floatingActionButton);

        myFab.setOnClickListener(this);

    }

    private void createRecyclerView(View rootView,LayoutInflater inflater, ViewGroup container){
        rvOrderHistory = rootView.findViewById(R.id.rv_order_list);
        rvOrderHistory.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        rvOrderHistory.setLayoutManager(layoutManager);

        orderHistoryAdapter = new OrderHistoryAdapter(initializeData(),this.getContext());
        rvOrderHistory.setAdapter(orderHistoryAdapter);
    }

    private ArrayList<OrderModel> initializeData() {
        ArrayList<OrderModel> models = new ArrayList<>();
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
        models.add(new OrderModel("#001MLGPRNT","Diproses",formattedDate));

        return models;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.floatingActionButton:
                Intent toUploadFile = new Intent(this.getContext(),UploadFileActivity.class);
                startActivity(toUploadFile);
        }
    }
}
