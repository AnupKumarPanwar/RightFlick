package com.rightflick.dating.social;

import android.support.v7.widget.RecyclerView;

public class FeedItem{
    String userame, user_dp, image, caption;

    public FeedItem(String userame, String image, String user_dp, String caption) {
        this.userame = userame;
        this.user_dp = user_dp;
        this.image = image;
        this.caption = caption;
    }
}
