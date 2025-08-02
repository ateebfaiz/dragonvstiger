package d7;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import androidx.work.WorkRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    private static final String f11864e = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private int f11865a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f11866b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Map f11867c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map f11868d;

    /* renamed from: d7.a$a  reason: collision with other inner class name */
    class C0133a extends g {
        C0133a() {
        }

        public void b(Object obj, h hVar) {
            synchronized (a.this.f11867c) {
                try {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("mode");
                        if (optString != null) {
                            String optString2 = jSONObject.optString("filename");
                            if (optString2 == null) {
                                throw new Exception("missing params.filename");
                            } else if (optString.equals("r")) {
                                hVar.a(Integer.valueOf(a.this.c(optString2)));
                            } else {
                                throw new IllegalArgumentException("unsupported mode: " + optString);
                            }
                        } else {
                            throw new Exception("missing params.mode");
                        }
                    } else {
                        throw new Exception("params must be an object { mode: string, filename: string }");
                    }
                } catch (Exception e10) {
                    hVar.b(e10.toString());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    class b extends g {
        b() {
        }

        public void b(Object obj, h hVar) {
            synchronized (a.this.f11867c) {
                try {
                    if (obj instanceof Number) {
                        d dVar = (d) a.this.f11867c.get(obj);
                        if (dVar != null) {
                            a.this.f11867c.remove(obj);
                            dVar.a();
                            hVar.a("");
                        } else {
                            throw new Exception("invalid file handle, it might have timed out");
                        }
                    } else {
                        throw new Exception("params must be a file handle");
                    }
                } catch (Exception e10) {
                    hVar.b(e10.toString());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    class c extends g {
        c() {
        }

        public void b(Object obj, h hVar) {
            synchronized (a.this.f11867c) {
                try {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("file");
                        if (optInt != 0) {
                            int optInt2 = jSONObject.optInt("size");
                            if (optInt2 != 0) {
                                d dVar = (d) a.this.f11867c.get(Integer.valueOf(optInt));
                                if (dVar != null) {
                                    hVar.a(dVar.d(optInt2));
                                } else {
                                    throw new Exception("invalid file handle, it might have timed out");
                                }
                            } else {
                                throw new Exception("invalid or missing read size");
                            }
                        } else {
                            throw new Exception("invalid or missing file handle");
                        }
                    } else {
                        throw new Exception("params must be an object { file: handle, size: number }");
                    }
                } catch (Exception e10) {
                    hVar.b(e10.toString());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private final FileInputStream f11872a;

        /* renamed from: b  reason: collision with root package name */
        private long f11873b = (System.currentTimeMillis() + WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);

        public d(String str) {
            this.f11872a = new FileInputStream(str);
        }

        private void c() {
            this.f11873b = System.currentTimeMillis() + WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        }

        public void a() {
            this.f11872a.close();
        }

        public boolean b() {
            if (System.currentTimeMillis() >= this.f11873b) {
                return true;
            }
            return false;
        }

        public String d(int i10) {
            c();
            byte[] bArr = new byte[i10];
            return Base64.encodeToString(bArr, 0, this.f11872a.read(bArr), 0);
        }
    }

    public a() {
        HashMap hashMap = new HashMap();
        this.f11868d = hashMap;
        hashMap.put("fopen", new C0133a());
        hashMap.put("fclose", new b());
        hashMap.put("fread", new c());
    }

    /* access modifiers changed from: private */
    public int c(String str) {
        int i10 = this.f11865a;
        this.f11865a = i10 + 1;
        this.f11867c.put(Integer.valueOf(i10), new d(str));
        if (this.f11867c.size() == 1) {
            this.f11866b.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        }
        return i10;
    }

    public Map d() {
        return this.f11868d;
    }

    public void run() {
        synchronized (this.f11867c) {
            Iterator it = this.f11867c.values().iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.b()) {
                    it.remove();
                    try {
                        dVar.a();
                    } catch (IOException e10) {
                        String str = f11864e;
                        z2.a.j(str, "closing expired file failed: " + e10.toString());
                    }
                }
            }
            if (!this.f11867c.isEmpty()) {
                this.f11866b.postDelayed(this, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            }
        }
    }
}
