package kz.mobile.listapplication.ui.dashboard;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kz.mobile.listapplication.GetDataService;
import kz.mobile.listapplication.Place;
import kz.mobile.listapplication.RetroPhoto;
import kz.mobile.listapplication.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends ViewModel {

    public MutableLiveData<List<RetroPhoto>> liveData;

    public DashboardViewModel() {
        liveData = new MutableLiveData<>();
    }

    public void findData(String title){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.findPhotos(title);
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                liveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                Log.d("DashboardViewModel", "ERROR!!!!");
            }
        });
    }

    public void getData(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                liveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                Log.d("response", "ERROR!!!!");
            }
        });
    }

}