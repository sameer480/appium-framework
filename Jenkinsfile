pipeline {
    agent any

    environment {
        ANDROID_HOME = 'C:\\Users\\Sameer\\AppData\\Local\\Android\\Sdk'
        PATH = "${ANDROID_HOME}\\platform-tools;${env.PATH}"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/sameer480/appium-framework.git'
            }
        }

        stage('Start Appium Server') {
            steps {
                bat 'start "" /B appium'
            }
        }

        stage('Wait for Server') {
            steps {
                bat 'ping 127.0.0.1 -n 15 > nul'
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
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
        }
    }
}