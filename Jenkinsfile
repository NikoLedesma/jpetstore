pipeline {
    agent any

    stages {

        /******************ANALYZE**********************/
        stage('Analyze') {
            steps {
                script	{
                   echo 'Building...'
                   sh './gradlew jacocoTestReport sonarqube -Dsonar.host.url=http://sonarqube:9000'
                }
            }
        }

        /******************BUILD*******************/
        stage('Build') {
            steps {
                script	{
                   echo 'Building...'
                   sh './gradlew build'
                }
            }
        }

        /*******************TEST**********************/
        stage('Test') {
            steps {
                script	{
                   echo 'Testing...'
                   sh './gradlew test'
                }
            }
        }

        /*******************DEPLOY**********************/
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
