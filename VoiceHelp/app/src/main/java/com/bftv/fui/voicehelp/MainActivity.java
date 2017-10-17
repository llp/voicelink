package com.bftv.fui.voicehelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bftv.fui.thirdparty.BindAidlManager;
import com.bftv.fui.thirdparty.UserStatusNoticeManager;
import com.bftv.fui.thirdparty.VoiceFeedback;
import com.bftv.fui.verification.AuthenticationManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.control).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                BindAidlManager.getInstance().dealMessage(MainActivity.this, "com.bftv.tell.a",
                        "第一个button执行点击事件", "{这里第三方自定义}", new BindAidlManager.OnBindAidlListener() {
                            @Override
                            public void onSuccess(VoiceFeedback voiceFeedback) {
                                Log.e("Less", "voicehelp-nonSuccess:" + voiceFeedback.toString());
                            }

                            @Override
                            public void onTimeOut(VoiceFeedback voiceFeedback) {
                                Log.e("Less", "voicehelp-nonTimeOut:" + voiceFeedback.toString());
                            }

                            @Override
                            public void onTimeOut() {
                                Log.e("Less", "voicehelp-nonTimeOut");
                            }

                            @Override
                            public boolean isVerification() {
                                return AuthenticationManager.getInstance().isSupport(MainActivity.this, "com.bftv.tell.a");
                            }
                        });
            }
        });

        findViewById(R.id.onshow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserStatusNoticeManager.getInstance().onShow(true);
            }
        });
    }


}
