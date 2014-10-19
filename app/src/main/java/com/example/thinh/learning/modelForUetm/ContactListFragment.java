package com.example.thinh.learning.modelForUetm;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ContactListFragment extends ListFragment {

    static final String ARG_UID = "uid";
    private static final ContactListModel model = new ContactListModel();
    private String currentUid = "0";
    private List<AbstractNode> childList;

    private OnFragmentInteractionListener mListener;

    public ContactListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentUid = getArguments().getString(ARG_UID);
        }
        childList = model.getChildNode(currentUid);
        if (childList != null) setListAdapter(new ArrayAdapter<AbstractNode>(getActivity(),
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
            mListener.onFragmentInteraction(childList.get(position).getUid());
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String uid);
    }

}
