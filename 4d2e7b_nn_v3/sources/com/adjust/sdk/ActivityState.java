package com.adjust.sdk;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;

public class ActivityState implements Serializable, Cloneable {
    private static final int ORDER_ID_MAXCOUNT = 10;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 9039439291143138148L;
    public String adid = null;
    public boolean askingAttribution = false;
    public long clickTime = 0;
    public long clickTimeHuawei = 0;
    public long clickTimeSamsung = 0;
    public long clickTimeServer = 0;
    public long clickTimeServerXiaomi = 0;
    public long clickTimeXiaomi = 0;
    public boolean enabled = true;
    public int eventCount = 0;
    public Boolean googlePlayInstant = null;
    public long installBegin = 0;
    public long installBeginHuawei = 0;
    public long installBeginSamsung = 0;
    public long installBeginServer = 0;
    public long installBeginServerXiaomi = 0;
    public long installBeginXiaomi = 0;
    public String installReferrer = null;
    public String installReferrerHuawei = null;
    public String installReferrerHuaweiAppGallery = null;
    public String installReferrerSamsung = null;
    public String installReferrerXiaomi = null;
    public String installVersion = null;
    public String installVersionXiaomi = null;
    public boolean isGdprForgotten = false;
    public boolean isThirdPartySharingDisabled = false;
    public boolean isThirdPartySharingDisabledForCoppa = false;
    public long lastActivity = -1;
    public long lastInterval = -1;
    private transient ILogger logger = AdjustFactory.getLogger();
    public LinkedList<String> orderIds = null;
    public String pushToken = null;
    public int sessionCount = 0;
    public long sessionLength = -1;
    public int subsessionCount = -1;
    public long timeSpent = -1;
    public boolean updatePackages = false;
    public String uuid = Util.createUuid();

    static {
        Class<String> cls = String.class;
        ObjectStreamField objectStreamField = new ObjectStreamField("uuid", cls);
        Class cls2 = Boolean.TYPE;
        ObjectStreamField objectStreamField2 = new ObjectStreamField("enabled", cls2);
        ObjectStreamField objectStreamField3 = new ObjectStreamField("isGdprForgotten", cls2);
        ObjectStreamField objectStreamField4 = new ObjectStreamField("isThirdPartySharingDisabled", cls2);
        ObjectStreamField objectStreamField5 = new ObjectStreamField("askingAttribution", cls2);
        Class cls3 = Integer.TYPE;
        ObjectStreamField objectStreamField6 = new ObjectStreamField("eventCount", cls3);
        ObjectStreamField objectStreamField7 = new ObjectStreamField("sessionCount", cls3);
        ObjectStreamField objectStreamField8 = new ObjectStreamField("subsessionCount", cls3);
        Class cls4 = Long.TYPE;
        ObjectStreamField objectStreamField9 = new ObjectStreamField("sessionLength", cls4);
        ObjectStreamField objectStreamField10 = new ObjectStreamField("timeSpent", cls4);
        ObjectStreamField objectStreamField11 = new ObjectStreamField("lastActivity", cls4);
        ObjectStreamField objectStreamField12 = new ObjectStreamField("lastInterval", cls4);
        ObjectStreamField objectStreamField13 = new ObjectStreamField("updatePackages", cls2);
        ObjectStreamField objectStreamField14 = new ObjectStreamField("orderIds", LinkedList.class);
        ObjectStreamField objectStreamField15 = objectStreamField14;
        serialPersistentFields = new ObjectStreamField[]{objectStreamField, objectStreamField2, objectStreamField3, objectStreamField4, objectStreamField5, objectStreamField6, objectStreamField7, objectStreamField8, objectStreamField9, objectStreamField10, objectStreamField11, objectStreamField12, objectStreamField13, objectStreamField15, new ObjectStreamField("pushToken", cls), new ObjectStreamField("adid", cls), new ObjectStreamField("clickTime", cls4), new ObjectStreamField("installBegin", cls4), new ObjectStreamField("installReferrer", cls), new ObjectStreamField("googlePlayInstant", Boolean.class), new ObjectStreamField("clickTimeServer", cls4), new ObjectStreamField("installBeginServer", cls4), new ObjectStreamField("installVersion", cls), new ObjectStreamField("clickTimeHuawei", cls4), new ObjectStreamField("installBeginHuawei", cls4), new ObjectStreamField("installReferrerHuawei", cls), new ObjectStreamField("installReferrerHuaweiAppGallery", cls), new ObjectStreamField("isThirdPartySharingDisabledForCoppa", cls2), new ObjectStreamField("clickTimeXiaomi", cls4), new ObjectStreamField("installBeginXiaomi", cls4), new ObjectStreamField("installReferrerXiaomi", cls), new ObjectStreamField("clickTimeServerXiaomi", cls4), new ObjectStreamField("installBeginServerXiaomi", cls4), new ObjectStreamField("installVersionXiaomi", cls), new ObjectStreamField("clickTimeSamsung", cls4), new ObjectStreamField("installBeginSamsung", cls4), new ObjectStreamField("installReferrerSamsung", cls)};
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.eventCount = Util.readIntField(readFields, "eventCount", 0);
        this.sessionCount = Util.readIntField(readFields, "sessionCount", 0);
        this.subsessionCount = Util.readIntField(readFields, "subsessionCount", -1);
        this.sessionLength = Util.readLongField(readFields, "sessionLength", -1);
        this.timeSpent = Util.readLongField(readFields, "timeSpent", -1);
        this.lastActivity = Util.readLongField(readFields, "lastActivity", -1);
        this.lastInterval = Util.readLongField(readFields, "lastInterval", -1);
        this.uuid = Util.readStringField(readFields, "uuid", (String) null);
        this.enabled = Util.readBooleanField(readFields, "enabled", true);
        this.isGdprForgotten = Util.readBooleanField(readFields, "isGdprForgotten", false);
        this.isThirdPartySharingDisabled = Util.readBooleanField(readFields, "isThirdPartySharingDisabled", false);
        this.isThirdPartySharingDisabledForCoppa = Util.readBooleanField(readFields, "isThirdPartySharingDisabledForCoppa", false);
        this.askingAttribution = Util.readBooleanField(readFields, "askingAttribution", false);
        this.updatePackages = Util.readBooleanField(readFields, "updatePackages", false);
        this.orderIds = (LinkedList) Util.readObjectField(readFields, "orderIds", null);
        this.pushToken = Util.readStringField(readFields, "pushToken", (String) null);
        this.adid = Util.readStringField(readFields, "adid", (String) null);
        this.clickTime = Util.readLongField(readFields, "clickTime", -1);
        this.installBegin = Util.readLongField(readFields, "installBegin", -1);
        this.installReferrer = Util.readStringField(readFields, "installReferrer", (String) null);
        this.googlePlayInstant = (Boolean) Util.readObjectField(readFields, "googlePlayInstant", null);
        this.clickTimeServer = Util.readLongField(readFields, "clickTimeServer", -1);
        this.installBeginServer = Util.readLongField(readFields, "installBeginServer", -1);
        this.installVersion = Util.readStringField(readFields, "installVersion", (String) null);
        this.clickTimeHuawei = Util.readLongField(readFields, "clickTimeHuawei", -1);
        this.installBeginHuawei = Util.readLongField(readFields, "installBeginHuawei", -1);
        this.installReferrerHuawei = Util.readStringField(readFields, "installReferrerHuawei", (String) null);
        this.installReferrerHuaweiAppGallery = Util.readStringField(readFields, "installReferrerHuaweiAppGallery", (String) null);
        this.clickTimeXiaomi = Util.readLongField(readFields, "clickTimeXiaomi", -1);
        this.installBeginXiaomi = Util.readLongField(readFields, "installBeginXiaomi", -1);
        this.installReferrerXiaomi = Util.readStringField(readFields, "installReferrerXiaomi", (String) null);
        this.clickTimeServerXiaomi = Util.readLongField(readFields, "clickTimeServerXiaomi", -1);
        this.installBeginServerXiaomi = Util.readLongField(readFields, "installBeginServerXiaomi", -1);
        this.installVersionXiaomi = Util.readStringField(readFields, "installVersionXiaomi", (String) null);
        this.clickTimeSamsung = Util.readLongField(readFields, "clickTimeSamsung", -1);
        this.installBeginSamsung = Util.readLongField(readFields, "installBeginSamsung", -1);
        this.installReferrerSamsung = Util.readStringField(readFields, "installReferrerSamsung", (String) null);
        if (this.uuid == null) {
            this.uuid = Util.createUuid();
        }
    }

    private static String stamp(long j10) {
        Calendar.getInstance().setTimeInMillis(j10);
        return Util.formatString("%02d:%02d:%02d", 11, 12, 13);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    public void addOrderId(String str) {
        if (this.orderIds == null) {
            this.orderIds = new LinkedList<>();
        }
        if (this.orderIds.size() >= 10) {
            this.orderIds.removeLast();
        }
        this.orderIds.addFirst(str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityState activityState = (ActivityState) obj;
        return Util.equalString(this.uuid, activityState.uuid) && Util.equalBoolean(Boolean.valueOf(this.enabled), Boolean.valueOf(activityState.enabled)) && Util.equalBoolean(Boolean.valueOf(this.isGdprForgotten), Boolean.valueOf(activityState.isGdprForgotten)) && Util.equalBoolean(Boolean.valueOf(this.isThirdPartySharingDisabled), Boolean.valueOf(activityState.isThirdPartySharingDisabled)) && Util.equalBoolean(Boolean.valueOf(this.isThirdPartySharingDisabledForCoppa), Boolean.valueOf(activityState.isThirdPartySharingDisabledForCoppa)) && Util.equalBoolean(Boolean.valueOf(this.askingAttribution), Boolean.valueOf(activityState.askingAttribution)) && Util.equalInt(Integer.valueOf(this.eventCount), Integer.valueOf(activityState.eventCount)) && Util.equalInt(Integer.valueOf(this.sessionCount), Integer.valueOf(activityState.sessionCount)) && Util.equalInt(Integer.valueOf(this.subsessionCount), Integer.valueOf(activityState.subsessionCount)) && Util.equalLong(Long.valueOf(this.sessionLength), Long.valueOf(activityState.sessionLength)) && Util.equalLong(Long.valueOf(this.timeSpent), Long.valueOf(activityState.timeSpent)) && Util.equalLong(Long.valueOf(this.lastInterval), Long.valueOf(activityState.lastInterval)) && Util.equalBoolean(Boolean.valueOf(this.updatePackages), Boolean.valueOf(activityState.updatePackages)) && Util.equalObject(this.orderIds, activityState.orderIds) && Util.equalString(this.pushToken, activityState.pushToken) && Util.equalString(this.adid, activityState.adid) && Util.equalLong(Long.valueOf(this.clickTime), Long.valueOf(activityState.clickTime)) && Util.equalLong(Long.valueOf(this.installBegin), Long.valueOf(activityState.installBegin)) && Util.equalString(this.installReferrer, activityState.installReferrer) && Util.equalBoolean(this.googlePlayInstant, activityState.googlePlayInstant) && Util.equalLong(Long.valueOf(this.clickTimeServer), Long.valueOf(activityState.clickTimeServer)) && Util.equalLong(Long.valueOf(this.installBeginServer), Long.valueOf(activityState.installBeginServer)) && Util.equalString(this.installVersion, activityState.installVersion) && Util.equalLong(Long.valueOf(this.clickTimeHuawei), Long.valueOf(activityState.clickTimeHuawei)) && Util.equalLong(Long.valueOf(this.installBeginHuawei), Long.valueOf(activityState.installBeginHuawei)) && Util.equalString(this.installReferrerHuawei, activityState.installReferrerHuawei) && Util.equalString(this.installReferrerHuaweiAppGallery, activityState.installReferrerHuaweiAppGallery) && Util.equalLong(Long.valueOf(this.clickTimeXiaomi), Long.valueOf(activityState.clickTimeXiaomi)) && Util.equalLong(Long.valueOf(this.installBeginXiaomi), Long.valueOf(activityState.installBeginXiaomi)) && Util.equalString(this.installReferrerXiaomi, activityState.installReferrerXiaomi) && Util.equalLong(Long.valueOf(this.clickTimeServerXiaomi), Long.valueOf(activityState.clickTimeServerXiaomi)) && Util.equalLong(Long.valueOf(this.installBeginServerXiaomi), Long.valueOf(activityState.installBeginServerXiaomi)) && Util.equalString(this.installVersionXiaomi, activityState.installVersionXiaomi) && Util.equalLong(Long.valueOf(this.clickTimeSamsung), Long.valueOf(activityState.clickTimeSamsung)) && Util.equalLong(Long.valueOf(this.installBeginSamsung), Long.valueOf(activityState.installBeginSamsung)) && Util.equalString(this.installReferrerSamsung, activityState.installReferrerSamsung);
    }

    public boolean findOrderId(String str) {
        LinkedList<String> linkedList = this.orderIds;
        if (linkedList == null) {
            return false;
        }
        return linkedList.contains(str);
    }

    public int hashCode() {
        int hashBoolean = Util.hashBoolean(Boolean.valueOf(this.enabled));
        int hashBoolean2 = Util.hashBoolean(Boolean.valueOf(this.isGdprForgotten));
        int hashBoolean3 = Util.hashBoolean(Boolean.valueOf(this.isThirdPartySharingDisabled));
        int hashBoolean4 = Util.hashBoolean(Boolean.valueOf(this.isThirdPartySharingDisabledForCoppa));
        int hashBoolean5 = Util.hashBoolean(Boolean.valueOf(this.askingAttribution));
        int hashLong = Util.hashLong(Long.valueOf(this.sessionLength));
        int hashLong2 = Util.hashLong(Long.valueOf(this.timeSpent));
        int hashLong3 = Util.hashLong(Long.valueOf(this.lastInterval));
        int hashBoolean6 = Util.hashBoolean(Boolean.valueOf(this.updatePackages));
        int hashObject = Util.hashObject(this.orderIds);
        int hashString = Util.hashString(this.pushToken);
        int hashString2 = Util.hashString(this.adid);
        int hashLong4 = Util.hashLong(Long.valueOf(this.clickTime));
        int hashLong5 = Util.hashLong(Long.valueOf(this.installBegin));
        int hashString3 = Util.hashString(this.installReferrer);
        int hashBoolean7 = Util.hashBoolean(this.googlePlayInstant);
        int hashLong6 = Util.hashLong(Long.valueOf(this.clickTimeServer));
        int hashLong7 = Util.hashLong(Long.valueOf(this.installBeginServer));
        int hashString4 = Util.hashString(this.installVersion);
        int hashLong8 = Util.hashLong(Long.valueOf(this.clickTimeHuawei));
        int hashLong9 = Util.hashLong(Long.valueOf(this.installBeginHuawei));
        int hashString5 = Util.hashString(this.installReferrerHuawei);
        int hashString6 = Util.hashString(this.installReferrerHuaweiAppGallery);
        int hashLong10 = Util.hashLong(Long.valueOf(this.clickTimeXiaomi));
        int hashLong11 = Util.hashLong(Long.valueOf(this.installBeginXiaomi));
        int hashString7 = Util.hashString(this.installReferrerXiaomi);
        int hashLong12 = Util.hashLong(Long.valueOf(this.clickTimeServerXiaomi));
        int hashLong13 = Util.hashLong(Long.valueOf(this.installBeginServerXiaomi));
        int hashString8 = Util.hashString(this.installVersionXiaomi);
        int hashLong14 = Util.hashLong(Long.valueOf(this.clickTimeSamsung));
        int hashLong15 = Util.hashLong(Long.valueOf(this.installBeginSamsung));
        return Util.hashString(this.installReferrerSamsung) + ((hashLong15 + ((hashLong14 + ((hashString8 + ((hashLong13 + ((hashLong12 + ((hashString7 + ((hashLong11 + ((hashLong10 + ((hashString6 + ((hashString5 + ((hashLong9 + ((hashLong8 + ((hashString4 + ((hashLong7 + ((hashLong6 + ((hashBoolean7 + ((hashString3 + ((hashLong5 + ((hashLong4 + ((hashString2 + ((hashString + ((hashObject + ((hashBoolean6 + ((hashLong3 + ((hashLong2 + ((hashLong + ((((((((hashBoolean5 + ((hashBoolean4 + ((hashBoolean3 + ((hashBoolean2 + ((hashBoolean + ((Util.hashString(this.uuid) + 629) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + this.eventCount) * 37) + this.sessionCount) * 37) + this.subsessionCount) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37);
    }

    public void resetSessionAttributes(long j10) {
        this.subsessionCount = 1;
        this.sessionLength = 0;
        this.timeSpent = 0;
        this.lastActivity = j10;
        this.lastInterval = -1;
    }

    public String toString() {
        return Util.formatString("ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s uuid:%s", Integer.valueOf(this.eventCount), Integer.valueOf(this.sessionCount), Integer.valueOf(this.subsessionCount), Double.valueOf(((double) this.sessionLength) / 1000.0d), Double.valueOf(((double) this.timeSpent) / 1000.0d), stamp(this.lastActivity), this.uuid);
    }
}
