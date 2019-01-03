pipeline {
    agent { 
        dockerfile  true 
    }
    stages {
        stage("Build") {
            steps {
                sh 'echo myCustomEnvVar = $myCustomerEnvVar'
                sh 'sbt sbtVersion'
            }
        }
    }
}
