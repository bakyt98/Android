package kz.mobile.listapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewPlaceName;
    private ImageView imageView2;
    private TextView textViewCityCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewPlaceName = findViewById(R.id.textViewPlaceName);
        textViewCityCountry = findViewById(R.id.textViewCityCountry);
        imageView2 = findViewById(R.id.imageView2);

        String placeName = getIntent().getStringExtra("place_name");
        textViewPlaceName.setText(placeName);
        int place_photo = getIntent().getIntExtra("place_photo", R.drawable.ic_launcher_background);
        imageView2.setImageResource(place_photo);
        String place_city = getIntent().getStringExtra("place_city");
        textViewCityCountry.setText(place_city);
        String place_price = getIntent().getStringExtra("place_price");
    }
}
