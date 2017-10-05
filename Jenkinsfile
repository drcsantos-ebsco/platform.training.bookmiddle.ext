#!groovy
@Library("platform.infrastructure.jenkinslib")
import com.ebsco.platform.Shared


node("docker") {

    // Create a groovy library object from the Shared.groovy file.
    def shared = new com.ebsco.platform.Shared()

    // Ensure we start with an empty directory.
    deleteDir()

    // Checkout the repo from github
    stage ('checkout') {
        checkout scm
    }

    /*
     * Run gradle build tasks -- gradle assemble, test, build
     * Please ensure that gradle build invokes all of your gradle tasks
     * Stages: Compile, Test, Build
     */
    shared.gradleBuild()

    /* https://jenkins.io/blog/2016/07/01/html-publisher-plugin/ */
    publishHTML (target: [
            allowMissing: true,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'build/reports/jacoco/test/html',
            reportFiles: 'index.html',
            reportName: "Jacoco Report"
    ])

    /*
     * Builds the docker file, updates tags, publishes the new container to ecr
     * Stages: Build/Publish Docker
     */
    shared.dockerPublishDev()

    /*
     *
     * Deploy to ECS
     * Bare bones ECS deployment
     * Stages: Deploy to ECS
     */

    // useless comment
    // Big red button!
    shared.liveDeploymentGate()

    //DEVQA
    shared.basicECSDeploy("devqa")
}