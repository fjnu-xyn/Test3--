
package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_login);

        // 调用方法来显示自定义的AlertDialog
        showCustomAlertDialog();
    }

    private void showCustomAlertDialog() {
        // 使用LayoutInflater加载自定义布局
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_login, null);

        // 创建AlertDialog并设置自定义布局
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setCancelable(false); // 防止点击外部关闭对话框

        // 获取布局中的UI元素
        EditText etUsername = dialogView.findViewById(R.id.et_username);
        EditText etPassword = dialogView.findViewById(R.id.et_password);
        Button btnCancel = dialogView.findViewById(R.id.btn_cancel);
        Button btnSignin = dialogView.findViewById(R.id.btn_signin);

        // 创建AlertDialog
        AlertDialog alertDialog = builder.create();

        // 设置Cancel按钮点击事件
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss(); // 关闭对话框
                Toast.makeText(Test2Activity.this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置Sign in按钮点击事件
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                // 验证输入
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Test2Activity.this, "Please enter both fields", Toast.LENGTH_SHORT).show();
                } else {
                    alertDialog.dismiss(); // 关闭对话框
                    Toast.makeText(Test2Activity.this, "Sign in with: " + username, Toast.LENGTH_SHORT).show();
                    // 在此处处理登录逻辑
                }
            }
        });

        // 显示AlertDialog
        alertDialog.show();
    }
}
