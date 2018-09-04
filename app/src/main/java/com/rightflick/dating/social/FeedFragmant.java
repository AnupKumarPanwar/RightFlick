package com.rightflick.dating.social;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.labo.kaji.fragmentanimations.MoveAnimation;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FeedFragmant.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FeedFragmant#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedFragmant extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    List<FeedItem> feedItems;
    RecyclerView recyclerView;
    FeedAdapter feedAdapter;

    private OnFragmentInteractionListener mListener;

    public FeedFragmant() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedFragmant.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedFragmant newInstance(String param1, String param2) {
        FeedFragmant fragment = new FeedFragmant();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return MoveAnimation.create(MoveAnimation.LEFT, enter, 100);
        }
        else {
            return MoveAnimation.create(MoveAnimation.RIGHT, enter, 100);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed_fragmant, container, false);

        feedItems = new ArrayList<>();

        feedAdapter = new FeedAdapter(feedItems);


        feedItems.add(new FeedItem("Anup", "https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9_400x400.jpeg", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Hello World"));
        feedItems.add(new FeedItem("Anup", "https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9_400x400.jpeg", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Hello World"));
        feedItems.add(new FeedItem("Anup", "https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9_400x400.jpeg", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Hello World"));
        feedItems.add(new FeedItem("Anup", "https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9_400x400.jpeg", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Hello World"));
        feedItems.add(new FeedItem("Anup", "https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9_400x400.jpeg", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Hello World"));
        feedItems.add(new FeedItem("Anup", "https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9_400x400.jpeg", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Hello World"));
        feedItems.add(new FeedItem("Anup", "https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9_400x400.jpeg", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Hello World"));

        feedAdapter.notifyDataSetChanged();


        recyclerView = (RecyclerView) view.findViewById(R.id.feed_container);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(feedAdapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
