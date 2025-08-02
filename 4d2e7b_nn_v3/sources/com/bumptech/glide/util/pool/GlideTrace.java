package com.bumptech.glide.util.pool;

import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.ws.WebSocketProtocol;

public final class GlideTrace {
    private static final AtomicInteger COOKIE_CREATOR = null;
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    private GlideTrace() {
    }

    public static void beginSection(String str) {
    }

    public static int beginSectionAsync(String str) {
        return -1;
    }

    public static void beginSectionFormat(String str, Object obj) {
    }

    public static void endSection() {
    }

    public static void endSectionAsync(String str, int i10) {
    }

    private static String truncateTag(String str) {
        if (str.length() > 127) {
            return str.substring(0, WebSocketProtocol.PAYLOAD_SHORT);
        }
        return str;
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2) {
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2, Object obj3) {
    }
}
