package o7;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f12874a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f12875b = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");

    private b() {
    }

    public static final String a(String str, ReadableArray readableArray) {
        m.f(str, "message");
        m.f(readableArray, "stack");
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(", stack:\n");
        int size = readableArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            ReadableMap map = readableArray.getMap(i10);
            sb2.append(map.getString("methodName"));
            sb2.append("@");
            sb2.append(f12874a.b(map));
            if (!map.hasKey("lineNumber") || map.isNull("lineNumber") || map.getType("lineNumber") != ReadableType.Number) {
                sb2.append(-1);
            } else {
                sb2.append(map.getInt("lineNumber"));
            }
            if (map.hasKey("column") && !map.isNull("column") && map.getType("column") == ReadableType.Number) {
                sb2.append(":");
                sb2.append(map.getInt("column"));
            }
            sb2.append("\n");
        }
        String sb3 = sb2.toString();
        m.e(sb3, "toString(...)");
        return sb3;
    }

    private final String b(ReadableMap readableMap) {
        String string;
        if (!readableMap.hasKey("file") || readableMap.isNull("file") || readableMap.getType("file") != ReadableType.String || (string = readableMap.getString("file")) == null) {
            return "";
        }
        Matcher matcher = f12875b.matcher(string);
        if (!matcher.find()) {
            return "";
        }
        String group = matcher.group(1);
        return group + ":";
    }
}
