package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    static class a {
        @DoNotInline
        static boolean a(Message message) {
            return message.isAsynchronous();
        }

        @DoNotInline
        static void b(Message message, boolean z10) {
            message.setAsynchronous(z10);
        }
    }

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        return a.a(message);
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z10) {
        a.b(message, z10);
    }
}
