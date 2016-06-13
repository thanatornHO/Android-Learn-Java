package javalearnn.comsci.java.thanatorn.com.javalearnn.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import javalearnn.comsci.java.thanatorn.com.javalearnn.R;

public class DialogCustom {

    private static final String APP_NAME = "Java Learn N";
    private static Button btnDialogExitYes, btnDialogExitNo;

    public static void getDialogDefault(final Activity activity, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle(APP_NAME);
        dialog
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        activity.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        dialog.show();
    }

    public static void getDialogCustomExit(final Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom_exit);
        dialog.setTitle(APP_NAME);

        btnDialogExitYes = (Button) dialog.findViewById(R.id.btn_dialog_exit_yes);
        btnDialogExitNo = (Button) dialog.findViewById(R.id.btn_dialog_exit_no);

        btnDialogExitYes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
        btnDialogExitNo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
