package pls.certination.com.certination.utilities.note_maker;

import android.provider.BaseColumns;


public final class NoteDBContract {

    public NoteDBContract() {}

    public static abstract class NoteEntry implements BaseColumns {
        public static final String TABLE_NAME = "notes";
        public static final String KEY_ID = "id";
        public static final String KEY_TITLE = "title";
        public static final String KEY_CONTENT = "content";
        public static final String KEY_CREATED = "created";
        public static final String KEY_EDITED = "edited";
        public static final String KEY_TAGS = "tags";
    }
}
