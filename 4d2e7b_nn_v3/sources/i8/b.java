package i8;

import com.fasterxml.jackson.core.k;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Object f12330a;

    /* renamed from: b  reason: collision with root package name */
    public Class f12331b;

    /* renamed from: c  reason: collision with root package name */
    public Object f12332c;

    /* renamed from: d  reason: collision with root package name */
    public String f12333d;

    /* renamed from: e  reason: collision with root package name */
    public a f12334e;

    /* renamed from: f  reason: collision with root package name */
    public k f12335f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12336g;

    public enum a {
        WRAPPER_ARRAY,
        WRAPPER_OBJECT,
        METADATA_PROPERTY,
        PAYLOAD_PROPERTY,
        PARENT_PROPERTY;

        public boolean a() {
            if (this == METADATA_PROPERTY || this == PAYLOAD_PROPERTY) {
                return true;
            }
            return false;
        }
    }

    public b(Object obj, k kVar) {
        this(obj, kVar, (Object) null);
    }

    public b(Object obj, k kVar, Object obj2) {
        this.f12330a = obj;
        this.f12332c = obj2;
        this.f12335f = kVar;
    }
}
