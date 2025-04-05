def call() {
    timeout(time: 10, unit: 'MINUTES') {
        withEnf(["sonarenv=simulated_value"]){
            sh 'echo "Static analysis started"'
        }
    }
}
