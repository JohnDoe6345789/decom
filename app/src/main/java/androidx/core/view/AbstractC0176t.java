package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: androidx.core.view.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0176t {
    public static void a(int i2, int i3, int i4, Rect rect, Rect rect2, int i5) {
        Gravity.apply(i2, i3, i4, rect, rect2, i5);
    }

    public static int b(int i2, int i3) {
        return Gravity.getAbsoluteGravity(i2, i3);
    }
}
