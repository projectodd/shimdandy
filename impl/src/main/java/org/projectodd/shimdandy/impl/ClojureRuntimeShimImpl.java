package org.projectodd.shimdandy.impl;

import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Symbol;
import clojure.lang.Var;
import org.projectodd.shimdandy.ClojureRuntimeShim;

/**
 */
public class ClojureRuntimeShimImpl extends ClojureRuntimeShim {
    public void init() {
        ClassLoader origLoader = preInvoke();
        try {
            this.require = RT.var("clojure.core", "require");
            this.resolve = RT.var("clojure.core", "resolve");
            clojure.lang.Compiler.LOADER.bindRoot(this.classLoader);
        } finally {
            postInvoke(origLoader);
        }
    }

    protected ClassLoader preInvoke() {
        ClassLoader originalClassloader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader( this.classLoader );

        return originalClassloader;
    }

    protected void postInvoke(ClassLoader loader) {
        Thread.currentThread().setContextClassLoader( loader );
    }

    protected Var var(String namespacedFunction) {
        ClassLoader origLoader = preInvoke();
        try {
            Var var = (Var)this.resolve.invoke(Symbol.create(namespacedFunction));
            if (var == null) {
                String[] parts = namespacedFunction.split("/");
                this.require.invoke(Symbol.create(parts[0]));
                var = RT.var(parts[0], parts[1]);
            }

            return var;
        } catch (Exception e) {
            throw new RuntimeException( "Failed to load Var " + namespacedFunction, e );
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public void require(String... namespaces) {
        ClassLoader origLoader = preInvoke();
        try {
            for (String ns : namespaces) {
              this.require.invoke(Symbol.create(ns));
            }
        } finally {
            postInvoke(origLoader);
        }
    }

    @Override
    public Object invoke(String namespacedFunction) {
        return invoke( var( namespacedFunction ) );
    }

    @Override
    public Object invoke(Object fn) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke();
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1) {
        return invoke( var( namespacedFunction ), arg1 );
    }

    @Override
    public Object invoke(Object fn, Object arg1) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2) {
        return invoke( var( namespacedFunction ), arg1, arg2);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3) {
        return invoke( var( namespacedFunction ), arg1, arg2, arg3);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2, arg3);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13, arg14);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13, arg14);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13, arg14, arg15);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13, arg14, arg15);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13, arg14, arg15, arg16);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13, arg14, arg15, arg16);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16, Object arg17) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13, arg14, arg15, arg16, arg17);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16, Object arg17) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13, arg14, arg15, arg16, arg17);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16,
                         Object arg17, Object arg18) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13, arg14, arg15, arg16,
                      arg17, arg18);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16,
                         Object arg17, Object arg18) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13, arg14, arg15, arg16,
                                    arg17, arg18);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16,
                         Object arg17, Object arg18, Object arg19) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13, arg14, arg15, arg16,
                      arg17, arg18, arg19);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16,
                         Object arg17, Object arg18, Object arg19) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13, arg14, arg15, arg16,
                                    arg17, arg18, arg19);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16,
                         Object arg17, Object arg18, Object arg19, Object arg20) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13, arg14, arg15, arg16,
                      arg17, arg18, arg19, arg20);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16,
                         Object arg17, Object arg18, Object arg19, Object arg20) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13, arg14, arg15, arg16,
                                    arg17, arg18, arg19, arg20);
        } finally {
            postInvoke( origLoader );
        }
    }

    @Override
    public Object invoke(String namespacedFunction, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16,
                         Object arg17, Object arg18, Object arg19, Object arg20,
                         Object... args) {
        return invoke(var( namespacedFunction ), arg1, arg2,
                      arg3, arg4, arg5, arg6, arg7,
                      arg8, arg9, arg10, arg11, arg12,
                      arg13, arg14, arg15, arg16,
                      arg17, arg18, arg19, arg20,
                      args);
    }

    @Override
    public Object invoke(Object fn, Object arg1, Object arg2,
                         Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                         Object arg8, Object arg9, Object arg10, Object arg11, Object arg12,
                         Object arg13, Object arg14, Object arg15, Object arg16,
                         Object arg17, Object arg18, Object arg19, Object arg20,
                         Object... args) {
        ClassLoader origLoader = preInvoke();
        try {
            return ((IFn)fn).invoke(arg1, arg2,
                                    arg3, arg4, arg5, arg6, arg7,
                                    arg8, arg9, arg10, arg11, arg12,
                                    arg13, arg14, arg15, arg16,
                                    arg17, arg18, arg19, arg20,
                                    args);
        } finally {
            postInvoke( origLoader );
        }
    }

    private Var require;
    private Var resolve;
}
