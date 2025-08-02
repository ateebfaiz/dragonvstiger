package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c1.f;
import com.bugsnag.android.k2;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class Breadcrumb implements k2.a {
    final p impl;
    private final s2 logger;

    Breadcrumb(@NonNull p pVar, @NonNull s2 s2Var) {
        this.impl = pVar;
        this.logger = s2Var;
    }

    private void logNull(String str) {
        s2 s2Var = this.logger;
        s2Var.a("Invalid null value supplied to breadcrumb." + str + ", ignoring");
    }

    @NonNull
    public String getMessage() {
        return this.impl.f18905a;
    }

    @Nullable
    public Map<String, Object> getMetadata() {
        return this.impl.f18907c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String getStringTimestamp() {
        return f.c(this.impl.f18908d);
    }

    @NonNull
    public Date getTimestamp() {
        return this.impl.f18908d;
    }

    @NonNull
    public BreadcrumbType getType() {
        return this.impl.f18906b;
    }

    public void setMessage(@NonNull String str) {
        if (str != null) {
            this.impl.f18905a = str;
        } else {
            logNull("message");
        }
    }

    public void setMetadata(@Nullable Map<String, Object> map) {
        this.impl.f18907c = map;
    }

    public void setType(@NonNull BreadcrumbType breadcrumbType) {
        if (breadcrumbType != null) {
            this.impl.f18906b = breadcrumbType;
        } else {
            logNull("type");
        }
    }

    public void toStream(@NonNull k2 k2Var) throws IOException {
        this.impl.toStream(k2Var);
    }

    Breadcrumb(@NonNull String str, @NonNull s2 s2Var) {
        this.impl = new p(str);
        this.logger = s2Var;
    }

    Breadcrumb(@NonNull String str, @NonNull BreadcrumbType breadcrumbType, @Nullable Map<String, Object> map, @NonNull Date date, @NonNull s2 s2Var) {
        this.impl = new p(str, breadcrumbType, map, date);
        this.logger = s2Var;
    }
}
