package pls.certination.com.Pls.learning.Result;

import android.app.AlertDialog;
import android.content.Context;

public class DialogHelper
{
    /**
     * Creates a dialog box displaying error message.
     *
     * @param context a context in which error occurred
     * @param title   title of the error
     * @param message error message
     * @return dialog containing error message
     */
    public static AlertDialog createErrorDialog(Context context, String title, String message )
    {
        return new AlertDialog.Builder( context )
                .setTitle( title )
                .setMessage( message )
                .setIcon( android.R.drawable.ic_dialog_alert )
                .create();
    }
}
