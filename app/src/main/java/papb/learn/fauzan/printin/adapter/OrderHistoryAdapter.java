package papb.learn.fauzan.printin.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import papb.learn.fauzan.printin.R;
import papb.learn.fauzan.printin.model.OrderModel;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder> {

    private ArrayList<OrderModel> orderModelList;
    private Context context;

    public OrderHistoryAdapter() {
    }

    public OrderHistoryAdapter(ArrayList<OrderModel> orderModelList, Context context) {
        this.orderModelList = orderModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_order_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryAdapter.ViewHolder holder, int position) {
        holder.tv_invoice_id.setText(orderModelList.get(position).getInvoiceId());
        holder.tv_status_order.setText(orderModelList.get(position).getStatusOrder());
        holder.tv_order_date.setText(orderModelList.get(position).getTanggal());

        Drawable delivery_icon = ContextCompat.getDrawable(context,R.drawable.ic_baseline_print_24px);
        holder.iv_img_order.setImageDrawable(delivery_icon);
    }

    @Override
    public int getItemCount() {
        return orderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_invoice_id,tv_status_order,tv_order_date;
        ImageView iv_img_order;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_invoice_id = itemView.findViewById(R.id.tv_order_invoice_id);
            tv_status_order = itemView.findViewById(R.id.tv_order_status);
            tv_order_date = itemView.findViewById(R.id.tv_tangggal_order);
            iv_img_order = itemView.findViewById(R.id.iv_order_icon);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
