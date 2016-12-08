package pls.certination.com.Pls.Account_managment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.InputStream;


public class DownloadImageTask extends AsyncTask<String,Void,Bitmap> {
    private ImageView bmimage;

    public DownloadImageTask(ImageView bmimage) {
        this.bmimage = bmimage;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String urldisplay=urls[0];
        Bitmap icon=null;
        try{
            InputStream in=new java.net.URL(urldisplay).openStream();
            icon= BitmapFactory.decodeStream(in);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return icon;
    }
    protected void onPostExecute(Bitmap result){
        bmimage.setImageBitmap(result);
    }
}
