def call(boolean abortPipeline = false, boolean abortOnQualityGate = false) {
    timeout(time: 10, unit: 'MINUTES') {
        withSonarQubeEnv('Sonar Local'){
            withCredentials([string(credentialsId: 'sonar-token', variable: 'SONNARQUBE_TOKEN')]){
                sh """${scannerHome}/bin/sonar-scanner \
                -Dsonar.projectKey=devops_ws \
                -Dsonar.sources=src \
                -Dsonar.host.url=http://localhost:9000 \
                -Dsonar.login=${SONNARQUBE_TOKEN}"""
            }
        }
    }
    def branchName = env.BRANCH_NAME ?: 'main'
    echo "Branch: ${branchName}"

    def qualityGateResult = "OK" // Simulated result, replace with actual quality gate check
    def shouldAbort = false // Simulated condition, replace with actual logic

    if(abortOnQualityGate) {
        shouldAbort = (qualityGateResult != "OK")
    } else {
        if (branchName == 'main' || branchName.startsWith('hotfix')){
            shouldAbort = (qualityGateResult != "OK")
        }
    }

    if (shouldAbort) {
        echo "Static analysis failed. Quality gate result: ${qualityGateResult}"
        if (abortOnQualityGate) {
            error('Pipeline aborted due to quality gate failure')
        } else {
            echo 'Static analysis failed but continuing the pipeline'
        }
    } else {
        echo 'Static analysis passed'
    }

    if (abortPipeline) {
        error('This pipeline has been aborted due to static analysis failure')
    } else {
        echo 'Continue with the pipeline'
    }
}
