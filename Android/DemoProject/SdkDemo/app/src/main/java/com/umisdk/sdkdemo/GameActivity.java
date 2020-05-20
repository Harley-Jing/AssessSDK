package com.umisdk.sdkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.umisdk.assesslib.LoginManager;
import com.umisdk.assesslib.ReportedData;

public class GameActivity extends AppCompatActivity {

    private Button mBtnLogout, mBtnCreateRole, mBtnEnterGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mBtnLogout = findViewById(R.id.btn_logout);
        mBtnCreateRole = findViewById(R.id.btn_create_role);
        mBtnEnterGame = findViewById(R.id.btn_enter_game);
        setOnClick();
    }

    private void setOnClick(){
        OnClick click = new OnClick();
        mBtnLogout.setOnClickListener(click);
        mBtnCreateRole.setOnClickListener(click);
        mBtnEnterGame.setOnClickListener(click);
    }

    public class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_logout:
                    LoginManager.getInstance().logout();
                    Intent intent = new Intent();
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                    break;
                case R.id.btn_create_role:
                    ReportedData.getInstance(GameActivity.this).createRole("10086", "爱恨狂刀", "战士",
                            1, 1, String.valueOf(System.currentTimeMillis()));
                    break;
                case R.id.btn_enter_game:
                    ReportedData.getInstance(GameActivity.this).enterGame("10086", "爱恨狂刀", "战士",
                            1, 1, 1, String.valueOf(System.currentTimeMillis()));
                    break;
            }
        }
    }
}
