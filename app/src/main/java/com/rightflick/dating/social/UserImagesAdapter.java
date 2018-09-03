package com.rightflick.dating.social;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserImagesAdapter extends BaseAdapter {

    Context context;
    List<UploadedPic> pics;

    public UserImagesAdapter(Context context, List<UploadedPic> pics) {
        this.context = context;
        this.pics = pics;
    }

    @Override
    public int getCount() {
        return pics.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            grid = new View(context);
            grid = layoutInflater.inflate(R.layout.single_uploaded_image, parent, false);
            ImageView imageView = (ImageView) grid.findViewById(R.id.uploaded_image);
//            imageView.setImageURI(Uri.parse(pics.get(position).image));
            Picasso.get().load(pics.get(position).image).into(imageView);
        }
        else {
            grid = (View) convertView;
        }

        return grid;
    }
}
