package com.bumptech.glide.util.pool;

/* loaded from: classes.dex */
public final class GlideTrace {
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    private GlideTrace() {
    }

    public static void beginSection(String str) {
    }

    public static void beginSectionFormat(String str, Object obj) {
    }

    public static void endSection() {
    }

    private static String truncateTag(String str) {
        return str.length() > MAX_LENGTH ? str.substring(0, 126) : str;
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2) {
    }

    public static void beginSectionFormat(String str, Object obj, Object obj2, Object obj3) {
    }
}
