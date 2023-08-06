package com.carloscordova.my_dialog_exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomUsersAdapter extends ArrayAdapter<User> {
    public CustomUsersAdapter(Context context, List<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        // Lookup view for data population
        TextView nameTextView = convertView.findViewById(R.id.name_TextView);
        TextView ageTextView = convertView.findViewById(R.id.age_TextView);
        TextView emailTextView = convertView.findViewById(R.id.email_TextView);

        // Populate the data into the template view using the data object
        nameTextView.setText(user.getNameUser());
        ageTextView.setText(String.valueOf(user.getAgeUser()));
        emailTextView.setText(user.getEmailUser());

        // Return the completed view to render on screen
        return convertView;
    }
}
