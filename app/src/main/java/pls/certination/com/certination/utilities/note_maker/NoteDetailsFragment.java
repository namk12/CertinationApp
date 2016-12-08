package pls.certination.com.certination.utilities.note_maker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.Date;
import java.util.ArrayList;

import pls.certination.com.certination.R;


public class NoteDetailsFragment extends Fragment {

    private static final String NOTE_ID = "id";
    private static final String NOTE_TITLE = "title";
    private static final String NOTE_CONTENT = "content";
    private static final String NOTE_EDITED = "edited";
    private static final String NOTE_TAGS = "tags";
    private int mId;
    private String mTitle;
    private String mContent;
    private Long mEdited;
    private ArrayList<String> mTags;

    private FloatingActionButton editNotebutton;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Note title.
     * @param content Note content
     * @return A new instance of fragment NoteDetailsFragment.
     */
    public static NoteDetailsFragment newInstance(int id, String title, String content, Date edited, ArrayList<String> tags) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(NOTE_ID, id);
        args.putString(NOTE_TITLE, title);
        args.putString(NOTE_CONTENT, content);
        args.putLong(NOTE_EDITED, edited.getTime());
        args.putStringArrayList(NOTE_TAGS, tags);
        fragment.setArguments(args);
        return fragment;
    }

    public NoteDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mId = getArguments().getInt(NOTE_ID);
            mTitle = getArguments().getString(NOTE_TITLE);
            mContent = getArguments().getString(NOTE_CONTENT);
            mEdited = getArguments().getLong(NOTE_EDITED);
            mTags = getArguments().getStringArrayList(NOTE_TAGS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_details, container, false);
        TextView tvTitle = (TextView) v.findViewById(R.id.title);
        TextView tvContent = (TextView) v.findViewById(R.id.content);
        //TextView tvEdited = (TextView) v.findViewById(R.id.edited_date);
        //TextView tvTags = (TextView) v.findViewById(R.id.tags);
        //ImageView ivTags = (ImageView) v.findViewById(R.id.tag_icon);
        tvTitle.setText(mTitle);
        tvContent.setText(mContent);
        /*Date date = new Date(mEdited);
        DateFormat df = new SimpleDateFormat("MMM dd, yyyy '@' hh:mm aa");
        tvEdited.setText(df.format(date));*/
        /*if (!mTags.isEmpty() && !mTags.get(0).equals("")) {
            ivTags.setImageResource(R.drawable.ic_tag_teal_72);
        } else {
            ivTags.setImageResource(R.drawable.ic_tag_grey_72);
        }*/

        editNotebutton = (FloatingActionButton) v.findViewById(R.id.normal_edit_note);
        editNotebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), EditNoteActivity.class);
                i.putExtra("id", mId);
                i.putExtra("title", mTitle);
                i.putExtra("content", mContent);
                startActivity(i);
            }
        });

        return v;
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
        try {
            ((Note_maker) activity).updateOptionsMenu();
        } catch (NullPointerException e) { }
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

}
