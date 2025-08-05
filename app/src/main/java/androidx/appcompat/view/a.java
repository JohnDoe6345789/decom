package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import defpackage.e;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1819a;

    private a(Context context) {
        this.f1819a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f1819a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f1819a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f1819a.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600) {
            return 5;
        }
        if (i2 > 960 && i3 > 720) {
            return 5;
        }
        if (i2 > 720 && i3 > 960) {
            return 5;
        }
        if (i2 >= 500) {
            return 4;
        }
        if (i2 > 640 && i3 > 480) {
            return 4;
        }
        if (i2 <= 480 || i3 <= 640) {
            return i2 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean e() {
        return this.f1819a.getResources().getBoolean(e.AbstractC0072e.f5858a);
    }

    public boolean f() {
        return true;
    }
}
