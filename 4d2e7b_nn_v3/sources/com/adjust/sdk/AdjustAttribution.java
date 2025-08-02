package com.adjust.sdk;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import org.json.JSONObject;

public class AdjustAttribution implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 1;
    public String adgroup;
    public String adid;
    public String campaign;
    public String clickLabel;
    public Double costAmount;
    public String costCurrency;
    public String costType;
    public String creative;
    public String fbInstallReferrer;
    public String network;
    public String trackerName;
    public String trackerToken;

    static {
        Class<String> cls = String.class;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("trackerToken", cls), new ObjectStreamField("trackerName", cls), new ObjectStreamField("network", cls), new ObjectStreamField("campaign", cls), new ObjectStreamField("adgroup", cls), new ObjectStreamField("creative", cls), new ObjectStreamField("clickLabel", cls), new ObjectStreamField("adid", cls), new ObjectStreamField("costType", cls), new ObjectStreamField("costAmount", Double.class), new ObjectStreamField("costCurrency", cls), new ObjectStreamField("fbInstallReferrer", cls)};
    }

    public static AdjustAttribution fromJson(JSONObject jSONObject, String str, String str2) {
        String optString;
        if (jSONObject == null) {
            return null;
        }
        AdjustAttribution adjustAttribution = new AdjustAttribution();
        if ("unity".equals(str2)) {
            adjustAttribution.trackerToken = jSONObject.optString("tracker_token", "");
            adjustAttribution.trackerName = jSONObject.optString("tracker_name", "");
            adjustAttribution.network = jSONObject.optString("network", "");
            adjustAttribution.campaign = jSONObject.optString("campaign", "");
            adjustAttribution.adgroup = jSONObject.optString("adgroup", "");
            adjustAttribution.creative = jSONObject.optString("creative", "");
            adjustAttribution.clickLabel = jSONObject.optString("click_label", "");
            if (str == null) {
                str = "";
            }
            adjustAttribution.adid = str;
            adjustAttribution.costType = jSONObject.optString("cost_type", "");
            adjustAttribution.costAmount = Double.valueOf(jSONObject.optDouble("cost_amount", 0.0d));
            adjustAttribution.costCurrency = jSONObject.optString("cost_currency", "");
            optString = jSONObject.optString("fb_install_referrer", "");
        } else {
            adjustAttribution.trackerToken = jSONObject.optString("tracker_token");
            adjustAttribution.trackerName = jSONObject.optString("tracker_name");
            adjustAttribution.network = jSONObject.optString("network");
            adjustAttribution.campaign = jSONObject.optString("campaign");
            adjustAttribution.adgroup = jSONObject.optString("adgroup");
            adjustAttribution.creative = jSONObject.optString("creative");
            adjustAttribution.clickLabel = jSONObject.optString("click_label");
            adjustAttribution.adid = str;
            adjustAttribution.costType = jSONObject.optString("cost_type");
            adjustAttribution.costAmount = Double.valueOf(jSONObject.optDouble("cost_amount"));
            adjustAttribution.costCurrency = jSONObject.optString("cost_currency");
            optString = jSONObject.optString("fb_install_referrer");
        }
        adjustAttribution.fbInstallReferrer = optString;
        return adjustAttribution;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
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
        AdjustAttribution adjustAttribution = (AdjustAttribution) obj;
        return Util.equalString(this.trackerToken, adjustAttribution.trackerToken) && Util.equalString(this.trackerName, adjustAttribution.trackerName) && Util.equalString(this.network, adjustAttribution.network) && Util.equalString(this.campaign, adjustAttribution.campaign) && Util.equalString(this.adgroup, adjustAttribution.adgroup) && Util.equalString(this.creative, adjustAttribution.creative) && Util.equalString(this.clickLabel, adjustAttribution.clickLabel) && Util.equalString(this.adid, adjustAttribution.adid) && Util.equalString(this.costType, adjustAttribution.costType) && Util.equalsDouble(this.costAmount, adjustAttribution.costAmount) && Util.equalString(this.costCurrency, adjustAttribution.costCurrency) && Util.equalString(this.fbInstallReferrer, adjustAttribution.fbInstallReferrer);
    }

    public int hashCode() {
        int hashString = Util.hashString(this.trackerName);
        int hashString2 = Util.hashString(this.network);
        int hashString3 = Util.hashString(this.campaign);
        int hashString4 = Util.hashString(this.adgroup);
        int hashString5 = Util.hashString(this.creative);
        int hashString6 = Util.hashString(this.clickLabel);
        int hashString7 = Util.hashString(this.adid);
        int hashString8 = Util.hashString(this.costType);
        int hashDouble = Util.hashDouble(this.costAmount);
        int hashString9 = Util.hashString(this.costCurrency);
        return Util.hashString(this.fbInstallReferrer) + ((hashString9 + ((hashDouble + ((hashString8 + ((hashString7 + ((hashString6 + ((hashString5 + ((hashString4 + ((hashString3 + ((hashString2 + ((hashString + ((Util.hashString(this.trackerToken) + 629) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37);
    }

    public String toString() {
        return Util.formatString("tt:%s tn:%s net:%s cam:%s adg:%s cre:%s cl:%s adid:%s ct:%s ca:%.2f cc:%s fir:%s", this.trackerToken, this.trackerName, this.network, this.campaign, this.adgroup, this.creative, this.clickLabel, this.adid, this.costType, this.costAmount, this.costCurrency, this.fbInstallReferrer);
    }
}
