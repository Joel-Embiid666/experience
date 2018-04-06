package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Phone;

public interface PhoneDao {
     public List<Phone> getPhones();
     public int add(Phone phone);
     public int update(Phone phone);
     public int del(int id);
     public Phone getPhoneById(int id);
    
}
