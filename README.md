TicTacToe DevOps Pipeline
This project demonstrates a complete CI/CD pipeline for a Java-based TicTacToe application using various DevOps tools.

Overview
The pipeline includes:
Source Control: GitHub
Build: Maven
Testing: JUnit
Containerization: Docker
Orchestration: Docker Compose
Configuration Management: Ansible
Monitoring: Graphite and Grafana
CI/CD: Jenkins

Pipeline Steps
Checkout code from GitHub
Build and package the application with Maven
Run unit tests with JUnit
Build Docker image
Deploy monitoring tools (Graphite, Grafana) via Docker Compose
Deploy the application with Ansible
Send deployment metrics to Graphite

Project Structure
Jenkinsfile: Defines the pipeline stages
Dockerfile: Builds the application image
docker-compose.yml: Sets up monitoring containers
ansibleExercises/: Ansible playbook and inventory

Notes
Graphite and Grafana are configured to visualize deployment metrics. The Grafana dashboard can be set up manually by importing a JSON model.
