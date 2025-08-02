package com.onesignal;

import com.onesignal.o3;
import java.util.Timer;
import java.util.TimerTask;

abstract class g1 {
    static void a(TimerTask timerTask, String str, long j10) {
        o3.v vVar = o3.v.DEBUG;
        o3.d1(vVar, "scheduleTrigger: " + str + " delay: " + j10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("trigger_timer:");
        sb2.append(str);
        new Timer(sb2.toString()).schedule(timerTask, j10);
    }
}
