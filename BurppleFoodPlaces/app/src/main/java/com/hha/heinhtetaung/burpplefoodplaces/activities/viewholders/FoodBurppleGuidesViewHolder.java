package com.hha.heinhtetaung.burpplefoodplaces.activities.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.FeaturesVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.GuidesVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 1/5/2018.
 */

public class FoodBurppleGuidesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_guide_title)
    TextView tvTitle;


    @BindView(R.id.iv_guide_image)
    ImageView ivGuideImage;


    public FoodBurppleGuidesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public void setGuide(GuidesVO guide) {

        tvTitle.setText(guide.getGuidesTitle());
        if (guide.getGuidesImage() != null) {
            ivGuideImage.setVisibility(View.VISIBLE);
            Glide.with(ivGuideImage.getContext())
                    .load(guide.getGuidesImage())
                    .into(ivGuideImage);
        } else {
            ivGuideImage.setVisibility(View.GONE);
        }

    }
}
