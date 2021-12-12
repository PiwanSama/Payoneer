package com.sample.payoneer.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.sample.payoneer.R;
import com.sample.payoneer.databinding.FragmentPaymentTypeBinding;
import com.sample.payoneer.model.ListResult;
import com.sample.payoneer.viewmodel.PaymentViewModel;

public class FragmentList extends BaseFragment{

    private FragmentPaymentTypeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment_type, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        NavController controller = Navigation.findNavController(view);
        binding.navigateBack.setOnClickListener(view1 -> {
            controller.navigate(R.id.action_fragmentList_to_fragmentWelcome);
        });
        PaymentViewModel viewModel = new ViewModelProvider(this).get(PaymentViewModel.class);

        viewModel.getData().observe(getViewLifecycleOwner(), listResult -> {

        });
    }
}
