package com.study.litianyi.easymedical2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class AttentionActivity extends AppCompatActivity {

    private final static String TAG = "AttentionActivity";

//    private String[] data = {"test data #1","test data #2","test data #3","test data #4","test data #5",
//            "test data #6","test data #7"};

    private ListView mAttentionListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);

        mAttentionListView = (ListView) findViewById(R.id.attention_list_view);

        List<AttentionList> mAttentionLists = LitePal.findAll(AttentionList.class);

        String[] data = new String[100];

        for (int i = 0; i<100; i++){
            data[i] = "test data #"+i;
        }

        for (int i = 0; i<mAttentionLists.size(); i++){
            String mString1 = mAttentionLists.get(i).getHospitalName().toString();
            String mString2 = mAttentionLists.get(i).getDepartmentName().toString();
            String mString3 = mAttentionLists.get(i).getDoctorName().toString();
            data[i] = mString1 +" 's "+ mString2 +" 's "+ mString3;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AttentionActivity.this,
                android.R.layout.simple_list_item_1,data);

        mAttentionListView.setAdapter(adapter);
    }
}
