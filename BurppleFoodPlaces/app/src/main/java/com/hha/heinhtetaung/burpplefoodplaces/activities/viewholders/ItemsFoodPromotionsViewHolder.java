package com.hha.heinhtetaung.burpplefoodplaces.activities.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.PromotionVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 1/4/2018.
 */

public class ItemsFoodPromotionsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_1for1)
    TextView tvTitle;

    @BindView(R.id.tv_date)
    TextView tvDate;

    @BindView(R.id.tv_food_name)
    TextView tvFoodName;

    @BindView(R.id.tv_seller)
    TextView tvSeller;

    @BindView(R.id.iv_food_promotion)
    ImageView ivFoodImage;

    public ItemsFoodPromotionsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setPromotion(PromotionVO promotion) {
        tvTitle.setText(promotion.getPromotionTitle());
        tvDate.setText(promotion.getPromotionUntil());
        tvFoodName.setText(promotion.getPromotionShop().getPromotionShopName());
        tvSeller.setText(promotion.getPromotionShop().getPromotionShopArea());
        Glide.with(ivFoodImage.getContext())
                .load(promotion.getPromotionImage())
                .into(ivFoodImage);
    }
}
