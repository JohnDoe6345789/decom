package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class A {
    public static boolean a(MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
