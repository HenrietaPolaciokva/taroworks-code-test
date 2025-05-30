#This script is used to setup a new scratch environment, you will not need to run it for the code test unless you wish to create a separate scratch org for testing

#Note that you will need the SF CLI utilities and a registered dev hub to run this command
sf org create scratch -f ./config/project-scratch-def.json --duration-days 30 -w 10 -a code-test-org -v prod-dev-hub
sf project deploy start --target-org code-test-org -w 10 

#You can ignore these steps unless you are creating a new scratch org
sf org open --target-org code-test-org
# 1. Create a new Force.com site (Setup -> Sites -> New Site)
# 2. After creating the site, edit "Public Access Settings" and add "Enabled Apex Class Access" to it
# 3. Activate the site and test from POSTMan or similar tool
# 4. Set the IP Login Range for the Sysadmin profile to "Open" (Setup -> Profiles -> System Administrator -> Login IP Ranges -> add from 0.0.0.0 to 255.255.255.255)

#Generate a password and save the username and password for the scratch org
sfdx force user password generate --target-org code-test-org 
sfdx org display user --target-org code-test-org > code-test-org-$(date -u +"%Y%m%d%H%M%S").txt