compile in windows: dll conversion
  gcc -m64 HelloWorld.c -I "E:/Eclipse_WorkSpace/openjdk-14.0.1_windows-x64_bin/jdk-14.0.1/include" -I "E:/Eclipse_WorkSpace/openjdk-14.0.1_windows-x64_bin/jdk-14.0.1/include/win32" -shared -o helloworld.dll

java 14 to use javah:
 javac -encoding utf8 -h . Yourclass.java