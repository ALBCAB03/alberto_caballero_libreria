pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/tu-repo.git'
            }
        }
        
        stage('Run Static Analysis') {
            steps {
                script {
                    staticAnalysis(qualityGateAbort: true, abortPipeline: false)
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
