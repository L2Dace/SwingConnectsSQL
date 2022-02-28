/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userService;

import java.util.List;
import javaswinglinksql.JavaSwingLinkSQL;
import users.users;

/**
 *
 * @author ADMIN
 */
public class userService {
    private JavaSwingLinkSQL userLink;

    public userService() {
        userLink = new JavaSwingLinkSQL();
        
    }
    
    public List<users> getAllUsers(){
        return userLink.getAllUsers();
    }
    
    public void addUser(users user){
        userLink.addUser(user);
    }
    
    public void deleteUser(int id){
        userLink.deleteUser(id);
    }
}
