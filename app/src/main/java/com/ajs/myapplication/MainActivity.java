package com.ajs.myapplication;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
//    private GoogleIabHelper mIabHelper;

    TabLayout tlTest;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInAppBillingHelper();
        initActionBar();
        initViews();
    }

    private void initInAppBillingHelper() {
//        mIabHelper = new GoogleIabHelper(this);
//        mIabHelper.setUpServiceConnection();
    }

    private void initActionBar() {
        final ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue, null)));
        }
    }

    private void initViews() {
        tlTest = findViewById(R.id.tlTest);
        final ViewPager viewPager = findViewById(R.id.activity_main_view_pager);
        viewPager.setAdapter(new MemeCircularViewPagerAdapter(this, getSupportFragmentManager(), Meme.createSampleMemes()));
        tlTest.setupWithViewPager(viewPager);
        final CircularViewPagerHandler circularViewPagerHandler = new CircularViewPagerHandler(viewPager);
        circularViewPagerHandler.setOnPageChangeListener(createOnPageChangeListener());
        viewPager.addOnPageChangeListener(circularViewPagerHandler);
    }

    private ViewPager.OnPageChangeListener createOnPageChangeListener() {
        final TextView currentPageText = (TextView) findViewById(R.id.activity_main_current_page_text);
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                currentPageText.setText(getString(R.string.current_page));
            }
            @Override
            public void onPageSelected(final int position) {}
            @Override
            public void onPageScrollStateChanged(final int state) {}
        };
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_beer) {
//            mIabHelper.purchaseItem(this, "beer_donation");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mIabHelper.unbindServiceConnection();
    }
}
