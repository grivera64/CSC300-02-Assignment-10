//package assignment10;

/*
 *
 * Name: AccessEntriesFromLinkedHashMapExample.java
 * Purpose: Tests how Linked HashMaps work with replacing and
 *          checking contents
 * Author: grivera64
 * Date: 11/24/2021
 *
 */

import java.util.LinkedHashMap;
import java.util.Map;

public class AccessEntriesFromLinkedHashMapExample {

    public static void main(String[] args) {

        Map<Integer, String> customerIdNameMapping = new LinkedHashMap<>();

        customerIdNameMapping.put(1001, "Jack");
        customerIdNameMapping.put(1002, "David");
        customerIdNameMapping.put(1003, "Steve");
        customerIdNameMapping.put(1004, "Alice");
        customerIdNameMapping.put(1005, "Marie");

        System.out.printf("customerIdNameMapping : %s\n\n", customerIdNameMapping);

        /* Find customer 1005 */
        if (customerIdNameMapping.containsKey(1005)) {

            System.out.printf("Found the customer with the id %d: %s\n\n", 1005, customerIdNameMapping.get(1005));

        } else {

            System.out.printf("Customer with id %d does not exist\n\n", 1005);

        }

        /* Find customer 1007 */
        if (customerIdNameMapping.containsKey(1007)) {

            System.out.printf("Found the customer with the id %d: %s\n\n", 1007, customerIdNameMapping.get(1007));

        } else {

            System.out.printf("Customer with id %d does not exist\n\n", 1007);

        }

        if (customerIdNameMapping.containsValue("David")) {

            System.out.printf("A customer named %s exists in the map\n\n", "David");

        } else {

            System.out.printf("No customer found with name %s in the map\n\n", "David");

        }

        if (customerIdNameMapping.containsValue("Lucy")) {

            System.out.printf("A customer named %s exists in the map\n\n", "Lucy");

        } else {

            System.out.printf("No customer found with name %s in the map\n\n", "Lucy");

        }

        customerIdNameMapping.put(1004, "Bob");
        System.out.printf("Changed the name of customer with id %d, New Mapping : %s\n", 1004, customerIdNameMapping);

    }

}
