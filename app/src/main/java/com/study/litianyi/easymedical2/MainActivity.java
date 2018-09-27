package com.study.litianyi.easymedical2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SearchView mMainSearchView;
    private ListView mSearchListView;

    private TextView mUserTextView;
    private TextView mRegistrationTextView;
    private TextView mSymptomTextView;
    private TextView mAttentionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainSearchView = (SearchView) findViewById(R.id.main_search_view);
        mSearchListView = (ListView) findViewById(R.id.search_list_view);

        mUserTextView = (TextView) findViewById(R.id.user_text_view);
        mRegistrationTextView = (TextView) findViewById(R.id.registration_text_view);
        mSymptomTextView = (TextView) findViewById(R.id.symptom_text_view);
        mAttentionTextView = (TextView) findViewById(R.id.attention_text_view);

        createDataBase();

        mMainSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {  //搜索框
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"searching...",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this,"Text change",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mUserTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        mRegistrationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

        mSymptomTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SymptomActivity.class);
                startActivity(intent);
            }
        });

        mAttentionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AttentionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createDataBase(){  //创建数据库
        int result = LitePal.count(Hospital.class);
        if(result == 0){
            createHospital();
            createDepartment();
            createDoctor();
            createUser();
            createIll();
            Log.d("MainActivity", "createDataBase: ");
        }
    }

    private void createHospital(){
        Connector.getDatabase();  //建立database
        for (int i = 0; i<20; i++){
            Hospital hospital = new Hospital();
            hospital.setHospitalName("医院 "+i);
            hospital.setHospitalWorkTime(" 08“00 - 17:30 ");
            hospital.setHospitalPhone("联系方式： "+i);
            hospital.setHospitalAbstract("Hospital Abstract #"+i);
            hospital.setHospitalAnnouncement("Hospital Announcement #"+i);
            hospital.save();
        }
    }

    private void createIll(){
        Connector.getDatabase();
        for (int i = 0; i<20; i++){
            Ill ill = new Ill();
            ill.setIllName("疾病名称： "+i);
            ill.setIllType("疾病类型： "+i);
            ill.setIllTrait("疾病特征： "+i);
            ill.save();
        }
    }

    private void createDepartment(){
        Connector.getDatabase();
        for (int i = 0; i<20; i++){
            Department department = new Department();
            department.setDepartmentName("科室 "+i);
            department.setDepartmentAbstract(" 08“00 - 17:30 ");
            department.setDepartmentAnnouncement("联系方式： "+i);
            department.save();
        }
    }

    private void createDoctor(){
        Connector.getDatabase();
        for (int i = 0; i<20; i++){
            Doctor doctor = new Doctor();
            doctor.setDoctorName("医生 "+i);
            doctor.setDoctorAbstract("简介 "+i);
            doctor.save();
        }
    }

    private void createUser(){
        Connector.getDatabase();
        for (int i = 0; i<10; i++){
            User user = new User();
            user.setUserName("lty"+i);
            user.setUserPassWord("123");
            user.setUserAddress("User Address #"+i);
            user.setUserPhone("User Phone #"+i);
            user.save();
        }
    }
}
