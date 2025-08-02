package com.adjust.sdk;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ActivityPackage implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = -35935556512024097L;
    private ActivityKind activityKind;
    private Map<String, String> callbackParameters;
    private long clickTimeInMilliseconds;
    private long clickTimeInSeconds;
    private long clickTimeServerInSeconds;
    private String clientSdk;
    private Boolean googlePlayInstant;
    private transient int hashCode;
    private long installBeginTimeInSeconds;
    private long installBeginTimeServerInSeconds;
    private String installVersion;
    private Map<String, String> parameters;
    private Map<String, String> partnerParameters;
    private String path;
    private int retries;
    private String suffix;

    static {
        Class<String> cls = String.class;
        Class<Map> cls2 = Map.class;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("path", cls), new ObjectStreamField("clientSdk", cls), new ObjectStreamField("parameters", cls2), new ObjectStreamField("activityKind", ActivityKind.class), new ObjectStreamField("suffix", cls), new ObjectStreamField("callbackParameters", cls2), new ObjectStreamField("partnerParameters", cls2)};
    }

    public ActivityPackage(ActivityKind activityKind2) {
        ActivityKind activityKind3 = ActivityKind.UNKNOWN;
        this.activityKind = activityKind2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.path = Util.readStringField(readFields, "path", (String) null);
        this.clientSdk = Util.readStringField(readFields, "clientSdk", (String) null);
        this.parameters = (Map) Util.readObjectField(readFields, "parameters", null);
        this.activityKind = (ActivityKind) Util.readObjectField(readFields, "activityKind", ActivityKind.UNKNOWN);
        this.suffix = Util.readStringField(readFields, "suffix", (String) null);
        this.callbackParameters = (Map) Util.readObjectField(readFields, "callbackParameters", null);
        this.partnerParameters = (Map) Util.readObjectField(readFields, "partnerParameters", null);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityPackage activityPackage = (ActivityPackage) obj;
        return Util.equalString(this.path, activityPackage.path) && Util.equalString(this.clientSdk, activityPackage.clientSdk) && Util.equalObject(this.parameters, activityPackage.parameters) && Util.equalEnum(this.activityKind, activityPackage.activityKind) && Util.equalString(this.suffix, activityPackage.suffix) && Util.equalObject(this.callbackParameters, activityPackage.callbackParameters) && Util.equalObject(this.partnerParameters, activityPackage.partnerParameters);
    }

    public ActivityKind getActivityKind() {
        return this.activityKind;
    }

    public Map<String, String> getCallbackParameters() {
        return this.callbackParameters;
    }

    public long getClickTimeInMilliseconds() {
        return this.clickTimeInMilliseconds;
    }

    public long getClickTimeInSeconds() {
        return this.clickTimeInSeconds;
    }

    public long getClickTimeServerInSeconds() {
        return this.clickTimeServerInSeconds;
    }

    public String getClientSdk() {
        return this.clientSdk;
    }

    public String getExtendedString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Util.formatString("Path:      %s\n", this.path));
        sb2.append(Util.formatString("ClientSdk: %s\n", this.clientSdk));
        if (this.parameters != null) {
            sb2.append("Parameters:");
            TreeMap treeMap = new TreeMap(this.parameters);
            List asList = Arrays.asList(new String[]{"app_secret", "secret_id", "event_callback_id"});
            for (Map.Entry entry : treeMap.entrySet()) {
                String str = (String) entry.getKey();
                if (!asList.contains(str)) {
                    sb2.append(Util.formatString("\n\t%-16s %s", str, entry.getValue()));
                }
            }
        }
        return sb2.toString();
    }

    public String getFailureMessage() {
        return Util.formatString("Failed to track %s%s", this.activityKind.toString(), this.suffix);
    }

    public Boolean getGooglePlayInstant() {
        return this.googlePlayInstant;
    }

    public long getInstallBeginTimeInSeconds() {
        return this.installBeginTimeInSeconds;
    }

    public long getInstallBeginTimeServerInSeconds() {
        return this.installBeginTimeServerInSeconds;
    }

    public String getInstallVersion() {
        return this.installVersion;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public Map<String, String> getPartnerParameters() {
        return this.partnerParameters;
    }

    public String getPath() {
        return this.path;
    }

    public int getRetries() {
        return this.retries;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashString = Util.hashString(this.path) + 629;
            this.hashCode = hashString;
            int hashString2 = Util.hashString(this.clientSdk) + (hashString * 37);
            this.hashCode = hashString2;
            int hashObject = Util.hashObject(this.parameters) + (hashString2 * 37);
            this.hashCode = hashObject;
            int hashEnum = Util.hashEnum(this.activityKind) + (hashObject * 37);
            this.hashCode = hashEnum;
            int hashString3 = Util.hashString(this.suffix) + (hashEnum * 37);
            this.hashCode = hashString3;
            int hashObject2 = Util.hashObject(this.callbackParameters) + (hashString3 * 37);
            this.hashCode = hashObject2;
            this.hashCode = Util.hashObject(this.partnerParameters) + (hashObject2 * 37);
        }
        return this.hashCode;
    }

    public int increaseRetries() {
        int i10 = this.retries + 1;
        this.retries = i10;
        return i10;
    }

    public void setCallbackParameters(Map<String, String> map) {
        this.callbackParameters = map;
    }

    public void setClickTimeInMilliseconds(long j10) {
        this.clickTimeInMilliseconds = j10;
    }

    public void setClickTimeInSeconds(long j10) {
        this.clickTimeInSeconds = j10;
    }

    public void setClickTimeServerInSeconds(long j10) {
        this.clickTimeServerInSeconds = j10;
    }

    public void setClientSdk(String str) {
        this.clientSdk = str;
    }

    public void setGooglePlayInstant(Boolean bool) {
        this.googlePlayInstant = bool;
    }

    public void setInstallBeginTimeInSeconds(long j10) {
        this.installBeginTimeInSeconds = j10;
    }

    public void setInstallBeginTimeServerInSeconds(long j10) {
        this.installBeginTimeServerInSeconds = j10;
    }

    public void setInstallVersion(String str) {
        this.installVersion = str;
    }

    public void setParameters(Map<String, String> map) {
        this.parameters = map;
    }

    public void setPartnerParameters(Map<String, String> map) {
        this.partnerParameters = map;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSuffix(String str) {
        this.suffix = str;
    }

    public String toString() {
        return Util.formatString("%s%s", this.activityKind.toString(), this.suffix);
    }
}
