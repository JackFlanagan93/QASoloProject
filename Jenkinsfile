pipeline{
        agent any
        stages{
                stage('--Package--'){
                        steps{
                                sh "mvn package"
                        }
                }
		stage('--Sonar Report--'){
                        steps{
                                sh "mvn sonar:sonar"
                        }
                }
		stage('--Surefire Report--'){
                        steps{
                                sh "mvn surefire-report:report"
				sh "mvn site"
                        }
                }
		stage('--Deploy To Wildfly--'){
                        steps{
                                sh "cd /"
				sh "pwd"
                                sh "sudo cp /var/lib/jenkins/workspace/pipline/target/MotoGPManager.war /home/jack_flanagan93/wildfly-10.1.0.Final/standalone/deployments/"
                        }
                }

                stage('--Email--'){
                        steps{
                                emailext attachLog: true, attachmentsPattern: 'target/site/jacoco/index.html, target/site/surefire-report.html', body: '$BUILD_STATUS!', subject: '$BUILD_STATUS! - $PROJECT_NAME - Build # $BUILD_NUMBER ', to: 'jack.flanagan93@outlook.com cc:jenkinsvirtualmachine@gmail.com'
                        }
                }
        }
}
