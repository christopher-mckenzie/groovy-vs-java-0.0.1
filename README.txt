This is a sample application that demonstrates differences between java and groovy.
It does not talk about all the differences. This project is meant to be an intro to using groovy
within an application that may already be using java or all groovy. Below is a list of topics covered within
this sample application. Most code is done within the test directory to hopefully give a better picture of
what is occurring. Also down below I have listed a few starter notes regarding using groovy

What is in this sample:
    POGO vs POJO
    Map constructors
    @Immutable & @Delegate
    Groovy list, def iteration samples
    Parsing & writing xml
    Parsing & writing json
    Running a groovy script either in code or from gradle
    Strings - ''', """, "" vs ''
    Database connections and writing to database

Groovy getting started tips/tricks
    can run anywhere where there is a jvm
    if you have the groovy plugin or sdk then you have javas
    compile time gets turned into byte code jvm can handle
    groovy is helpful think about where we use it (gradle, logback, tests, or could even have a application.groovy)
    can call java methods in groovy - can even write java if you wish
    can call groovy methods in java - using the java format
    use where groovy make sense - doesn't need to consume entire application, but maybe where it makes your life easier
