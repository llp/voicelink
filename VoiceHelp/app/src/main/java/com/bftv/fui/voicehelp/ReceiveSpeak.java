package com.bftv.fui.voicehelp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.bftv.fui.nlp.NlpClient;
import com.bftv.fui.nlp.NlpData;
import com.bftv.fui.nlp.call.BaseCall;
import com.bftv.fui.nlp.call.Call;
import com.bftv.fui.tell.Tell;

import java.util.HashMap;

/**
 * Author by Less on 17/10/10.
 */

public class ReceiveSpeak extends BroadcastReceiver{

    @Override
    public void onReceive(final Context context, Intent intent) {
        NlpClient nlpClient = new NlpClient.Builder().build();
        Call callMiddle = nlpClient.newCall(NlpClient.CallType.GLOBAL);
        callMiddle.execute(intent.getStringExtra("test"), new BaseCall.OnNlpDealListener() {
            @Override
            public void onTTS(NlpData nlpData) {
                Log.e("Less","voicehelp-nonTTS:"+nlpData.toString());
                Toast.makeText(context,"onTTS:"+nlpData.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResult(NlpData nlpData) {
                Log.e("Less","voicehelp-nonResult:"+nlpData.toString());
                Toast.makeText(context,"onResult:"+nlpData.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTransport(NlpData nlpData) {
                Log.e("Less","voicehelp-nonTransport:"+nlpData.toString());
                Toast.makeText(context,"onTransport:"+nlpData.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCache(NlpData nlpData) {
                Log.e("Less","voicehelp-nonCache:"+nlpData.toString());
                Toast.makeText(context,"onCache:"+nlpData.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public Pair<String, HashMap<String, String>> fromCacheData() {
                HashMap<String,String> hashMap = new HashMap<String, String>();
                hashMap.put("你好","哈哈哈命中了");
                return new Pair<>("com.bftv.fui.voicehelp",hashMap);

            }
        });

    }
}
