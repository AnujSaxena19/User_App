package com.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.User.Dao.UserDao;
import com.User.Model.User;

@RestController
public class UserController {
    private User user;
    
private UserDao userdao;
    
@Autowired
private Validator validator;

 UserController() {
        user=new User();
        userdao=new UserDao();
 }
    
    @PostMapping("/create")
    public String adduser(@Validated @RequestParam String fname,@RequestParam String lname)
    {
        user.setFname(fname);
        user.setLname(lname);
        if(userdao.registerUser(user)==true)
        {
            return "inserted";
        }
    	
        return "not inserted";
    }
    
    
    @DeleteMapping("/delete/{id}")
    public  boolean del(@PathVariable ( "id") int id )
    { 
        userdao.deleteUser(id);
        return true;
        
    }
    
    
    @GetMapping("/getall")
    
    public  List <User> getall()
    {
        return userdao.getAllUser();
           
    }
    
    @PutMapping("/updateuser/{id}")
    public String update(@PathVariable("id") int id, User user)
    {
         userdao.updateUser(id, user);
         return "Updated";
    }
    
    
}