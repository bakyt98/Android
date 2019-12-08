package kz.mobile.listapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;

import java.net.URI;

import kz.mobile.listapplication.R;

public class DetailFragment extends Fragment {

    private TextView textViewPlaceName;
    private ImageView imageView2;
    private TextView textViewCityCountry;
    private HomeViewModel homeViewModel;
    private TextView textViewPrice;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.activity_second, container, false);
        textViewPlaceName = root.findViewById(R.id.textViewPlaceName);
        textViewCityCountry = root.findViewById(R.id.textViewCityCountry);
        imageView2 = root.findViewById(R.id.imageView2);
        textViewPrice = root.findViewById(R.id.textViewPrice);
        Bundle bundle = getArguments();
        String placeName = bundle.getString("place_name");
        textViewPlaceName.setText(placeName);
        String place_photo = bundle.getString("place_photo");
        Glide.with(imageView2.getContext()).load(place_photo).into(imageView2);
        String place_city = bundle.getString("place_city");
        textViewCityCountry.setText(place_city);
        String place_price = bundle.getString("place_price");
        textViewPrice.setText(place_price);
        return root;
    }
}
