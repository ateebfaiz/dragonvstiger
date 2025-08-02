package com.facebook.react.modules.sound;

import android.media.AudioManager;
import com.facebook.fbreact.specs.NativeSoundManagerSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.jvm.internal.m;
import s6.a;

@a(name = "SoundManager")
public final class SoundManagerModule extends NativeSoundManagerSpec {
    public SoundManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void playTouchSound() {
        Object systemService = getReactApplicationContext().getSystemService("audio");
        m.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        ((AudioManager) systemService).playSoundEffect(0);
    }
}
