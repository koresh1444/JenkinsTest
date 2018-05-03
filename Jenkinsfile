pipeline {
    // Make sure that the tools we need are installed and on the path.
    tools {
        maven "mvn"
        jdk "jdk8"
    }

    agent none

    // Set log rotation, timeout and timestamps in the console
    options {
        buildDiscarder(logRotator(numToKeepStr:'10'))
        timestamps()
        timeout(time: 90, unit: 'MINUTES')
    }
}