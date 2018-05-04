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

    stages {
        // While there is only one stage here, you can specify as many stages as you like!
        stage ("unit tests run") {
            steps {
                script {
                    log.info "Starting"
                    log.warning "Nothing to do!"
                }
            }
        }
        stage ("integration tests run") {
            steps {
                script {
                    log.info "Starting"
                    log.warning "Nothing to do!"
                }
            }
        }

        stage ("system tests run") {
            steps {
                script {
                    log.info "Starting"
                    log.warning "Nothing to do!"
                }
            }
        }
    }
}