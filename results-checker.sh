#!/usr/bin/env bash
# Add script to mount an NFS with an AS-TS results XML.

                # Runs Results Checker (copied from eap-7.x-messaging-nightly-cluster)
                export SERVER_NAME=place.holder
                export PACKAGE="org.jboss.qe.as" # Save Java filters here
                export REPORTS_DIRECTORY=$WORKSPACE/**/target/surefire-reports/*.xml
                export SHORTEN_JUNIT_REPORT=true
                export $CLIENT_MODE=false

                cd $WORKSPACE/filters # Fill in where the filters and POM are going to be.

                mvn clean package exec:exec

                mv $WORKSPACE/filters/results-checker-report.html $WORKSPACE
                mv $WORKSPACE/filters/results-checker-report.json $WORKSPACE # Fill in proper paths.
