package papb.learn.fauzan.printin;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import papb.learn.fauzan.printin.Entity.Order;

public class OrderListsActivity extends AppCompatActivity {

    ArrayList<Order> orderProcessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_lists);
        orderProcessList = new ArrayList<>();

        setTitle("Order");

        initOrders();
        initRecyclerView(isOrderNotEmpty());
        initFab();
    }

    private boolean isOrderNotEmpty() {
        if (!orderProcessList.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    private void initFab() {
        FloatingActionButton fab = findViewById(R.id.btTambahOrder);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tambah Order", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void initRecyclerView(boolean orderNotEmpty) {
        if (orderNotEmpty) {
            RecyclerView recyclerView = findViewById(R.id.recyclerviewOrder);
            OrderAdapter adapter = new OrderAdapter(this, orderProcessList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    private void initOrders() {
        orderProcessList.add(new Order("Dokumen", "15/3/2018 12:23"));
        orderProcessList.add(new Order("Dokumen", "15/3/2018 12:23"));
        orderProcessList.add(new Order("Dokumen", "15/3/2018 12:23"));
        orderProcessList.add(new Order("Dokumen", "15/3/2018 12:23"));
        orderProcessList.add(new Order("Dokumen", "15/3/2018 12:23"));

    }

}
