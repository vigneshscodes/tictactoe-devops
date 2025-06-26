pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'git@github.com:vigneshscodes/tictactoe-devops.git'
      }
    }

    stage('Build with Maven') {
      steps {
        sh 'mvn clean package'
      }
    }

    stage('Run Unit Tests') {
      steps {
        sh 'mvn test'
      }
      post {
        always {
          junit '**/target/surefire-reports/*.xml'
        }
      }
    }

    stage('Docker Build') {
      steps {
        sh 'docker build -t tictactoe-app .'
      }
    }

    stage('Docker Compose Deploy') {
      steps {
        dir('monitoring') {
          sh 'docker compose up -d'
        }
      }
    }

    stage('Ansible Deploy') {
      steps {
        dir('ansibleExercises') {
          sh 'ansible-playbook tictactoe_playbook.yml -i inventory.ini'
        }
      }
    }

    stage('Send Metric to Graphite') {
      steps {
        sh 'echo "tictactoe.deploy.success 1 $(date +%s)" | nc 172.19.0.2 2003'
      }
    }
  }

  post {
    success {
      echo ' Deployment successful!'
    }
    failure {
      echo ' Deployment failed.'
    }
  }
}

