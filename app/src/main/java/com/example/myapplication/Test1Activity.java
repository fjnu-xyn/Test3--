package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1Activity extends AppCompatActivity {

    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE = "image";
    private TextView selectedItemTextView; // 用于显示选中的项名称
    private String selectedItemName = ""; // 用于存储选中的项名称

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取 ListView
        ListView listView = findViewById(R.id.listView);
        selectedItemTextView = findViewById(R.id.selectedItemTextView); // 获取 TextView

        // 准备数据源
        List<Map<String, Object>> data = new ArrayList<>();

        // 添加数据
        int[] images = {
                R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
                R.drawable.dog, R.drawable.cat, R.drawable.elephant
        };
        String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};

        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put(KEY_NAME, names[i]);
            map.put(KEY_IMAGE, images[i]);
            data.add(map);
        }

        // 定义 SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                R.layout.list_item,
                new String[]{KEY_NAME, KEY_IMAGE},
                new int[]{R.id.textView, R.id.imageView}
        );

        // 设置适配器到 ListView
        listView.setAdapter(adapter);

        // 动态设置点击效果，点击后背景变色
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // 重置所有列表项的背景颜色
            for (int i = 0; i < parent.getChildCount(); i++) {
                parent.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
            }
            // 设置当前点击项的背景颜色
            view.setBackgroundColor(Color.RED);

            // 获取选中的项名称并显示在 TextView 上
            selectedItemName = names[position]; // 获取选中的项名称
            selectedItemTextView.setText(selectedItemName); // 更新 TextView 文本

            // 显示 Toast 消息
            Toast.makeText(Test1Activity.this, "Selected: " + selectedItemName, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}