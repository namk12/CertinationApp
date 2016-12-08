package pls.certination.com.certination.utilities.note_maker;

import android.app.Fragment;
import android.app.FragmentManager;
import
        android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import
        android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import
        android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import
        android.widget.Toast;

import pls.certination.com.certination.R;
import pls.certination.com.certination.utilities.note_maker.NoteListFragment;


public class Note_maker extends ActionBarActivity implements

        NoteListFragment.OnFragmentInteractionListener,
        NoteDetailsFragment.OnFragmentInteractionListener,

        OptionsBarFragment.OnFragmentInteractionListener {

    private final static String TAG_NOTE_LIST_FRAGMENT =
            "TAG_NOTE_LIST_FRAGMENT";
    private final static String TAG_NOTE_DETAILS_FRAGMENT = "TAG_NOTE_DETAILS_FRAGMENT";

    private final static String TAG_MOVE_TO_TRASH_DIALOG_FRAGMENT = "TAG_MOVE_TO_TRASH_DIALOG_FRAGMENT";

    private Menu
            mOptionsMenu;
    private Toolbar toolbar;
    private NoteListFragment noteListFragment;
    private NoteDetailsFragment
            noteDetailsFragment;
    private FrameLayout optionsBarContainer;
    private FragmentManager fm;
    private Note note;

    private NoteDBHelper noteDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_making);

        //Set up the toolbar

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getFragmentManager();

        Fragment mainFragment = fm.findFragmentById(R.id.main_container);
        if (mainFragment == null ||
                mainFragment.getClass().equals(NoteListFragment.class)) {
            optionsBarContainer = (FrameLayout) findViewById
                    (R.id.options_container);
            optionsBarContainer.setVisibility(View.GONE);
            noteListFragment =NoteListFragment.newInstance();
            fm.beginTransaction().replace(R.id.main_container, noteListFragment, TAG_NOTE_LIST_FRAGMENT).commit();
            setDefaultActionBar();
        } else {

            setAlternateActionBar();
        }

        noteDBHelper = new NoteDBHelper(this);
    }

    @Override
    public
    boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mOptionsMenu = menu;
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        super.onPrepareOptionsMenu(menu);
        if (note != null) {
            menu.findItem(R.id.action_delete).setVisible
                    (true);
            menu.findItem(R.id.action_share).setVisible(true);
        } else {
            menu.findItem
                    (R.id.action_delete).setVisible(false);
            menu.findItem(R.id.action_share).setVisible(false);
        }

        return true;
    }

    public void updateOptionsMenu() {
        onPrepareOptionsMenu(mOptionsMenu);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==
                android.R.id.home) {
            changeToListFragment();
            return true;
        } else if (id ==
                R.id.action_delete) {
            if (note != null) {
                MoveToTrashDialogFragment fragment = new MoveToTrashDialogFragment();
                fragment.show(fm, TAG_MOVE_TO_TRASH_DIALOG_FRAGMENT);
            }

            showTrashDialog();
            return true;
        } else if (id == R.id.action_share) {
            shareNote();

            return true;
        } else if (id == R.id.action_settings) {
            return true;
        }
        return
                super.onOptionsItemSelected(item);
    }

    public void onFragmentInteraction(Uri uri) {
    }

    public void deleteNote() {

        if (note != null) {
            new DeleteNoteTask(note.getId()).execute();
        }
    }

    public void shareNote()
    {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");

            i.putExtra(Intent.EXTRA_SUBJECT, note.getTitle());
            i.putExtra(Intent.EXTRA_TEXT, note.getContent());

            startActivity(Intent.createChooser(i, "Share Note"));
        } catch (Exception e) {
        }
    }

    public void
    setDefaultActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle(R.string.app_name);

    }

    public void setAlternateActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(R.string.note);
    }

    public void changeToDetailsFragment(Note note) {
        noteDetailsFragment =
                NoteDetailsFragment.newInstance(note.getId(), note.getTitle(), note.getContent(), note.getEdited(), note.getTags());

        fm.beginTransaction().replace(R.id.main_container, noteDetailsFragment, TAG_NOTE_DETAILS_FRAGMENT).addToBackStack(null).commit();
        this.note = note;
        optionsBarContainer.setVisibility
                (View.VISIBLE);
        setAlternateActionBar();
    }

    public void changeToListFragment() {

        optionsBarContainer.setVisibility(View.GONE);
        noteListFragment = NoteListFragment.newInstance();

        fm.beginTransaction()
                .replace(R.id.main_container, noteListFragment, TAG_NOTE_LIST_FRAGMENT)

                .commit();
        note = null;
        setDefaultActionBar();
    }

    @Override
    public void onBackPressed() {
        if
                (fm.getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            fm.popBackStack();

            changeToListFragment();
        }
    }

    private class DeleteNoteTask extends AsyncTask<Void, Void, Void> {


        private int id;
        private boolean deleted;

        public DeleteNoteTask(int id) {
            this.id = id;

            this.deleted = false;
        }

        protected void onPreExecute() {
            Log.d("Note_Maker", "Deleting Note...");
        }

        protected Void doInBackground(Void... v) {
            deleted = noteDBHelper.deleteEntry(id);

            return null;
        }

        protected void onPostExecute(Void v) {
            if (deleted) {
                note
                        = null;
                Toast.makeText(Note_maker.this, "Note deleted",
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(Note_maker.this, Note_maker.class);
                startActivity(i);
            }

        }
    }

    private void showTrashDialog() {

    }
}
