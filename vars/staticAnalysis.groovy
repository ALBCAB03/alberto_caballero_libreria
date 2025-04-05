def call() {
    timeout(time: 10, unit: 'MINUTES') {
        withEnv(["sonarenv=simulated_value"]){
            sh 'echo "Static analysis started"'
        }
    }
}
