package com.example.nowfeed;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;
import static com.example.nowfeed.R.id.add_notes;
import static com.example.nowfeed.R.id.list_notes;
import static com.example.nowfeed.R.id.notes;
import static com.example.nowfeed.R.id.save_notes;

/**
 * Created by Millochka on 10/31/16.
 */

public class ThirdCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    View mView;
    TextView mNote;
    EditText mEdit;
    Button mAdd, mSave, mList;

    Set<String> mWrittenNotes = new HashSet<String>();


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
            case add_notes: case save_notes:
                String addingLast = mEdit.getText().toString();
                mWrittenNotes.add(addingLast);
                Toast.makeText(view.getContext(),"saved notes",Toast.LENGTH_SHORT).show();
                mEdit.setText("");
                SharedPreferences sharedPrefs = view.getContext().getSharedPreferences()
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putStringSet("MyNotes", mWrittenNotes);
                Log.d(TAG, String.valueOf(editor.putStringSet(TAG, mWrittenNotes)));
                editor.commit();
                break;
            case list_notes:
                //fragments
                break;
        }

    }

}

//        Set<String> notation = sharedPrefs.getStringSet(TAG,new HashSet<String>());
//        if(notation != null){
//            Iterator<String> iterator = notation.iterator();
//            while(iterator.hasNext()){
//                mEdit.setText((CharSequence) iterator);
//            }
//        }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        sharedPrefs = getSharedPreferences(TAG,MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPrefs.edit();
//        editor.putStringSet(TAG,mWrittenNotes);
//        editor.commit();
//    }

