package com.jsn.jsrrcms;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.storage.util.Helper;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
public class time_table extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImageView;
    private StorageReference imageRef;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        bindWidget();
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        imageRef = storageRef.child("photos/flying-parrot.jpg");
    }

    @Override
    public void onClick(View v) {
        downloadInLocalFile();
    }

    private void bindWidget() {
        //mImageView = findViewById(R.id.imageview);
        //mTextView = findViewById(R.id.tt);
        findViewById(R.id.tt).setOnClickListener(this);
    }
    private void downloadInLocalFile() {
        File dir = new File(Environment.getExternalStorageDirectory() + "/photos");
        final File file = new File(dir, UUID.randomUUID().toString() + ".png");
        try {
            if (!dir.exists()) {
                dir.mkdir();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final FileDownloadTask fileDownloadTask = imageRef.getFile(file);
       // Helper.initProgressDialog(this);
        //Helper.mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            //@Override
            //public void onClick(DialogInterface dialogInterface, int i) {
               // fileDownloadTask.cancel();
           // }
       // });
       // Helper.mProgressDialog.show();

        fileDownloadTask.addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                //Helper.dismissProgressDialog();
                mTextView.setText(file.getPath());
                mImageView.setImageURI(Uri.fromFile(file));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                //Helper.dismissProgressDialog();
                mTextView.setText(String.format("Failure: %s", exception.getMessage()));
            }
        }).addOnProgressListener(new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onProgress(FileDownloadTask.TaskSnapshot taskSnapshot) {
                int progress = (int) ((100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount());
                //Helper.setProgress(progress);
            }
        });
    }
}