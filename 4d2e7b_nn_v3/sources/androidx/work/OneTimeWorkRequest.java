package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.List;

public final class OneTimeWorkRequest extends WorkRequest {

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            super(cls);
            this.mWorkSpec.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder getThis() {
            return this;
        }

        @NonNull
        public Builder setInputMerger(@NonNull Class<? extends InputMerger> cls) {
            this.mWorkSpec.inputMergerClassName = cls.getName();
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public OneTimeWorkRequest buildInternal() {
            if (!this.mBackoffCriteriaSet || !this.mWorkSpec.constraints.requiresDeviceIdle()) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }
    }

    OneTimeWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }

    @NonNull
    public static OneTimeWorkRequest from(@NonNull Class<? extends ListenableWorker> cls) {
        return (OneTimeWorkRequest) new Builder(cls).build();
    }

    @NonNull
    public static List<OneTimeWorkRequest> from(@NonNull List<Class<? extends ListenableWorker>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Class<? extends ListenableWorker> builder : list) {
            arrayList.add((OneTimeWorkRequest) new Builder(builder).build());
        }
        return arrayList;
    }
}
