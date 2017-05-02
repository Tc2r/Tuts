package com.tc2r.sharedpref;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5213602039222610~6161940680");

        RelativeLayout mAdRelativeLayout = (RelativeLayout) findViewById(R.id.adMobView);
        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);

        boolean isDebuggable =  ( 0 != ( getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE ) );
        if(BuildConfig.DEBUG || isDebuggable){
            mAdView.setAdUnitId(getString(R.string.banner_TEST_ad_unit_id));
        }else{
            mAdView.setAdUnitId(getString(R.string.banner_MY_ad_unit_id));
        }
        mAdRelativeLayout.addView(mAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void ButClicked1(View View){
        Intent intent = new Intent(this, Tutorial1.class);
        startActivity(intent);
    }
    public void ButClicked2(View view){
        Intent intent = new Intent(this, Tutorial2.class);
        startActivity(intent);
    }
}
