package activitytest.example.com.dreamlist.entity;

import cn.bmob.v3.BmobUser;

/**
 * Created by HP on 2018/3/28.
 */

public class MyUser extends BmobUser {


//    private String username;
    private int age;
    private boolean sex;
    private String desc;
//    public String getusername() {
//        return username;
//    }
//
//    public void setusername(String username) {
//        this.username = username;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
