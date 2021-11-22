package com.springboot.crud;

import com.springboot.crud.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestUser {
    @Test
    public void testGetSetId(){
        long id = 1;
        User user = new User();
        user.setId(id);
        assertEquals(user.getId(), id);
    }
    @Test
    public void testGetSetEmail(){
        String email = "teste@hotmail.com";
        User user = new User();
        user.setEmail(email);
        assertEquals(user.getEmail(), email);
    }
    @Test
    public void testGetSetName(){
        String name = "Teste";
        User user = new User();
        user.setName(name);
        assertEquals(user.getName(), name);
    }

}
