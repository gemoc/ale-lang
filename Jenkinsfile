// Pipeline using declarative syntax
// you can fall down to script syntax using the script { } command 
pipeline {
	agent any
	options {
		buildDiscarder( logRotator(numToKeepStr:'60', artifactNumToKeepStr: '1'))
	}
	tools {
        	maven 'apache-maven-latest'
        	jdk 'oracle-jdk8-latest'
	}
	// 
	stages {
		
		stage('Build and verify') {
	    	steps { 
				wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
					sh "mvn -Dmaven.test.failure.ignore clean verify --errors --show-version"
				}
			}
			post {
				success {
					junit 'tests/**/target/surefire-reports/TEST-*.xml' 
				}
			}
	 	}
		stage("Archive in Jenkins") {
			steps {
				echo "archive artifact"
				archiveArtifacts 'releng/org.eclipse.emf.ecoretools.ale.updatesite/target/repository/**, **/screenshots/**'
			}
		}
		stage("Deploy") {
			when { tag "release-*"}
			steps{
				withAnt(installation: 'Ant_1.8.4') {
				    sh "ant -Dkey.file=/builds/.ssh/id_rsa -f releng/promotion_build.xml upload"
				}
			}
		}
	}
	post { 
        fixed { // back to normal
            emailext 	subject: 'Build $BUILD_STATUS $PROJECT_NAME #$BUILD_NUMBER!', 
			            body: '''Check console output at $BUILD_URL to view the results.''',
			            recipientProviders: [[$class: 'CulpritsRecipientProvider'],[$class: 'RequesterRecipientProvider']], 
			            to: 'didier.vojtisek@inria.fr'
        }
		// changed { }
		unstable {
			echo 'Unstable' 
            emailext 	subject: 'Build $BUILD_STATUS $PROJECT_NAME #$BUILD_NUMBER!', 
			            body: '''Check console output at $BUILD_URL to view the results.''',
			            recipientProviders: [[$class: 'CulpritsRecipientProvider'],[$class: 'RequesterRecipientProvider']], 
			            to: 'didier.vojtisek@inria.fr'
		}
		failure {
			echo 'Failure' 
            emailext 	subject: 'Build $BUILD_STATUS $PROJECT_NAME #$BUILD_NUMBER!', 
			            body: '''Check console output at $BUILD_URL to view the results.''',
			            recipientProviders: [[$class: 'CulpritsRecipientProvider'],[$class: 'RequesterRecipientProvider']], 
			            to: 'didier.vojtisek@inria.fr'
		}
	}
}
