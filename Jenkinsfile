pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
		echo 'Building...'
                ./gradlew build
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
		./gradlew test
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
