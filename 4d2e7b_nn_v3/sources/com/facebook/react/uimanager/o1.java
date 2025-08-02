package com.facebook.react.uimanager;

import com.facebook.react.config.ReactFeatureFlags;
import e6.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class o1 {
    static Map a(j2 j2Var) {
        Map b10 = m1.b();
        b10.put("ViewManagerNames", new ArrayList(j2Var.a()));
        b10.put("LazyViewManagersEnabled", Boolean.TRUE);
        return b10;
    }

    static Map b(List list, Map map, Map map2) {
        Map b10 = m1.b();
        Map a10 = m1.a();
        Map c10 = m1.c();
        if (map != null) {
            map.putAll(a10);
        }
        if (map2 != null) {
            map2.putAll(c10);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ViewManager viewManager = (ViewManager) it.next();
            String name = viewManager.getName();
            Map c11 = c(viewManager, (Map) null, (Map) null, map, map2);
            if (!c11.isEmpty()) {
                b10.put(name, c11);
            }
        }
        b10.put("genericBubblingEventTypes", a10);
        b10.put("genericDirectEventTypes", c10);
        return b10;
    }

    static Map c(ViewManager viewManager, Map map, Map map2, Map map3, Map map4) {
        HashMap b10 = f.b();
        Map<String, Object> exportedCustomBubblingEventTypeConstants = viewManager.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants != null) {
            if (ReactFeatureFlags.enableFabricRenderer && ReactFeatureFlags.unstable_useFabricInterop) {
                e(exportedCustomBubblingEventTypeConstants);
            }
            f(map3, exportedCustomBubblingEventTypeConstants);
            f(exportedCustomBubblingEventTypeConstants, map);
            b10.put("bubblingEventTypes", exportedCustomBubblingEventTypeConstants);
        } else if (map != null) {
            b10.put("bubblingEventTypes", map);
        }
        Map<String, Object> exportedCustomDirectEventTypeConstants = viewManager.getExportedCustomDirectEventTypeConstants();
        g(viewManager.getName(), exportedCustomDirectEventTypeConstants);
        if (exportedCustomDirectEventTypeConstants != null) {
            if (ReactFeatureFlags.enableFabricRenderer && ReactFeatureFlags.unstable_useFabricInterop) {
                e(exportedCustomDirectEventTypeConstants);
            }
            f(map4, exportedCustomDirectEventTypeConstants);
            f(exportedCustomDirectEventTypeConstants, map2);
            b10.put("directEventTypes", exportedCustomDirectEventTypeConstants);
        } else if (map2 != null) {
            b10.put("directEventTypes", map2);
        }
        Map<String, Object> exportedViewConstants = viewManager.getExportedViewConstants();
        if (exportedViewConstants != null) {
            b10.put("Constants", exportedViewConstants);
        }
        Map<String, Integer> commandsMap = viewManager.getCommandsMap();
        if (commandsMap != null) {
            b10.put("Commands", commandsMap);
        }
        Map<String, String> nativeProps = viewManager.getNativeProps();
        if (!nativeProps.isEmpty()) {
            b10.put("NativeProps", nativeProps);
        }
        return b10;
    }

    public static Map d() {
        return f.e("bubblingEventTypes", m1.a(), "directEventTypes", m1.c());
    }

    static void e(Map map) {
        String str;
        if (map != null) {
            HashSet<String> hashSet = new HashSet<>();
            for (Object next : map.keySet()) {
                if (next instanceof String) {
                    String str2 = (String) next;
                    if (!str2.startsWith("top")) {
                        hashSet.add(str2);
                    }
                }
            }
            if (!(map instanceof HashMap)) {
                map = new HashMap(map);
            }
            for (String str3 : hashSet) {
                Object obj = map.get(str3);
                if (str3.startsWith("on")) {
                    str = str3.substring(2);
                } else {
                    str = str3.substring(0, 1).toUpperCase() + str3.substring(1);
                }
                map.put("top" + str, obj);
            }
        }
    }

    private static void f(Map map, Map map2) {
        if (map != null && map2 != null && !map2.isEmpty()) {
            for (Object next : map2.keySet()) {
                Object obj = map2.get(next);
                Object obj2 = map.get(next);
                if (obj2 == null || !(obj instanceof Map) || !(obj2 instanceof Map)) {
                    map.put(next, obj);
                } else {
                    if (!(obj2 instanceof HashMap)) {
                        HashMap hashMap = new HashMap((Map) obj2);
                        Object unused = map.replace(next, hashMap);
                        obj2 = hashMap;
                    }
                    f((Map) obj2, (Map) obj);
                }
            }
        }
    }

    private static void g(String str, Map map) {
    }
}
