package e5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class a implements e {

    /* renamed from: c  reason: collision with root package name */
    private static final Set f21260c = new HashSet(Arrays.asList(new String[]{"encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config", "is_rounded", "non_fatal_decode_error", "modified_url", "image_color_space"}));

    /* renamed from: a  reason: collision with root package name */
    private Map f21261a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private l f21262b;

    public boolean D() {
        return false;
    }

    public Map getExtras() {
        return this.f21261a;
    }

    public void m(Map map) {
        if (map != null) {
            for (String str : f21260c) {
                Object obj = map.get(str);
                if (obj != null) {
                    this.f21261a.put(str, obj);
                }
            }
        }
    }

    public o s() {
        return n.f21287d;
    }

    public l u() {
        if (this.f21262b == null) {
            this.f21262b = new m(getWidth(), getHeight(), g(), s(), getExtras());
        }
        return this.f21262b;
    }

    public void w(String str, Object obj) {
        if (f21260c.contains(str)) {
            this.f21261a.put(str, obj);
        }
    }
}
