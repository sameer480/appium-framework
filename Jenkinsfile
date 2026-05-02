pipeline {
    agent any


    environment {
        ANDROID_HOME = 'C:\\Users\\Sameer\\AppData\\Local\\Android\\Sdk'
        PATH = "${env.ANDROID_HOME}\\platform-tools;${env.PATH}"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main'
                git url: 'https://github.com/sameer480/appium-framework.git'
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