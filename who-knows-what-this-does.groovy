def includes = "Run includes: "
if (manager.getEnvVariable('STABLE_SUBSET') != 'true'){
    manager.addBadge("//raw.githubusercontent.com/jenkinsci/jenkins/master/war/src/main/webapp/images/16x16/attribute.png", "Run includes unstable tests")
    includes = includes + "stable tests, unstable tests"
}
else {
    includes = includes + "stable tests"
}


manager.addBadge("//design.jboss.org/wildfly/logo/final/wildfly_icon_64px.png", "Run includes integration tests")
includes = includes + ", integration tests"
if (manager.getEnvVariable('BROKER_TESTS') == 'true'){
    manager.addBadge("//signalfx.github.io/images/repos/collectd-activemq/img/integrations_activemq%402x.png", "Run includes broker tests")
    includes = includes + ", broker tests"
}

manager.createSummary("attribute.png").appendText(includes, false, false, false, "black")
