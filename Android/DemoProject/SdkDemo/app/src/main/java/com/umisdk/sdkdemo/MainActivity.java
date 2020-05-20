package com.umisdk.sdkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.umisdk.assesslib.LoginManager;
import com.umisdk.assesslib.LoginResultCallback;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginManager.getInstance().init(this);
        //注册登录回调
        LoginManager.getInstance().setLoginCallback(new LoginResultCallback() {
            @Override
            public void loginSuccess(String accessToken) {

                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }

            @Override
            public void loginCancel() {

            }

            @Override
            public void loginError(Exception e) {

            }

            @Override
            public void logout() {

            }
        });

        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().showLoginPanel();
            }
        });
    }
}
