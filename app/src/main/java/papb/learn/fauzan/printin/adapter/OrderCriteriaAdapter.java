package papb.learn.fauzan.printin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import papb.learn.fauzan.printin.R;
import papb.learn.fauzan.printin.model.OrderCriteriaModel;

public class OrderCriteriaAdapter extends RecyclerView.Adapter<OrderCriteriaAdapter.ViewHolder> {

    private ArrayList<OrderCriteriaModel> orderCriteriaModelList;
    private Context context;

    public OrderCriteriaAdapter(ArrayList<OrderCriteriaModel> dataSet) {
        this.orderCriteriaModelList = dataSet;
    }

    @Override
    public OrderCriteriaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_kriteria_order,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderCriteriaAdapter.ViewHolder holder, int position) {
        holder.tv_file_name.setText(orderCriteriaModelList.get(position).getFileName());
        if(orderCriteriaModelList.get(position).isColored()){
            holder.rb_colored.setActivated(true);
        } else {
            holder.rb_monochrome.setActivated(true);
        }
        holder.cb_bind.setActivated(orderCriteriaModelList.get(position).isBinded());

    }


    @Override
    public int getItemCount() {
        return orderCriteriaModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_file_name;
        RadioButton rb_colored,rb_monochrome;

        CheckBox cb_bind;
        Spinner sp_bind_type,sp_front_bind,sp_back_bind,sp_paper_type;

        public ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            tv_file_name = itemView.findViewById(R.id.tv_file_name);
            rb_colored = itemView.findViewById(R.id.rb_colored);
            rb_monochrome = itemView.findViewById(R.id.rb_monochrome);
            sp_paper_type = itemView.findViewById(R.id.sp_paper_type);

            cb_bind = itemView.findViewById(R.id.cb_is_binded);
            sp_bind_type = itemView.findViewById(R.id.sp_bind_type);
            sp_front_bind = itemView.findViewById(R.id.sp_front_bind);
            sp_back_bind = itemView.findViewById(R.id.sp_back_bind);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
