package com.neuedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.dao.PhoneDao;
import com.neuedu.pojo.Phone;

@Service
public class PhoneServiceImpl implements IphoneService{
    
	@Autowired
	private PhoneDao dao;
	
	@Override
	public List<Phone> getPhones() {
		// TODO Auto-generated method stub
		return dao.getPhones();
	}

	@Override
	public int add(Phone phone) {
		// TODO Auto-generated method stub
		return dao.add(phone);
	}

	@Override
	public int update(Phone phone) {
		// TODO Auto-generated method stub
		return dao.update(phone);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return dao.del(id);
	}

	@Override
	public Phone getPhoneById(int id) {
		// TODO Auto-generated method stub
		return dao.getPhoneById(id);
	}

}
