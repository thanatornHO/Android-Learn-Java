package javalearnn.comsci.java.thanatorn.com.javalearnn.fragment.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import javalearnn.comsci.java.thanatorn.com.javalearnn.R;
import javalearnn.comsci.java.thanatorn.com.javalearnn.utils.FragmentUtils;

public class FragmentJavaMain extends Fragment implements FragmentUtils {

    TextView lbJavaMain;
    LinearLayout layoutJavaMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_java_main_ss1, container, false);

        lbJavaMain = (TextView) view.findViewById(R.id.lb_java_main);
        layoutJavaMain = (LinearLayout) view.findViewById(R.id.layout_java_main);

        lbJavaMain.setText(Html.fromHtml(getString(R.string.fragment_java_main)));
        return view;
    }

    @Override
    public void setLbJavaMain(float size) {
        lbJavaMain.setTextSize(size);
    }


}
