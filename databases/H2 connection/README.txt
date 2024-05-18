To launch from terminal:
    java -cp ".:lib/h2.jar"  Main.java

DB file will be locked in any type of connection (except in memory mode of course).

But in server mode it could be possible to make tcp connection to h2.jar
In embedded mode there is no opened ports to do that.
