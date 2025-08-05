package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements M.a {

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        public static void c(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.n
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j2) {
                    runnable.run();
                }
            });
        }
    }

    private static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: androidx.profileinstaller.m
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                j.i(context);
            }
        });
    }

    @Override // M.a
    public List a() {
        return Collections.emptyList();
    }

    @Override // M.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c b(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new c();
        }
        g(context.getApplicationContext());
        return new c();
    }

    void g(final Context context) {
        a.c(new Runnable() { // from class: androidx.profileinstaller.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f3814a.i(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void i(final Context context) {
        (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new Runnable() { // from class: androidx.profileinstaller.l
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.l(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
