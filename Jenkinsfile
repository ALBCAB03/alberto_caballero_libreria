@Library('threepoints-sharedlib') _
pipeline {
    agent any
    stages {
        
        stage('Run Static Analysis') {
            steps {
                script {
                    staticAnalysis(abortPipeline: true)
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