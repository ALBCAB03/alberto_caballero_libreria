@Library('threepoints-sharedlib') _
pipeline {
    agent any
    environment {
        BRANCH_NAME = 'main'
    }
    stages {
        
        stage('Run Static Analysis') {
            steps {
                script {
                    staticAnalysis(false, true)
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