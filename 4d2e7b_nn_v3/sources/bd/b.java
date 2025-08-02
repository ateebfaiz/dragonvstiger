package bd;

import java.security.Permission;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import xc.a;

class b implements a {

    /* renamed from: e  reason: collision with root package name */
    private static Permission f43e = new xc.b("SC", "threadLocalEcImplicitlyCa");

    /* renamed from: f  reason: collision with root package name */
    private static Permission f44f = new xc.b("SC", "ecImplicitlyCa");

    /* renamed from: g  reason: collision with root package name */
    private static Permission f45g = new xc.b("SC", "threadLocalDhDefaultParams");

    /* renamed from: h  reason: collision with root package name */
    private static Permission f46h = new xc.b("SC", "DhDefaultParams");

    /* renamed from: i  reason: collision with root package name */
    private static Permission f47i = new xc.b("SC", "acceptableEcCurves");

    /* renamed from: j  reason: collision with root package name */
    private static Permission f48j = new xc.b("SC", "additionalEcParameters");

    /* renamed from: a  reason: collision with root package name */
    private ThreadLocal f49a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    private ThreadLocal f50b = new ThreadLocal();

    /* renamed from: c  reason: collision with root package name */
    private volatile Set f51c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private volatile Map f52d = new HashMap();

    b() {
    }
}
