package javalearnn.comsci.java.thanatorn.com.javalearnn.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static javalearnn.comsci.java.thanatorn.com.javalearnn.utils.Utils.*;

import javalearnn.comsci.java.thanatorn.com.javalearnn.R;
import javalearnn.comsci.java.thanatorn.com.javalearnn.adapter.ExpandableJavaConceptAdapter;
import javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.FragmentJavaMain;
import javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.ss1.FragmentJava01;
import javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.ss1.FragmentJava02;
import javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.ss1.FragmentJava03;
import javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.ss1.FragmentJava04;
import javalearnn.comsci.java.thanatorn.com.javalearnn.utils.FragmentUtils;

public class JavaMainFragment extends AppCompatActivity implements ExpandableListView.OnChildClickListener {

    private SeekBar seekbarJavaFontSize;
    private TextView lbTextMenu, lbJavaFontSize;
    private DrawerLayout mDrawerLayout;
    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> groupList;
    private String statusBrightness;
    private HashMap<String, List<String>> childList;

    private ImageButton imgMenuSidebar;

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept_java);

        loadListData();

        fragment = new FragmentJavaMain();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame_java, fragment).commit();

        //lbJavaMain = getSupportFragmentManager().findFragmentById(R.id.lb_java_main);
        expListView = (ExpandableListView) findViewById(R.id.lv_sidebar_java);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_java_concept);
        seekbarJavaFontSize = (SeekBar) findViewById(R.id.seekbar_java_font_size);
        lbJavaFontSize = (TextView) findViewById(R.id.lb_java_font_size);

        // ExpandListView
        listAdapter = new ExpandableJavaConceptAdapter(this, groupList, childList);
        expListView.setGroupIndicator(null);
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(this);


        // Action bar custom view
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);

        View customView = getLayoutInflater().inflate(R.layout.action_bar_custom, null);
        imgMenuSidebar = (ImageButton) customView.findViewById(R.id.icon_menu_sidebar);
        lbTextMenu = (TextView) customView.findViewById(R.id.text_left);

        imgMenuSidebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawers();
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);

        // ads
        AdView adView = (AdView) findViewById(R.id.ad_java_main);
        AdRequest adRequest = new AdRequest.Builder()
                .setGender(AdRequest.GENDER_MALE)
                .addKeyword("game")
                .addKeyword("games")
                .addKeyword("Game")
                .addKeyword("Games")
                .build();
        adView.loadAd(adRequest);

        // seek bar
        seekbarJavaFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress > 8) {
                    ((FragmentUtils) fragment).setLbJavaMain((float) progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void loadListData() {

        groupList = new ArrayList<String>();
        childList = new HashMap<String, List<String>>();

        groupList.add("Java Basic");
        groupList.add("OOP Concept");
        groupList.add("Coming Soon..");

        childList.put(groupList.get(0), Arrays.asList(getResources().getStringArray(R.array.fragment_java_ss1)));
        childList.put(groupList.get(1), Arrays.asList(getResources().getStringArray(R.array.fragment_java_ss2)));
        childList.put(groupList.get(2), new ArrayList<String>());
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {
        if (isNotNull(childList.get(groupList.get(groupPosition)).get(childPosition))) {
            fragment = null;

            if (childList.get(groupList.get(groupPosition)).get(childPosition).equals("First App")) {
                fragment = new FragmentJava01();
                lbTextMenu.setText("First App");
            } else if (childList.get(groupList.get(groupPosition)).get(childPosition).equals("If Statement")) {
                fragment = new FragmentJava02();
                lbTextMenu.setText("If Statement");
            } else if (childList.get(groupList.get(groupPosition)).get(childPosition).equals("Switch Case")) {
                fragment = new FragmentJava03();
                lbTextMenu.setText("Switch Case");
            } else if (childList.get(groupList.get(groupPosition)).get(childPosition).equals("Loop control")) {
                fragment = new FragmentJava04();
                lbTextMenu.setText("Loop control");
            } else if (childList.get(groupList.get(groupPosition)).get(childPosition).equals("Encapsulation")) {
                fragment = new javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.ss2.FragmentJava01();
                lbTextMenu.setText("Encapsulation");
            } else if (childList.get(groupList.get(groupPosition)).get(childPosition).equals("Inheritance")) {
                fragment = new javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.ss2.FragmentJava02();
                lbTextMenu.setText("Inheritance");
            } else if (childList.get(groupList.get(groupPosition)).get(childPosition).equals("Polymorphism")) {
                fragment = new javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.ss2.FragmentJava03();
                lbTextMenu.setText("Polymorphism");
            }

            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame_java, fragment).commit();
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            JavaMainFragment.this.finish();
        }
    }

}
