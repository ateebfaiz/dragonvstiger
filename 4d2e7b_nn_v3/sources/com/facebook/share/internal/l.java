package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f4534a = new l();

    public interface a {
        JSONObject a(SharePhoto sharePhoto);
    }

    private l() {
    }

    private final JSONArray a(List list, a aVar) {
        JSONArray jSONArray = new JSONArray();
        for (Object d10 : list) {
            jSONArray.put(d(d10, aVar));
        }
        return jSONArray;
    }

    public static final JSONObject b(ShareOpenGraphAction shareOpenGraphAction, a aVar) {
        if (shareOpenGraphAction == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphAction.d()) {
            jSONObject.put(str, d(shareOpenGraphAction.a(str), aVar));
        }
        return jSONObject;
    }

    private final JSONObject c(ShareOpenGraphObject shareOpenGraphObject, a aVar) {
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphObject.d()) {
            jSONObject.put(str, d(shareOpenGraphObject.a(str), aVar));
        }
        return jSONObject;
    }

    public static final Object d(Object obj, a aVar) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj;
        }
        try {
            if (obj instanceof SharePhoto) {
                if (aVar != null) {
                    return aVar.a((SharePhoto) obj);
                }
                return null;
            } else if (obj instanceof ShareOpenGraphObject) {
                return f4534a.c((ShareOpenGraphObject) obj, aVar);
            } else {
                if (obj instanceof List) {
                    return f4534a.a((List) obj, aVar);
                }
                return null;
            }
        } catch (Exception unused) {
        }
    }
}
