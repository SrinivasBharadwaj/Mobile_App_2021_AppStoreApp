package com.example.appstoreapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppListViewAdapter extends ArrayAdapter<DataServices.App> {
    public AppListViewAdapter(@NonNull Context context, int resource, @NonNull List<DataServices.App> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.app_list_item, parent, false);
            AppListViewHolder viewHolder = new AppListViewHolder();
            viewHolder.textViewAppName = convertView.findViewById(R.id.textViewAppName);
            viewHolder.textViewArtistName = convertView.findViewById(R.id.textViewArtistName);
            viewHolder.textViewReleaseDate = convertView.findViewById(R.id.textViewReleaseDate);
            convertView.setTag(viewHolder);
        }
        AppListViewHolder viewHolder = (AppListViewHolder) convertView.getTag();
        DataServices.App app = getItem(position);
        viewHolder.textViewAppName.setText(app.name);
        viewHolder.textViewArtistName.setText(app.artistName);
        viewHolder.textViewReleaseDate.setText(app.releaseDate);
        return convertView;
    }


    public class AppListViewHolder {
        TextView textViewAppName;
        TextView textViewArtistName;
        TextView textViewReleaseDate;
    }
}
