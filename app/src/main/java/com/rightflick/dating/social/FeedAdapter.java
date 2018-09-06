package com.rightflick.dating.social;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    List<FeedItem> feedItems;

    class FeedViewHolder extends RecyclerView.ViewHolder{
        TextView userName, caption;
        ImageView userDP, image;
        public FeedViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            caption = (TextView) itemView.findViewById(R.id.caption);

            userDP = (ImageView) itemView.findViewById(R.id.profile_image);
            image = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

    public FeedAdapter(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View feedViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_feed_item, parent, false);
        return new FeedViewHolder(feedViewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        FeedItem feedItem = feedItems.get(position);

        holder.caption.setText(feedItem.caption);
        holder.userName.setText(feedItem.userame);

        Picasso.get().load(feedItem.user_dp).into(holder.userDP);

        Picasso.get().load(feedItem.image).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }
}
