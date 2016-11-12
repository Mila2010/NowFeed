package com.example.nowfeed;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Hyun on 11/10/16.
 */

public class ListNotesFragment extends Fragment {
    ListView lvNotes;

    // using support.FragmentTransaction

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notes_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        lvNotes = (ListView) view.findViewById(R.id.notes_listview);
        super.onViewCreated(view, savedInstanceState);
    }
}
