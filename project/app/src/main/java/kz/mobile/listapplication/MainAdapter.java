package kz.mobile.listapplication;

import android.util.Log;
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
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<RetroPhoto> places;
    private ItemClickListener itemClickListener;

    public MainAdapter(List<RetroPhoto> places, ItemClickListener itemClickListener) {
        super();
        this.places = places;
        this.itemClickListener = itemClickListener;
    }

    public MainAdapter(ItemClickListener itemClickListener) {
        super();
        this.places = new ArrayList<RetroPhoto>();
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
                places.get(position).getUrl()
        ).into(holder.imageView);
        Log.d("Adapter", places.toString());
        Log.d("Adapter", "lalallaa");
        holder.textViewPlaceName.setText(places.get(position).getTitle());
//        String city_country = places.get(position).getCity() + " (" + places.get(position).getCountry() + ")";
        holder.textViewCityCountry.setText("City (Country)");
        holder.textViewPrice.setText("50 euro");
        holder.setItemClick(places.get(position));
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public void replaceData(List<RetroPhoto> retroPhotos) {
        places = retroPhotos;
        notifyDataSetChanged();
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

        public void setItemClick(final RetroPhoto item) {

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

    public interface ItemClickListener {

        void onItemClick(RetroPhoto item, int position);
    }
}
