package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {

    class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        Object f17060a = null;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TaskExecutor f17061b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f17062c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Function f17063d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f17064e;

        /* renamed from: androidx.work.impl.utils.LiveDataUtils$a$a  reason: collision with other inner class name */
        class C0220a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f17065a;

            C0220a(Object obj) {
                this.f17065a = obj;
            }

            public void run() {
                synchronized (a.this.f17062c) {
                    try {
                        Object apply = a.this.f17063d.apply(this.f17065a);
                        a aVar = a.this;
                        Object obj = aVar.f17060a;
                        if (obj == null && apply != null) {
                            aVar.f17060a = apply;
                            aVar.f17064e.postValue(apply);
                        } else if (obj != null && !obj.equals(apply)) {
                            a aVar2 = a.this;
                            aVar2.f17060a = apply;
                            aVar2.f17064e.postValue(apply);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        a(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
            this.f17061b = taskExecutor;
            this.f17062c = obj;
            this.f17063d = function;
            this.f17064e = mediatorLiveData;
        }

        public void onChanged(Object obj) {
            this.f17061b.executeOnBackgroundThread(new C0220a(obj));
        }
    }

    private LiveDataUtils() {
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull Function<In, Out> function, @NonNull TaskExecutor taskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new a(taskExecutor, obj, function, mediatorLiveData));
        return mediatorLiveData;
    }
}
