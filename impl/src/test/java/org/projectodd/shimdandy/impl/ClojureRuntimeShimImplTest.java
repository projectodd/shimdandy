package org.projectodd.shimdandy.impl;

import clojure.lang.Symbol;
import clojure.lang.Var;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClojureRuntimeShimImplTest {
    @Before
    public void setup() {
        shim = new ClojureRuntimeShimImpl();
        shim.setClassLoader(Symbol.class.getClassLoader());
        shim.init();
    }

    @Test
    public void testVarWhenVarExistsInRTOnly() {
        Object ns = shim.invoke("clojure.core/create-ns", Symbol.create("foo"));
        Var intern = shim.var("clojure.core/intern");
        intern.invoke(ns, Symbol.create("bar"), "baz");
        Var bar = shim.var("foo/bar");
        assertNotNull(bar);
        assertEquals("baz", bar.deref());
    }

    @Test
    public void testVarWhenNSExists() {
        Var trim = shim.var("clojure.string/trim");
        assertNotNull(trim);
    }

    @Test
    public void testInvoke() {
        assertEquals("ham", shim.invoke("clojure.core/identity", "ham"));
    }

    private ClojureRuntimeShimImpl shim;
}
