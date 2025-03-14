#Note that you will need the SF CLI utilities and a registered dev hub to run this command
sf org create scratch -f ./config/project-scratch-def.json --duration-days 30 -w 10 -a code-test-org -v prod-dev-hub
sf project deploy start --target-org code-test-org -w 10 