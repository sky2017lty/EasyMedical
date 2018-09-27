package com.study.litianyi.easymedical2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private final static String TAG = "LoginActivity";

    private boolean mUserNameBoolean;
    private boolean mPassWordBoolean;

    private EditText mUserNameEditText;
    private EditText mPassWordEditText;

    private String mUserNameDataBase;
    private String mPassWordDataBase;

    private String mUserName;

    private Button mLoginButton;
    private Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);   //与视图联系起来

        mUserNameEditText = (EditText) findViewById(R.id.user_name_edit_text);
        mPassWordEditText = (EditText) findViewById(R.id.pass_word_edit_text);

        mLoginButton = (Button) findViewById(R.id.login_button);
        mRegisterButton = (Button) findViewById(R.id.register_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //设置登录按钮监听器——当点击按钮时

                List<User> users = LitePal.findAll(User.class);  //取出User表数据

                String mUserNameInput = mUserNameEditText.getText().toString();
                String mPassWordInput = mPassWordEditText.getText().toString();


                for (int i = 0; i<users.size(); i++){                               //与数据库对比
                    mUserNameDataBase = users.get(i).getUserName().toString();      //提取username
                    mPassWordDataBase = users.get(i).getUserPassWord().toString();
                    if (mUserNameDataBase.equals(mUserNameInput)){
                        Log.d(TAG, "onClick: 123");
                        mUserNameBoolean = true;
                        if (mPassWordDataBase.equals(mPassWordInput)){    //如果一致，登录通过
                            mPassWordBoolean = true;
//                            mUserName = mUserNameDataBase;
                            break;
                        }
                    }
                }

                if (mUserNameBoolean == true || mPassWordBoolean == true){   //登录
                    Intent intent = new Intent(LoginActivity.this,UserActivity.class);
                    intent.putExtra("username",mUserName);  //传递信息
                    startActivity(intent);
                } else {  //登录失败
                    Toast.makeText(LoginActivity.this,"Message Wrong",Toast.LENGTH_SHORT).show();
                }

            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  //跳到注册页面
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
