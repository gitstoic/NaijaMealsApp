package com.example.naijameals.data

import com.example.naijameals.R
import com.example.naijameals.model.FoodItem

class DataSource{
    fun loadFoodItems(): List<FoodItem>{
        return listOf(
            FoodItem( "Abacha", "Abacha is an Eastern Nigeria dish made using dried, shredded cassava. You can eat it as a snack or a full meal. There are many variations to making this salad, but the more ingredients you add, the tastier the dish is. Whichever way you prepare or eat it, warm or cold, it will still come out delicious.",1500.00, R.drawable.abacha),
            FoodItem( "Ewa Agoyin", "Ewa Agoyin (Ewa Aganyin) is a very popular street food, especially on Lagos streets in Nigeria and it is very easy to prepare at home. It is made by boiling Beans until it’s really tender then mashing it. This delicious meal is usually accompanied by a spicy stew which is usually referred to as Ewa Agoyin (Ewa Agoyin) Stew. Ewa Aganyin sauce is a spicy sauce made with dried tatashe, chili pepper, and lot of onions.",2000.00, R.drawable.ewaagoyin),
            FoodItem( "Akara", "Akara (Black Eyed Peas Fritters) is deep-fried bean cake made from black-eyed peas paste.. It is crispy, golden, tasty, downright irresistible, and quite filling.",800.00, R.drawable.akara),
            FoodItem( "Masa masa", "Rice cakes (masa) are a northern Nigerian delicacy, particularly among the Hausa tribe. Made with rice and just a few other ingredients, this dish is easy and inexpensive to prepare. It is nutritious, delicious and filling, and its fluffy goodness can be enjoyed alone or paired with a sauce.",500.00, R.drawable.masamasa),
            FoodItem( "Semo & Efo riro", "Efo Riro is a rich vegetable soup that is native to the Yorubas of Western Nigeria. The vegetables that can be used to cook this soup are Efo Shoko or Efo Tete (Green Amaranth). It is eaten well with Semo, a Nigerian solid food.",3800.00, R.drawable.semo_eforiro),
            FoodItem( "Ofe Akwu", "Ofe Akwu is a delicious African delicacy Made from the creamy extract got from pulverized Palm nut fruits and can be eaten with rice.",2300.00, R.drawable.ofeakwu),
            FoodItem( "Egusi", "Egusi Soup is a rich and savory West African soup made with ground melon seeds and eaten with fufu dishes",2200.00, R.drawable.egusi),
            FoodItem( "Asaro", "Asaro is another delicious Nigerian yam dish cooked in a well-seasoned pepper mix until soft and fluffy with some yam chunks.",1800.00, R.drawable.asaro),
            FoodItem( "Ngwo ngwo", "Ngwo ngwo goat offal pepper soup is a delicacy cooked in the Eastern part of Nigeria. The parts of the goat used are the tripe (stomach locally called towel), intestines, liver, kidney, heart, spleen, testicles and a bit of the flesh.",3200.50, R.drawable.ngwongwo),
            FoodItem( "Jollof rice", "Jollof Rice, sometimes called jellof rice, is a classic rice dish cooked in a flavorful tomato-infused broth.",3600.20, R.drawable.jollofrice),
            FoodItem( "Fufu", "Fufu, which is believed to have originated in modern-day Ghana, is commonly made by pounding starchy food crops such as cassava, yam, plantain and others",2400.50, R.drawable.fufu),
            FoodItem( "Moin moin", "Moin-Moin or Moimoi is a Yoruba steamed bean pudding made from a mixture of washed and peeled black-eyed beans, onions and fresh ground red peppers.",950.50, R.drawable.moin_moin),
            FoodItem( "Dodo Ikire", "Dodo Ikire is a Nigerian spicy fried plantain snack. It is named after a town called Ikire, Ikire is in the south western part of Nigeria",600.50, R.drawable.dodo_ikire),
            FoodItem( "Tuwo Shinkafa", "Tuwo Shinkafa is a northern Nigerian solid food that is prepared with the soft rice variety. It is usually served with Northern Nigerian soups.",1200.00, R.drawable.tuwo),
            FoodItem( "Eba", "Ẹ̀bà is a Nigerian staple food made from dried grated cassava flour, commonly known as garri. Often eaten with Yoruba or Igbo soups",3800.50, R.drawable.eba)

            )

    }
}

