import groovy.json.JsonSlurper

if (manager.getResult() == 'FAILURE')
    return

def jsonReport = manager.build.getWorkspace().child('results-checker-report.json').readToString()
def testResults = new JsonSlurper().parseText(jsonReport)

def summary

if (testResults.unknownFailures == 0 && testResults.regressions == 0) {
    summary = manager.createSummary("help.gif")
    manager.build.@result = hudson.model.Result.SUCCESS
} else {
    summary = manager.createSummary("warning.gif")
}

def status = "<ul> <li> <b>Known issues: </b>" + testResults.knownFailures + "</li>" +
        "<li> <b>Unkown failures </b>:" + testResults.unknownFailures + "</li> " +
        "<li> <b>Regressions </b>:" + testResults.regressions + "</li> </ul>"

summary.appendText(status, false, false, false, "black")
manager.addShortText(status, "grey", "white", "0px", "grey")

