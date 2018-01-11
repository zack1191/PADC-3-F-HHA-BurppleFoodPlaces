package com.hha.heinhtetaung.burpplefoodplaces.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.viewholders.FoodTrendingVenuesViewHolder;

/**
 * Created by E5 on 1/10/2018.
 */

public class FoodTrendingVenuesAdapter extends RecyclerView.Adapter<FoodTrendingVenuesViewHolder> {
    @Override
    public FoodTrendingVenuesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View foodTrendingVenues = layoutInflater.inflate(R.layout.item_food_trending_venues, parent, false);
        FoodTrendingVenuesViewHolder foodTrendingVenuesViewHolder = new FoodTrendingVenuesViewHolder(foodTrendingVenues);
        return foodTrendingVenuesViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodTrendingVenuesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
