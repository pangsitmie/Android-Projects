package com.example.e_tuku;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profile.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

    private RecyclerView profileRecView;
    private ImageView profilePic;
    private TextView profileName, profileBalance;
    private ProfileRecViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);


        profilePic = v.findViewById(R.id.profilePic);
        profileName = v.findViewById(R.id.profileName);
        profileBalance = v.findViewById(R.id.profileBalance);

        profileRecView = v.findViewById(R.id.profileRecView);
        adapter = new ProfileRecViewAdapter(getActivity());

        profileRecView.setAdapter(adapter);
        profileRecView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<ProfileItemData> profile = new ArrayList<>();

        profile.add(new ProfileItemData("https://img.icons8.com/ios-glyphs/192/000000/like--v1.png","Favorites"));
        profile.add(new ProfileItemData("https://img.icons8.com/ios-glyphs/30/000000/wedding-gift.png","Rewards"));
        profile.add(new ProfileItemData("https://img.icons8.com/fluent-systems-filled/48/000000/mastercard-credit-card.png","Payments"));
        profile.add(new ProfileItemData("https://img.icons8.com/ios-filled/48/000000/help.png","Help"));
        profile.add(new ProfileItemData("https://img.icons8.com/fluent-systems-filled/48/000000/sale-price-tag.png","Promotions"));
        profile.add(new ProfileItemData("https://img.icons8.com/material-sharp/24/000000/starred-ticket.png","Subscription"));
        profile.add(new ProfileItemData("https://img.icons8.com/material-rounded/24/000000/briefcase.png","Partners"));

        profile.add(new ProfileItemData("https://img.icons8.com/ios-filled/24/000000/settings.png","Settings"));

        adapter.setProfileItemData(profile);






        return v;

    }
}