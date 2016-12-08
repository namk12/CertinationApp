package pls.certination.com.certination.utilities.note_maker;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;




public class NoteDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NAME = "note.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    public static final String STR_SEP = "__,__";
    private static final String SQL_CREATE_NOTE_ENTRIES =
            "CREATE TABLE " + NoteDBContract.NoteEntry.TABLE_NAME + " (" +
                    NoteDBContract.NoteEntry.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    NoteDBContract.NoteEntry.KEY_TITLE + TEXT_TYPE + COMMA_SEP +
                    NoteDBContract.NoteEntry.KEY_CONTENT + TEXT_TYPE + COMMA_SEP +

                    NoteDBContract.NoteEntry.KEY_CREATED + INTEGER_TYPE + COMMA_SEP +
                    NoteDBContract.NoteEntry.KEY_EDITED + INTEGER_TYPE + COMMA_SEP +
                    NoteDBContract.NoteEntry.KEY_TAGS + TEXT_TYPE +
            ")";

    private static final String SQL_DELETE_NOTE_ENTRIES =
            "DROP TABLE IF EXISTS " + NoteDBContract.NoteEntry.TABLE_NAME;

    public NoteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_NOTE_ENTRIES);
        ContentValues values = new ContentValues();
        Note note = new Note();
        note.setTitle("Welcome to NoteMaker!");
        note.setContent("Store your content here");
        values.put(NoteDBContract.NoteEntry.KEY_TITLE, note.getTitle());
        values.put(NoteDBContract.NoteEntry.KEY_CONTENT, note.getContent());
        values.put(NoteDBContract.NoteEntry.KEY_CREATED, note.getCreated().getTime());
        values.put(NoteDBContract.NoteEntry.KEY_EDITED, note.getEdited().getTime());
        values.put(NoteDBContract.NoteEntry.KEY_TAGS, convertArrayListToString(note.getTags()));

        db.insert(NoteDBContract.NoteEntry.TABLE_NAME,
                null,
                values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_NOTE_ENTRIES);
        this.onCreate(db);
    }

    public void createEntry(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NoteDBContract.NoteEntry.KEY_TITLE, note.getTitle());
        values.put(NoteDBContract.NoteEntry.KEY_CONTENT, note.getContent());
        values.put(NoteDBContract.NoteEntry.KEY_CREATED, note.getCreated().getTime());
        values.put(NoteDBContract.NoteEntry.KEY_EDITED, note.getEdited().getTime());
        values.put(NoteDBContract.NoteEntry.KEY_TAGS, convertArrayListToString(note.getTags()));

        db.insert(NoteDBContract.NoteEntry.TABLE_NAME,
                null,
                values);

        db.close();
    }

    public void updateEntry(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NoteDBContract.NoteEntry.KEY_TITLE, note.getTitle());
        values.put(NoteDBContract.NoteEntry.KEY_CONTENT, note.getContent());
        values.put(NoteDBContract.NoteEntry.KEY_EDITED, note.getEdited().getTime());
        values.put(NoteDBContract.NoteEntry.KEY_TAGS, convertArrayListToString(note.getTags()));

        db.update(NoteDBContract.NoteEntry.TABLE_NAME,
                values,
                NoteDBContract.NoteEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(note.getId()) });

        db.close();
    }

    public boolean deleteEntry(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean deleted = db.delete(NoteDBContract.NoteEntry.TABLE_NAME,
                NoteDBContract.NoteEntry.KEY_ID + " = ?",
                new String[] { String.valueOf(id) }) > 0;

        db.close();
        return deleted;
    }

    public Note getEntry(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + NoteDBContract.NoteEntry.TABLE_NAME + " WHERE " +
                NoteDBContract.NoteEntry.KEY_ID + " = " + id;
        Cursor cursor = db.rawQuery(query, null);

        Note note = new Note();
        if (cursor.moveToFirst()) {
            note.setId(Integer.parseInt(cursor.getString(0)));
            note.setTitle(cursor.getString(1));
            note.setContent(cursor.getString(2));
            note.setCreated(new Date(cursor.getLong(3)));
            note.setEdited(new Date(cursor.getLong(4)));
            note.setTags(convertStringToArrayList(cursor.getString(5)));
        }

        return note;
    }

    public List<NoteItem> getAllEntries() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + NoteDBContract.NoteEntry.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        List<NoteItem> notes = new LinkedList<NoteItem>();

        Note note;
        if (cursor.moveToFirst()) {
            do {
                note = new Note();
                note.setId(Integer.parseInt(cursor.getString(0)));
                note.setTitle(cursor.getString(1));
                note.setContent(cursor.getString(2));
                note.setCreated(new Date(cursor.getLong(3)));
                note.setEdited(new Date(cursor.getLong(4)));
                note.setTags(convertStringToArrayList(cursor.getString(5)));
                notes.add(note);
            } while (cursor.moveToNext());
        }

        return notes;
    }

    public static String convertArrayListToString(ArrayList<String> arrayList) {
        String str = "";
        for (int i = 0, n = arrayList.size(); i < n; i++) {
            str = str + arrayList.get(i);
            if (i < n-1) {
                str = str + STR_SEP;
            }
        }
        return str;
    }

    public static ArrayList<String> convertStringToArrayList(String str) {
        String[] arr = str.split(STR_SEP);
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));
        return arrayList;
    }

}
