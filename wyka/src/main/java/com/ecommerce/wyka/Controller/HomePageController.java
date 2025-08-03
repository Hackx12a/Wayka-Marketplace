//package com.ecommerce.wyka.Controller;
//
//
//import com.ecommerce.wyka.Dto.ItemDto;
//import com.ecommerce.wyka.Services.ItemsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class HomePageController {
//
//
//    @Autowired
//    private ItemsService itemsService;
//
//
//    @GetMapping("/Home")
//    public ResponseEntity<List<ItemDto>> getAllItems() {
//        try {
//            // 2. Fetch all items from all users from your service
//            List<ItemDto> allItems = itemsService.getAllItemsFromAllUsers();
//
//            // 3. Return the list with OK status
//            return ResponseEntity.ok(allItems);
//        } catch (Exception e) {
//            // 4. Handle any exceptions
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//
//
//}
