package com.example.viewsdemo;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.viewsdemo.ui.NewCreditSesameView;
import com.example.viewsdemo.ui.OldCreditSesameView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final int[] mColors = new int[]{
            0xFFFF80AB,
            0xFFFF4081,
            0xFFFF5177,
            0xFFFF7997
    };

    private RelativeLayout mMain_layout;
    private Button mButton;
    private NewCreditSesameView newCreditSesameView;
    private OldCreditSesameView mOldCreditSesameView;

    private Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMain_layout = (RelativeLayout) findViewById(R.id.activity_main);
        mButton = (Button) findViewById(R.id.button1);
        newCreditSesameView = (NewCreditSesameView) findViewById(R.id.creditSesameView);
        mOldCreditSesameView = (OldCreditSesameView) findViewById(R.id.oldSesameView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int values = random.nextInt(950);
                newCreditSesameView.setSesameValues(values);
                mOldCreditSesameView.setSesameValues(values);
                startColorChangeAnim();
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void startColorChangeAnim() {

        ObjectAnimator animator = ObjectAnimator.ofInt(mMain_layout,"backgroundColor",mColors);
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.start();
    }
}
