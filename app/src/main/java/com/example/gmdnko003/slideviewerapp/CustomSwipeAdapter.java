package com.example.gmdnko003.slideviewerapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by gmdnko003 on 2015/09/13.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    public int[] images = {R.drawable.ucttopview, R.drawable.uctuppercampus, R.drawable.kramerlt1, R.drawable.labs
            , R.drawable.ikeys, R.drawable.jammies, R.drawable.diskidance, R.drawable.logo_uct};

    public String[] captions = {"Situated in the heart of Cape Town...", "... with beautiful campuses..."
            , "state of the art lecture theatres", "fantastic computer laboratories...", "a rich and diverse sporting code..."
            , "and free transport for the convenience of students...", "is UCT, one of Africa's premier universities!"
            , "Thanks for watching!"};

    private Context ctx;

    private int position;
    private ViewGroup container;
    private Object itemView;

    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context context){
        this.ctx = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view== (RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        this.position = position; ///
        this.container = container;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.activity_slide_show,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        TextView textView = (TextView) item_view.findViewById(R.id.text_view);
        imageView.setImageResource(images[position]); //
        textView.setText(captions[position]); //
        container.addView(item_view); //
        this.itemView = item_view;
        return item_view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
        //super.destroyItem(container, position, object);
    }
}