pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
		script	{
		   echo 'Building...'
                   ./gradlew build
		}
            }
        }
        stage('Test') {
            steps {
		script	{
                   echo 'Testing...'
		   ./gradlew test
		}
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
