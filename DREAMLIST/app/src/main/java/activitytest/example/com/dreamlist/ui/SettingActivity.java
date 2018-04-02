package activitytest.example.com.dreamlist.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;

import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;

import activitytest.example.com.dreamlist.MainActivity;
import activitytest.example.com.dreamlist.R;
import activitytest.example.com.dreamlist.entity.MyUser;
import activitytest.example.com.dreamlist.utils.L;
import activitytest.example.com.dreamlist.utils.UtilTools;
import activitytest.example.com.dreamlist.view.CustomDialog;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by HP on 2018/3/30.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_exit_user;
    private TextView edit_user;

    private EditText et_username;
    private EditText et_sex;
    private EditText et_age;
    private EditText et_desc;
    //更新按钮
    private Button btn_update_ok;
    //圆形头像
    private CircleImageView profile_image;
    private CustomDialog dialog;

    private Button btn_camera;
    private Button btn_picture;
    private Button btn_cancel;

//    @Parcel
    public class Person implements Serializable {
        EditText et_username;
        EditText et_desc;
        CircleImageView profile_image;

        public EditText getEt_username() {
            return et_username;
        }

        public void setEt_username(EditText et_username) {
            this.et_username = et_username;
        }

        public EditText getEt_desc() {
            return et_desc;
        }

        public void setEt_desc(EditText et_desc) {
            this.et_desc = et_desc;
        }

        public CircleImageView getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(CircleImageView profile_image) {
            this.profile_image = profile_image;
        }
}


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //退出登录
        btn_exit_user = (Button) findViewById(R.id.btn_exit_user);
        btn_exit_user.setOnClickListener(this);
        //编辑资料
        edit_user = (TextView) findViewById(R.id.edit_user);
        edit_user.setOnClickListener(this);

        et_username = (EditText) findViewById(R.id.et_username);
        et_sex = (EditText) findViewById(R.id.et_sex);
        et_age = (EditText) findViewById(R.id.et_age);
        et_desc = (EditText) findViewById(R.id.et_desc);
        //确定修改
        btn_update_ok = (Button) findViewById(R.id.btn_update_ok);
        btn_update_ok.setOnClickListener(this);



        profile_image = (CircleImageView)findViewById(R.id.profile_image);
        profile_image.setOnClickListener(this);

        //设置具体的值
        MyUser userInfo = BmobUser.getCurrentUser(MyUser.class);
        et_username.setText(userInfo.getUsername());
        et_age.setText(userInfo.getAge() + "");
        et_sex.setText(userInfo.isSex() ? getString(R.string.text_boy) : getString(R.string.text_girl_f));
        et_desc.setText(userInfo.getDesc());

        //intent传入数据
        Person person=new Person();
        person.setProfile_image(profile_image);
        person.setEt_username(et_username);
        person.setEt_desc(et_desc);

        Intent intent=new Intent(SettingActivity.this,MainActivity.class);
        intent.putExtra("person", person);
        startActivity(intent);

        //初始化dialog
        dialog = new CustomDialog(this, 0, 0,
                R.layout.dialog_photo, R.style.pop_anim_style, Gravity.BOTTOM, 0);
        //提示框以外点击无效
        dialog.setCancelable(false);
        btn_camera = (Button) dialog.findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(this);
        btn_picture = (Button) dialog.findViewById(R.id.btn_picture);
        btn_picture.setOnClickListener(this);
        btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);

        //默认是不可点击的/不可输入
        setEnabled(false);

//        //设置具体的值
//        MyUser userInfo = BmobUser.getCurrentUser(MyUser.class);
//        et_username.setText(userInfo.getUsername());
//        et_age.setText(userInfo.getAge() + "");
//        et_sex.setText(userInfo.isSex() ? getString(R.string.text_boy) : getString(R.string.text_girl_f));
//        et_desc.setText(userInfo.getDesc());




//        Intent intent=new Intent(SettingActivity.this,MainActivity.class);
//        //用Bundle携带数据
////        Bundle bundle=new Bundle();
////        bundle.putString("et_desc",userInfo.getDesc());
////        intent.putExtras(bundle);
//
//        startActivity(intent);
    }

    //控制焦点
    private void setEnabled(boolean is) {
        et_username.setEnabled(is);
        et_sex.setEnabled(is);
        et_age.setEnabled(is);
        et_desc.setEnabled(is);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //退出登录
            case R.id.btn_exit_user:
                //清除缓存用户对象
                MyUser.logOut();
                // 现在的currentUser是null了
                BmobUser currentUser = MyUser.getCurrentUser();
                startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                finish();
                break;
            //编辑资料
            case R.id.edit_user:
                setEnabled(true);
                btn_update_ok.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_update_ok:
                //1.拿到输入框的值
                String username = et_username.getText().toString();
                String age = et_age.getText().toString();
                String sex = et_sex.getText().toString();
                String desc = et_desc.getText().toString();

                //2.判断是否为空
                if (!TextUtils.isEmpty(username) & !TextUtils.isEmpty(age) & !TextUtils.isEmpty(sex)) {
                    //3.更新属性
                    MyUser user = new MyUser();
                    user.setUsername(username);
                    user.setAge(Integer.parseInt(age));
                    //性别
                    if (sex.equals(getString(R.string.text_boy))) {
                        user.setSex(true);
                    } else {
                        user.setSex(false);
                    }
                    //简介
                    if (!TextUtils.isEmpty(desc)) {
                        user.setDesc(getString(R.string.text_nothing));
                    } else {
                        user.setDesc(desc);
                    }
                    BmobUser bmobUser = BmobUser.getCurrentUser();
                    user.update(bmobUser.getObjectId(), new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null) {
                                //修改成功
                                setEnabled(false);
                                btn_update_ok.setVisibility(View.GONE);
                                Toast.makeText(SettingActivity.this, R.string.text_editor_success, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SettingActivity.this, R.string.text_editor_failure, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SettingActivity.this, getString(R.string.text_tost_empty), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.profile_image:
                dialog.show();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
            case R.id.btn_camera:
                toCamera();
                break;
            case R.id.btn_picture:
                toPicture();
                break;
//            case R.id.tv_courier:
//                startActivity(new Intent(SettingActivity.this, CourierActivity.class));
//                break;
//            case R.id.tv_phone:
//                startActivity(new Intent(SettingActivity.this, PhoneActivity.class));
//                break;
        }
    }

    public static final String PHOTO_IMAGE_FILE_NAME = "fileImg.jpg";
    public static final int CAMERA_REQUEST_CODE = 100;
    public static final int IMAGE_REQUEST_CODE = 101;
    public static final int RESULT_REQUEST_CODE = 102;
    private File tempFile = null;

    //跳转相机
    private void toCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断内存卡是否可用，可用的话就进行储存
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File(Environment.getExternalStorageDirectory(), PHOTO_IMAGE_FILE_NAME)));
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
        dialog.dismiss();
    }

    //跳转相册
    private void toPicture() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
        dialog.dismiss();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != this.RESULT_CANCELED) {
            switch (requestCode) {
                //相册数据
                case IMAGE_REQUEST_CODE:
                    startPhotoZoom(data.getData());
                    break;
                //相机数据
                case CAMERA_REQUEST_CODE:
                    tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_IMAGE_FILE_NAME);
                    startPhotoZoom(Uri.fromFile(tempFile));
                    break;
                case RESULT_REQUEST_CODE:
                    //有可能点击舍弃
                    if (data != null) {
                        //拿到图片设置
                        setImageToView(data);
                        //既然已经设置了图片，我们原先的就应该删除
                        if (tempFile != null) {
                            tempFile.delete();
                        }
                    }
                    break;
            }
        }
    }

    //裁剪
    private void startPhotoZoom(Uri uri) {
        if (uri == null) {
            L.e("uri == null");
            return;
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        //设置裁剪
        intent.putExtra("crop", "true");
        //裁剪宽高比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //裁剪图片的质量
        intent.putExtra("outputX", 320);
        intent.putExtra("outputY", 320);
        //发送数据
        intent.putExtra("return-data", true);
        startActivityForResult(intent, RESULT_REQUEST_CODE);
    }

    //设置图片
    private void setImageToView(Intent data) {
        Bundle bundle = data.getExtras();
        if (bundle != null) {
            Bitmap bitmap = bundle.getParcelable("data");
            profile_image.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //保存
        UtilTools.putImageToShare(SettingActivity.this,profile_image);
//        UtilTools.getImageToShare(SettingActivity.this,profile_image);
    }
}
