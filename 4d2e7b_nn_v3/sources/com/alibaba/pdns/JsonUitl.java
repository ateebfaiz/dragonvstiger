package com.alibaba.pdns;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUitl {

    /* renamed from: a  reason: collision with root package name */
    private static Gson f17856a = new Gson();

    public static <T> List<T> a(String str, Class<T> cls) {
        Gson gson = new Gson();
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = new JsonParser().parse(str).getAsJsonArray().iterator();
        while (it.hasNext()) {
            arrayList.add(gson.fromJson(it.next(), cls));
        }
        return arrayList;
    }

    public static Object b(String str, Class cls) {
        return f17856a.fromJson(str, cls);
    }

    public static <T> String objectToString(T t10) {
        return f17856a.toJson((Object) t10);
    }
}
