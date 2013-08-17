This directory contains native library folders for alljoyn_java and triumph.

In order to use the Native Class loader file structure must be a sub directory of
the NativeLoader.class package.

IE
-- <NativeLoader.class package path>/lib/
---- win-x86/
------ liballjoyn.dll
------ libtriumph.dll
---- linux-x86/
------ liballjoyn.so
------ libtriumph.so
---- linux-x86_64/
---- linux-ia64/
