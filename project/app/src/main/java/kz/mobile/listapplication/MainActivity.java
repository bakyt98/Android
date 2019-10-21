package kz.mobile.listapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private MainAdapter mainAdapter;

    private MainAdapter.ItemClickListener itemClickListener = new MainAdapter.ItemClickListener() {
        @Override
        public void onItemClick(Place item, int position) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("place_name", item.getName());
            intent.putExtra("place_photo", item.getPhoto());
            intent.putExtra("place_city", item.getCity_country());
            intent.putExtra("place_price", item.getPrice());
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Place> places = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Place place = new Place("Place " + (i+1), R.drawable.photo,
                    "City (Country)", 200, "Mon - Sun", "09:00 - 17:00");
            places.add(place);
        }
        mainAdapter = new MainAdapter(places, itemClickListener);
        recyclerView.setAdapter(mainAdapter);
    }
}
