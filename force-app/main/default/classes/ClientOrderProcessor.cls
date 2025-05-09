@RestResource(urlMapping='/CustomerOrder/*')
global with sharing class REST_CustomerOrder {

    @HttpGet
    global static List<CustomerOrder__c> getOrders() {
        try {
            return [SELECT Id, name__c, OrderQuantity__c, BagSize__c FROM CustomerOrder__c];
        } catch (Exception e) {
            System.debug('Error fetching orders: ' + e.getMessage());
            return new List<CustomerOrder__c>();
        }
    }

    @HttpPost
    global static String CreateNewCustomerOrder(String name, Integer OrderQuantity, String BagSize) {
        try {
            // Create new CustomerOrder record
            CustomerOrder__c newOrder = new CustomerOrder__c(Name__c = name, OrderQuantity__c = OrderQuantity, BagSize__c = BagSize);
            insert newOrder;

            // Return JSON response
            return '{"message": "Customer Order Created Successfully", "id": "' + newOrder.Id + '"}';
        } catch (Exception e) {
            return '{"error": "' + e.getMessage() + '"}';
        }
    }

    @HttpPut
    global static String UpdateCustomerOrder(String orderId, String name, Integer OrderQuantity, String BagSize) {
        try {
            // Fetch the existing Customer Order record
            CustomerOrder__c updatedOrder = [SELECT Id, name__c, OrderQuantity__c, BagSize__c FROM CustomerOrder__c WHERE Id = :orderId LIMIT 1];

            updatedOrder.name__c = name;
            updatedOrder.OrderQuantity__c = OrderQuantity;
            updatedOrder.BagSize__c = BagSize;

            update updatedOrder;

            // Return JSON response
            return '{"message": "Customer Order Updated Successfully", "id": "' + updatedOrder.Id + '"}';
        } catch (Exception e) {
            return '{"error": "' + e.getMessage() + '"}';
        }
    }

    @HttpDelete
    global static String DeleteCustomerOrder() {
        RestRequest req = RestContext.request;
        String orderId = req.requestURI.substring(req.requestURI.lastIndexOf('/') + 1);

        try {
            delete [SELECT Id FROM CustomerOrder__c WHERE Id = :orderId LIMIT 1];
            return '{"message": "Customer Order Deleted Successfully"}';
        } catch (Exception e) {
            return '{"error": "' + e.getMessage() + '"}';
        }
    }
}
