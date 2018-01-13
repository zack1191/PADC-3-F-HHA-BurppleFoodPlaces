package com.hha.heinhtetaung.burpplefoodplaces.activities.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.PromotionVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.viewholders.ItemsFoodPromotionsViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 1/4/2018.
 */

public class FoodPromotionsAdapter extends RecyclerView.Adapter<ItemsFoodPromotionsViewHolder> {

    private List<PromotionVO> mPromotionList;

    public FoodPromotionsAdapter() {
        mPromotionList = new ArrayList<>();
    }

    @Override
    public ItemsFoodPromotionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View foodPromotion = layoutInflater.inflate(R.layout.item_food_promotions, parent, false);
        ItemsFoodPromotionsViewHolder itemsFoodPromotionsViewHolder = new ItemsFoodPromotionsViewHolder(foodPromotion);
        return itemsFoodPromotionsViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemsFoodPromotionsViewHolder holder, int position) {
        holder.setPromotion(mPromotionList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPromotionList.size();
    }

    public void setPromotion(List<PromotionVO> promotionList) {
        mPromotionList = promotionList;
        notifyDataSetChanged();
    }


}
