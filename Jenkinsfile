pipeline {
    agent any

    stages {
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

        /******************ANALYZE**********************/
        stage('Analyze') {
            steps {
                script	{
                   echo 'Building...'
                   sh './gradlew jacocoTestReport sonarqube -Dsonar.host.url=http://sonarqube:9000'
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
