package kz.mobile.listapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private ArrayList<Place> places;

    private ItemClickListener itemClickListener;

    public MainAdapter(ArrayList<Place> places, ItemClickListener itemClickListener) {
        super();
        this.places = places;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_row_person, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        Glide.with(holder.imageView.getContext()).load(
                places.get(position).getPhoto()
        ).into(holder.imageView);
        holder.textViewPlaceName.setText(places.get(position).getName());
        holder.textViewCityCountry.setText(places.get(position).getCity_country());
        holder.textViewPrice.setText(places.get(position).getPrice()+" euro");
        holder.setItemClick(places.get(position));
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private CardView obj;
        private TextView textViewPlaceName;
        private TextView textViewCityCountry;
        private TextView textViewPrice;
        private ImageView imageView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            obj = itemView.findViewById(R.id.obj);
            textViewPlaceName = itemView.findViewById(R.id.textViewPlaceName);
            imageView  = itemView.findViewById(R.id.imageView);
            textViewCityCountry = itemView.findViewById(R.id.textViewCityCountry);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }

        public void setItemClick(final Place item) {

            obj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(item, getAdapterPosition());
                    }
                }
            });
        }
    }

    interface ItemClickListener {

        void onItemClick(Place item, int position);
    }
}
