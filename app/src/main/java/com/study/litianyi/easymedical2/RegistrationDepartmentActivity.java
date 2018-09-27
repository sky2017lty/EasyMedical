package com.study.litianyi.easymedical2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.List;

public class RegistrationDepartmentActivity extends AppCompatActivity {

    private final static String TAG = "RegistrationActivity";

    private String[] data = new String[20];

    private ListView mDepartmentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_department);

        Intent intent = getIntent();

        final String mHospitalName = intent.getStringExtra("hospital name");


        final List<Department> mDepartments = LitePal.findAll(Department.class);

        for (int i = 0; i<mDepartments.size(); i++){
            data[i] = mHospitalName +" 's "+ mDepartments.get(i).getDepartmentName().toString();
            Log.d(TAG, "onCreate: data i = "+ mDepartments.get(i).getDepartmentName().toString());
    }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegistrationDepartmentActivity.this,
                android.R.layout.simple_list_item_1,data);

        mDepartmentListView = (ListView) findViewById(R.id.registration_department_list_view);
        mDepartmentListView.setAdapter(adapter);

        mDepartmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RegistrationDepartmentActivity.this,
                        RegistrationDoctorActivity.class);
                String dataHospital = mHospitalName;
                String data = mDepartments.get(position).getDepartmentName();
                intent.putExtra("department name",data);
                intent.putExtra("hospital name",dataHospital);
                startActivity(intent);
            }
        });
    }
}
