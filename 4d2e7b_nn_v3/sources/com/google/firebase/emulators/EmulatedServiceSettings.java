package com.google.firebase.emulators;

import androidx.annotation.NonNull;

public final class EmulatedServiceSettings {
    private final String host;
    private final int port;

    public EmulatedServiceSettings(@NonNull String str, int i10) {
        this.host = str;
        this.port = i10;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }
}
