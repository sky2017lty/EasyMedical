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

public class SymptomActivity extends AppCompatActivity {

    private final static String TAG = "SymptomActivity";

    private String[] data = new String[20];

    private ListView mSymptomListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);
        
        mSymptomListView = (ListView) findViewById(R.id.symptom_list_view);

        final List<Ill> mIlls = LitePal.findAll(Ill.class);

        for (int i = 0; i<mIlls.size(); i++){
            data[i] = mIlls.get(i).getIllName().toString() +"  "+ mIlls.get(i).getIllType().toString()+
            "  "+ mIlls.get(i).getIllTrait().toString();
            Log.d(TAG, "onCreate: data i = "+ data[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SymptomActivity.this,
                android.R.layout.simple_list_item_1,data);


        mSymptomListView.setAdapter(adapter);

//        mSymptomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(SymptomActivity.this,
//                        RegistrationDepartmentActivity.class);
//                String data = mHospitals.get(position).getHospitalName();
//                intent.putExtra("hospital name",data);
//                startActivity(intent);
////                Toast.makeText(RegistrationActivity.this,
////                        mHospitals.get(position).getHospitalName(),Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
