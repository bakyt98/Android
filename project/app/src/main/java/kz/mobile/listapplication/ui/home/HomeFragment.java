package kz.mobile.listapplication.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import kz.mobile.listapplication.GetDataService;
import kz.mobile.listapplication.MainAdapter;
import kz.mobile.listapplication.Place;
import kz.mobile.listapplication.R;
import kz.mobile.listapplication.RetroPhoto;
import kz.mobile.listapplication.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    private MainAdapter mainAdapter;
    private BottomNavigationView bottomNavigationView;

    private MainAdapter.ItemClickListener itemClickListener = new MainAdapter.ItemClickListener() {
        @Override
        public void onItemClick(RetroPhoto item, int position) {
            Bundle bundle = new Bundle();
            bundle.putString("place_name", item.getTitle());
            bundle.putString("place_photo", item.getUrl());
            bundle.putString("place_city", "City (Country)");
            bundle.putString("place_price", "50 euro");
            DetailFragment detail = new DetailFragment();
            detail.setArguments(bundle);
//            detail.setTargetFragment(HomeFragment.this, 2);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, detail)
                    .commit();
        }
    };
//

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                Log.d("response", "ERROR!!!!");
            }
        });

        return root;
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroPhoto> photoList) {
        mainAdapter = new MainAdapter(photoList, itemClickListener);
        recyclerView.setAdapter(mainAdapter);
    }
}