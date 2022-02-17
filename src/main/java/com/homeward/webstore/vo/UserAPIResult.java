package com.homeward.webstore.vo;

import com.homeward.webstore.pojo.userapi.cart.Cart;
import com.homeward.webstore.pojo.userapi.currency.Currency;
import com.homeward.webstore.pojo.userapi.modules.Modules;
import com.homeward.webstore.pojo.userapi.user.User;
import com.homeward.webstore.pojo.userapi.categories.Categories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserAPIResult {
    private User user;
    private Cart cart;
    private List<Categories> categories;
    private Currency currency;
    private Modules modules;
}
