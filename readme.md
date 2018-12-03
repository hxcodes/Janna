# janna: hxcodes Code Support Libraries for Java

[![Latest release](https://img.shields.io/github/release/hxcodes/janna.svg)](https://github.com/hxcodes/janna/releases/latest)
[![Build Status](https://travis-ci.org/hxcodes/janna.svg?branch=master)](https://travis-ci.org/hxcodes/janna)

janna is a set of core libraries that includes new collection types (such as
multimap and multiset), immutable collections, a graph library, functional
types, an in-memory cache, and APIs/utilities for concurrency, I/O, hashing,
primitives, reflection, string processing, and much more!

janna comes in two flavors.

*   The JRE flavor requires JDK 1.8 or higher.
*   If you need support for JDK 1.7 or Android, use the Android flavor. You can
    find the Android Guava source in the [`android` directory].


## Adding janna to your build

janna's Maven group ID is `com.hxcodes` and its artifact ID is `janna`.
janna provides two different "flavors": one for use on a (Java 8+) JRE.

To add a dependency on janna using Maven, use the following:

```xml
<dependency>
  <groupId>com.hxcodes</groupId>
  <artifactId>janna</artifactId>
  <version>1.0</version>
</dependency>
```

To add a dependency using Gradle:

```gradle
dependencies {
  compile 'com.hxcodes:janna-1.0'
}
```

## Snapshots

Snapshots of janna built from the `master` branch are available through Maven
using version `HEAD-SNAPSHOT` flavor.

## Links

- [GitHub project](https://github.com/hxcodes/janna)

## IMPORTANT WARNINGS

1. APIs marked with the `@Beta` annotation at the class or method level
are subject to change. They can be modified in any way, or even
removed, at any time. If your code is a library itself (i.e. it is
used on the CLASSPATH of users outside your own control), you should
not use beta APIs, unless you [repackage] them. **If your
code is a library, we strongly recommend using the [Guava Beta Checker] to
ensure that you do not use any `@Beta` APIs!**

2. APIs without `@Beta` will remain binary-compatible for the indefinite
future. (Previously, we sometimes removed such APIs after a deprecation period.
The last release to remove non-`@Beta` APIs was Guava 21.0.) Even `@Deprecated`
APIs will remain (again, unless they are `@Beta`). We have no plans to start
removing things again, but officially, we're leaving our options open in case
of surprises (like, say, a serious security problem).

3. Serialized forms of ALL objects are subject to change unless noted
otherwise. Do not persist these and assume they can be read by a
future version of the library.

4. Our classes are not designed to protect against a malicious caller.
You should not use them for communication between trusted and
untrusted code.