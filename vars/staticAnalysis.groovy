def call(boolean qualityGateAbort = false, boolean abortPipeline = false) {
    try {
        echo "Analisis de código estático en curso..."
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
