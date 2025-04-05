pipeline {
    agent any
    stages {
        
        stage('Run Static Analysis') {
            steps {
                script {
                    staticAnalysis(qualityGateAbort: false, abortPipeline: false)
                }
            }
        }
        stage('Build') {
            steps {
                echo 'Compilando el proyecto...'
            }
        } 
        stage('Deploy') {
            steps {
                echo 'Desplegando la aplicación...'
            }
        }
    }
}
