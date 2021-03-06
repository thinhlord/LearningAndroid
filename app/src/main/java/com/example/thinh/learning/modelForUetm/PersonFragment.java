package com.example.thinh.learning.modelForUetm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thinh.learning.R;


public class PersonFragment extends Fragment {

    static final String ARG_ID = "id";
    private static final ModelContactList model = new ModelContactList();
    private String currentId = "R";

    public PersonFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentId = getArguments().getString(ARG_ID);
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
            updateDataView(args.getString(ARG_ID));
        } else if (!currentId.equals("0")) {
            updateDataView(currentId);
        }
    }

    public void updateDataView(String id) {
        TextView data = (TextView) getActivity().findViewById(R.id.article);
        data.setTextSize(20);
        PersonNode currentNode = (PersonNode) model.getNode(id);
        data.setText(currentNode.getName() + "\n" + currentNode.getId());
        currentId = id;
    }
}
