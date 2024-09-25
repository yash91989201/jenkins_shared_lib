def QualityGateStatus(SonarQubecredentialsId) {
    timeout(time: 5, unit: 'MINUTES') {  // Adjust timeout as needed
        def qg = waitForQualityGate() // This will wait for the analysis to finish and the status to be available
        if (qg.status != 'OK') {
            error "Pipeline aborted due to quality gate failure: ${qg.status}"
        }
    }
}
