package com.example.arvtraining;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    final static int PERMISSION_REQUEST_CODE = 1001;
    

    ImageView iv;
    ImageView imageview;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        permissionCheck();

        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.changeBtn);
        imageview = findViewById(R.id.image1);

        iv = findViewById(R.id.image1);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); //기기 기본 갤러리 접근
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE); //구글 갤러리 접근 //
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,101);
            }
        });

        button.setOnClickListener(new View.OnClickListener(){

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Uri uri1 = pickRandomImage();

                Bitmap bm = null;
                try {
                    bm = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.parse("file://" + uri1));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ExifInterface exif = null;
                try {
                    exif = new ExifInterface(String.valueOf(uri1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                        ExifInterface.ORIENTATION_UNDEFINED);

                Bitmap bmRotated = rotateBitmap(bm, orientation);

                imageview.setImageBitmap(bmRotated);
            }
        });


    }
    
    private void permissionCheck(){
        if(Build.VERSION.SDK_INT >= 23){
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            ArrayList<String> arrayPermission = new ArrayList<String>();

            if (permissionCheck != PackageManager.PERMISSION_GRANTED){
                arrayPermission.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }

            if(arrayPermission.size() > 0){
                String strArray[] = new String[arrayPermission.size()];
                strArray = arrayPermission.toArray(strArray);
                ActivityCompat.requestPermissions(this, strArray, PERMISSION_REQUEST_CODE);
            } else{
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        switch (requestCode){
            case PERMISSION_REQUEST_CODE: {
                if (grantResults.length < 1){
                    Toast.makeText(this, "권한 획득 실패", Toast.LENGTH_SHORT).show();
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                    return;
                }

                for (int i= 0; i< grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "거부되었습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                }

                Toast.makeText(this, "승인되었습니다.", Toast.LENGTH_SHORT).show();
                //초기화 코드임

                }

                break;
            }

            super.onRequestPermissionsResult(requestCode, permissions,grantResults);
        }

    private Uri pickRandomImage() {
        Cursor c = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.ImageColumns._ID, MediaStore.Images.ImageColumns.DATA},
                MediaStore.Images.ImageColumns.SIZE + ">?", new String[]{"99999"}, null);
        Uri uri = null;

        if(c != null){
            int total = c.getCount();
            int position = (int) (Math.random() * total);
            if (total > 0) {
                if (c.moveToPosition(position)) {
                    String data = c.getString(
                            c.getColumnIndex(MediaStore.Images.ImageColumns.DATA));
                    long id = c.getLong(
                            c.getColumnIndex(MediaStore.Images.ImageColumns._ID));
                    uri = Uri.parse(data);
                }
            }
            c.close();
        }
        return uri;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int orientation) {

        Matrix matrix = new Matrix();
        switch (orientation) {
            case ExifInterface.ORIENTATION_NORMAL:
                return bitmap;
            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                matrix.setScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                matrix.setRotate(180);
                break;
            case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                matrix.setRotate(180);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_TRANSPOSE:
                matrix.setRotate(90);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_90:
                matrix.setRotate(90);
                break;
            case ExifInterface.ORIENTATION_TRANSVERSE:
                matrix.setRotate(-90);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                matrix.setRotate(-90);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return bmRotated;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
}
