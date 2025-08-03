////package com.ecommerce.wyka.Services;
////
////import com.ecommerce.wyka.Repository.ItemsRepository;
////import com.ecommerce.wyka.Repository.SaveItemsRepository;
////import com.ecommerce.wyka.Repository.SaveRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////@Service
////public class SaveService {
////    @Autowired
////    private SaveItemsRepository saveItemsRepository;
////
////    @Autowired
////    private SaveRepository saveRepository;
////
////    @Autowired
////    private ItemsRepository itemsRepository;
////
////
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
////    public Items getItemById(int itemId) {
////        return itemsRepository.findById(itemId).orElse(null);
////    }
////
////    public SaveListingItems addItemToSave(Users currentUser, Items item) {
////        SaveCart save = saveRepository.findByUser(currentUser)
////                .orElseGet(() -> {
////                    SaveCart newSave = new SaveCart();
////                    newSave.setUser(currentUser);
////                    return saveRepository.save(newSave);
////                });
////
////        Optional<SaveListingItems> existingItem = save.getSaveListings().stream()
////                .filter(saveItem -> saveItem.getItem().getItemId() == item.getItemId())
////                .findFirst();
////
////        if (existingItem.isPresent()) {
////            return existingItem.get();
////        }
////
////        SaveListingItems saveItem = new SaveListingItems();
////        saveItem.setSaveCart(save);
////        saveItem.setItem(item);
////
////        save.getSaveListings().add(saveItem);
////        saveRepository.save(save);
////
////        return saveItem;
////    }
////
////    public List<SaveListingItems> findByUser(Users user) {
////        Optional<SaveCart> optionalSave = saveRepository.findByUser(user);
////        return optionalSave.map(SaveCart::getSaveListings).orElse(List.of());
////    }
//}


