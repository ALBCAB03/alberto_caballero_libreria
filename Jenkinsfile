@Library('threepoints-sharedlib') _
pipeline {
    agent any
    environment {
        BRANCH_NAME = 'main'
        SONAR_PROJECT_KEY = 'devops_ws'
        SONAR_PROJECT_NAME = 'devops_ws'
        SONAR_HOST_URL = 'http://localhost:9000'
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