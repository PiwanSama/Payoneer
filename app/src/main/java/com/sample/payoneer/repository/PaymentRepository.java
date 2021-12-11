package com.sample.payoneer.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sample.payoneer.api.NetworkService;
import com.sample.payoneer.api.RetrofitInstance;
import com.sample.payoneer.model.ListResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentRepository {
    private static PaymentRepository paymentRepository;
    private final NetworkService service = RetrofitInstance.getRetrofitInstance().create(NetworkService.class);

    public static PaymentRepository getInstance(){
        if (paymentRepository == null){
            return new PaymentRepository();
        }
        return paymentRepository;
    }

    public MutableLiveData<ListResult> getData(){
        MutableLiveData<ListResult> listResult = new MutableLiveData<>();
        service.getData().enqueue(new Callback<ListResult>() {
            @Override
            public void onResponse(@NonNull Call<ListResult> call, @NonNull Response<ListResult> response) {
                listResult.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ListResult> call, @NonNull Throwable t) {

            }
        });
        return listResult;
    }
}
