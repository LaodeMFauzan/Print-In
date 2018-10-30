package papb.learn.fauzan.printin;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import papb.learn.fauzan.printin.adapter.OrderCriteriaAdapter;

public class OrderCriteriaActivity extends Activity {
    private RecyclerView  rvOrder;
    private RecyclerView.Adapter adapterOrderCriteria;
    private RecyclerView.LayoutManager lmOrderCriteria;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_criteria);
        rvOrder = findViewById(R.id.rv_order_criteria);

        rvOrder.setHasFixedSize(true);

        lmOrderCriteria = new LinearLayoutManager(this);
        rvOrder.setLayoutManager(lmOrderCriteria);

        String[] dataSet = new String[10];
        adapterOrderCriteria = new OrderCriteriaAdapter(dataSet);
        rvOrder.setAdapter(adapterOrderCriteria);
    }
}
