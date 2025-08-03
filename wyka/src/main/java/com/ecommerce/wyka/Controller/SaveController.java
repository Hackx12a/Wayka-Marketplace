//package com.ecommerce.wyka.Controller;
//
//
//import com.ecommerce.wyka.Services.SaveService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/Item")
//public class SaveController {
//
//    @Autowired
//    private SaveService saveService;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////    @PostMapping("{itemId}/saveItem")
////    public ResponseEntity<ItemDto> saveItemById(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable int itemId){
////
////        Users currentUser = userPrincipal.getUser();
////        Items item = saveService.getItemById(itemId);
////
////
////        SaveListingItems saveListingItems = saveService.addItemToSave(currentUser, item);
////        return ResponseEntity.status(HttpStatus.CREATED).body(new ItemDto(saveListingItems.getItem()));
////
////    }
////
////
////
////
////    @GetMapping("/mysave")
////    public ResponseEntity<List<ItemDto>> getSaveItem(@AuthenticationPrincipal UserPrincipal userPrincipal) {
////        Users currentUser = userPrincipal.getUser();
////        List<SaveListingItems> saveItems = saveService.findByUser(currentUser);
////
////        List<ItemDto> itemDtos = saveItems.stream()
////                .map(saveItem -> new ItemDto(saveItem.getItem())) // Assuming saveItem has a method getItem()
////                .collect(Collectors.toList());
////
////        return ResponseEntity.ok(itemDtos);
////    }
//
//
//
//
//
//
//}
