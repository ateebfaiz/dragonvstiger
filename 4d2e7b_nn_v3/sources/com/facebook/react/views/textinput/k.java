package com.facebook.react.views.textinput;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.e;

class k extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    private ReactEditText f4342a;

    /* renamed from: b  reason: collision with root package name */
    private e f4343b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4344c;

    /* renamed from: d  reason: collision with root package name */
    private String f4345d = null;

    public k(InputConnection inputConnection, ReactContext reactContext, ReactEditText reactEditText, e eVar) {
        super(inputConnection, false);
        this.f4343b = eVar;
        this.f4342a = reactEditText;
    }

    private void a(String str) {
        if (str.equals("\n")) {
            str = "Enter";
        }
        this.f4343b.c(new p(this.f4342a.getId(), str));
    }

    private void b(String str) {
        if (this.f4344c) {
            this.f4345d = str;
        } else {
            a(str);
        }
    }

    public boolean beginBatchEdit() {
        this.f4344c = true;
        return super.beginBatchEdit();
    }

    public boolean commitText(CharSequence charSequence, int i10) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= 2) {
            if (charSequence2.equals("")) {
                charSequence2 = "Backspace";
            }
            b(charSequence2);
        }
        return super.commitText(charSequence, i10);
    }

    public boolean deleteSurroundingText(int i10, int i11) {
        a("Backspace");
        return super.deleteSurroundingText(i10, i11);
    }

    public boolean endBatchEdit() {
        this.f4344c = false;
        String str = this.f4345d;
        if (str != null) {
            a(str);
            this.f4345d = null;
        }
        return super.endBatchEdit();
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        boolean z10;
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getUnicodeChar() >= 58 || keyEvent.getUnicodeChar() <= 47) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (keyEvent.getKeyCode() == 67) {
                a("Backspace");
            } else if (keyEvent.getKeyCode() == 66) {
                a("Enter");
            } else if (z10) {
                a(String.valueOf(keyEvent.getNumber()));
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    public boolean setComposingText(CharSequence charSequence, int i10) {
        boolean z10;
        String str;
        int selectionStart = this.f4342a.getSelectionStart();
        int selectionEnd = this.f4342a.getSelectionEnd();
        boolean composingText = super.setComposingText(charSequence, i10);
        int selectionStart2 = this.f4342a.getSelectionStart();
        boolean z11 = false;
        if (selectionStart == selectionEnd) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (selectionStart2 == selectionStart) {
            z11 = true;
        }
        if (selectionStart2 < selectionStart || selectionStart2 <= 0 || (!z10 && z11)) {
            str = "Backspace";
        } else {
            str = String.valueOf(this.f4342a.getText().charAt(selectionStart2 - 1));
        }
        b(str);
        return composingText;
    }
}
