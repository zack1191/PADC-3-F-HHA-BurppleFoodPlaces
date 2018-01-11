package com.hha.heinhtetaung.burpplefoodplaces.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.viewholders.FoodNewlyOpenedViewHolder;

/**
 * Created by E5 on 1/10/2018.
 */

public class FoodNewlyOpenedAdapter extends RecyclerView.Adapter<FoodNewlyOpenedViewHolder> {
    @Override
    public FoodNewlyOpenedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View foodNewlyOpened = layoutInflater.inflate(R.layout.item_food_newly_opened, parent, false);
        FoodNewlyOpenedViewHolder foodNewlyOpenedViewHolder = new FoodNewlyOpenedViewHolder(foodNewlyOpened);
        return foodNewlyOpenedViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodNewlyOpenedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
