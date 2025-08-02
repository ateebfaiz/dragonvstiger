package com.google.firebase.platforminfo;

import androidx.annotation.Nullable;
import kotlin.g;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    @Nullable
    public static String detectVersion() {
        try {
            return g.f12580f.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
