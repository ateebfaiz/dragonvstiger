package androidx.recyclerview.widget;

import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final String TAG = "ConcatAdapter";
    private final c mController;

    public static final class Config {
        @NonNull
        public static final Config DEFAULT = new Config(true, StableIdMode.NO_STABLE_IDS);
        public final boolean isolateViewTypes;
        @NonNull
        public final StableIdMode stableIdMode;

        public static final class Builder {
            private boolean mIsolateViewTypes;
            private StableIdMode mStableIdMode;

            public Builder() {
                Config config = Config.DEFAULT;
                this.mIsolateViewTypes = config.isolateViewTypes;
                this.mStableIdMode = config.stableIdMode;
            }

            @NonNull
            public Config build() {
                return new Config(this.mIsolateViewTypes, this.mStableIdMode);
            }

            @NonNull
            public Builder setIsolateViewTypes(boolean z10) {
                this.mIsolateViewTypes = z10;
                return this;
            }

            @NonNull
            public Builder setStableIdMode(@NonNull StableIdMode stableIdMode) {
                this.mStableIdMode = stableIdMode;
                return this;
            }
        }

        public enum StableIdMode {
            NO_STABLE_IDS,
            ISOLATED_STABLE_IDS,
            SHARED_STABLE_IDS
        }

        Config(boolean z10, @NonNull StableIdMode stableIdMode2) {
            this.isolateViewTypes = z10;
            this.stableIdMode = stableIdMode2;
        }
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... adapterArr) {
        this(Config.DEFAULT, adapterArr);
    }

    public boolean addAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.mController.h(adapter);
    }

    public int findRelativeAdapterPositionIn(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, @NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        return this.mController.q(adapter, viewHolder, i10);
    }

    @NonNull
    public List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters() {
        return Collections.unmodifiableList(this.mController.n());
    }

    public int getItemCount() {
        return this.mController.r();
    }

    public long getItemId(int i10) {
        return this.mController.o(i10);
    }

    public int getItemViewType(int i10) {
        return this.mController.p(i10);
    }

    @NonNull
    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> getWrappedAdapterAndPosition(int i10) {
        return this.mController.s(i10);
    }

    /* access modifiers changed from: package-private */
    public void internalSetStateRestorationPolicy(@NonNull RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }

    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mController.x(recyclerView);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        this.mController.y(viewHolder, i10);
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return this.mController.z(viewGroup, i10);
    }

    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mController.A(recyclerView);
    }

    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.mController.B(viewHolder);
    }

    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.mController.C(viewHolder);
    }

    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.mController.D(viewHolder);
    }

    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.mController.E(viewHolder);
    }

    public boolean removeAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.mController.G(adapter);
    }

    public void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    public void setStateRestorationPolicy(@NonNull RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull Config config, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... adapterArr) {
        this(config, (List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>>) Arrays.asList(adapterArr));
    }

    public boolean addAdapter(int i10, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.mController.g(i10, adapter);
    }

    public ConcatAdapter(@NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this(Config.DEFAULT, list);
    }

    public ConcatAdapter(@NonNull Config config, @NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this.mController = new c(this, config);
        for (RecyclerView.Adapter addAdapter : list) {
            addAdapter(addAdapter);
        }
        super.setHasStableIds(this.mController.u());
    }
}
