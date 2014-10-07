package com.example.thinh.learning;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.thinh.learning.model.HeadlineItems;

public class HeadlineFragment extends ListFragment {

    private OnFragmentInteractionListener mListener;

    public HeadlineFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<HeadlineItems.HeadlineText>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, HeadlineItems.ITEMS));
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
            mListener.onFragmentInteraction(position);
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(int pos);
    }

}
