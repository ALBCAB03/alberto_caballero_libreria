def call(boolean abortPipeline = false, boolean abortOnQualityGate = false) {
    timeout(time: 10, unit: 'MINUTES') {
        withEnv(["sonarenv=simulated_value"]){
            sh 'echo "Static analysis started"'
        }
    }
    def qualityGateResult = "OK" // Simulated result, replace with actual quality gate check
    if(abortOnQualityGate && qualityGateResult != "OK") {
        error("Quality gate failed: ${qualityGateResult}")
    } else {
        echo "Quality gate passed: ${qualityGateResult}"
    }
    if (abortPipeline) {
        error('This pipeline has been aborted due to static analysis failure')
    } else {
        echo 'Continue with the pipeline'
    }
}
