pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage("Checkout") {
            steps {
                checkout scm
            }
        }
        stage("Docker Build") {
            steps {
              sh '''
                  oc start-build notificaciones
                  # oc start-build -F notificaciones --from-dir=./
              '''
            }
        }
    }
}
