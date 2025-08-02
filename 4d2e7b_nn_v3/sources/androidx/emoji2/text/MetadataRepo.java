package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi(19)
@AnyThread
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    @NonNull
    private final char[] mEmojiCharArray;
    @NonNull
    private final MetadataList mMetadataList;
    @NonNull
    private final a mRootNode = new a(1024);
    @NonNull
    private final Typeface mTypeface;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray f15419a;

        /* renamed from: b  reason: collision with root package name */
        private EmojiMetadata f15420b;

        private a() {
            this(1);
        }

        /* access modifiers changed from: package-private */
        public a a(int i10) {
            SparseArray sparseArray = this.f15419a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i10);
        }

        /* access modifiers changed from: package-private */
        public final EmojiMetadata b() {
            return this.f15420b;
        }

        /* access modifiers changed from: package-private */
        public void c(EmojiMetadata emojiMetadata, int i10, int i11) {
            a a10 = a(emojiMetadata.getCodepointAt(i10));
            if (a10 == null) {
                a10 = new a();
                this.f15419a.put(emojiMetadata.getCodepointAt(i10), a10);
            }
            if (i11 > i10) {
                a10.c(emojiMetadata, i10 + 1, i11);
            } else {
                a10.f15420b = emojiMetadata;
            }
        }

        a(int i10) {
            this.f15419a = new SparseArray(i10);
        }
    }

    private MetadataRepo(@NonNull Typeface typeface, @NonNull MetadataList metadataList) {
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        this.mEmojiCharArray = new char[(metadataList.listLength() * 2)];
        constructIndex(metadataList);
    }

    private void constructIndex(MetadataList metadataList) {
        int listLength = metadataList.listLength();
        for (int i10 = 0; i10 < listLength; i10++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i10);
            Character.toChars(emojiMetadata.getId(), this.mEmojiCharArray, i10 * 2);
            put(emojiMetadata);
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static MetadataRepo create(@NonNull Typeface typeface) {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, new MetadataList());
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public a getRootNode() {
        return this.mRootNode;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface getTypeface() {
        return this.mTypeface;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void put(@NonNull EmojiMetadata emojiMetadata) {
        boolean z10;
        Preconditions.checkNotNull(emojiMetadata, "emoji metadata cannot be null");
        if (emojiMetadata.getCodepointsLength() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "invalid metadata codepoint length");
        this.mRootNode.c(emojiMetadata, 0, emojiMetadata.getCodepointsLength() - 1);
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface typeface, @NonNull InputStream inputStream) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, j.c(inputStream));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, j.d(byteBuffer));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(Typeface.createFromAsset(assetManager, str), j.b(assetManager, str));
        } finally {
            TraceCompat.endSection();
        }
    }
}
