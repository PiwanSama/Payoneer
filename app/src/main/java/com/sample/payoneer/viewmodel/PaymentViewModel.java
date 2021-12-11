package com.sample.payoneer.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sample.payoneer.model.ListResult;
import com.sample.payoneer.repository.PaymentRepository;

public class PaymentViewModel extends ViewModel {
    private final PaymentRepository repository = PaymentRepository.getInstance();

    public MutableLiveData<ListResult> getData(){
        return repository.getData();
    }
}
