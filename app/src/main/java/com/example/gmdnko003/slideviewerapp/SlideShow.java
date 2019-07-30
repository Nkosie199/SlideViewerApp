package com.example.gmdnko003.slideviewerapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import java.util.logging.LogRecord;

public class SlideShow extends Activity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    private Context ctx = this;
    ImageView imageView;
    TextView textView;
    Runnable run;
    Boolean paused = false;
    Boolean switcher=true; //boolean which handles first and other iterations
    Handler handler;
    private int position;
    private ViewGroup container;
    private Object itemView;
    private LayoutInflater layoutInflater;

    public int[] images = {R.drawable.ucttopview, R.drawable.uctuppercampus , R.drawable.kramerlt1, R.drawable.labs
            , R.drawable.ikeys, R.drawable.jammies, R.drawable.diskidance, R.drawable.logo_uct};

    public String[] captions = {"Situated in the heart of Cape Town...", "with beautiful campuses..."
            , "state of the art lecture theatres...", "fantastic computer laboratories...", "a rich and diverse sporting code..."
            , "and free transport for the convenience of students...", "is UCT, one of Africa's premier universities!"
            , "Thanks for watching!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);
        position=0;
        viewPager = (ViewPager)findViewById(R.id.view_pager);

        //adapter = new CustomSwipeAdapter(this);
        //viewPager.setAdapter(adapter);
        //
        //viewPager.setCurrentItem(R.layout.swipe_layout);
        //
        imageView = (ImageView) findViewById(R.id.image_view);
        textView = (TextView) findViewById(R.id.text_view);
        imageView.setImageResource(images[position]); //
        textView.setText(captions[position]); //
        //container.addView(item_view); //
    }
    public int getCount() {
        return images.length;
    }

    public void next(View view){
        //viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        //viewPager.setCurrentItem();
        if (position >= getCount()-1){
            position=0;
            imageView.setImageResource(images[position]); //
            textView.setText(captions[position]); //
        }else{
            position++;
            imageView.setImageResource(images[position]); //
            textView.setText(captions[position]); //
        }

    }

    public void previous(View view){
        //viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        if (position <= 0){
            position=getCount()-1;
            imageView.setImageResource(images[position]); //
            textView.setText(captions[position]); //
        }else{
            position--;
            imageView.setImageResource(images[position]); //
            textView.setText(captions[position]); //
        }
    }


    public void stop(View view){
        paused = true;
        //start(view);
    }

    public void begin(View view){
        if (switcher==true){
            switcher=false;
            paused = false;
            start(view);
        }
        else{
            paused=false;
        }
    }

    public void start(View view){
        handler = new Handler();
        //if (paused==false){ //slide show should run, is not pause
            //run.notify();
            run = new Runnable()
            {
                @Override
                public void run() {
                    handler.postDelayed(run, 3500);
                    if (paused==false){
                        if (position >= getCount()-1){
                            position=0;
                            imageView.setImageResource(images[position]); //
                            textView.setText(captions[position]); //
                        }else{
                            position++;
                            imageView.setImageResource(images[position]); //
                            textView.setText(captions[position]); //
                        }
                    }
                }
            };
            handler.postDelayed(run, 500);
       // }

    }

}
