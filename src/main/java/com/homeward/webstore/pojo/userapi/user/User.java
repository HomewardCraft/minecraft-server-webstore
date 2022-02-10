package com.homeward.webstore.pojo.userapi.user;


import com.homeward.webstore.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User extends BasePojo {
    private Boolean loggedIn;
    private String ign;
    private String uuid;
}
