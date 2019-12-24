package kz.mobile.listapplication.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kz.mobile.listapplication.GetDataService;
import kz.mobile.listapplication.RetroPhoto;
import kz.mobile.listapplication.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<List<RetroPhoto>> liveData;

    public HomeViewModel() {
        liveData = new MutableLiveData<>();
    }

    public void getData() {
        Log.d("HomeViewModel", "getData()");
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                Log.d("HomeViewModel2", "getData()2");
                Log.d("HomeViewModel3", response.body().toString());
                liveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                t.printStackTrace();
                Log.d("response", "ERROR!!!!");
            }
        });
    }

}