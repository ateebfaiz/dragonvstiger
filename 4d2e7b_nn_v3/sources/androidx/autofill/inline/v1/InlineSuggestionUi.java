package androidx.autofill.inline.v1;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.R;
import androidx.autofill.inline.UiVersions;
import androidx.autofill.inline.common.BundledStyle;
import androidx.autofill.inline.common.ImageViewStyle;
import androidx.autofill.inline.common.SlicedContent;
import androidx.autofill.inline.common.TextViewStyle;
import androidx.autofill.inline.common.ViewStyle;
import androidx.autofill.inline.common.e;
import java.util.Collections;
import java.util.List;

@RequiresApi(api = 30)
public final class InlineSuggestionUi {
    private static final String TAG = "InlineSuggestionUi";

    public static final class Content extends SlicedContent {
        static final String HINT_INLINE_ATTRIBUTION_INTENT = "inline_attribution";
        static final String HINT_INLINE_CONTENT_DESCRIPTION = "inline_content_description";
        static final String HINT_INLINE_END_ICON = "inline_end_icon";
        static final String HINT_INLINE_START_ICON = "inline_start_icon";
        static final String HINT_INLINE_SUBTITLE = "inline_subtitle";
        static final String HINT_INLINE_TITLE = "inline_title";
        @Nullable
        private PendingIntent mAttributionIntent;
        @Nullable
        private CharSequence mContentDescription;
        @Nullable
        private Icon mEndIcon;
        @Nullable
        private Icon mStartIcon;
        @Nullable
        private CharSequence mSubtitle;
        @Nullable
        private CharSequence mTitle;

        public static final class Builder extends SlicedContent.Builder<Content> {
            @NonNull
            private final PendingIntent mAttributionIntent;
            @Nullable
            private CharSequence mContentDescription;
            @Nullable
            private Icon mEndIcon;
            @Nullable
            private List<String> mHints;
            @Nullable
            private Icon mStartIcon;
            @Nullable
            private CharSequence mSubtitle;
            @Nullable
            private CharSequence mTitle;

            Builder(@NonNull PendingIntent pendingIntent) {
                super(UiVersions.INLINE_UI_VERSION_1);
                this.mAttributionIntent = pendingIntent;
            }

            @NonNull
            public Builder setContentDescription(@NonNull CharSequence charSequence) {
                this.mContentDescription = charSequence;
                return this;
            }

            @NonNull
            public Builder setEndIcon(@NonNull Icon icon) {
                this.mEndIcon = icon;
                return this;
            }

            @NonNull
            public Builder setHints(@NonNull List<String> list) {
                this.mHints = list;
                return this;
            }

            @NonNull
            public Builder setStartIcon(@NonNull Icon icon) {
                this.mStartIcon = icon;
                return this;
            }

            @NonNull
            public Builder setSubtitle(@NonNull CharSequence charSequence) {
                this.mSubtitle = charSequence;
                return this;
            }

            @NonNull
            public Builder setTitle(@NonNull CharSequence charSequence) {
                this.mTitle = charSequence;
                return this;
            }

            @NonNull
            public Content build() {
                CharSequence charSequence = this.mTitle;
                if (charSequence == null && this.mStartIcon == null && this.mEndIcon == null && this.mSubtitle == null) {
                    throw new IllegalStateException("Title, subtitle, start icon, end icon are all null. Please set value for at least one of them");
                } else if (charSequence == null && this.mSubtitle != null) {
                    throw new IllegalStateException("Cannot set the subtitle without setting the title.");
                } else if (this.mAttributionIntent != null) {
                    Icon icon = this.mStartIcon;
                    if (icon != null) {
                        Slice.Builder unused = this.mSliceBuilder.addIcon(icon, (String) null, Collections.singletonList(Content.HINT_INLINE_START_ICON));
                    }
                    CharSequence charSequence2 = this.mTitle;
                    if (charSequence2 != null) {
                        Slice.Builder unused2 = this.mSliceBuilder.addText(charSequence2, (String) null, Collections.singletonList(Content.HINT_INLINE_TITLE));
                    }
                    CharSequence charSequence3 = this.mSubtitle;
                    if (charSequence3 != null) {
                        Slice.Builder unused3 = this.mSliceBuilder.addText(charSequence3, (String) null, Collections.singletonList(Content.HINT_INLINE_SUBTITLE));
                    }
                    Icon icon2 = this.mEndIcon;
                    if (icon2 != null) {
                        Slice.Builder unused4 = this.mSliceBuilder.addIcon(icon2, (String) null, Collections.singletonList(Content.HINT_INLINE_END_ICON));
                    }
                    PendingIntent pendingIntent = this.mAttributionIntent;
                    if (pendingIntent != null) {
                        Slice.Builder builder = this.mSliceBuilder;
                        e.a();
                        Slice.Builder unused5 = builder.addAction(pendingIntent, m.a(this.mSliceBuilder).addHints(Collections.singletonList(Content.HINT_INLINE_ATTRIBUTION_INTENT)).build(), (String) null);
                    }
                    CharSequence charSequence4 = this.mContentDescription;
                    if (charSequence4 != null) {
                        Slice.Builder unused6 = this.mSliceBuilder.addText(charSequence4, (String) null, Collections.singletonList(Content.HINT_INLINE_CONTENT_DESCRIPTION));
                    }
                    List<String> list = this.mHints;
                    if (list != null) {
                        Slice.Builder unused7 = this.mSliceBuilder.addHints(list);
                    }
                    return new Content(this.mSliceBuilder.build());
                } else {
                    throw new IllegalStateException("Attribution intent cannot be null.");
                }
            }
        }

        Content(@NonNull Slice slice) {
            super(slice);
            for (Object a10 : slice.getItems()) {
                SliceItem a11 = b.a(a10);
                String itemType = itemType(a11);
                if (itemType != null) {
                    char c10 = 65535;
                    switch (itemType.hashCode()) {
                        case -1790855426:
                            if (itemType.equals(HINT_INLINE_SUBTITLE)) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case -1269099888:
                            if (itemType.equals(HINT_INLINE_CONTENT_DESCRIPTION)) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case -145102948:
                            if (itemType.equals(HINT_INLINE_START_ICON)) {
                                c10 = 2;
                                break;
                            }
                            break;
                        case 729157938:
                            if (itemType.equals(HINT_INLINE_TITLE)) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case 1020097497:
                            if (itemType.equals(HINT_INLINE_ATTRIBUTION_INTENT)) {
                                c10 = 4;
                                break;
                            }
                            break;
                        case 1994860611:
                            if (itemType.equals(HINT_INLINE_END_ICON)) {
                                c10 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c10) {
                        case 0:
                            this.mSubtitle = a11.getText().toString();
                            break;
                        case 1:
                            this.mContentDescription = a11.getText();
                            break;
                        case 2:
                            this.mStartIcon = a11.getIcon();
                            break;
                        case 3:
                            this.mTitle = a11.getText().toString();
                            break;
                        case 4:
                            this.mAttributionIntent = a11.getAction();
                            break;
                        case 5:
                            this.mEndIcon = a11.getIcon();
                            break;
                    }
                }
            }
        }

        @Nullable
        private static String itemType(SliceItem sliceItem) {
            String a10 = sliceItem.getFormat();
            a10.hashCode();
            char c10 = 65535;
            switch (a10.hashCode()) {
                case -1422950858:
                    if (a10.equals("action")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 3556653:
                    if (a10.equals("text")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 100313435:
                    if (a10.equals("image")) {
                        c10 = 2;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    if (sliceItem.getAction() == null || !sliceItem.getHints().contains(HINT_INLINE_ATTRIBUTION_INTENT)) {
                        return null;
                    }
                    return HINT_INLINE_ATTRIBUTION_INTENT;
                case 1:
                    if (TextUtils.isEmpty(sliceItem.getText())) {
                        return null;
                    }
                    if (sliceItem.getHints().contains(HINT_INLINE_TITLE)) {
                        return HINT_INLINE_TITLE;
                    }
                    if (sliceItem.getHints().contains(HINT_INLINE_SUBTITLE)) {
                        return HINT_INLINE_SUBTITLE;
                    }
                    if (sliceItem.getHints().contains(HINT_INLINE_CONTENT_DESCRIPTION)) {
                        return HINT_INLINE_CONTENT_DESCRIPTION;
                    }
                    break;
                case 2:
                    if (sliceItem.getIcon() == null) {
                        return null;
                    }
                    if (sliceItem.getHints().contains(HINT_INLINE_START_ICON)) {
                        return HINT_INLINE_START_ICON;
                    }
                    if (sliceItem.getHints().contains(HINT_INLINE_END_ICON)) {
                        return HINT_INLINE_END_ICON;
                    }
                    break;
                default:
                    return null;
            }
            return null;
        }

        @Nullable
        public PendingIntent getAttributionIntent() {
            return this.mAttributionIntent;
        }

        @Nullable
        public CharSequence getContentDescription() {
            return this.mContentDescription;
        }

        @Nullable
        public Icon getEndIcon() {
            return this.mEndIcon;
        }

        @Nullable
        public Icon getStartIcon() {
            return this.mStartIcon;
        }

        @Nullable
        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        @Nullable
        public CharSequence getTitle() {
            return this.mTitle;
        }

        /* access modifiers changed from: package-private */
        public boolean isSingleIconOnly() {
            if (this.mStartIcon != null && this.mTitle == null && this.mSubtitle == null && this.mEndIcon == null) {
                return true;
            }
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public boolean isValid() {
            return UiVersions.INLINE_UI_VERSION_1.equals(SlicedContent.getVersion(this.mSlice));
        }
    }

    private InlineSuggestionUi() {
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Style fromBundle(@NonNull Bundle bundle) {
        Style style = new Style(bundle);
        if (style.isValid()) {
            return style;
        }
        Log.w(TAG, "Invalid style for androidx.autofill.inline.ui.version:v1");
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Content fromSlice(@NonNull Slice slice) {
        Content content = new Content(slice);
        if (content.isValid()) {
            return content;
        }
        Log.w(TAG, "Invalid content for androidx.autofill.inline.ui.version:v1");
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static PendingIntent getAttributionIntent(@NonNull Content content) {
        return content.getAttributionIntent();
    }

    private static Context getDefaultContextThemeWrapper(@NonNull Context context) {
        Resources.Theme newTheme = context.getResources().newTheme();
        newTheme.applyStyle(R.style.Theme_AutofillInlineSuggestion, true);
        return new ContextThemeWrapper(context, newTheme);
    }

    @NonNull
    public static Content.Builder newContentBuilder(@NonNull PendingIntent pendingIntent) {
        return new Content.Builder(pendingIntent);
    }

    @NonNull
    public static Style.Builder newStyleBuilder() {
        return new Style.Builder();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static View render(@NonNull Context context, @NonNull Content content, @NonNull Style style) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getDefaultContextThemeWrapper(context)).inflate(R.layout.autofill_inline_suggestion, (ViewGroup) null);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.autofill_inline_suggestion_start_icon);
        TextView textView = (TextView) viewGroup.findViewById(R.id.autofill_inline_suggestion_title);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.autofill_inline_suggestion_subtitle);
        ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.autofill_inline_suggestion_end_icon);
        CharSequence title = content.getTitle();
        if (title != null) {
            textView.setText(title);
            textView.setVisibility(0);
        }
        CharSequence subtitle = content.getSubtitle();
        if (subtitle != null) {
            textView2.setText(subtitle);
            textView2.setVisibility(0);
        }
        Icon startIcon = content.getStartIcon();
        if (startIcon != null) {
            imageView.setImageIcon(startIcon);
            imageView.setVisibility(0);
        }
        Icon endIcon = content.getEndIcon();
        if (endIcon != null) {
            imageView2.setImageIcon(endIcon);
            imageView2.setVisibility(0);
        }
        CharSequence contentDescription = content.getContentDescription();
        if (!TextUtils.isEmpty(contentDescription)) {
            viewGroup.setContentDescription(contentDescription);
        }
        if (style.isValid()) {
            if (content.isSingleIconOnly()) {
                style.applyStyle(viewGroup, imageView);
            } else {
                style.applyStyle(viewGroup, imageView, textView, textView2, imageView2);
            }
        }
        return viewGroup;
    }

    public static final class Style extends BundledStyle implements UiVersions.Style {
        private static final String KEY_CHIP_STYLE = "chip_style";
        private static final String KEY_END_ICON_STYLE = "end_icon_style";
        private static final String KEY_LAYOUT_DIRECTION = "layout_direction";
        private static final String KEY_SINGLE_ICON_CHIP_ICON_STYLE = "single_icon_chip_icon_style";
        private static final String KEY_SINGLE_ICON_CHIP_STYLE = "single_icon_chip_style";
        private static final String KEY_START_ICON_STYLE = "start_icon_style";
        private static final String KEY_STYLE_V1 = "style_v1";
        private static final String KEY_SUBTITLE_STYLE = "subtitle_style";
        private static final String KEY_TITLE_STYLE = "title_style";

        public static final class Builder extends BundledStyle.Builder<Style> {
            Builder() {
                super(Style.KEY_STYLE_V1);
            }

            @NonNull
            public Builder setChipStyle(@NonNull ViewStyle viewStyle) {
                viewStyle.assertIsValid();
                this.mBundle.putBundle(Style.KEY_CHIP_STYLE, viewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setEndIconStyle(@NonNull ImageViewStyle imageViewStyle) {
                imageViewStyle.assertIsValid();
                this.mBundle.putBundle(Style.KEY_END_ICON_STYLE, imageViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setLayoutDirection(int i10) {
                this.mBundle.putInt(Style.KEY_LAYOUT_DIRECTION, i10);
                return this;
            }

            @NonNull
            public Builder setSingleIconChipIconStyle(@NonNull ImageViewStyle imageViewStyle) {
                imageViewStyle.assertIsValid();
                this.mBundle.putBundle(Style.KEY_SINGLE_ICON_CHIP_ICON_STYLE, imageViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setSingleIconChipStyle(@NonNull ViewStyle viewStyle) {
                viewStyle.assertIsValid();
                this.mBundle.putBundle(Style.KEY_SINGLE_ICON_CHIP_STYLE, viewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setStartIconStyle(@NonNull ImageViewStyle imageViewStyle) {
                imageViewStyle.assertIsValid();
                this.mBundle.putBundle(Style.KEY_START_ICON_STYLE, imageViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setSubtitleStyle(@NonNull TextViewStyle textViewStyle) {
                textViewStyle.assertIsValid();
                this.mBundle.putBundle(Style.KEY_SUBTITLE_STYLE, textViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Builder setTitleStyle(@NonNull TextViewStyle textViewStyle) {
                textViewStyle.assertIsValid();
                this.mBundle.putBundle(Style.KEY_TITLE_STYLE, textViewStyle.getBundle());
                return this;
            }

            @NonNull
            public Style build() {
                return new Style(this.mBundle);
            }
        }

        Style(@NonNull Bundle bundle) {
            super(bundle);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void applyStyle(@NonNull View view, @NonNull ImageView imageView) {
            if (isValid()) {
                view.setLayoutDirection(getLayoutDirection());
                if (imageView.getVisibility() != 8) {
                    ImageViewStyle singleIconChipIconStyle = getSingleIconChipIconStyle();
                    if (singleIconChipIconStyle == null) {
                        singleIconChipIconStyle = getStartIconStyle();
                    }
                    if (singleIconChipIconStyle != null) {
                        singleIconChipIconStyle.applyStyleOnImageViewIfValid(imageView);
                    }
                }
                ViewStyle singleIconChipStyle = getSingleIconChipStyle();
                if (singleIconChipStyle == null) {
                    singleIconChipStyle = getChipStyle();
                }
                if (singleIconChipStyle != null) {
                    singleIconChipStyle.applyStyleOnViewIfValid(view);
                }
            }
        }

        @Nullable
        public ViewStyle getChipStyle() {
            Bundle bundle = this.mBundle.getBundle(KEY_CHIP_STYLE);
            if (bundle == null) {
                return null;
            }
            return new ViewStyle(bundle);
        }

        @Nullable
        public ImageViewStyle getEndIconStyle() {
            Bundle bundle = this.mBundle.getBundle(KEY_END_ICON_STYLE);
            if (bundle == null) {
                return null;
            }
            return new ImageViewStyle(bundle);
        }

        public int getLayoutDirection() {
            int i10 = this.mBundle.getInt(KEY_LAYOUT_DIRECTION, 0);
            if (i10 == 0 || i10 == 1) {
                return i10;
            }
            return 0;
        }

        @Nullable
        public ImageViewStyle getSingleIconChipIconStyle() {
            Bundle bundle = this.mBundle.getBundle(KEY_SINGLE_ICON_CHIP_ICON_STYLE);
            if (bundle == null) {
                return null;
            }
            return new ImageViewStyle(bundle);
        }

        @Nullable
        public ViewStyle getSingleIconChipStyle() {
            Bundle bundle = this.mBundle.getBundle(KEY_SINGLE_ICON_CHIP_STYLE);
            if (bundle == null) {
                return null;
            }
            return new ViewStyle(bundle);
        }

        @Nullable
        public ImageViewStyle getStartIconStyle() {
            Bundle bundle = this.mBundle.getBundle(KEY_START_ICON_STYLE);
            if (bundle == null) {
                return null;
            }
            return new ImageViewStyle(bundle);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String getStyleKey() {
            return KEY_STYLE_V1;
        }

        @Nullable
        public TextViewStyle getSubtitleStyle() {
            Bundle bundle = this.mBundle.getBundle(KEY_SUBTITLE_STYLE);
            if (bundle == null) {
                return null;
            }
            return new TextViewStyle(bundle);
        }

        @Nullable
        public TextViewStyle getTitleStyle() {
            Bundle bundle = this.mBundle.getBundle(KEY_TITLE_STYLE);
            if (bundle == null) {
                return null;
            }
            return new TextViewStyle(bundle);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String getVersion() {
            return UiVersions.INLINE_UI_VERSION_1;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void applyStyle(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2) {
            ImageViewStyle endIconStyle;
            TextViewStyle subtitleStyle;
            TextViewStyle titleStyle;
            ImageViewStyle startIconStyle;
            if (isValid()) {
                view.setLayoutDirection(getLayoutDirection());
                if (!(imageView.getVisibility() == 8 || (startIconStyle = getStartIconStyle()) == null)) {
                    startIconStyle.applyStyleOnImageViewIfValid(imageView);
                }
                if (!(textView.getVisibility() == 8 || (titleStyle = getTitleStyle()) == null)) {
                    titleStyle.applyStyleOnTextViewIfValid(textView);
                }
                if (!(textView2.getVisibility() == 8 || (subtitleStyle = getSubtitleStyle()) == null)) {
                    subtitleStyle.applyStyleOnTextViewIfValid(textView2);
                }
                if (!(imageView2.getVisibility() == 8 || (endIconStyle = getEndIconStyle()) == null)) {
                    endIconStyle.applyStyleOnImageViewIfValid(imageView2);
                }
                ViewStyle chipStyle = getChipStyle();
                if (chipStyle != null) {
                    chipStyle.applyStyleOnViewIfValid(view);
                }
            }
        }
    }
}
