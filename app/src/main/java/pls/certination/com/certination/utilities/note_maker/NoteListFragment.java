package pls.certination.com.certination.utilities.note_maker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;



import java.util.List;

import pls.certination.com.certination.R;
import pls.certination.com.certination.utilities.note_maker.CreateNoteActivity;
import pls.certination.com.certination.utilities.note_maker.Note;
import pls.certination.com.certination.utilities.note_maker.NoteDBHelper;
import pls.certination.com.certination.utilities.note_maker.NoteItem;
import pls.certination.com.certination.utilities.note_maker.NoteListAdapter;
import pls.certination.com.certination.utilities.note_maker.Note_maker;


public class NoteListFragment extends Fragment {

    private ListView lv;
    private List<NoteItem> notes;
    private NoteListAdapter adapter;
    private NoteDBHelper noteDBHelper;
    private FloatingActionButton createNotebutton;
    private OnFragmentInteractionListener mListener;

    public static NoteListFragment newInstance() {
        return new NoteListFragment();
    }

    public NoteListFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_list, container, false);
        lv = (ListView) v.findViewById(R.id.list_view);

        createNotebutton = (FloatingActionButton) v.findViewById(R.id.normal_create_note);
        createNotebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CreateNoteActivity.class);
                startActivity(i);
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                NoteItem note = notes.get(position);
                ((Note_maker) getActivity()).changeToDetailsFragment((Note) note);
            }
        });
        noteDBHelper = new NoteDBHelper(getActivity());
        getNotes();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        activity.invalidateOptionsMenu();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private void getNotes() {
        new GetNotesTask().execute();
    }

    private class GetNotesTask extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute() {
            Log.d("MainActivity", "Getting Notes...");
        }

        protected Void doInBackground(Void... v) {
            notes = noteDBHelper.getAllEntries();
            return null;
        }

        protected void onPostExecute(Void v) {
            if (getActivity() != null) {
                adapter = new NoteListAdapter(getActivity(), notes);
                lv.setAdapter(adapter);
            }
        }
    }

}
