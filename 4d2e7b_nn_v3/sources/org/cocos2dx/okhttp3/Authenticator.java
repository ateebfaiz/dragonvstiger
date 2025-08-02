package org.cocos2dx.okhttp3;

import java.io.IOException;

public interface Authenticator {
    public static final Authenticator NONE = new a();

    class a implements Authenticator {
        a() {
        }

        public Request authenticate(Route route, Response response) {
            return null;
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
