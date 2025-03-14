@RestResource(urlMapping='/ClientOrderProcessor/*')
global with sharing class ClientOrderProcessor {


    //This is just an example of a POST method, replace it with your own code
    @HttpPost
    global static String doGet() {
        String name = RestContext.request.params.get('name');
        return '{"message": "Hello ' + name + '!"}';
    }
}