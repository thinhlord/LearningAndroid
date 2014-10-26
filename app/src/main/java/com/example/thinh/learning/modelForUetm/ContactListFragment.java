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

    static final String ARG_UID = "uid";
    private static final ModelContactList model = new ModelContactList();
    private String currentUid = "0";
    private List<Node> childList = new ArrayList<Node>();

    private OnFragmentInteractionListener mListener;

    public ContactListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentUid = getArguments().getString(ARG_UID);
        }
        if (!model.isLeafNode(currentUid)) {
            childList = model.getChildNode(currentUid);
            setListAdapter(new ArrayAdapter<Node>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, childList));
        } else {
            List<String> leafData = new ArrayList<String>();
            leafData.add(((PersonNode) (model.getNode(currentUid))).getPersonalData());
            setListAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, leafData));
        }

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
            String clickedChildUid = childList.get(position).getId();
            mListener.onFragmentInteraction(clickedChildUid,
                    model.isLeafNode(clickedChildUid));
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String uid, boolean isLeaf);
    }

}
