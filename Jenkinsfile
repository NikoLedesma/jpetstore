pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
		script	{
		   echo 'Building...'
		   sh './gradlew build'
		}
            }
        }
        stage('Test') {
            steps {
		script	{
                   echo 'Testing...'
		   sh './gradlew test'
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
