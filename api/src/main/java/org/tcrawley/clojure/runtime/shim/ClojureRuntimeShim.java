package org.tcrawley.clojure.runtime.shim;

/**
 * Provides a shim for accessing the Clojure runtime without loading Clojure classes in the
 * current classLoader.
 *
 * @author toby@tcrawley.org
 */
public abstract class ClojureRuntimeShim {
    /**
     * Creates a new runtime shim. The given classLoader must be able to find clojure classes and
     * ClojureRuntimeShimImpl.
     */
    public static ClojureRuntimeShim newRuntime(ClassLoader classLoader, String name) {
        ClojureRuntimeShim runtime;
        try {
            runtime = (ClojureRuntimeShim)classLoader
                    .loadClass("org.tcrawley.clojure.runtime.shim.impl.ClojureRuntimeShimImpl")
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load ClojureRuntimeImpl", e);
        }

        runtime.setClassLoader( classLoader );
        runtime.setName( name );
        runtime.init();

        return runtime;
    }

    public static ClojureRuntimeShim newRuntime(ClassLoader classLoader) {
        return newRuntime(classLoader, null);
    }

    public abstract void require(String... namespaces);

    public abstract Object invoke(String namespacedFunction);

    public abstract Object invoke(Object fn);

    public abstract Object invoke(String namespacedFunction, Object arg1);

    public abstract Object invoke(Object fn, Object arg1);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2);

    public abstract Object invoke(Object fn, Object arg1, Object arg2);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17, Object arg18);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17, Object arg18);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17, Object arg18, Object arg19);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17, Object arg18, Object arg19);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20);

    public abstract Object invoke(String namespacedFunction, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20,
                                  Object... args);

    public abstract Object invoke(Object fn, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                                  Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                                  Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20,
                                  Object... args);



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public abstract void init();

    protected ClassLoader classLoader;
    protected String name;
}
