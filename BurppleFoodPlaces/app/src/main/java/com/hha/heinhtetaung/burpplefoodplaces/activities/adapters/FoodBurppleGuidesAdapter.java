package com.hha.heinhtetaung.burpplefoodplaces.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FeaturesVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.GuidesVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.viewholders.FoodBurppleGuidesViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 1/5/2018.
 */

public class FoodBurppleGuidesAdapter extends RecyclerView.Adapter<FoodBurppleGuidesViewHolder> {

    private List<GuidesVO> mGuideList;

    public FoodBurppleGuidesAdapter() {
        mGuideList = new ArrayList<>();
    }

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
        holder.setGuide(mGuideList.get(position));
    }

    @Override
    public int getItemCount() {
        return mGuideList.size();
    }

    public void setGuide(List<GuidesVO> guideList) {
        mGuideList = guideList;
        notifyDataSetChanged();
    }


}
