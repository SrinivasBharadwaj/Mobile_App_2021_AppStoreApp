package com.example.appstoreapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_APP_DETAILS = "ARG_APP_DETAILS";

    // TODO: Rename and change types of parameters
    private DataServices.App appDetails;

    public AppDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment AppDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppDetailsFragment newInstance(DataServices.App appDetails) {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_APP_DETAILS, appDetails);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            appDetails =(DataServices.App) getArguments().getSerializable(ARG_APP_DETAILS);
        }
    }

    TextView textViewAppNameDetails;
    TextView textViewArtistNameDetails;
    TextView textViewReleaseDateDetails;
    ListView appDetailsListView;
    ArrayList<String> genres;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_details, container, false);
        appDetailsListView = view.findViewById(R.id.ListViewGenres);
        textViewAppNameDetails = view.findViewById(R.id.textViewAppNameDetails);
        textViewArtistNameDetails = view.findViewById(R.id.textViewArtistNameDetails);
        textViewReleaseDateDetails = view.findViewById(R.id.textViewReleaseDateDetails);
        genres = appDetails.genres;
        textViewAppNameDetails.setText(appDetails.name);
        textViewArtistNameDetails.setText(appDetails.artistName);
        textViewReleaseDateDetails.setText(appDetails.releaseDate);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, genres);
        appDetailsListView.setAdapter(adapter);
        return view;
    }
}