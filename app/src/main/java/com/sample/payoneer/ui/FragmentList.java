package com.sample.payoneer.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sample.payoneer.R;
import com.sample.payoneer.adapter.PaymentListAdapter;
import com.sample.payoneer.databinding.FragmentPaymentTypeBinding;
import com.sample.payoneer.model.ApplicableNetwork;
import com.sample.payoneer.model.ListResult;
import com.sample.payoneer.viewmodel.PaymentViewModel;

import java.util.List;

public class FragmentList extends BaseFragment {

    private FragmentPaymentTypeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment_type, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.shimmerView.startShimmer();

        NavController controller = Navigation.findNavController(view);
        binding.navigateBack.setOnClickListener(view1 -> { controller.navigate(R.id.action_fragmentList_to_fragmentWelcome); });
        PaymentViewModel viewModel = new ViewModelProvider(this).get(PaymentViewModel.class);

        if (isNetworkConnected()){
            viewModel.getData().observe(getViewLifecycleOwner(), listResult -> {
                List<ApplicableNetwork> data = listResult.getNetworks().getApplicable();
                if (data!=null&&data.size()>0){
                    setUpDataList(data);
                }else{
                    showAlert("No data available");
                }
            });
        }else{
            binding.shimmerView.hideShimmer();
            showAlert("Data not found");
           // activity.showSnack("No internet connection");
        }
    }

    private void setUpDataList(List<ApplicableNetwork> dataList) {
        PaymentListAdapter adapter = new PaymentListAdapter(activity, dataList, item -> Toast.makeText(activity, "Pay with "+item.getLabel()+"?", Toast.LENGTH_SHORT).show());
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false);
        binding.rvPaymentList.setAdapter(adapter);
        binding.rvPaymentList.setLayoutManager(layoutManager);

        binding.shimmerView.stopShimmer();
        binding.shimmerView.setVisibility(View.GONE);
        binding.rvPaymentList.setVisibility(View.VISIBLE);
    }

    private void showAlert(String message){
        new AlertDialog.Builder(activity)
                .setTitle("Something went wrong")
                .setMessage(message)
                .show();
    }
}
