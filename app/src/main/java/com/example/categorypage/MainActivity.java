package com.example.categorypage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup mRoot;
    private ImageButton mIcon1;
    private ImageButton mIcon2;
    private ImageButton mIcon3;
    private ImageButton mIcon4;

    private TextView mText1;
    private TextView mText2;
    private TextView mText3;
    private TextView mText4;

    private RelativeLayout relLayout1;
    private RelativeLayout relLayout2;
    private RelativeLayout relLayout3;
    private RelativeLayout relLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=21) {
            /*TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition = inflater.inflateTransition(R.transition.transition_b);
            getWindow().setExitTransition(transition);*/
            getWindow().setSharedElementExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_a));
            /*Slide slide = new Slide();
            slide.setDuration(5000);
            getWindow().setEnterTransition(slide);*/
            getWindow().setSharedElementReenterTransition(null);
            getWindow().setReenterTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_b));
        }

        setContentView(R.layout.activity_main);

        mRoot = (ViewGroup) findViewById(R.id.container_a);
        mIcon1 = (ImageButton) findViewById(R.id.icon_1);
        mIcon2 = (ImageButton) findViewById(R.id.icon_2);
        mIcon3 = (ImageButton) findViewById(R.id.icon_3);
        mIcon4 = (ImageButton) findViewById(R.id.icon_4);

        mText1 = (TextView) findViewById(R.id.text_1);
        mText2 = (TextView) findViewById(R.id.text_2);
        mText3 = (TextView) findViewById(R.id.text_3);
        mText4 = (TextView) findViewById(R.id.text_4);

        relLayout1 = (RelativeLayout) findViewById(R.id.rel_layout_1);
        relLayout2 = (RelativeLayout) findViewById(R.id.rel_layout_2);
        relLayout3 = (RelativeLayout) findViewById(R.id.rel_layout_3);
        relLayout4 = (RelativeLayout) findViewById(R.id.rel_layout_4);

        relLayout1.setOnClickListener(this);
        relLayout2.setOnClickListener(this);
        relLayout3.setOnClickListener(this);
        relLayout4.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.rel_layout_1) {
            v.setTransitionName("relLayout1");
        }else if(v.getId() == R.id.rel_layout_2) {
            v.setTransitionName("relLayout2");
        }else if(v.getId() == R.id.rel_layout_3) {
            v.setTransitionName("relLayout3");
        }else if(v.getId() == R.id.rel_layout_4) {
            v.setTransitionName("relLayout4");
        }
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, v, v.getTransitionName());
        //ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);

        Intent intent = new Intent(this, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent, optionsCompat.toBundle());
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
