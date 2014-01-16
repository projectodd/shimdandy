# ShimDandy

A Clojure runtime shim, allowing for multiple Clojure runtimes in the
same JVM.

Clojure has a static runtime (implemented as static methods off of
clojure.lang.RT), so to run multiple runtimes in the same JVM, they
have to be loaded in isolated ClassLoader trees. ShimDandy provides a
mechanism for isolating the runtimes within a non-Clojure application,
and for calling in to the runtimes from the app.

## Usage

The project provides two artifacts: `shimdandy-api.jar` and
`shimdandy-impl.jar`. `shimdandy-api` can be on the boot classpath of
your app, but `shimdandy-impl` should not be on the boot classpath or
exposed to any ClassLoader initially. Nor should any Clojure jars -
having a Clojure jar on the classpath will cause the RT from that jar
(and only that RT) to be loaded, preventing isolation.

You then create a ClassLoader that has access to `shimdandy-impl.jar`,
`clojure.jar`, and any dependencies you want in the runtime
(`URLClassLoader` works well for this). That ClassLoader is then
passed to `ClojureRuntimeShim.newRuntime`, which returns a
`ClojureRuntimeShim` instance. This instance provides `require` and
`invoke` methods that can be used to call in to the runtime.

Example:

    URL[] urls = {new URL("file:/path/to/shimdandy-impl.jar"),
                  new URL("file:/path/to/clojure.jar"),
                  new URL("file:/path/to/app/src/")};
    ClassLoader cl = new URLClassLoader(urls, parentClassLoader);
    ClojureRuntimeShim runtime = ClojureRuntimeShim.newRuntime(cl, "my-app-name");
    
    runtime.require("my-app.core");
    Object retval = runtime.invoke("my-app.core/some-fn", arg1, arg2);

The latest version is `1.0.1`:

    <dependency>
      <groupId>org.projectodd.shimdandy</groupId>
      <artifactId>shimdandy-api</artifactId>
      <version>1.0.1</version>
    </dependency>
    
I realize the example here is pretty sparse,
[ping me](mailto:toby@tcrawley.org) if you have any questions.

Copyright (C) 2013-2014 Tobias Crawley.

Licensed under the Eclipse Public License v1.0
