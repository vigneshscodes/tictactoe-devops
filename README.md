# TicTacToe DevOps Pipeline

This project demonstrates a complete CI/CD pipeline for a Java-based TicTacToe application using various DevOps tools.

## Overview

The pipeline includes:

- Source Control: GitHub
- Build: Maven
- Testing: JUnit
- Containerization: Docker
- Orchestration: Docker Compose
- Configuration Management: Ansible
- Monitoring: Graphite and Grafana
- CI/CD: Jenkins

## Pipeline Steps

1. Checkout code from GitHub
2. Build and package the application with Maven
3. Run unit tests with JUnit
4. Build Docker image
5. Deploy monitoring tools (Graphite, Grafana) via Docker Compose
6. Deploy the application with Ansible
7. Send deployment metrics to Graphite

## Project Structure

- `Jenkinsfile`: Defines the pipeline stages
- `Dockerfile`: Builds the application image
- `docker-compose.yml`: Sets up monitoring containers
- `ansibleExercises/`: Ansible playbook and inventory
