//package com.ecommerce.wyka.Controller;
//
//import com.ecommerce.wyka.Dto.ItemDto;
//import com.ecommerce.wyka.Model.Item.Items;
//import com.ecommerce.wyka.Model.UserPrincipal;
//import com.ecommerce.wyka.Model.Users;
//import com.ecommerce.wyka.Services.ItemsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api")
//public class ProfileController {
//
//    @Autowired
//    private ItemsService itemsService;
//
//    @GetMapping("/my-items")
//    public List<ItemDto> getItemsForCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
//        Users currentUser = userPrincipal.getUser();
//        List<Items> userItems = itemsService.getItemsByUser(currentUser);
//
//        return userItems.stream()
//                .map(ItemDto::new)
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/my-items/{itemId}")
//    public ResponseEntity<?> getItemById(@PathVariable int itemId, @AuthenticationPrincipal UserPrincipal userPrincipal) {
//
//        Users currentUser = userPrincipal.getUser();
//        Optional<Items> item = itemsService.getItemByIdAndUser(itemId, currentUser);
//
//        if (item.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
//        }
//
//        return ResponseEntity.ok(new ItemDto(item.get()));
//    }
//
//}
