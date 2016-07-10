package com.geminno.app.myplaymusic.circle_activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;

public class ShareCircleActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_sharecircle;
    private ImageButton ib_sharecircle;
    PopupWindow popupWindow;
    private static final int RESULT_LOAD_IMAGE = 200;
    private TextView tv_takephoto;
    private TextView tv_fromphone;
    private TextView cancel_photo;
    private RelativeLayout rl_view_1;
    private ImageView iv_sharecircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_circle);

        iv_sharecircle = ((ImageView) findViewById(R.id.iv_sharecircle));
        rl_view_1 = ((RelativeLayout) findViewById(R.id.rl_view_1));
        btn_sharecircle = ((Button) findViewById(R.id.btn_sharecircle));
        ib_sharecircle=((ImageButton) findViewById(R.id.ib_sharecircle));
        btn_sharecircle.setOnClickListener(this);
        ib_sharecircle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sharecircle:
                this.finish();
                break;
            case R.id.ib_sharecircle:
                final View photo = LayoutInflater.from(this).inflate(R.layout.photo, null);
                tv_takephoto = ((TextView) photo.findViewById(R.id.tv_takephoto));
                tv_fromphone = ((TextView) photo.findViewById(R.id.tv_fromphone));
                cancel_photo = ((TextView) photo.findViewById(R.id.cancel_photo));

                tv_takephoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //startActivityForResult(camera, RESULT_LOAD_IMAGE);
                        Intent intent=new Intent();
                        intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                        startActivity(intent);
                    }
                });

                tv_fromphone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(picture, RESULT_LOAD_IMAGE );

                    }
                });

                cancel_photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });


                if (popupWindow == null) {
                    popupWindow = new PopupWindow(photo, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.setFocusable(true);
                }
                popupWindow.showAtLocation(rl_view_1, Gravity.BOTTOM, 0, 0);
        }
}

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        switch (requestCode) {
//            case RESULT_LOAD_IMAGE:
//                switch (resultCode) {
//                    case Activity.RESULT_OK://照相完成点击确定
//                        String sdStatus = Environment.getExternalStorageState();
//                        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {//检测sd是否可用
//                            Log.v("TestFile", "SD card is not avaiable/writeable right now");
//                            return;
//                        }
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
//                        String name = sdf.format(Calendar.getInstance().getTime()) + ".jpg";
//                        System.out.println(name);
//
//                        Bundle bundle = data.getExtras();
//                        Bitmap bitmap = (Bitmap) bundle.get("data");
//
//                        File file = new File("/sdcard/picak/");
//                        file.mkdirs();
//
//                        String fileName = file.getPath() + name;
//
//                        FileOutputStream fos = null;
//
//                        try {
//                            fos = new FileOutputStream(fileName);
//                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        } finally {
//                            try {
//                                fos.flush();
//                                fos.close();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                }
//
//
            case RESULT_LOAD_IMAGE :
                if (resultCode == Activity.RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumns = {MediaStore.Images.Media.DATA};
                    Cursor c = this.getContentResolver().query(selectedImage, filePathColumns, null, null, null);
                    c.moveToNext();
                    int columnIndex = c.getColumnIndex(filePathColumns[0]);
                    String picturePath = c.getString(columnIndex);
                    c.close();
                   Bitmap bm= BitmapFactory.decodeFile(picturePath,null);
                    iv_sharecircle.setImageBitmap(bm);
                    ObjectAnimator oa=ObjectAnimator.ofFloat(ib_sharecircle,"translationX",0,iv_sharecircle.getWidth());
                    oa.setDuration(100);
                    oa.start();
                }

        }

    }
}
