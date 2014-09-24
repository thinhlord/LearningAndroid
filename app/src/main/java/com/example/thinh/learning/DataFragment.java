package com.example.thinh.learning;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DataFragment extends Fragment {

    static final String ARG_POS = "position";

    int currentPosition = -1;

    public DataFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentPosition = getArguments().getInt(ARG_POS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            updateDataView(args.getInt(ARG_POS));
        } else if (currentPosition != -1) {
            updateDataView(currentPosition);
        }
    }

    public void updateDataView(int pos) {
        TextView data = (TextView) getActivity().findViewById(R.id.article);
        data.setTextSize(40);
        SharedPreferences contentFile = getActivity().
                getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE);
        data.setText(contentFile.getString("Option" + pos, "Đéo có gì :))"));
        currentPosition = pos;
    }
}
