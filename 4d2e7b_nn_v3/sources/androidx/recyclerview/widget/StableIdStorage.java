package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId = 0;

        class a implements StableIdLookup {

            /* renamed from: a  reason: collision with root package name */
            private final LongSparseArray f16252a = new LongSparseArray();

            a() {
            }

            public long localToGlobal(long j10) {
                Long l10 = (Long) this.f16252a.get(j10);
                if (l10 == null) {
                    l10 = Long.valueOf(IsolatedStableIdStorage.this.obtainId());
                    this.f16252a.put(j10, l10);
                }
                return l10.longValue();
            }
        }

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return new a();
        }

        /* access modifiers changed from: package-private */
        public long obtainId() {
            long j10 = this.mNextStableId;
            this.mNextStableId = 1 + j10;
            return j10;
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup = new a();

        class a implements StableIdLookup {
            a() {
            }

            public long localToGlobal(long j10) {
                return -1;
            }
        }

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup = new a();

        class a implements StableIdLookup {
            a() {
            }

            public long localToGlobal(long j10) {
                return j10;
            }
        }

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long j10);
    }

    StableIdLookup createStableIdLookup();
}
