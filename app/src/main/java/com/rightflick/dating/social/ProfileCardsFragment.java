package com.rightflick.dating.social;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileCardsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileCardsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileCardsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CardStackView cardStackView;
    RightFlickCardsAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public ProfileCardsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileCardsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileCardsFragment newInstance(String param1, String param2) {
        ProfileCardsFragment fragment = new ProfileCardsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private List<ProfileData> createProfileDatas() {
        List<ProfileData> profiles = new ArrayList<>();
        profiles.add(new ProfileData("Yasaka Shrine", "Kyoto", "https://source.unsplash.com/Xq1ntWruZQI/600x800"));
        profiles.add(new ProfileData("Fushimi Inari Shrine", "Kyoto", "https://source.unsplash.com/NYyCqdBOKwc/600x800"));
        profiles.add(new ProfileData("Bamboo Forest", "Kyoto", "https://source.unsplash.com/buF62ewDLcQ/600x800"));
        profiles.add(new ProfileData("Brooklyn Bridge", "New York", "https://source.unsplash.com/THozNzxEP3g/600x800"));
        profiles.add(new ProfileData("Empire State Building", "New York", "https://source.unsplash.com/USrZRcRS2Lw/600x800"));
        profiles.add(new ProfileData("The statue of Liberty", "New York", "https://source.unsplash.com/PeFk7fzxTdk/600x800"));
        profiles.add(new ProfileData("Louvre Museum", "Paris", "https://source.unsplash.com/LrMWHKqilUw/600x800"));
        profiles.add(new ProfileData("Eiffel Tower", "Paris", "https://source.unsplash.com/HN-5Z6AmxrM/600x800"));
        profiles.add(new ProfileData("Big Ben", "London", "https://source.unsplash.com/CdVAUADdqEc/600x800"));
        profiles.add(new ProfileData("Great Wall of China", "China", "https://source.unsplash.com/AWh9C-QjhE4/600x800"));
        return profiles;
    }

    private RightFlickCardsAdapter createRightFlickCardsAdapter() {
        final RightFlickCardsAdapter adapter = new RightFlickCardsAdapter(getApplicationContext());
        adapter.addAll(createProfileDatas());
        return adapter;
    }

    private void reload() {
        cardStackView.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter = createRightFlickCardsAdapter();
                cardStackView.setAdapter(adapter);
                cardStackView.setVisibility(View.VISIBLE);
            }
        }, 1000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile_cards, container, false);
        cardStackView = (CardStackView) rootView.findViewById(R.id.profile_cards);
        cardStackView.setCardEventListener(new CardStackView.CardEventListener() {
            @Override
            public void onCardDragging(float percentX, float percentY) {

            }

            @Override
            public void onCardSwiped(SwipeDirection direction) {

            }

            @Override
            public void onCardReversed() {

            }

            @Override
            public void onCardMovedToOrigin() {

            }

            @Override
            public void onCardClicked(int index) {

            }
        });

        reload();

        // Inflate the layout for this fragment
        return rootView;
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
