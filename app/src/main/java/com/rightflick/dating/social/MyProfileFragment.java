package com.rightflick.dating.social;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.GridView;

import com.labo.kaji.fragmentanimations.MoveAnimation;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GridView gridView;

    List<UploadedPic> pics;

    UserImagesAdapter userImagesAdapter;


    private OnFragmentInteractionListener mListener;

    public MyProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProfileFragment newInstance(String param1, String param2) {
        MyProfileFragment fragment = new MyProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return MoveAnimation.create(MoveAnimation.RIGHT, enter, 100);
        }
        else {
            return MoveAnimation.create(MoveAnimation.LEFT, enter, 100);
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
        View rootView = inflater.inflate(R.layout.fragment_my_profile, container, false);

        pics = new ArrayList<>();
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/96bb29858c765c593b9596581999786f/5C154F9B/t51.2885-15/e35/c83.0.419.419/39370232_2241023096184777_3804415295594954752_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/b710693e4dc4cb443b6fb743d2501f7c/5C35DA0C/t51.2885-15/sh0.08/e35/s640x640/31941457_1031025983720679_1139431025215012864_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/4e223503b2af0ccd40f7b154d59fc7a8/5C3BBC76/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/30830197_221762301915876_5171126910553423872_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/894ed9f2dd780ad9d3663054bcd106b5/5C2039D9/t51.2885-15/sh0.08/e35/s640x640/27880047_604100519921565_8860978355869057024_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/214f2d2cf81b7844f7919dddd705dde2/5C3ABC04/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/25023543_1733848449979150_1973813321081552896_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/44e20d6a2b6c87f920810a32e61a5a7d/5C22E0B1/t51.2885-15/sh0.08/e35/s640x640/22345018_1343678789071111_1940766648705220608_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/b710693e4dc4cb443b6fb743d2501f7c/5C35DA0C/t51.2885-15/sh0.08/e35/s640x640/31941457_1031025983720679_1139431025215012864_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/4e223503b2af0ccd40f7b154d59fc7a8/5C3BBC76/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/30830197_221762301915876_5171126910553423872_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/894ed9f2dd780ad9d3663054bcd106b5/5C2039D9/t51.2885-15/sh0.08/e35/s640x640/27880047_604100519921565_8860978355869057024_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/214f2d2cf81b7844f7919dddd705dde2/5C3ABC04/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/25023543_1733848449979150_1973813321081552896_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/44e20d6a2b6c87f920810a32e61a5a7d/5C22E0B1/t51.2885-15/sh0.08/e35/s640x640/22345018_1343678789071111_1940766648705220608_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/b710693e4dc4cb443b6fb743d2501f7c/5C35DA0C/t51.2885-15/sh0.08/e35/s640x640/31941457_1031025983720679_1139431025215012864_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/4e223503b2af0ccd40f7b154d59fc7a8/5C3BBC76/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/30830197_221762301915876_5171126910553423872_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/894ed9f2dd780ad9d3663054bcd106b5/5C2039D9/t51.2885-15/sh0.08/e35/s640x640/27880047_604100519921565_8860978355869057024_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/214f2d2cf81b7844f7919dddd705dde2/5C3ABC04/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/25023543_1733848449979150_1973813321081552896_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/44e20d6a2b6c87f920810a32e61a5a7d/5C22E0B1/t51.2885-15/sh0.08/e35/s640x640/22345018_1343678789071111_1940766648705220608_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/b710693e4dc4cb443b6fb743d2501f7c/5C35DA0C/t51.2885-15/sh0.08/e35/s640x640/31941457_1031025983720679_1139431025215012864_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/4e223503b2af0ccd40f7b154d59fc7a8/5C3BBC76/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/30830197_221762301915876_5171126910553423872_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/894ed9f2dd780ad9d3663054bcd106b5/5C2039D9/t51.2885-15/sh0.08/e35/s640x640/27880047_604100519921565_8860978355869057024_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/214f2d2cf81b7844f7919dddd705dde2/5C3ABC04/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/25023543_1733848449979150_1973813321081552896_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/44e20d6a2b6c87f920810a32e61a5a7d/5C22E0B1/t51.2885-15/sh0.08/e35/s640x640/22345018_1343678789071111_1940766648705220608_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/b710693e4dc4cb443b6fb743d2501f7c/5C35DA0C/t51.2885-15/sh0.08/e35/s640x640/31941457_1031025983720679_1139431025215012864_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/4e223503b2af0ccd40f7b154d59fc7a8/5C3BBC76/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/30830197_221762301915876_5171126910553423872_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/894ed9f2dd780ad9d3663054bcd106b5/5C2039D9/t51.2885-15/sh0.08/e35/s640x640/27880047_604100519921565_8860978355869057024_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/214f2d2cf81b7844f7919dddd705dde2/5C3ABC04/t51.2885-15/sh0.08/e35/c0.135.1080.1080/s640x640/25023543_1733848449979150_1973813321081552896_n.jpg"));
        pics.add(new UploadedPic("https://instagram.fixc1-2.fna.fbcdn.net/vp/44e20d6a2b6c87f920810a32e61a5a7d/5C22E0B1/t51.2885-15/sh0.08/e35/s640x640/22345018_1343678789071111_1940766648705220608_n.jpg"));

        gridView = (GridView) rootView.findViewById(R.id.my_pics);
        userImagesAdapter = new UserImagesAdapter(getActivity(), pics);
        gridView.setAdapter(userImagesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), FullScreenImage.class);
                intent.putExtra("url", pics.get(position).image);
                startActivity(intent);
            }
        });


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
