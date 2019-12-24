package kz.mobile.listapplication.ui.notifications;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import kz.mobile.listapplication.GetDataService;
import kz.mobile.listapplication.RetroPhoto;
import kz.mobile.listapplication.RetrofitClientInstance;
import kz.mobile.listapplication.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsViewModel extends ViewModel {

    public MutableLiveData<User> liveData;

    public NotificationsViewModel() {
        liveData = new MutableLiveData<>();
    }

    public void getData() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<User> call = service.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                liveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
                Log.d("response", "ERROR!!!!");
            }
        });
    }
}