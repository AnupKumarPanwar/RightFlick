package com.rightflick.dating.social;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class RightFlickCardsAdapter extends ArrayAdapter<ProfileData> {


    public RightFlickCardsAdapter(@NonNull Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.single_card, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        ProfileData profileData = getItem(position);
        Picasso.get().load(profileData.image).into(holder.image);
        holder.name.setText(profileData.name);
        holder.city.setText(profileData.city);

        return convertView;
    }

    class ViewHolder {
        ImageView image;
        TextView name;
        TextView city;

        ViewHolder(View view) {
            this.image = (ImageView) view.findViewById(R.id.user_image);
            this.name = (TextView) view.findViewById(R.id.user_name);
            this.city = (TextView) view.findViewById(R.id.user_city);
        }

    }
}
