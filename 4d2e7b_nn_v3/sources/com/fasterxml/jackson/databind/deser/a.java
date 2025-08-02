package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.w;
import java.io.Serializable;
import java.util.Map;
import l8.j;

public abstract class a extends f implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    private static final Class f5225c = Object.class;

    /* renamed from: d  reason: collision with root package name */
    private static final Class f5226d = String.class;

    /* renamed from: e  reason: collision with root package name */
    private static final Class f5227e = CharSequence.class;

    /* renamed from: f  reason: collision with root package name */
    private static final Class f5228f = Iterable.class;

    /* renamed from: g  reason: collision with root package name */
    private static final Class f5229g = Map.Entry.class;

    /* renamed from: h  reason: collision with root package name */
    private static final Class f5230h = Serializable.class;

    /* renamed from: i  reason: collision with root package name */
    protected static final w f5231i = new w("@JsonUnwrapped");

    /* renamed from: b  reason: collision with root package name */
    protected final j f5232b;

    protected a(j jVar) {
        this.f5232b = jVar;
    }
}
