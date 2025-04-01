def call(boolean abortPipeline = false) {
    pipeline {
        agent any
        environment {
            SONAR_ENV = "sonar"
        }
        stages {
            stage('Static Analysis') {
                steps {
                    script {
                        echo "Running static analysis..."
                        timeout(time: 5, unit: 'MINUTES') {
                            echo "Running SonarQube analysis..."
                        }
                        echo "SonarQube analysis completed."
                    }
                }
            }
            stage('Quality Gate') {
                steps {
                    script {
                        if (abortPipeline) {
                            echo "Quality gate failed. Aborting pipeline."
                            error("Quality gate failed.")
                        } else {
                            echo "Quality gate passed. Proceeding with the pipeline."
                        }
                    }
                }
            }
        }
    }
}
