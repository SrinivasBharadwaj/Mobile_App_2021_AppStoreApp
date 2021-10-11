package com.example.appstoreapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CATEGORY= "ARG_CATEGORY";

    // TODO: Rename and change types of parameters
    private String mCategory;

    public AppListFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AppListFragment newInstance(String category) {
        AppListFragment fragment = new AppListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategory = getArguments().getString(ARG_CATEGORY);
        }
    }
    AppListViewAdapter adapter;
    ArrayList<DataServices.App> apps;
    ListView appListView;
    IAppDetails mAppDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_app_list, container, false);
        mAppDetails.AppDetailsSetTitle(mCategory);
        appListView = view.findViewById(R.id.appListView);
        apps = DataServices.getAppsByCategory(mCategory);
        adapter = new AppListViewAdapter(view.getContext(), R.layout.app_list_item, apps);
        appListView.setAdapter(adapter);

        appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mAppDetails.sendToAppDetails(apps.get(position));
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof IAppDetails)
        {
            mAppDetails =  (IAppDetails) context;
        }
    }

    interface IAppDetails{
        void sendToAppDetails(DataServices.App app);
        void AppDetailsSetTitle(String categoryTitle);
    }
}