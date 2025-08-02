package com.microsoft.codepush.react;

import android.util.Base64;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import ia.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import t9.a;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10245a = System.getProperty("line.separator");

    private static void a(String str, String str2, ArrayList arrayList) {
        String str3;
        for (File file : new File(str).listFiles()) {
            String name = file.getName();
            String absolutePath = file.getAbsolutePath();
            StringBuilder sb2 = new StringBuilder();
            if (str2.isEmpty()) {
                str3 = "";
            } else {
                str3 = str2 + DomExceptionUtils.SEPARATOR;
            }
            sb2.append(str3);
            sb2.append(name);
            String sb3 = sb2.toString();
            if (!h(sb3)) {
                if (file.isDirectory()) {
                    a(absolutePath, sb3, arrayList);
                } else {
                    try {
                        arrayList.add(sb3 + ":" + b(new FileInputStream(file)));
                    } catch (FileNotFoundException e10) {
                        throw new g("Unable to compute hash of update contents.", e10);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052 A[SYNTHETIC, Splitter:B:27:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005a A[Catch:{ IOException -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.io.InputStream r6) {
        /*
            r0 = 1
            r1 = 0
            java.lang.String r2 = "SHA-256"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0047, IOException -> 0x0045 }
            java.security.DigestInputStream r3 = new java.security.DigestInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0047, IOException -> 0x0045 }
            r3.<init>(r6, r2)     // Catch:{ NoSuchAlgorithmException -> 0x0047, IOException -> 0x0045 }
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch:{ NoSuchAlgorithmException -> 0x0041, IOException -> 0x003e, all -> 0x003b }
        L_0x0011:
            int r4 = r3.read(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0041, IOException -> 0x003e, all -> 0x003b }
            r5 = -1
            if (r4 == r5) goto L_0x0019
            goto L_0x0011
        L_0x0019:
            r3.close()     // Catch:{ IOException -> 0x0022 }
            if (r6 == 0) goto L_0x0026
            r6.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0026:
            byte[] r6 = r2.digest()
            java.math.BigInteger r1 = new java.math.BigInteger
            r1.<init>(r0, r6)
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r0 = 0
            r6[r0] = r1
            java.lang.String r0 = "%064x"
            java.lang.String r6 = java.lang.String.format(r0, r6)
            return r6
        L_0x003b:
            r0 = move-exception
            r1 = r3
            goto L_0x0050
        L_0x003e:
            r0 = move-exception
        L_0x003f:
            r1 = r3
            goto L_0x0048
        L_0x0041:
            r0 = move-exception
            goto L_0x003f
        L_0x0043:
            r0 = move-exception
            goto L_0x0050
        L_0x0045:
            r0 = move-exception
            goto L_0x0048
        L_0x0047:
            r0 = move-exception
        L_0x0048:
            com.microsoft.codepush.react.g r2 = new com.microsoft.codepush.react.g     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "Unable to compute hash of update contents."
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0043 }
            throw r2     // Catch:{ all -> 0x0043 }
        L_0x0050:
            if (r1 == 0) goto L_0x0058
            r1.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0058
        L_0x0056:
            r6 = move-exception
            goto L_0x005e
        L_0x0058:
            if (r6 == 0) goto L_0x0061
            r6.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0061
        L_0x005e:
            r6.printStackTrace()
        L_0x0061:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.codepush.react.j.b(java.io.InputStream):java.lang.String");
    }

    public static void c(String str, String str2, String str3) {
        n.a(str2, str3);
        try {
            JSONArray jSONArray = k.f(str).getJSONArray("deletedFiles");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                File file = new File(str3, jSONArray.getString(i10));
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (JSONException e10) {
            throw new g("Unable to copy files from current package during diff update", e10);
        }
    }

    public static String d(String str, String str2) {
        for (File file : new File(str).listFiles()) {
            String a10 = k.a(str, file.getName());
            if (file.isDirectory()) {
                String d10 = d(a10, str2);
                if (d10 != null) {
                    return k.a(file.getName(), d10);
                }
            } else {
                String name = file.getName();
                if (name.equals(str2)) {
                    return name;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        return com.microsoft.codepush.react.k.g(r2.getAssets().open("CodePushHash.json"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r3 == false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        com.microsoft.codepush.react.k.h("Unable to get the hash of the binary's bundled resources - \"codepush.gradle\" may have not been added to the build definition.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(android.content.Context r2, boolean r3) {
        /*
            android.content.res.AssetManager r0 = r2.getAssets()     // Catch:{ IOException -> 0x000f }
            java.lang.String r1 = "CodePushHash"
            java.io.InputStream r0 = r0.open(r1)     // Catch:{ IOException -> 0x000f }
            java.lang.String r2 = com.microsoft.codepush.react.k.g(r0)     // Catch:{ IOException -> 0x000f }
            return r2
        L_0x000f:
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ IOException -> 0x001e }
            java.lang.String r0 = "CodePushHash.json"
            java.io.InputStream r2 = r2.open(r0)     // Catch:{ IOException -> 0x001e }
            java.lang.String r2 = com.microsoft.codepush.react.k.g(r2)     // Catch:{ IOException -> 0x001e }
            return r2
        L_0x001e:
            if (r3 != 0) goto L_0x0025
            java.lang.String r2 = "Unable to get the hash of the binary's bundled resources - \"codepush.gradle\" may have not been added to the build definition."
            com.microsoft.codepush.react.k.h(r2)
        L_0x0025:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.codepush.react.j.e(android.content.Context, boolean):java.lang.String");
    }

    public static String f(String str) {
        try {
            return n.g(g(str));
        } catch (IOException e10) {
            k.h(e10.getMessage());
            k.h(e10.getStackTrace().toString());
            return null;
        }
    }

    public static String g(String str) {
        return k.a(k.a(str, "CodePush"), ".codepushrelease");
    }

    public static boolean h(String str) {
        if (str.startsWith("__MACOSX/") || str.equals(".DS_Store") || str.endsWith("/.DS_Store") || str.equals(".codepushrelease") || str.endsWith("/.codepushrelease")) {
            return true;
        }
        return false;
    }

    public static PublicKey i(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replace(f10245a, "").getBytes(), 0)));
        } catch (Exception e10) {
            k.h(e10.getMessage());
            k.h(e10.getStackTrace().toString());
            return null;
        }
    }

    public static Map j(String str, PublicKey publicKey) {
        try {
            b p10 = b.p(str);
            if (!p10.n(new a((RSAPublicKey) publicKey))) {
                return null;
            }
            Map c10 = p10.o().c();
            k.h("JWT verification succeeded, payload content: " + c10.toString());
            return c10;
        } catch (Exception e10) {
            k.h(e10.getMessage());
            k.h(e10.getStackTrace().toString());
            return null;
        }
    }

    public static void k(String str, String str2) {
        k.h("Verifying hash for folder path: " + str);
        ArrayList arrayList = new ArrayList();
        a(str, "", arrayList);
        Collections.sort(arrayList);
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        String replace = jSONArray.toString().replace("\\/", DomExceptionUtils.SEPARATOR);
        k.h("Manifest string: " + replace);
        String b10 = b(new ByteArrayInputStream(replace.getBytes()));
        k.h("Expected hash: " + str2 + ", actual hash: " + b10);
        if (str2.equals(b10)) {
            k.h("The update contents succeeded the data integrity check.");
            return;
        }
        throw new c("The update contents failed the data integrity check.");
    }

    public static void l(String str, String str2, String str3) {
        k.h("Verifying signature for folder path: " + str);
        PublicKey i10 = i(str3);
        if (i10 != null) {
            String f10 = f(str);
            if (f10 != null) {
                Map j10 = j(f10, i10);
                if (j10 != null) {
                    String str4 = (String) j10.get("contentHash");
                    if (str4 == null) {
                        throw new c("The update could not be verified because the signature did not specify a content hash.");
                    } else if (str4.equals(str2)) {
                        k.h("The update contents succeeded the code signing check.");
                    } else {
                        throw new c("The update contents failed the code signing check.");
                    }
                } else {
                    throw new c("The update could not be verified because it was not signed by a trusted party.");
                }
            } else {
                throw new c("The update could not be verified because no signature was found.");
            }
        } else {
            throw new c("The update could not be verified because no public key was found.");
        }
    }
}
