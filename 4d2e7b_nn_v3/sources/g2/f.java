package g2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class f implements SensorEventListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21684b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private b f21685a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void a();
    }

    public final void a(b bVar) {
        if (!v5.a.d(this)) {
            try {
                this.f21685a = bVar;
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i10) {
        if (!v5.a.d(this)) {
            try {
                m.f(sensor, "sensor");
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!v5.a.d(this)) {
            try {
                m.f(sensorEvent, NotificationCompat.CATEGORY_EVENT);
                b bVar = this.f21685a;
                if (bVar != null) {
                    float[] fArr = sensorEvent.values;
                    float f10 = fArr[0];
                    double d10 = (double) (f10 / 9.80665f);
                    double d11 = (double) (fArr[1] / 9.80665f);
                    double d12 = (double) (fArr[2] / 9.80665f);
                    if (Math.sqrt((d10 * d10) + (d11 * d11) + (d12 * d12)) > 2.3d) {
                        bVar.a();
                    }
                }
            } catch (Throwable th) {
                v5.a.b(th, this);
            }
        }
    }
}
