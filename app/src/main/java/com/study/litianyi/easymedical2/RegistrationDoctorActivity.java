package com.study.litianyi.easymedical2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class RegistrationDoctorActivity extends AppCompatActivity {

    private final static String TAG = "RegistrationActivity";

    private String[] data = new String[20];

    private ListView mDoctorListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_doctor);

        Intent intent = getIntent();
        String mDepartmentName = intent.getStringExtra("department name");

        final List<Doctor> mDoctors = LitePal.findAll(Doctor.class);

        for (int i = 0; i<mDoctors.size(); i++){
            data[i] = mDepartmentName +" 's "+ mDoctors.get(i).getDoctorName().toString();
            Log.d(TAG, "onCreate: data i = "+ mDoctors.get(i).getDoctorName().toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegistrationDoctorActivity.this,
                android.R.layout.simple_list_item_1,data);

        mDoctorListView = (ListView) findViewById(R.id.registration_doctor_list_view);
        mDoctorListView.setAdapter(adapter);

        mDoctorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RegistrationDoctorActivity.this,
                        RegistrationDoctorActivity.class);
                String data = mDoctors.get(position).getDoctorName();
                intent.putExtra("doctor name",data);
                Toast.makeText(RegistrationDoctorActivity.this,
                        "挂号成功，请前往“我的关注”中查看",Toast.LENGTH_SHORT).show();

                Intent intent1 = getIntent();
                Intent intent2 = getIntent();
                String mHospitalName = intent2.getStringExtra("hospital name");
                String mDepartmentName = intent1.getStringExtra("department name");
                String mDoctorName = intent.getStringExtra("doctor name");

                Connector.getDatabase();
                AttentionList attentionList = new AttentionList();

                String attentionUUID = attentionList.getAttentionUUID().toString();
                String attentionHospitalName = mHospitalName;
                String attentionDepartmentName = mDepartmentName;
                String attentionDoctorName = mDoctorName;

                attentionList.setHospitalName(attentionHospitalName);
                attentionList.setDepartmentName(attentionDepartmentName);
                attentionList.setDoctorName(attentionDoctorName);
                attentionList.save();

                List<AttentionList> attentionLists = LitePal.findAll(AttentionList.class);
                for (AttentionList attentionList1 : attentionLists){
                    Log.d(TAG, "hospital name is "+attentionList1.getHospitalName());
                    Log.d(TAG, "department name is "+attentionList1.getDepartmentName());
                    Log.d(TAG, "doctor name is "+attentionList1.getDoctorName());
                }
            }
        });

//        createDataBase();

    }


    private void createDataBase(){

        Intent intent = getIntent();
        String mHospitalName = intent.getStringExtra("hospital name");
        String mDepartmentName = intent.getStringExtra("department name");
        String mDoctorName = intent.getStringExtra("doctor name");

        Connector.getDatabase();
        AttentionList attentionList = new AttentionList();

        String attentionUUID = attentionList.getAttentionUUID().toString();
        String attentionHospitalName = mHospitalName;
        String attentionDepartmentName = mDepartmentName;
        String attentionDoctorName = mDoctorName;

        attentionList.setHospitalName(attentionHospitalName);
        attentionList.setDepartmentName(attentionDepartmentName);
        attentionList.setDoctorName(attentionDoctorName);
        attentionList.save();

        Log.d(TAG, "createDataBase: "+attentionList.getHospitalName()+"   "+
                attentionList.getDepartmentName()+"   "+
                attentionList.getDoctorName());
    }
}
