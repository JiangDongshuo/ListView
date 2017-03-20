package com.example.john.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private String[] names=new String[]{"Lion","Tiger","Monkey","Dog","Cat"};
    private int[] imageIds=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems=new ArrayList<Map<String, Object>>();
        for (int i=0;i<names.length;i++){
            Map<String, Object> listItem=new HashMap<String, Object>();
            listItem.put("name",names[i]);
            listItem.put("pic",imageIds[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"name","pic"},new int[]{R.id.name,R.id.pic});
        ListView list=(ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // System.out.println(imageIds[i]+"选中了");
                Toast.makeText(MainActivity.this, names[i], Toast.LENGTH_SHORT).show();
                view.setBackgroundResource(R.color.colorPrimaryDark);
            }
        });
    }
}
