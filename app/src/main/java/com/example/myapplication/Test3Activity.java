package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Test3Activity extends AppCompatActivity {

    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        testTextView = findViewById(R.id.test_text_view);
        invalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("Test3Activity", "onCreateOptionsMenu called");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_test3, menu);
        return true;
    }

    private Toast toast;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("Test3Activity", "onOptionsItemSelected called for: " + item.getTitle());
        int id = item.getItemId();

        if (toast != null) {
            toast.cancel();  // 取消当前显示的 Toast
        }

        if (id == R.id.font_small) {
            testTextView.setTextSize(10); // 小号字体
            return true;
        } else if (id == R.id.font_medium) {
            testTextView.setTextSize(16); // 中号字体
            return true;
        } else if (id == R.id.font_large) {
            testTextView.setTextSize(20); // 大号字体
            return true;
        } else if (id == R.id.menu_normal_item) {
            // 通过全局 toast 对象显示 Toast
            toast = Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        } else if (id == R.id.color_red) {
            testTextView.setTextColor(Color.RED); // 设置为红色字体
            return true;
        } else if (id == R.id.color_black) {
            testTextView.setTextColor(Color.BLACK); // 设置为黑色字体
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

