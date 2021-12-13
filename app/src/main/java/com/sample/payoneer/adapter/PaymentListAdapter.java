package com.sample.payoneer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.payoneer.R;
import com.sample.payoneer.databinding.ItemPaymentListBinding;
import com.sample.payoneer.model.ApplicableNetwork;

import java.util.List;

public class PaymentListAdapter extends RecyclerView.Adapter<PaymentListAdapter.ViewHolder> {

    private List<ApplicableNetwork> dataList;
    private Context context;
    private PaymentListListener listener;

    public PaymentListAdapter(Context context, List<ApplicableNetwork> dataList, PaymentListListener listener){
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPaymentListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_payment_list, parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ApplicableNetwork item = dataList.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemPaymentListBinding binding;
        public ViewHolder(@NonNull ItemPaymentListBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(ApplicableNetwork item, PaymentListListener listener){
            binding.setItem(item);
            itemView.setOnClickListener(view->listener.getItemName(item));
        }
    }

    public interface PaymentListListener{
        void getItemName(ApplicableNetwork item);
    }
}