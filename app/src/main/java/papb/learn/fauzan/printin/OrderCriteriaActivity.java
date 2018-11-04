package papb.learn.fauzan.printin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import papb.learn.fauzan.printin.adapter.OrderCriteriaAdapter;
import papb.learn.fauzan.printin.model.OrderCriteriaModel;

public class OrderCriteriaActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView  rvOrder;
    private OrderCriteriaAdapter adapterOrderCriteria;
    private RecyclerView.LayoutManager lmOrderCriteria;

    private Button btn_save_criteria;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_criteria);
        btn_save_criteria = findViewById(R.id.btn_simpan_kriteria);

        btn_save_criteria.setOnClickListener(this);

        showListOrder();
    }

    private void showListOrder(){
        rvOrder = findViewById(R.id.rv_order_criteria);

        rvOrder.setHasFixedSize(true);

        lmOrderCriteria = new LinearLayoutManager(this);
        rvOrder.setLayoutManager(lmOrderCriteria);

        adapterOrderCriteria=new OrderCriteriaAdapter(initializeData(),getApplicationContext());
        rvOrder.setAdapter(adapterOrderCriteria);
    }

    private ArrayList<OrderCriteriaModel> initializeData(){
        ArrayList<OrderCriteriaModel> orderCriteriaModels = new ArrayList<>();
        OrderCriteriaModel orderTest1 = new OrderCriteriaModel("Laporan Sisop","a","a","a","a",true,true);
        OrderCriteriaModel orderTest2 = new OrderCriteriaModel("Proposal Skripsi","a","a","a","a",false,true);
        orderCriteriaModels.add(orderTest1);
        orderCriteriaModels.add(orderTest2);

        return orderCriteriaModels;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_simpan_kriteria :
                Intent toMapDelivery = new Intent(this,OrderMapsActivity.class);
                startActivity(toMapDelivery);
                break;
        }
    }
}
