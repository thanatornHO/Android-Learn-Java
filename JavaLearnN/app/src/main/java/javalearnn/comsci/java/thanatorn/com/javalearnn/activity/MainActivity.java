package javalearnn.comsci.java.thanatorn.com.javalearnn.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import javalearnn.comsci.java.thanatorn.com.javalearnn.R;
import javalearnn.comsci.java.thanatorn.com.javalearnn.utils.DialogCustom;

public class MainActivity extends Activity{

    private AdView adView;
    private LinearLayout layoutExamsMain, layoutConceptMain, layoutMain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        adView = (AdView) findViewById(R.id.ad_view_main);

        layoutExamsMain = (LinearLayout) findViewById(R.id.layoutExamsMain);
        layoutConceptMain = (LinearLayout) findViewById(R.id.layoutConceptMain);
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);

        // .addTestDevice(getResources().getString(R.string.device_id))
        AdRequest adRequest = new AdRequest.Builder()
                .setGender(AdRequest.GENDER_MALE)
                .addKeyword("game")
                .addKeyword("games")
                .addKeyword("Game")
                .addKeyword("Games")
                .build();
        adView.loadAd(adRequest);

        layoutConceptMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JavaMainFragment.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DialogCustom.getDialogCustomExit(MainActivity.this);
    }
}
