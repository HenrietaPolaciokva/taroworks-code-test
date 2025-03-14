@RestResource(urlMapping='/ClientOrderProcessor/*')
global with sharing class ClientOrderProcessor {


    //This is just an example of a GET method, replace it with your own code
    @HttpGet
    global static String doGet() {
        String name = RestContext.request.params.get('name');
        return 'Hello '+name;
    }
}