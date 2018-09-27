package com.study.litianyi.easymedical2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    private ImageView mLoginImageView;
    private TextView mUserNameTextView;
    private TextView mQuickRegistrationTextView;
    private TextView mQuickVisitTextView;
    private TextView mIllInformationTextView;
    private Button mPayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mLoginImageView = (ImageView) findViewById(R.id.imageView);

        mUserNameTextView = (TextView) findViewById(R.id.user_username_text_view);
        mQuickRegistrationTextView= (TextView) findViewById(R.id.quick_registration_text_view);
        mQuickVisitTextView = (TextView) findViewById(R.id.quick_visit_text_view);
        mIllInformationTextView = (TextView) findViewById(R.id.ill_information_text_view);
        mPayButton = (Button) findViewById(R.id.pay_button);

        final Intent intent = getIntent();
        String mUserName = intent.getStringExtra("username");
        Log.d("UserActivity", "onCreate: username = "+mUserName);
        mUserNameTextView.setText("Username : "+mUserName);

        mQuickRegistrationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(UserActivity.this,RegistrationActivity.class);
                startActivity(intent1);
            }
        });

        mQuickVisitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(UserActivity.this,AttentionActivity.class);
                startActivity(intent2);
            }
        });

        mIllInformationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(UserActivity.this,SymptomActivity.class);
                startActivity(intent3);
            }
        });

        mPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(UserActivity.this,PayDemoActivity.class);
                startActivity(intent1);
//                startActivity(new Intent(UserActivity.this, PayDemoActivity.class));
            }
        });
    }
}
