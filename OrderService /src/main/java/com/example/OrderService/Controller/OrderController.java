package com.example.OrderService.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/order")
//public class OrderController {
//    @GetMapping("/id")
//    public String getID(@RequestParam String id) {
//        return id;
//    }
//}




import com.example.OrderService.Client.UserServiceClient;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final UserServiceClient userServiceClient;

    public OrderController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/user")
    public String getUserInfo(@RequestParam String id)throws InterruptedException  {
//        Thread.sleep(3000);
//        return userServiceClient.getUserById(id)+" Order Received";
        try {
            long startTime = System.currentTimeMillis();
            long waitTime = 3000;  // 3 seconds

            // Loop for 3 seconds
            while (System.currentTimeMillis() - startTime < waitTime) {
                // You can perform some logic here if needed
            }

            // Throw an exception after 3 seconds
            if (true) {  // You can replace this condition with your custom logic
                throw new RuntimeException("Simulated exception after 3 seconds");
            }
        } catch (RuntimeException e) {
            return "An error occurred: " + e.getMessage();
        }
        return userServiceClient.getUserById(id) + " Order Received";

    };
}
