package edu.hawaii.android.toolbaranimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ToggleButton;
import android.widget.Toolbar;


public class MainActivity extends Activity {

    private View mRevealView;
    private View mRevealBackgroundView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.appbar);
        mToolbar.setTitle(getString(R.string.app_name));

        mRevealView = findViewById(R.id.reveal);
        mRevealBackgroundView = findViewById(R.id.revealBackground);

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();

                if (on) {
                    animateAppAndStatusBar(R.color.primary, R.color.accent);
                } else {
                    animateAppAndStatusBar(R.color.accent, R.color.primary);
                }
            }
        });

        setActionBar(mToolbar);
    }

    private void animateAppAndStatusBar(int fromColor, final int toColor) {
        Animator animator = ViewAnimationUtils.createCircularReveal(
                mRevealView,
                mToolbar.getWidth() / 2,
                mToolbar.getHeight() / 2, 0,
                mToolbar.getWidth() / 2);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mRevealView.setBackgroundColor(getResources().getColor(toColor));
            }
        });

        mRevealBackgroundView.setBackgroundColor(getResources().getColor(fromColor));
        animator.setStartDelay(200);
        animator.setDuration(125);
        animator.start();
        mRevealView.setVisibility(View.VISIBLE);
    }
}
