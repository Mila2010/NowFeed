package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import static com.example.nowfeed.R.id.add_notes;
import static com.example.nowfeed.R.id.list_notes;
import static com.example.nowfeed.R.id.notes;
import static com.example.nowfeed.R.id.save_notes;

/**
 * Created by Millochka on 10/31/16.
 */

public class ThirdCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//    Fragment fragment = new Fragment();

    View mView;
    TextView mNote;
    EditText mEdit;
    Button mAdd, mSave, mList;

    Set<String> mAddNotes = new HashSet<String>();
    Set<String> mSavedNotes = new HashSet<String>();

    public ThirdCardViewHolder(ViewGroup parent) {
        super(inflateView(parent));

        mView = itemView;
        mNote = (TextView) mView.findViewById(notes);
        mEdit = (EditText) mView.findViewById(R.id.edit_notes);
        mAdd = (Button) mView.findViewById(R.id.add_notes);
        mAdd.setOnClickListener(this);
        mSave = (Button) mView.findViewById(R.id.save_notes);
        mSave.setOnClickListener(this);
        mList = (Button) mView.findViewById(R.id.list_notes);
        mList.setOnClickListener(this);

    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.third_card, parent, false);
    }

    protected void onBind(String input) {
        mEdit.setText(input);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case add_notes:
                String addLast = mEdit.getText().toString();
                mAddNotes.add(addLast);
                Toast.makeText(view.getContext(), "added notes", Toast.LENGTH_SHORT).show();
                mEdit.setText("");
                break;
            case save_notes:
                String saveLast = mEdit.getText().toString();
                mSavedNotes.add(saveLast);
                Toast.makeText(view.getContext(), "saved notes", Toast.LENGTH_SHORT).show();
                break;
            case list_notes:
                //fragments - to display my list of notes
                Toast.makeText(view.getContext(), "list notes", Toast.LENGTH_SHORT).show();
//                getFragment();
                break;
        }
    }

//    private void getFragment() {
//                FragmentTransaction fragmentTransaction = fragment.getFragmentManager().beginTransaction();
//                ListNotesFragment listFrag = new ListNotesFragment();
//                fragmentTransaction.add(R.id.notes_fragment,listFrag);
//                fragmentTransaction.commit();
//    }
}



