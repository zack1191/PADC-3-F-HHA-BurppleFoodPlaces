package com.hha.heinhtetaung.burpplefoodplaces.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.viewholders.FoodBurppleGuidesViewHolder;

/**
 * Created by E5 on 1/5/2018.
 */

public class FoodBurppleGuidesAdapter extends RecyclerView.Adapter<FoodBurppleGuidesViewHolder> {

    @Override
    public FoodBurppleGuidesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View foodBurppleGuides = layoutInflater.inflate(R.layout.item_food_burpple_guide, parent, false);
        FoodBurppleGuidesViewHolder foodBurppleGuidesViewHolder = new FoodBurppleGuidesViewHolder(foodBurppleGuides);
        return foodBurppleGuidesViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodBurppleGuidesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
