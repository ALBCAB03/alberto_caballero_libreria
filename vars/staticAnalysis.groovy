def call(boolean abortPipeline = false) {
    timeout(time: 10, unit: 'MINUTES') {
        withEnv(["sonarenv=simulated_value"]){
            sh 'echo "Static analysis started"'
        }
    }
    if (abortPipeline) {
        error('This pipeline has been aborted due to static analysis failure')
    } else {
        echo 'Continue with the pipeline'
    }
}
