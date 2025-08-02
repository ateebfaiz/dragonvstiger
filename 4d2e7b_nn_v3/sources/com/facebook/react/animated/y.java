package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;

class y extends b {

    /* renamed from: e  reason: collision with root package name */
    private final p f2881e;

    /* renamed from: f  reason: collision with root package name */
    private final List f2882f;

    private class a extends c {

        /* renamed from: c  reason: collision with root package name */
        public int f2883c;

        private a() {
            super();
        }
    }

    private class b extends c {

        /* renamed from: c  reason: collision with root package name */
        public double f2885c;

        private b() {
            super();
        }
    }

    private class c {

        /* renamed from: a  reason: collision with root package name */
        public String f2887a;

        private c() {
        }
    }

    y(ReadableMap readableMap, p pVar) {
        ReadableArray array = readableMap.getArray("transforms");
        this.f2882f = new ArrayList(array.size());
        for (int i10 = 0; i10 < array.size(); i10++) {
            ReadableMap map = array.getMap(i10);
            String string = map.getString("property");
            if (map.getString("type").equals("animated")) {
                a aVar = new a();
                aVar.f2887a = string;
                aVar.f2883c = map.getInt("nodeTag");
                this.f2882f.add(aVar);
            } else {
                b bVar = new b();
                bVar.f2887a = string;
                bVar.f2885c = map.getDouble("value");
                this.f2882f.add(bVar);
            }
        }
        this.f2881e = pVar;
    }

    public String e() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TransformAnimatedNode[");
        sb2.append(this.f2778d);
        sb2.append("]: mTransformConfigs: ");
        List list = this.f2882f;
        if (list != null) {
            str = list.toString();
        } else {
            str = "null";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public void i(JavaOnlyMap javaOnlyMap) {
        double d10;
        ArrayList arrayList = new ArrayList(this.f2882f.size());
        for (c cVar : this.f2882f) {
            if (cVar instanceof a) {
                b k10 = this.f2881e.k(((a) cVar).f2883c);
                if (k10 == null) {
                    throw new IllegalArgumentException("Mapped style node does not exist");
                } else if (k10 instanceof b0) {
                    d10 = ((b0) k10).l();
                } else {
                    throw new IllegalArgumentException("Unsupported type of node used as a transform child node " + k10.getClass());
                }
            } else {
                d10 = ((b) cVar).f2885c;
            }
            arrayList.add(JavaOnlyMap.of(cVar.f2887a, Double.valueOf(d10)));
        }
        javaOnlyMap.putArray("transform", JavaOnlyArray.from(arrayList));
    }
}
