package com.rightflick.dating.social;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

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

        feedAdapter = new FeedAdapter(getApplicationContext(), feedItems, this.getFragmentManager(), getActivity());


        feedItems.add(new FeedItem("Anup", "https://pbs.twimg.com/profile_images/565802631231062016/7FuVrnc9_400x400.jpeg", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Being cool is being your own self, not doing something that someone else is telling you to do."));

        feedItems.add(new FeedItem("Anup", "https://scontent.xx.fbcdn.net/v/t1.0-9/34396679_1566654770129480_5831421825292173312_o.jpg?_nc_cat=0&oh=fe97fbd0fb81bd46837fae60a79e571b&oe=5C34D11E", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Being cool is being your own self, not doing something that someone else is telling you to do."));

        feedItems.add(new FeedItem("Anup", "https://scontent.xx.fbcdn.net/v/t1.0-9/31739802_1529853770476247_1026674909490708480_o.jpg?_nc_cat=0&oh=a00569020f89a82c553973020084db48&oe=5C33A6DB", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Being cool is being your own self, not doing something that someone else is telling you to do."));

        feedItems.add(new FeedItem("Anup", "https://scontent.xx.fbcdn.net/v/t1.0-9/31486621_1529853743809583_8490965707842912256_o.jpg?_nc_cat=0&oh=c5a6bac3f7c9a3ab46f51550f058aff7&oe=5C340E42", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Being cool is being your own self, not doing something that someone else is telling you to do."));

        feedItems.add(new FeedItem("Anup", "https://scontent.xx.fbcdn.net/v/t1.0-9/31143891_1521453244649633_8114888570289782784_n.jpg?_nc_cat=0&oh=0d16196d23c28e68fdcbcdc1aef75fdb&oe=5C233AF4", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Being cool is being your own self, not doing something that someone else is telling you to do."));

        feedItems.add(new FeedItem("Anup", "https://scontent.xx.fbcdn.net/v/t1.0-9/29573090_1497794830348808_3946811174397111108_n.jpg?_nc_cat=0&oh=8f7bbde86831bce9a6f1ae02ce8e6051&oe=5BFA2325", "http://www.smosh.com/wp-content/uploads/2017/04/work-memes-th.jpg", "Being cool is being your own self, not doing something that someone else is telling you to do."));

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
