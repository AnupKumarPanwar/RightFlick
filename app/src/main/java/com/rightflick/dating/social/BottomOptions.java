package com.rightflick.dating.social;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class BottomOptions extends Dialog {

    public Activity c;
    public Dialog d;
    public TextView unfollow, msg, report, link, cancel;

    public BottomOptions(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bottom_options);
        unfollow = (TextView) findViewById(R.id.unfollow);
        msg = (TextView) findViewById(R.id.msg);
        link = (TextView) findViewById(R.id.link);
        report = (TextView) findViewById(R.id.report);
    }

}