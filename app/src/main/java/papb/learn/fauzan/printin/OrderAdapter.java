package papb.learn.fauzan.printin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import papb.learn.fauzan.printin.Entity.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private Context mContext;
    private ArrayList<Order> orderList;

    public OrderAdapter(Context mContext, ArrayList<Order> orderList) {
        this.mContext = mContext;
        this.orderList = orderList;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowvieworder, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        holder.tvNamaOrder.setText(orderList.get(position).getDokumen());
        holder.tvTanggal.setText(orderList.get(position).getTanggal());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{
        TextView tvNamaOrder;
        TextView tvTanggal;

        public OrderViewHolder(View itemView) {
            super(itemView);
            this.tvNamaOrder = itemView.findViewById(R.id.tvNamaDok);
            this.tvTanggal = itemView.findViewById(R.id.tvTanggal);
        }
    }
}
