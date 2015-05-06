================================================================================
JUnit Per Test Case Coverage
================================================================================

Provided below are examples of how to use the program.

In the /src/ directory there is a Makefile, which you can either use or look at for more examples of how to run the program.

================================================================================
*. How to compile the java classes
================================================================================

javac -d /bin/ -cp .:lib/jacocoagent.jar:lib/junit-4.11.jar:lib/org.jacoco.core-0.6.2.20130126-2101.jar src/PerTestCaseCoverageRunner.java

javac -d /bin/ -cp .:lib/jacocoagent.jar:lib/junit-4.11.jar:lib/org.jacoco.core-0.6.2.20130126-2101.jar src/ExecDump.java

================================================================================
*. How to run the program with a given JUnit test suite class file. In this example, ClassATest.class is the test suite class.
================================================================================

java -javaagent:lib/jacocoagent.jar=destfile=bin/jacoco.exec,dumponexit=false -cp bin:lib/jacocoagent.jar:lib/hamcrest-core-1.3.jar:lib/junit-4.11.jar PerTestCaseCoverageRunner ClassATest

	*. Note: you can add more arguments to the jacocoagent (comma separated as above). For example "excludes=*junit*" would cause the jacocoagent to not track coverage for any class files with "junit" in the name. My Makefile in /src/ adds a few that I believe are useful.

	*. "dumponexit=false" causes the jacocoagent to not do dump of coverage information upon termination (since we are dumping at the end of each test case already).

================================================================================
*. How to dump some high-level coverage information out of an .exec file. In this example, the .exec file is "bin/jacoco.exec"
================================================================================

java -cp .:lib/org.jacoco.core-0.6.2.20130126-2101.jar ExecDump bin/jacoco.exec
