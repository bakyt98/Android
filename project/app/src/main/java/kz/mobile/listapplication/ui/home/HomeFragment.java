package kz.mobile.listapplication.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import kz.mobile.listapplication.MainAdapter;
import kz.mobile.listapplication.R;
import kz.mobile.listapplication.RetroPhoto;

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
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, detail)
                    .commit();
        }
    };


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mainAdapter = new MainAdapter(itemClickListener);
        recyclerView.setAdapter(mainAdapter);
        homeViewModel.getData();
        homeViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<List<RetroPhoto>>() {
            @Override
            public void onChanged(@Nullable List<RetroPhoto> retroPhotos) {
                mainAdapter.replaceData(retroPhotos);
            }
        });
    }

}