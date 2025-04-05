@Library('threepoints-sharedlib')
def call(boolean qualityGateAbort = false, boolean abortPipeline = false) {
    pipeline {
        agent any
        stages {
            stage('Static Code Analysis') {
                steps {
                    script {
                        try {
                            timeout(time: 5, unit: 'MINUTES') {
                                withEnv(['SONAR_ENV=dummy']) {
                                    sh 'echo "Ejecución de las pruebas de calidad de código"'
                                }
                            }
                        } catch (Exception e) {
                            echo "Error: Tiempo de espera excedido en el análisis de código"
                            if (qualityGateAbort) {
                                error("Pipeline abortado debido al Quality Gate")
                            }
                        }

                        if (abortPipeline) {
                            error("Pipeline abortado según el parámetro abortPipeline")
                        }
                    }
                }
            }
        }
    }
}
