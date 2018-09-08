package com.rightflick.dating.social;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    List<FeedItem> feedItems;
    Context context;


    class FeedViewHolder extends RecyclerView.ViewHolder{
        TextView userName, caption;
        ImageView userDP, image;
        ImageView whiteLike;
        CheckBox likButton;
        ImageView commentButton;
        public FeedViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            caption = (TextView) itemView.findViewById(R.id.caption);

            userDP = (ImageView) itemView.findViewById(R.id.profile_image);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            whiteLike = (ImageView) itemView.findViewById(R.id.white_like);
            likButton = (CheckBox) itemView.findViewById(R.id.likeButton);
            commentButton = (ImageView) itemView.findViewById(R.id.commentButton);

        }
    }

    public FeedAdapter(Context context, List<FeedItem> feedItems) {
        this.feedItems = feedItems;
        this.context = context;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View feedViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_feed_item, parent, false);
        return new FeedViewHolder(feedViewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull final FeedViewHolder holder, int position) {
        FeedItem feedItem = feedItems.get(position);

        final long[] prevTime = {0};

        holder.caption.setText(feedItem.caption);
        holder.userName.setText(feedItem.userame);

        Picasso.get().load(feedItem.user_dp).into(holder.userDP);

        Picasso.get().load(feedItem.image).into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prevTime[0] ==0){
                    prevTime[0] = System.currentTimeMillis();
                }
                else {
                    long diff = System.currentTimeMillis() - prevTime[0];

                    if (diff<=300) {
                        AnimationSet animationSet = new AnimationSet(true);
                        @SuppressLint("ResourceType") Animation alphaAnimation = AnimationUtils.loadAnimation(context, R.animator.fade_in_animation);
                        @SuppressLint("ResourceType") Animation scaleAnimation = AnimationUtils.loadAnimation(context, R.animator.scale2);
//                        animationSet.addAnimation(alphaAnimation);
                        animationSet.addAnimation(scaleAnimation);
                        holder.whiteLike.startAnimation(animationSet);
                        animationSet.setFillBefore(true);
                        animationSet.setFillAfter(true);
                        holder.likButton.setChecked(true);
//                        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
                    }

                    prevTime[0] = System.currentTimeMillis();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }
}
