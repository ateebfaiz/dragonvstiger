package e6;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.concurrent.TimeUnit;

public class g implements SensorEventListener {

    /* renamed from: j  reason: collision with root package name */
    private static final long f11908j;

    /* renamed from: k  reason: collision with root package name */
    private static final float f11909k;

    /* renamed from: a  reason: collision with root package name */
    private float f11910a;

    /* renamed from: b  reason: collision with root package name */
    private float f11911b;

    /* renamed from: c  reason: collision with root package name */
    private float f11912c;

    /* renamed from: d  reason: collision with root package name */
    private final a f11913d;

    /* renamed from: e  reason: collision with root package name */
    private SensorManager f11914e;

    /* renamed from: f  reason: collision with root package name */
    private long f11915f;

    /* renamed from: g  reason: collision with root package name */
    private int f11916g;

    /* renamed from: h  reason: collision with root package name */
    private long f11917h;

    /* renamed from: i  reason: collision with root package name */
    private int f11918i;

    public interface a {
        void a();
    }

    static {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        f11908j = timeUnit.convert(20, TimeUnit.MILLISECONDS);
        f11909k = (float) timeUnit.convert(3, TimeUnit.SECONDS);
    }

    public g(a aVar, int i10) {
        this.f11913d = aVar;
        this.f11918i = i10;
    }

    private boolean a(float f10) {
        if (Math.abs(f10) > 13.042845f) {
            return true;
        }
        return false;
    }

    private void b(long j10) {
        if (this.f11916g >= this.f11918i * 8) {
            d();
            this.f11913d.a();
        }
        if (((float) (j10 - this.f11917h)) > f11909k) {
            d();
        }
    }

    private void c(long j10) {
        this.f11917h = j10;
        this.f11916g++;
    }

    private void d() {
        this.f11916g = 0;
        this.f11910a = 0.0f;
        this.f11911b = 0.0f;
        this.f11912c = 0.0f;
    }

    public void e(SensorManager sensorManager) {
        p5.a.c(sensorManager);
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.f11914e = sensorManager;
            this.f11915f = -1;
            sensorManager.registerListener(this, defaultSensor, 2);
            this.f11917h = 0;
            d();
        }
    }

    public void f() {
        SensorManager sensorManager = this.f11914e;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f11914e = null;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        long j10 = sensorEvent.timestamp;
        if (j10 - this.f11915f >= f11908j) {
            float[] fArr = sensorEvent.values;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2] - 9.80665f;
            this.f11915f = j10;
            if (a(f10) && this.f11910a * f10 <= 0.0f) {
                c(sensorEvent.timestamp);
                this.f11910a = f10;
            } else if (a(f11) && this.f11911b * f11 <= 0.0f) {
                c(sensorEvent.timestamp);
                this.f11911b = f11;
            } else if (a(f12) && this.f11912c * f12 <= 0.0f) {
                c(sensorEvent.timestamp);
                this.f11912c = f12;
            }
            b(sensorEvent.timestamp);
        }
    }
}
