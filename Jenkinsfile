pipeline {
    agent any

    tools {
        maven 'Maven3'   // configure in Jenkins
        jdk 'Java17'     // configure in Jenkins
    }

    environment {
        ANDROID_HOME = 'C:\\Users\\Sameer\\AppData\\Local\\Android\\Sdk'
        PATH = "${env.ANDROID_HOME}\\platform-tools;${env.PATH}"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-repo/appium-framework.git'
            }
        }

        stage('Start Appium Server') {
            steps {
                bat 'start /B appium'
            }
        }

        stage('Wait for Server') {
            steps {
                bat 'timeout /t 10'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.xml', allowEmptyArchive: true
        }
    }
}