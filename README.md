# TaroWorks Code Test

# Part 0: Coding Environment

This test will require:
1. A local Java environment (https://www.java.com/en/download/help/download_options.html)
2. Access to a web browser (Chrome is recommended)
3. An Android Development Environment (https://developer.android.com/studio)
4. Salesforce CLI Tools (https://developer.salesforce.com/docs/atlas.en-us.sfdx_setup.meta/sfdx_setup/sfdx_setup_install_cli.htm)
5. (Optional but helpful) VSCode (https://code.visualstudio.com/)
6. (Optional but helpful) VSCode Extensions for Salesforce (https://marketplace.visualstudio.com/items?itemName=salesforce.salesforcedx-vscode)
7. (Optional) POSTMan for API Testing  (https://www.postman.com/)
8. (Optional) If you are on windows, a way to run the "cURL" command such as git-scm (https://git-scm.com/downloads/win)

## Salesforce Environment

You will have received an email with your scratch org credentials. You can use these credentials to login and configure the salesforce scratch org. The environment will be deleted within a month of your code test, you can treat it as “yours” and make any changes you wish. The environment will be checked automatically to verify functionality and your code will be reviewed.

 Note that the pre-configured URL ("fun-momentum-8899-dev-ed") is for demonstration only and should not be used in your submission - use the credentials sent via email instead.

```
curl --location --request POST 'https://fun-momentum-8899-dev-ed.scratch.my.salesforce-sites.com/services/apexrest/ClientOrderProcessor?name=TaroDev'
```

## Java Environment

You have been provided a Java command line utility. The included code will call the Salesforce API described using syntax like:

```
java java/CallAPIClass.java TaroDev 
```

## Javascript Environment

The javascript folder includes a file "CallAPIClass.html". This can be opened in the Chrome browser (it may work in others, it's only been tested in Chrome). 

# Part 1: General Coding/API Knowledge

## Application Security

There are a number of security issues with this repository. Identify at least 5, rank them in severity and explain how you would mitigate them.

## Salesforce API

The API included here has a number of stylistic issues. Identify at least 4 and explain how you would improve them.

## Frontend Debugging

The Javascript in 'javascript/CallAPIClass.html' will not work in your environment (attempting to POST with the current code will throw an error). Solve and explain the error. 
We recommend that you first test with the provided cURL or Java code to confirm that both salesforce and your network are configured correctly.

# Part 2: Salesforce API Logic

Implement an APEX Controller that will respond to GET requests for an API

> You are designing a system to distribute bags of fertilizer to clients. Fertilizer can be purchased from a supplier in increments of 10 kg, 5 kg and 1 kg. Client orders may be any positive integer value (for example, 26 kg). Write an algorithm to calculate how many bags of each weight of fertilizer should be given to each client to fulfill their order.

## Instructions

At minimum, you should:
1. Create custom objects to represent the relevant logic of the problem (such as client orders and bag sizes). In a real salesforce org you would use built-in standard objects, but for this test you should use only custom objects in your solution (we aren’t testing knowledge of salesforce objects, but we are testing your ability to follow instructions).
2. Modify the APEX API function to take relevant inputs and perform any necessary calculations
3. Modify the Java Code to call your API appropriately and display the result in the command line

## Bonus Points (Android):
1. Create a Simple Android Application to run the same Java code (calling the Salesforce API)


## Bonus Points (Logic):
1. Rewrite your algorithm to make the bag sizes dynamic
2. Rewrite your algorithm to minimize the number of total bags given per client (for example, if fertilizer is distributed in bags of 9 kg, 6 kg, 5 kg and 1 kg and a client orders 11 kg - your algorithm should recommend 6 kg and 5 kg instead of 9 kg and 2x1 kg bags).
3. Include relevant Unit Tests and Integration Tests for your solution
4. Validate any inputs for possible edge cases

## Bonus Points (General)
1. Using the same APEX function, write a Frontend (Javascript, JS library of your choice, Visualforce, Lightning Web Component view or a Salesforce Screen Flow) to take input and display the same results
2. Demonstrate how you would migrate your code between environments using Salesforce CLI tools, including the commands to do so
3. Currently the APEX, Java and JS projects are all contained in one file each within the same repository. Describe how you would organize the project and justify your logic.

## Materials to submit:
1. A copy of your code
2. Any Salesforce Custom Objects and frontends, in the format of your choice (Bonus points for use of the CLI to do this)
3. Documentation (in markdown format), including which objectives you did/did not complete and an explanation of how your code works

Include all relevant material in a zip file and submit it using an email

## Notes 
1. **If you use generative AI for any part of this exercise, cite it as a source and include the line numbers for the code written this way. Also include an explanation of what you did to verify the accuracy/safety of the code generated by AI.**

2. In general you should focus on logic and coding best practices, not demonstrating salesforce knowledge.
3. You will be expected to explain and modify your solution on a call
