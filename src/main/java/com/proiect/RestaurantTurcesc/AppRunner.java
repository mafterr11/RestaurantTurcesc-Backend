package com.proiect.RestaurantTurcesc;

import com.proiect.RestaurantTurcesc.entities.Category;
import com.proiect.RestaurantTurcesc.entities.Product;
import com.proiect.RestaurantTurcesc.helpers.CategoryEnum;
import com.proiect.RestaurantTurcesc.repository.CategoryRepository;
import com.proiect.RestaurantTurcesc.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {
    private final CategoryRepository categoryRepository;
    private final ProductsRepository productsRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (categoryRepository.count() == 0) {
           List<Category> categoryList = new ArrayList<>();
           categoryList.add(new Category(1,CategoryEnum.SOUPS.toString()));
           categoryList.add(new Category(2,CategoryEnum.SALADS.toString()));
           categoryList.add(new Category(3,CategoryEnum.COLD_STARTERS.toString()));
           categoryList.add(new Category(4,CategoryEnum.HOT_STARTERS.toString()));
           categoryList.add(new Category(5,CategoryEnum.GRILL.toString()));
           categoryList.add(new Category(6,CategoryEnum.DESSERTS.toString()));
           categoryList.add(new Category(7,CategoryEnum.COFFEE.toString()));
           categoryList.add(new Category(8,CategoryEnum.DRINKS.toString()));
           categoryList.add(new Category(9,CategoryEnum.ALCOHOL.toString()));
           categoryRepository.saveAll(categoryList);
        }

        if(productsRepository.count() == 0) {
            List<Product> productList = new ArrayList<>();
            productList.add(new Product(1, "MERCIMEK CORBASI", 25.0, "Red Lentil Soup - red lentils, tomato paste, mint", (short)0, CategoryEnum.SOUPS));
            productList.add(new Product(2, "TAVUK CORBASI", 23.0, "Chicken Soup - vegetable soup with chicken meat", (short)0, CategoryEnum.SOUPS));
            productList.add(new Product(3, "SEBZELI CORBA", 24.0, "Vegetable Soup - celery, carrot, bell pepper, onion, potatoes, parsley", (short)0, CategoryEnum.SOUPS));
            productList.add(new Product(4, "BALIK CORBASI", 27.0, "Beef Soup - beef, vegetables, hot pepper", (short)0, CategoryEnum.SOUPS));


            productList.add(new Product(5, "GAVURDAGI SALATA", 22.0, "Tomatoes, cucumbers, onion, bell pepper, walnut, pomegranate sauce", (short)0, CategoryEnum.SALADS));
            productList.add(new Product(6, "TABOULEH", 25.0, "Parsley, tomatoes, mint, ground bulgur", (short)0, CategoryEnum.SALADS));
            productList.add(new Product(7, "FATUSH", 23.0, "Green salad, cucumbers, tomatoes, onion, bell pepper, croutons", (short)0, CategoryEnum.SALADS));
            productList.add(new Product(8, "ASSORTED PICKLES", 20.0, "Cucumbers, hot peppers, pickled green tomatoes, cabbage", (short)0, CategoryEnum.SALADS));

            productList.add(new Product(9, "HUMMUS", 21.0, "Chickpeas, sesame paste, olive oil, sweet paprika, lemon, garlic", (short)0, CategoryEnum.COLD_STARTERS));
            productList.add(new Product(10, "HUMMUS WITH PINE", 21.0, "Chickpeas, sesame paste, pine nuts, olive oil, hot paprika, lemon, garlic", (short)0, CategoryEnum.COLD_STARTERS));
            productList.add(new Product(11, "ÇIĞ KÖFTE", 23.0, "Grated wheat, hot paste, turkish spices", (short)0, CategoryEnum.COLD_STARTERS));
            productList.add(new Product(12, "MUTABAL", 27.0, "Roasted eggplants, sesame paste, garlic", (short)0, CategoryEnum.COLD_STARTERS));
            productList.add(new Product(13, "LABNEH", 16.0, "Yogurt cream, olive oil", (short)0, CategoryEnum.COLD_STARTERS));

            productList.add(new Product(14, "KARIDES GÜVEÇ", 56.0, "Shrimp, bell pepper, butter, mushrooms, tomatoes, cheese", (short)0, CategoryEnum.HOT_STARTERS));
            productList.add(new Product(15, "RAS ASFOUR BEEF", 47.0, "Beef, onion, bell pepper, garlic, pomegranate sauce", (short)0, CategoryEnum.HOT_STARTERS));
            productList.add(new Product(16, "IÇLI KÖFTE", 43.0, "Stuffed meatballs with beef, onion, bulgur, walnut, turkish spices", (short)0, CategoryEnum.HOT_STARTERS));
            productList.add(new Product(17, "BULGUR PILAV", 32.0, "Bulgur, onion, tomatoes", (short)0, CategoryEnum.HOT_STARTERS));


            productList.add(new Product(18, "LAHMACUN", 31.0, "Meat and vegetables", (short)0, CategoryEnum.GRILL));
            productList.add(new Product(19, "MANTAR GÜVEÇ", 22.0, "Gratinated mushrooms", (short)0, CategoryEnum.GRILL));
            productList.add(new Product(20, "ADANA KEBAP", 47.0, "Spicy beef and lamb kebab, vegetables, bulgur", (short)0, CategoryEnum.GRILL));
            productList.add(new Product(21, "URFA KEBAP", 55.0, "Beef and lamb kebab, vegetables, bulgur", (short)0, CategoryEnum.GRILL));
            productList.add(new Product(22, "ÇÖP ŞIŞ", 63.0, "Beef skewers, vegetables, bulgur", (short)0, CategoryEnum.GRILL));
            productList.add(new Product(23, "KÜŞLEME", 53.0, "Beef skewers, vegetables, bulgur", (short)0, CategoryEnum.GRILL));
            productList.add(new Product(24, "ISKENDER KEBAP", 47.0, "Beef, lamb, flatbread, tomato sauce", (short)0, CategoryEnum.GRILL));


            productList.add(new Product(25, "KÜNEFE", 37.0, "Kataifi with cheese", (short)0, CategoryEnum.DESSERTS));
            productList.add(new Product(26, "SÜTLAÇ", 34.0, "Rice pudding", (short)0, CategoryEnum.DESSERTS));
            productList.add(new Product(27, "BAKLAVA", 35.0, "Pistachio baklava", (short)0, CategoryEnum.DESSERTS));
            productList.add(new Product(28, "KATMER", 47.0, "Turkish dessert", (short)0, CategoryEnum.DESSERTS));

            productList.add(new Product(29, "ESPRESSO", 20.0, "", (short)0, CategoryEnum.COFFEE));
            productList.add(new Product(30, "AMERICANO", 23.0, "", (short)0, CategoryEnum.COFFEE));
            productList.add(new Product(31, "ESPRESSO LATTE", 24.0, "", (short)0, CategoryEnum.COFFEE));
            productList.add(new Product(32, "FRAPPE", 26.0, "", (short)0, CategoryEnum.COFFEE));
            productList.add(new Product(33, "ICE COFFEE", 21.0, "", (short)0, CategoryEnum.COFFEE));
            productList.add(new Product(34, "TURKISH COFFEE", 20.0, "", (short)0, CategoryEnum.COFFEE));
            productList.add(new Product(35, "TURKISH TEA", 17.0, "", (short)0, CategoryEnum.COFFEE));

            productList.add(new Product(36, "PEPSI/COLA", 10.0, "classic, lime, zero", (short)0, CategoryEnum.DRINKS));
            productList.add(new Product(37, "FANTA", 10.0, "", (short)0, CategoryEnum.DRINKS));
            productList.add(new Product(38, "SPRITE", 10.0, "", (short)0, CategoryEnum.DRINKS));
            productList.add(new Product(39, "LIPTON PEACH", 10.0, "", (short)0, CategoryEnum.DRINKS));
            productList.add(new Product(40, "PRIGAT", 10.0, "Oranges, peaches, banana with strawberries", (short)0, CategoryEnum.DRINKS));
            productList.add(new Product(41, "STILL WATER", 8.0, "", (short)0, CategoryEnum.DRINKS));
            productList.add(new Product(42, "MINERAL WATER", 8.0, "", (short)0, CategoryEnum.DRINKS));

            productList.add(new Product(43, "CABERNET SAUVIGNON PREMIUM 14%", 34.0, "", (short)0, CategoryEnum.ALCOHOL));
            productList.add(new Product(44, "WHITE RUSALCA 13%", 36.0, "Chardonnay, Sauvignon Blanc, Pinot Gris, Riesling Italian", (short)0, CategoryEnum.ALCOHOL));
            productList.add(new Product(45, "CALOIAN", 31.0, "Sauvignon Blanc 14%, Rose 13,5%, Merlot 14,5%", (short)0, CategoryEnum.ALCOHOL));
            productList.add(new Product(46, "CHARDONNAY", 33.0, "", (short)0, CategoryEnum.ALCOHOL));
            productList.add(new Product(47, "PURCARI ROSE", 28.0, "", (short)0, CategoryEnum.ALCOHOL));
            productsRepository.saveAll(productList);
        }

    }
}