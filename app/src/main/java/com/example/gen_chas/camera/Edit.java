package com.example.gen_chas.camera;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Edit extends AppCompatActivity implements Button.OnClickListener{
// Inialization
    //Variables
   int i=1;
    ArrayList<Bitmap> effects=new ArrayList<Bitmap>();
    AlertDialog dialog;
    public  static int LOAD_IMAGE_RESULLTS=1;
    Bitmap imgEDT;
    //Buttons
    Button eFT1,eFT2,eFT3,eFT4,eFT5,eFT6,eFT7,eFT8,lYR1,lYR2,lYR3,save,undo;
    //Image View
    ImageView imgEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_edit);
            imgEd = (ImageView) findViewById(R.id.imgEdit2);
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, LOAD_IMAGE_RESULLTS);
            eFT1=(Button)findViewById(R.id.btn_eftone);
            eFT2=(Button)findViewById(R.id.btn_efttwo);
            eFT3=(Button)findViewById(R.id.btn_eftthree);
            eFT4=(Button)findViewById(R.id.btn_eftfour);
            eFT5=(Button)findViewById(R.id.btn_eftfive);
            eFT6=(Button)findViewById(R.id.btn_eftsix);
            eFT7=(Button)findViewById(R.id.btn_eftseven);
            eFT8=(Button)findViewById(R.id.btn_efteight);
            lYR1=(Button)findViewById(R.id.btn_lyruno);
            lYR2=(Button)findViewById(R.id.btn_lyrdupo);
            lYR3=(Button)findViewById(R.id.btn_lyrtre);
            save=(Button)findViewById(R.id.btn_SAVE);
            undo=(Button)findViewById(R.id.btn_undo);


            eFT1.setOnClickListener(this);
            eFT2.setOnClickListener(this);
            eFT3.setOnClickListener(this);
            eFT4.setOnClickListener(this);
            eFT5.setOnClickListener(this);
            eFT6.setOnClickListener(this);
            eFT7.setOnClickListener(this);
            eFT8.setOnClickListener(this);
            lYR1.setOnClickListener(this);
            lYR2.setOnClickListener(this);
            lYR3.setOnClickListener(this);
            save.setOnClickListener(this);
            undo.setOnClickListener(this);

        }catch(Exception e){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==LOAD_IMAGE_RESULLTS && resultCode==RESULT_OK && data!=null){
            Uri pickedImage=data.getData();
            String[] file_Path={MediaStore.Images.Media.DATA};

            Cursor cursor= getContentResolver().query(pickedImage,file_Path,null,null,null);
            cursor.moveToFirst();

            String imagePath=cursor.getString(cursor.getColumnIndex(file_Path[0]));
          //  Toast.makeText(this,imagePath,Toast.LENGTH_LONG).show();
            imgEDT= BitmapFactory.decodeFile(imagePath);
            effects.add(0,imgEDT);
            imgEd.setImageBitmap(imgEDT);
            // imgEDT=BitmapFactory.decodeFile(imagePath);
            cursor.close();
        }
    }

    protected  Bitmap bitmap(int l)throws Exception{
        Bitmap x = ((BitmapDrawable)imgEd.getDrawable()).getBitmap();

    Bitmap result=Bitmap.createBitmap(x.getWidth(),x.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas c=new Canvas(result);
        c.drawBitmap(x,0,0,null);
        Paint p=new Paint();

        if(l==1) {
            p.setAlpha(127);
           Bitmap  effect = effectone();
            c.drawBitmap(effect,0,0,p);
        }else if(l==2){
            p.setAlpha(127);
          Bitmap  effect=effecttwo();
            c.drawBitmap(effect,0,0,p);
        }else if(l==3){
            p.setAlpha(127);
            Bitmap  effect=effectthree();
            c.drawBitmap(effect,0,0,p);
        }else if(l==4){
            p.setAlpha(127);
            Bitmap  effect=effectfour();
            c.drawBitmap(effect,0,0,p);
        }else if(l==5){
            p.setAlpha(127);
            Bitmap  effect=effectfive();
            c.drawBitmap(effect,0,0,p);
        }else if(l==6){
            p.setAlpha(127);
            Bitmap  effect=effectsix();
            c.drawBitmap(effect,0,0,p);

        }else if(l==7){
            p.setAlpha(127);
            Bitmap  effect=effectseven();
            c.drawBitmap(effect,0,0,p);
        }else if(l==8){
            p.setAlpha(127);
            Bitmap  effect=effecteight();
            c.drawBitmap(effect,0,0,p);
        }else if(l==9){
            if(l==10 || l==11){

            }else{
                p.setAlpha(1000);
                Bitmap  effect=layeruno();
                c.drawBitmap(effect,0,0,p);
            }

        }else if(l==10){
            if(l==9 || l==11){

            }else {
                p.setAlpha(1000);
                Bitmap effect = layerduo();
                c.drawBitmap(effect, 0, 0, p);
            }
        }else if(l==11){
            if(l==9 || l==10){}else {
                p.setAlpha(1000);
                Bitmap effect = layertre();
                c.drawBitmap(effect, 0, 0, p);
            }
        }

effects.add(i,result);
i++;


        return result;
}

protected  Bitmap effectone()throws Exception{
    Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.effectone);
   effect=size(effect);
    return effect;
}
    protected  Bitmap effecttwo()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.effecttwo);
        effect=size(effect);
        return effect;
    }


    protected  Bitmap effectthree()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.effectthree);
        effect=size(effect);
        return effect;
    }
    protected  Bitmap effectfour()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.effectfour);
        effect=size(effect);
        return effect;
    }
    protected  Bitmap effectfive()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.effectfive);
        effect=size(effect);
        return effect;
    }
    protected  Bitmap effectsix()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.effectsix);
        effect=size(effect);
        return effect;
    }
    protected  Bitmap effectseven()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.effectseven);
        effect=size(effect);
        return effect;
    }
    protected  Bitmap effecteight()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.effecteight);
        effect=size(effect);
        return effect;
    }
    protected  Bitmap layeruno()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.layeruno);
        effect=size(effect);
        return effect;
    }
    protected  Bitmap layerduo()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.layerduo);
        effect=size(effect);
        return effect;
    }
    protected  Bitmap layertre()throws Exception{
        Bitmap effect=BitmapFactory.decodeResource(getResources(),R.drawable.layertre);
        effect=size(effect);
        return effect;
    }

    protected  Bitmap size(Bitmap yourBitmap)throws Exception{

            int newWidth = imgEDT.getWidth();
            int newHeight = imgEDT.getHeight();
            Bitmap resized = Bitmap.createScaledBitmap(yourBitmap, newWidth, newHeight, true);

        return resized;
    }

    public void startSave(){
        FileOutputStream fileOutputStream=null;
        File file=getDisc();
        if(!file.exists()&&!file.mkdir()){
            Toast.makeText(this,"Cant Create",Toast.LENGTH_LONG).show();
            return;
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyymmsshhmmss");
        String Date=simpleDateFormat.format(new Date());
        String Name="imag"+Date+".jpg";
        String fileName=file.getAbsolutePath()+"/"+Name;
        File new_file=new File(fileName);
        try {
            fileOutputStream =new FileOutputStream(new_file);
            BitmapDrawable drawable = (BitmapDrawable) imgEd.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            Toast.makeText(this,"Image Saves On The Device",Toast.LENGTH_LONG).show();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        refreshGallery(new_file);

    }

    private void refreshGallery(File file) {
        Intent  intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }

    private File getDisc(){
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return new File(file,"Image demo");

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        int l=0;
        if(v.getId()==R.id.btn_eftone){
            l=1;
           // Toast.makeText(this,"working",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(v.getId()==R.id.btn_efttwo){
            l=2;
           // Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(v.getId()==R.id.btn_eftthree){
            l=3;
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(v.getId()==R.id.btn_eftfour){
            l=4;
            // Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(v.getId()==R.id.btn_eftfive){
            l=5;
            // Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }else if(v.getId()==R.id.btn_eftsix) {
            l = 6;
             Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1 = null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }else if(v.getId()==R.id.btn_eftseven){
            l=7;
            // Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }else if(v.getId()==R.id.btn_efteight){
            l=8;
            // Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }else if(v.getId()==R.id.btn_lyruno){
            l=9;
            // Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }else if(v.getId()==R.id.btn_lyrdupo){
            l=10;
            // Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }else if(v.getId()==R.id.btn_lyrtre){
            l=11;
            // Toast.makeText(this,"working2",Toast.LENGTH_LONG).show();
            Bitmap aple1= null;
            try {
                aple1 = bitmap(l);
                imgEd.setImageBitmap(aple1);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }else if(v.getId()==R.id.btn_SAVE){
             // Toast.makeText(this,"working ifne",Toast.LENGTH_LONG).show();

                         startSave();


        }else if(v.getId()==R.id.btn_undo){
            i--;

            if(i>=0) {

                Bitmap temp = effects.get(i);
                imgEd.setImageBitmap(temp);

            }else if(i<0){
                Toast.makeText(this,"No Effects Applied",Toast.LENGTH_LONG).show();
                imgEd.setImageBitmap(imgEDT);
                   i++;
            }
        }

        }

}
