pipeline {
    agent any

    stages {
        stage('1: Git') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/khaveesh/ScientificCalculator.git'
            }
        }
        
        stage('2: Maven') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            // post {
            //     // If Maven was able to run the tests, even if some of the test
            //     // failed, record the test results and archive the jar file.
            //     success {
            //         junit '**/target/surefire-reports/TEST-*.xml'
            //         archiveArtifacts 'target/*.jar'
            //     }
            // }
        }
        
        stage('3: Docker Image') {
            steps {
                script {
                    docker_image = docker.build("khaveesh/scientific-calculator:latest")
                }
            }
        }
        
        stage('4: Push Docker Image') { 
            steps {
                script {
                    docker.withRegistry('', "docker-cred") {
                        docker_image.push()
                    }
                }
            }
        }
        
        stage('5: Ansible') {
            steps {
                script {
                    ansiblePlaybook colorized: false, disableHostKeyChecking: true, installation: 'Ansible', inventory: './deploy/inventory', playbook: './deploy/playbook.yml'
                }
            }
        }
    }
}
