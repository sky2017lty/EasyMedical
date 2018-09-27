package com.study.litianyi.easymedical2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private final static String TAG = "RegisterActivity";

    private EditText mUserNameEditText;
    private EditText mPassWordEditText;
    private EditText mHomeAddressEditText;
    private EditText mPhoneNumberEditText;

    private Button mRegisterButton;
    private Button mInquireDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUserNameEditText = (EditText) findViewById(R.id.register_username_edit_text);
        mPassWordEditText = (EditText) findViewById(R.id.register_password_edit_text);
        mHomeAddressEditText = (EditText) findViewById(R.id.register_home_address);
        mPhoneNumberEditText = (EditText) findViewById(R.id.register_phone_number);

        mRegisterButton = (Button) findViewById(R.id.register_register_button);
        mInquireDataButton = (Button) findViewById(R.id.register_inquire_data);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
                User user = new User();

                String userUUID = user.getUserUUID().toString();
                String username = mUserNameEditText.getText().toString();
                String password = mPassWordEditText.getText().toString();
                String address = mHomeAddressEditText.getText().toString();
                String phone = mPhoneNumberEditText.getText().toString();

                user.setUserName(username);
                user.setUserPassWord(password);
                user.setUserAddress(address);
                user.setUserPhone(phone);
                user.save();

                Toast.makeText(RegisterActivity.this,"success",Toast.LENGTH_SHORT).show();
            }
        });

        mInquireDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> users = LitePal.findAll(User.class);
                for (User user : users){
                    Log.d(TAG, "username is "+user.getUserName());
                    Log.d(TAG, "password is "+user.getUserPassWord());
                    Log.d(TAG, "address is "+user.getUserAddress());
                    Log.d(TAG, "Phone is "+user.getUserPhone());
                    Log.d(TAG, "id is "+user.getUserUUID());
                }
            }
        });

    }
}
