pipeline {
    agent any
    
     

    stages {
	
	stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/mdashub/MFS_Jenkins.git'
            }
        
		}
		
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}