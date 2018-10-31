package papb.learn.fauzan.printin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import papb.learn.fauzan.printin.model.OrderCriteriaModel;

public class OrderCriteriaAdapter extends RecyclerView.Adapter<OrderCriteriaAdapter.ViewHolder> {

    private ArrayList<OrderCriteriaModel> orderCriteriaModel;

    public OrderCriteriaAdapter(ArrayList<OrderCriteriaModel> dataSet) {
        this.orderCriteriaModel = dataSet;
    }

    @Override
    public OrderCriteriaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(OrderCriteriaAdapter.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return orderCriteriaModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
