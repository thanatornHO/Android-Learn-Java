package javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java.ss1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import javalearnn.comsci.java.thanatorn.com.javalearnn.R;
import javalearnn.comsci.java.thanatorn.com.javalearnn.utils.FragmentUtils;

public class FragmentJava01 extends Fragment implements FragmentUtils {

    TextView lb01L1, lb01L2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_java_ss1_01, container, false);
        lb01L1 = (TextView) view.findViewById(R.id.lb_f01_l1_01);
        lb01L2 = (TextView) view.findViewById(R.id.lb_f01_l1_02);
        lb01L1.setText(Html.fromHtml(getString(R.string.ss1_java_01_01)));
        lb01L2.setText(Html.fromHtml(getString(R.string.ss1_java_01_02)));
        return view;
    }

    @Override
    public void setLbJavaMain(float size) {
        lb01L1.setTextSize(size);
        lb01L2.setTextSize(size);
    }

}
