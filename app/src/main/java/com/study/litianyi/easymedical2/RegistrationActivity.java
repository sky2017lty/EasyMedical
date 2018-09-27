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

import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    private final static String TAG = "RegistrationActivity";

    private String[] data = new String[20];

    private ListView mHospitalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mHospitalListView = (ListView) findViewById(R.id.registration_hospital_list_view);

        final List<Hospital> mHospitals = LitePal.findAll(Hospital.class);

        for (int i = 0; i<mHospitals.size(); i++){
            data[i] = mHospitals.get(i).getHospitalName().toString();
            Log.d(TAG, "onCreate: data i = "+ data[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegistrationActivity.this,
               android.R.layout.simple_list_item_1,data);


        mHospitalListView.setAdapter(adapter);

        mHospitalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RegistrationActivity.this,
                        RegistrationDepartmentActivity.class);
                String data = mHospitals.get(position).getHospitalName();
                intent.putExtra("hospital name",data);
                startActivity(intent);
//                Toast.makeText(RegistrationActivity.this,
//                        mHospitals.get(position).getHospitalName(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
