package com.example.saeed_pc.mydoctor.Main_MyDr.Hi_Dr.SdCard;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ici80071 on 5/7/2016.
 */
public class SDCard {

    private  Context context;

    public SDCard(Context context) {
        this.context = context;
    }

    public  String saveImageToSdCard(Uri imageUri, String DoctorID) {
        Log.i("===>", "SDCard.saveImageToSdCard.1" + imageUri);

        String file_path ="";

        ContentResolver provider = context.getContentResolver();
        File file = null;

        try {
            Log.i("===>", "SDCard.saveImageToSdCard.2" + imageUri);
            InputStream inputStream = provider.openInputStream(imageUri);


            // reduce size of pic
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 256, 256, false);
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 50, arrayOutputStream);
            Log.i("===>", "SDCard.saveImageToSdCard.3" );



            String folderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Arina_MyDr";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
                Log.i("===>", "SDCard.saveImageToSdCard.3.1" + folderPath);
            }
            Log.i("===>", "SDCard.saveImageToSdCard.4 folder:" + folderPath);

            SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            Log.i("===>", "SDCard.saveImageToSdCard.4.1" + imageUri);
            String time = format.format(new Date());
            Log.i("===>", "SDCard.saveImageToSdCard.4.2 time:" + time);

            file = new File(folder.getAbsolutePath() + "/"+DoctorID+ time +".png");
            Log.i("===>", "SDCard.saveImageToSdCard.4.3:" + file);
            file.createNewFile();
            Log.i("===>", "SDCard.saveImageToSdCard.4.5" + imageUri);

            file_path=file.getAbsolutePath();
            Log.i("===>", "SDCard.saveImageToSdCard.5 file path:" + file_path);




            FileOutputStream outputStream = new FileOutputStream(file);


            outputStream.write(arrayOutputStream.toByteArray());
            Log.i("===>", "SDCard.saveImageToSdCard.6" + imageUri);
            //int numberOfByte = 0 ;
            //byte[] buffer = new byte[1024];

            //while ((numberOfByte = inputStream.read(buffer)) != -1) {
            //    outputStream.write(buffer,0,numberOfByte);
            //}

            outputStream.flush();
            outputStream.close();
            Log.i("===>", "SDCard.saveImageToSdCard.7" + imageUri);


        } catch (FileNotFoundException e) {
            Log.i("===>", "SDCard.saveImageToSdCard.oops.1" + imageUri);
            e.printStackTrace();
        } catch (IOException e) {
            Log.i("===>", "SDCard.saveImageToSdCard.oops.2" + imageUri);
            e.printStackTrace();
        }
        return file_path;
    }


}
