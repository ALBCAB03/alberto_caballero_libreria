@Library('threepoints-sharedlib')_

pipeline{
    agent any
    stages{
        stage('Checkout') {
            steps {
                git 'https://github.com/ALBCAB03/alberto_caballero_libreria.git'
            }
        }
        stage('Static Analysis') {
            steps {
                script {
                    staticAnalysis(abortPipeline: false)
                }
            }
        }
    }
}
