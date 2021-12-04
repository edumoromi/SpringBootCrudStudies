package com.springboot.crud.user;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TestUserControler {

    @InjectMocks
    UserControler userControler;

    @Mock
    UserRepository userRepository ;

    @Mock
    Model model;

    @Mock
    User user;

    @BeforeEach
    public void init() {
        user.setName("Test");
        user.setEmail("Test@hotmail.com");
        user.setId(1);
    }
    @Test
    public void testRepoFindById() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
    }
    @Test
    public void testsaveUser(){
        when(userRepository.save(user)).thenReturn(user);
    }

    @Test
    public void testAddUser() {
        //
        userControler.addUser(user,null,model);
        verify(userRepository, times(1)).save(user);
    }
    @Test
    public void testAddUserReturn() {when(userControler.addUser(user, null, null)).thenReturn(ResponseEntity.ok(user));}

    @Test
    public void testshowUser(){
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userControler.showUser(user.getId(),model);
        verify(userRepository, times(1)).findById(user.getId());
    }

    @Ignore
    public void testshowUserList(){
        when(userRepository.findAll()).thenReturn(any());
        userControler.showUserList(model);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testupdateUser(){
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userControler.updateUser(user.getId(),user,null,null);
        verify(userRepository, times(1)).save(user);

    }

    @Test
    public void testdeleteUser(){
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userControler.deleteUser(user.getId(),null);
        verify(userRepository, times(1)).delete(user);
    }






}