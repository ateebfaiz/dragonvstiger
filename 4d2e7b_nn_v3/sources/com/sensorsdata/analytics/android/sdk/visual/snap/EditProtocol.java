package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.os.Handler;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditProtocol {
    private static final Class<?>[] NO_PARAMS = new Class[0];
    private static final String TAG = "SA.EProtocol";
    private final ResourceIds mResourceIds;
    private List<PropertyDescription> propertyDescriptionList;

    public static class BadInstructionsException extends Exception {
        private static final long serialVersionUID = -4062004792184145311L;

        public BadInstructionsException(String str) {
            super(str);
        }

        public BadInstructionsException(String str, Throwable th) {
            super(str, th);
        }
    }

    public EditProtocol(ResourceIds resourceIds) {
        this.mResourceIds = resourceIds;
        try {
            JSONObject jSONObject = new JSONObject("{\"type\":\"snapshot_request\",\"payload\":{\"config\":{\"classes\":[{\"name\":\"android.view.View\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]},{\"name\":\"android.widget.TextView\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]},{\"name\":\"android.widget.ImageView\",\"properties\":[{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]}]}}}").getJSONObject("payload");
            if (jSONObject.has("config")) {
                this.propertyDescriptionList = getListPropertyDescription(jSONObject);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private List<PropertyDescription> getListPropertyDescription(JSONObject jSONObject) throws BadInstructionsException {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                Class<?> cls = Class.forName(jSONObject2.getString("name"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray(SAPropertyFilter.PROPERTIES);
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    linkedList.add(readPropertyDescription(cls, jSONArray2.getJSONObject(i11)));
                }
            }
            return linkedList;
        } catch (JSONException e10) {
            throw new BadInstructionsException("Can't read snapshot configuration", e10);
        } catch (ClassNotFoundException e11) {
            throw new BadInstructionsException("Can't resolve types for snapshot configuration", e11);
        }
    }

    private PropertyDescription readPropertyDescription(Class<?> cls, JSONObject jSONObject) throws BadInstructionsException {
        Caller caller;
        try {
            String string = jSONObject.getString("name");
            String str = null;
            if (jSONObject.has("get")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                caller = new Caller(cls, jSONObject2.getString("selector"), NO_PARAMS, Class.forName(jSONObject2.getJSONObject(DbParams.KEY_CHANNEL_RESULT).getString("type")));
            } else {
                caller = null;
            }
            if (jSONObject.has("set")) {
                str = jSONObject.getJSONObject("set").getString("selector");
            }
            return new PropertyDescription(string, cls, caller, str);
        } catch (NoSuchMethodException e10) {
            throw new BadInstructionsException("Can't create property reader", e10);
        } catch (JSONException e11) {
            throw new BadInstructionsException("Can't read property JSON", e11);
        } catch (ClassNotFoundException e12) {
            throw new BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e12);
        }
    }

    public ViewSnapshot readSnapshotConfig(Handler handler) throws BadInstructionsException {
        List<PropertyDescription> list = this.propertyDescriptionList;
        if (list == null) {
            return null;
        }
        return new ViewSnapshot(list, this.mResourceIds, handler);
    }
}
