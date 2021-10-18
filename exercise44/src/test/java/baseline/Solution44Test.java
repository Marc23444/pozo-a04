package baseline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution44Test {

    @Test
    void testCheckInventory() {

        Solution44 testObject = new Solution44();

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Widget",25,5));
        products.add(new Product("Thing",15,5));
        products.add(new Product("Doodad",5,10));

        String testItem = "Thing";

        Assertions.assertTrue(testObject.checkInventory(products,testItem));

    }

    @Test
    void testDeserializeJson() {

        Solution44 testObj = new Solution44();

        ArrayList<String> testStrings = new ArrayList<>();
        testStrings.add("{\"name\": \"Widget\", \"price\": 25.00, \"quantity\": 5 }");

        ArrayList<Product> expectedProduct = new ArrayList<>();
        expectedProduct.add(new Product("Widget",25,5));

        ArrayList<Product> testProducts = testObj.deserializeJson(testStrings);


        Assertions.assertEquals(expectedProduct.get(0).getName(),testProducts.get(0).getName());
        Assertions.assertEquals(expectedProduct.get(0).getPrice(),testProducts.get(0).getPrice());
        Assertions.assertEquals(expectedProduct.get(0).getQuantity(),testProducts.get(0).getQuantity());
    }
}