package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames {
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        sKeyMakers = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor((Class[]) null));
            sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor((Class[]) null));
            sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor((Class[]) null));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor((Class[]) null));
            sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor((Class[]) null));
        } catch (NoSuchMethodException e10) {
            Log.e(TAG, "unable to load", e10);
        }
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        HashMap<String, ConstraintAttribute> hashMap;
        Exception e10;
        Key key;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key2 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (sKeyMakers.containsKey(name)) {
                        try {
                            key = (Key) sKeyMakers.get(name).newInstance((Object[]) null);
                            try {
                                key.load(context, Xml.asAttributeSet(xmlPullParser));
                                addKey(key);
                            } catch (Exception e11) {
                                e10 = e11;
                                Log.e(TAG, "unable to create ", e10);
                                key2 = key;
                                eventType = xmlPullParser.next();
                            }
                        } catch (Exception e12) {
                            Key key3 = key2;
                            e10 = e12;
                            key = key3;
                            Log.e(TAG, "unable to create ", e10);
                            key2 = key;
                            eventType = xmlPullParser.next();
                        }
                        key2 = key;
                    } else if (!(!name.equalsIgnoreCase("CustomAttribute") || key2 == null || (hashMap = key2.mCustomConstraints) == null)) {
                        ConstraintAttribute.parse(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3) {
                    if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e13) {
            e13.printStackTrace();
        } catch (IOException e14) {
            e14.printStackTrace();
        }
    }

    private void addKey(Key key) {
        if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
            this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList());
        }
        this.mFramesMap.get(Integer.valueOf(key.mTargetId)).add(key);
    }

    static String name(int i10, Context context) {
        return context.getResources().getResourceEntryName(i10);
    }

    public void addFrames(MotionController motionController) {
        ArrayList arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
        ArrayList arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Key key = (Key) it.next();
                if (key.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                    motionController.addKey(key);
                }
            }
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i10) {
        return this.mFramesMap.get(Integer.valueOf(i10));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }
}
