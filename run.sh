#!/usr/bin/env bash
######
# WARNING!!! Set Working directory to: /home/pkremens/devel/tests-jobs/
######

OUTPUT=$(realpath output)
#rm -f ${OUTPUT}/* ; jenkins-jobs --conf config-eap.ini test . *eap-7.x-panda\|bambus\)-* -o ${OUTPUT} ; ls -l ${OUTPUT}/
rm -f ${OUTPUT}/*
jenkins-jobs --conf config-eap.ini test *server-mode-results-checker* -o ${OUTPUT}
#jenkins-jobs --conf config-eap.ini test . *eap-7.x-bambus* -o ${OUTPUT}
ls -l ${OUTPUT}/

for FILE in $(ls ${OUTPUT}/*) ; do echo -e "\n${FILE}:\n" ; cat $FILE ; echo -e "\n#################" ; done  ; ls -l ${OUTPUT}/

export PYTHONHTTPSVERIFY=0

jenkins-jobs --conf config-eap.ini update  *server-mode-results-checker*
#jenkins-jobs --conf config-eap.ini update . *eap-7.x-bambus*
#
#echo "##############   eap-7.x-panda-example-single"
## https://eap-qe-jenkins.rhev-ci-vms.eng.rdu2.redhat.com/view/EAP7/view/EAP7-Panda/job/eap-7x-panda-example-single/config.xml
#diff $OUTPUT/eap-7.x-panda-example-single /tmp/panda/eap-7x-panda-example-single.xml
#echo ''
#echo "##############   eap-7.x-panda-example-matrix"
## https://eap-qe-jenkins.rhev-ci-vms.eng.rdu2.redhat.com/view/EAP7/view/EAP7-Panda/job/eap-7x-panda-example-matrix/config.xml
#diff $OUTPUT/eap-7.x-panda-example-matrix /tmp/panda/eap-7x-panda-example-matrix.xml
#echo ''
#echo "##############   eap-7.x-panda-testcase-upload"
## https://eap-qe-jenkins.rhev-ci-vms.eng.rdu2.redhat.com/view/EAP7/view/EAP7-Panda/job/eap-7x-panda-testcase-upload/config.xml
#diff $OUTPUT/eap-7.x-panda-testcase-upload /tmp/panda/eap-7x-panda-testcase-upload.xml
#echo ''
#echo "##############   eap-7.x-panda-testrun-upload"
## https://eap-qe-jenkins.rhev-ci-vms.eng.rdu2.redhat.com/view/EAP7/view/EAP7-Panda/job/eap-7x-panda-testrun-upload/config.xml
#diff $OUTPUT/eap-7.x-panda-testrun-upload /tmp/panda/eap-7x-panda-testrun-upload.xml