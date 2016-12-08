package pls.certination.com.certination.utilities.note_maker;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.inputmethodservice.KeyboardView;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import pls.certination.com.certination.R;


public class CamActivity extends Activity {
    final static private int NEW_PICTURE = 1;
    private String mCameraFileName;

    private Button b;
    private Button btnbck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        b=(Button)findViewById(R.id.btnSelectPhoto);
        btnbck=(Button)findViewById(R.id.btnbck);
        btnbck.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                finish();
              }
        });

        b.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

                Date date = new Date();
                DateFormat df = new SimpleDateFormat("-mm-ss");

                String newPicFile = "Bild"+ df.format(date) + ".jpg";
                String outPath = "/sdcard/" + newPicFile;
                File outFile = new File(outPath);

                mCameraFileName = outFile.toString();
                Uri outuri = Uri.fromFile(outFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outuri);


                startActivityForResult(intent, NEW_PICTURE);
            }
        });


    }
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {


        if (requestCode == NEW_PICTURE)
        {

            // return from file upload
            if (resultCode == Activity.RESULT_OK)
            {
                Uri uri = null;
                if (data != null)
                {
                    uri = data.getData();
                }
                if (uri == null && mCameraFileName != null)
                {
                    Toast.makeText(CamActivity.this, "photo added Successfully to :  emulated/0", Toast.LENGTH_SHORT).show();
                    uri = Uri.fromFile(new File(mCameraFileName));
                }
                File file = new File(mCameraFileName);
                if (!file.exists()) {
                    file.mkdir();
                }


            }
        }}

}