package kz.mobile.listapplication.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kz.mobile.listapplication.GetDataService;
import kz.mobile.listapplication.Place;
import kz.mobile.listapplication.R;
import kz.mobile.listapplication.MainAdapter;
import kz.mobile.listapplication.RetroPhoto;
import kz.mobile.listapplication.RetrofitClientInstance;
import kz.mobile.listapplication.ui.home.DetailFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private EditText title;
    private Button search;
    private RecyclerView recyclerView;

    private MainAdapter mainAdapter;

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

        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        title = view.findViewById(R.id.editTextTitle);
        search = view.findViewById(R.id.button);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!title.getText().toString().matches(""))
                    dashboardViewModel.findData(title.getText().toString());
                else dashboardViewModel.getData();
                dashboardViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<List<RetroPhoto>>() {
                    @Override
                    public void onChanged(@Nullable List<RetroPhoto> retroPhotos) {
                        mainAdapter.replaceData(retroPhotos);
                    }
                });
            }
        });
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mainAdapter = new MainAdapter(itemClickListener);
        recyclerView.setAdapter(mainAdapter);
        dashboardViewModel.getData();
        dashboardViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<List<RetroPhoto>>() {
            @Override
            public void onChanged(@Nullable List<RetroPhoto> retroPhotos) {
                mainAdapter.replaceData(retroPhotos);
            }
        });
    }


}