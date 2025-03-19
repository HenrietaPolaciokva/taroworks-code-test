# TaroWorks Code Test

# Part 0: Coding Environment

This test will require:
1. A local Java environment, v17+ (https://www.java.com/en/download/help/download_options.html) 
2. Access to a web browser (Chrome is recommended)
3. An Android Development Environment (https://developer.android.com/studio)
4. Salesforce CLI Tools (https://developer.salesforce.com/docs/atlas.en-us.sfdx_setup.meta/sfdx_setup/sfdx_setup_install_cli.htm)
5. (Optional but helpful) VSCode (https://code.visualstudio.com/)
6. (Optional but helpful) VSCode Extensions for Salesforce (https://marketplace.visualstudio.com/items?itemName=salesforce.salesforcedx-vscode)
7. (Optional) POSTMan for API Testing  (https://www.postman.com/)
8. (Optional) If you are on windows, a way to run the "cURL" command such as git-scm (https://git-scm.com/downloads/win)
9. Git or a tool to interact with git
10. A github account (your final solution will need to be uploaded to github)

## Salesforce Environment

You have already received an email with your scratch org credentials. You can use these credentials to login and configure the salesforce scratch org. The environment will be deleted within a month of your code test, you can treat it as “yours” and make any changes you wish (please do not change the admin password or add multi-factor authentication as this may complicate scoring). The environment will be checked automatically to verify functionality and your code will be reviewed both in your submission and within the salesforce org.

 Note that the pre-configured URL ("fun-momentum-8899-dev-ed") is for demonstration only and should not be used in your submission - use the credentials sent via email instead.

 This cURL command demonstrates the API - replace the URL with your scratch org to verify that your org is configured properly. Also included in this repository are POSTMan tests that accomplish the same task.

```
curl --location --request POST 'https://fun-momentum-8899-dev-ed.scratch.my.salesforce-sites.com/services/apexrest/ClientOrderProcessor?name=TaroDev'
```

## Java Environment

You have been provided a Java command line starter template. The included code will call the Salesforce API described using this syntax:

```
java java/CallAPIClass.java TaroDev 
```

## Javascript Environment

The javascript folder includes a file "CallAPIClass.html". This can be opened in the Chrome browser.

# Part 1: General Coding/API Knowledge

## Application Security

There are a number of security issues with this repository. Identify at least 5, rank them in severity and explain how you would mitigate them.

## Salesforce API

The API included in ClientOrderProcessor.cls has a number of stylistic issues. Identify at least 4 and explain how you would improve them.

## Java Code

Modify the java code to parse and display JSON results in a table, printed to the command line.

## Frontend Debugging

The Javascript in 'javascript/CallAPIClass.html' will not work in your environment (attempting to POST with the current code will throw an error). Solve and explain the error. 
We recommend that you first test with the provided cURL or Java code to confirm that both salesforce and your network are configured correctly.

# Part 2: Salesforce API Logic

Implement an APEX Controller that will respond to GET requests for an API

> You are designing a system to distribute bags of fertilizer to clients. Fertilizer can be purchased from a supplier in increments of 10 kg, 5 kg and 1 kg. Client orders may be any positive integer value (for example, 26 kg). Write an algorithm to calculate how many bags of each weight of fertilizer should be given to each client to fulfill their order.

## Instructions

At minimum, you should:
1. Create custom objects to represent the relevant logic of the problem (such as client orders and bag sizes). In a real salesforce org you would use built-in standard objects, but for this test you should use only custom objects in your solution (we aren’t testing knowledge of salesforce objects, but we are testing your ability to follow instructions).
2. Modify the APEX ClientOrderProcessor function to take relevant inputs and perform any necessary calculations, using the custom objects you created
3. Modify the Java Code to call your API appropriately and display the result in the command line

## Bonus Points (Android):
1. Create a Simple Android Application to act as a frontend (calling the Salesforce API based on user-submitted data)


## Bonus Points (Logic):
1. Rewrite your algorithm to minimize the number of total bags given per client (for example, if fertilizer is distributed in bags of 9 kg, 6 kg, 5 kg and 1 kg and a client orders 11 kg - your algorithm should recommend 6 kg and 5 kg instead of 9 kg and 2x1 kg bags).
2. Include relevant Unit Tests and Integration Tests for your solution
3. Validate any inputs for possible edge cases and security vulnerabilities

## Bonus Points (General)
1. Using the same APEX code for the backend logic, write a Web Frontend (Javascript, JS library of your choice, Visualforce, Lightning Web Component view or a Salesforce Screen Flow) to take input and display the same results
2. Demonstrate how you would migrate your code between environments using Salesforce CLI tools, including the commands to do so
3. Currently the APEX, Java and JS projects are all contained in one file each within the same repository. Describe how you would organize the project and justify your logic.

# Materials to submit:
1. A copy of your code uploaded to a new github repository
2. Any Salesforce Custom Objects and frontends, in the format of your choice (Bonus points for use of the CLI to do this)
3. Documentation (in markdown format), including which objectives you did/did not complete and an explanation of how your code works as well as your answers to the questions above.

Make sure that the github repository is shared with the github account in the intro email and send a link to this repository via email by the code test deadline (within 24 hours of the code test starting, the exact time will be included in the email). Any work committed to the github repository/uploaded to the scratch org after the deadline will not be considered.

## Notes 
1. **If you use generative AI for any part of this exercise, cite it as a source and indicate which parts of your response were written this way. Also include an explanation of what you did to verify the accuracy/safety of the code/answers generated by AI.**

2. In general you should focus on logic and coding best practices, not demonstrating salesforce knowledge.
3. If you proceed to the next round of interviews, you will be expected to explain and modify your solution on a call.
