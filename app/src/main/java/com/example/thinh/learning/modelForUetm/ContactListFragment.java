package com.example.thinh.learning.modelForUetm;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactListFragment extends ListFragment {

    static final String ARG_ID = "id";
    private static final ModelContactList model = new ModelContactList();
    private String currentNodeId = "R";
    private List<Node> childList = new ArrayList<Node>();

    private OnFragmentInteractionListener mListener;

    public ContactListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentNodeId = getArguments().getString(ARG_ID);
        }
        childList = model.getChildNode(currentNodeId);
        setListAdapter(new ArrayAdapter<Node>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, childList));

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (null != mListener) {
            Node clickedChildUid = childList.get(position);
            mListener.onFragmentInteraction(clickedChildUid.getId(),
                    clickedChildUid.isPersonNode());
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String uid, boolean isLeaf);
    }

}
