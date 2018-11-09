package papb.learn.fauzan.printin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;

import papb.learn.fauzan.printin.adapter.OrderSummaryAdapter;
import papb.learn.fauzan.printin.model.OrderCriteriaModel;

public class OrderSummaryActivity extends AppCompatActivity {

    private RecyclerView rvOrderSummary;
    private OrderSummaryAdapter orderSummaryAdapter;
    private RecyclerView.LayoutManager lmOrderSummary;

    private Button btn_checkout_order;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        showListOrderSummary();
    }

    private void showListOrderSummary(){
        rvOrderSummary = findViewById(R.id.rv_summary_order);
        rvOrderSummary.setHasFixedSize(true);

        lmOrderSummary = new LinearLayoutManager(this);
        rvOrderSummary.setLayoutManager(lmOrderSummary);

        orderSummaryAdapter = new OrderSummaryAdapter(initializeOrderSummary(),getApplicationContext());
        rvOrderSummary.setAdapter(orderSummaryAdapter);
    }

    private ArrayList<OrderCriteriaModel> initializeOrderSummary() {
        ArrayList<OrderCriteriaModel> orderSummaryModels = new ArrayList<>();
        OrderCriteriaModel orderTest1 = new OrderCriteriaModel("Laporan Sisop","A4-80","Lakban","Transparan","Biru",true,true);
        OrderCriteriaModel orderTest2 = new OrderCriteriaModel("Proposal Skripsi","A4-70","Lakban","Biru","Biru",false,true);
        orderSummaryModels.add(orderTest1);
        orderSummaryModels.add(orderTest2);

        return orderSummaryModels;
    }
}
