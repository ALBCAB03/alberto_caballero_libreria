def call(boolean abortPipeline = false, boolean abortOnQualityGate = false) {
    timeout(time: 10, unit: 'MINUTES') {
        withEnv(["sonarenv=simulated_value"]){
            sh 'echo "Static analysis started"'
        }
    }
    def branchName = env.BRANCH_NAME ?: 'main'
    echo "Branch: ${branchName}"

    def qualityGateResult = "ERROR" // Simulated result, replace with actual quality gate check
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
