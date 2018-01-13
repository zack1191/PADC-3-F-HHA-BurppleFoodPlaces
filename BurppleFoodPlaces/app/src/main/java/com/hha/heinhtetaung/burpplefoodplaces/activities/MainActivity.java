package com.hha.heinhtetaung.burpplefoodplaces.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.adapters.FoodBurppleGuidesAdapter;
import com.hha.heinhtetaung.burpplefoodplaces.activities.adapters.FoodImagesAdapter;
import com.hha.heinhtetaung.burpplefoodplaces.activities.adapters.FoodNewlyOpenedAdapter;
import com.hha.heinhtetaung.burpplefoodplaces.activities.adapters.FoodPromotionsAdapter;
import com.hha.heinhtetaung.burpplefoodplaces.activities.adapters.FoodTrendingVenuesAdapter;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.FeaturesModel;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.GuidesModel;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.PromotionModel;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadFeaturedEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadGuidesEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadPromotionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tb_toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_newly_open_view_pager)
    ViewPager vpNewlyOpen;

    @BindView(R.id.rv_promotions)
    RecyclerView rvPromotions;

//    @BindView(R.id.rv_food_genre)
//    RecyclerView rvFoodGenre;

    @BindView(R.id.rv_burpple_guides)
    RecyclerView rvFoodBurppleGuides;

    @BindView(R.id.rv_newly_opened)
    RecyclerView rvFoodNewlyOpened;

    @BindView(R.id.rv_trending_venues)
    RecyclerView rvFoodTrendingVenues;

    private FoodImagesAdapter mFoodImagesAdapter;
    private FoodPromotionsAdapter mFoodPromotionsAdapter;
    private FoodBurppleGuidesAdapter mFoodBurppleGuidesAdapter;
    private FoodNewlyOpenedAdapter mFoodNewlyOpenedAdapter;
    private FoodTrendingVenuesAdapter mFoodTrendingVenuesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        mFoodImagesAdapter = new FoodImagesAdapter();
        vpNewlyOpen.setAdapter(mFoodImagesAdapter);

        mFoodPromotionsAdapter = new FoodPromotionsAdapter();
        LinearLayoutManager lmFoodPromotion = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvPromotions.setLayoutManager(lmFoodPromotion);
        rvPromotions.setAdapter(mFoodPromotionsAdapter);

//        mFoodGenreAdapter = new FoodGenreAdapter();
//        LinearLayoutManager lmFoodGenre = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
//        rvFoodGenre.setLayoutManager(lmFoodGenre);
//        rvFoodGenre.setAdapter(mFoodGenreAdapter);

        mFoodBurppleGuidesAdapter = new FoodBurppleGuidesAdapter();
        LinearLayoutManager lmFoodBurppleGuides = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvFoodBurppleGuides.setLayoutManager(lmFoodBurppleGuides);
        rvFoodBurppleGuides.setAdapter(mFoodBurppleGuidesAdapter);

        mFoodNewlyOpenedAdapter = new FoodNewlyOpenedAdapter();
        LinearLayoutManager lmFoodNewlyOpened = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvFoodNewlyOpened.setLayoutManager(lmFoodNewlyOpened);
        rvFoodNewlyOpened.setAdapter(mFoodNewlyOpenedAdapter);

        mFoodTrendingVenuesAdapter = new FoodTrendingVenuesAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvFoodTrendingVenues.setLayoutManager(linearLayoutManager);
        rvFoodTrendingVenues.setAdapter(mFoodTrendingVenuesAdapter);

        FeaturesModel.getSobjInstance().loadFeatured();
        PromotionModel.getsObjInstance().loadPromotion();
        GuidesModel.getsObjInstance().loadGuides();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFeaturedLoaded(LoadFeaturedEvent event) {
        Log.d(BurppleFoodPlacesApp.LOG_TAG, "FeaturedLoaded" + event.getFeaturedList().size());
        mFoodImagesAdapter.setFeatured(event.getFeaturedList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionLoaded(LoadPromotionEvent event) {
        Log.d(BurppleFoodPlacesApp.LOG_TAG, "PromotionLoaded" + event.getPromotionVOList().size());
        mFoodPromotionsAdapter.setPromotion(event.getPromotionVOList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuideLoaded(LoadGuidesEvent event) {
        Log.d(BurppleFoodPlacesApp.LOG_TAG, "GuideLoaded" + event.getGuideList().size());
        mFoodBurppleGuidesAdapter.setGuide(event.getGuideList());
    }


}
