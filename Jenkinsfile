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
        /******************ANALYZE**********************/
        stage('Analyze') {
            steps {
                script	{
                   echo 'Building...'
                   sh './gradlew sonarqube -Dsonar.host.url=sonarqube:9000'
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
