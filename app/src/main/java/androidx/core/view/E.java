package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class E {

    /* renamed from: a, reason: collision with root package name */
    private int f3085a;

    /* renamed from: b, reason: collision with root package name */
    private int f3086b;

    public E(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f3085a | this.f3086b;
    }

    public void b(View view, View view2, int i2) {
        c(view, view2, i2, 0);
    }

    public void c(View view, View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f3086b = i2;
        } else {
            this.f3085a = i2;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i2) {
        if (i2 == 1) {
            this.f3086b = 0;
        } else {
            this.f3085a = 0;
        }
    }
}
