package com.adjust.sdk;

import java.util.HashMap;
import java.util.Map;

public class SessionParameters {
    public Map<String, String> callbackParameters;
    public Map<String, String> partnerParameters;

    public SessionParameters deepCopy() {
        SessionParameters sessionParameters = new SessionParameters();
        if (this.callbackParameters != null) {
            sessionParameters.callbackParameters = new HashMap(this.callbackParameters);
        }
        if (this.partnerParameters != null) {
            sessionParameters.partnerParameters = new HashMap(this.partnerParameters);
        }
        return sessionParameters;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SessionParameters sessionParameters = (SessionParameters) obj;
        return Util.equalObject(this.callbackParameters, sessionParameters.callbackParameters) && Util.equalObject(this.partnerParameters, sessionParameters.partnerParameters);
    }

    public int hashCode() {
        return Util.hashObject(this.partnerParameters) + ((Util.hashObject(this.callbackParameters) + 629) * 37);
    }
}
