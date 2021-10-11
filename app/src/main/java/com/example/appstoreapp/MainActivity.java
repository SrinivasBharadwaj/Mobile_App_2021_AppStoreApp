package com.example.appstoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*
* Srinivas Bharadwaj Chintalapati
* */

public class MainActivity extends AppCompatActivity implements AppCategoryFragment.ICategory, AppListFragment.IAppDetails {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.appCategoryTitle));
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new AppCategoryFragment())
                .commit();
    }

    @Override
    public void navigateToAppList(String categoryName) {
        setTitle(categoryName);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, AppListFragment.newInstance(categoryName))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void AppCategoryFragmentSetTitle() {
        setTitle(getString(R.string.appCategoryTitle));
    }

    @Override
    public void sendToAppDetails(DataServices.App app) {
        setTitle(getString(R.string.appDetailsTitle));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, AppDetailsFragment.newInstance(app))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void AppDetailsSetTitle(String categoryTitle) {
        setTitle(categoryTitle);
    }
}