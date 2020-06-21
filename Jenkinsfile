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
                   sh './gradlew -i test jacocoTestReport'
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
