package com.hha.heinhtetaung.burpplefoodplaces.activities.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FeaturesVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.viewitems.ImagesInFoodViewItems;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 1/4/2018.
 */

public class FoodImagesAdapter extends PagerAdapter {

    @BindView(R.id.tv_feature)
    TextView tvFeature;

    @BindView(R.id.tv_text2_food_details_images)
    TextView tvFoodDescription;

    @BindView(R.id.tv_text_food_details_images)
    TextView tvFoodTitle;

    @BindView(R.id.iv_food_images)
    ImageView ivFoodImage;


    private List<FeaturesVO> mFeaturedList;

    public FoodImagesAdapter() {
        mFeaturedList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mFeaturedList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImagesInFoodViewItems view = (ImagesInFoodViewItems) layoutInflater.inflate(R.layout.item_food_details_images, container, false);
        ButterKnife.bind(this, view);

        tvFeature.setText(mFeaturedList.get(position).getFeatureTag());
        tvFoodTitle.setText(mFeaturedList.get(position).getFeatureTitle());
        tvFoodDescription.setText(mFeaturedList.get(position).getFeatureDescription());

        Glide.with(ivFoodImage.getContext())
                .load(mFeaturedList.get(position).getFeatureImage())
                .into(ivFoodImage);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setFeatured(List<FeaturesVO> featuredList) {
        mFeaturedList = featuredList;
        notifyDataSetChanged();
    }
}
