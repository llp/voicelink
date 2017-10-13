package com.bftv.tell.a;

import android.os.RemoteException;

import com.bftv.fui.thirdparty.IRemoteVoice;
import com.bftv.fui.thirdparty.RomoteVoiceService;
import com.bftv.fui.thirdparty.SimpleLog;
import com.bftv.fui.thirdparty.VoiceFeedback;
import com.bftv.fui.thirdparty.notify.DataChange;

/**
 * Author by Less on 17/10/13.
 */

public class TestAidl extends RomoteVoiceService {

    @Override
    public void send(String userTxt, String nlpJson, IRemoteVoice iRemoteVoice) {
        VoiceFeedback voiceFeedback = DataChange.getInstance().notifyDataChange(nlpJson);
        if(voiceFeedback != null){
            try {
                iRemoteVoice.sendMessage(voiceFeedback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            SimpleLog.l("send");
        }
    }
}
