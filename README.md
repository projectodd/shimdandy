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
`shimdandy-impl.jar`. `shimdandy-api` can be on the classpath of
your app, but `shimdandy-impl` should not be on the classpath or
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

When you are done with a shim, you should close it:

    runtime.close();

The latest version is `1.2.1`:

    <dependency>
      <groupId>org.projectodd.shimdandy</groupId>
      <artifactId>shimdandy-api</artifactId>
      <version>1.2.1</version>
    </dependency>

## Preventing memory leaks

If any code in the shim used an agent or a future, the agent thread
pool will have been started, and those threads will continue to run
after you are done with the shim. This will consume a few resources,
but the bigger concern is the contextClassLoader for those threads
will hold a reference to the shim's classloader, which will prevent
any classes loaded in the shim from being unloaded. Those classes will
eventually cause an OutOfMemoryException from exhausted permgen space
if you create lots of shims. It's best practice to `close()` the shim
when you are done with it (see above). This will shutdown the agent
pool for you.

This same caveat applies to any other threads started from within the
shim - you need to make sure they are stopped. One particular culprit
is the `clojure.core.async.impl.timers/timeout-daemon` thread. If you
use `core.async`, you need to interrupt that thread on shim shutdown
to interrupt its loop and allow it to exit.

If you are using a `URLClassLoader`, you should also `close()` it when
you are done with the shim, as some implementations may leak file
descriptors.

In addition, be sure to use Clojure 1.6.0 or newer to prevent
[other memory leaks](http://dev.clojure.org/jira/browse/CLJ-1125).

I realize the example here is pretty sparse - please file an issue if
you have any questions.

Copyright (C) 2013-2018 Tobias Crawley.

Licensed under the Eclipse Public License v1.0
