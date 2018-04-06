package com.neuedu.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.pojo.Phone;
import com.neuedu.service.IphoneService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
public class PhoneController {
	
	 @Resource
	 private IphoneService service;
	
     @RequestMapping("/list.do")
     public String list(ModelMap map){
    	 List<Phone> phones=service.getPhones();
    	 map.addAttribute("phones",phones);
    	 return "list";   	 
     }
     @RequestMapping(value="/add.do",method=RequestMethod.GET)
     public String goAdd(){
    	 return "add";
     }
     @RequestMapping(value="/add.do",method=RequestMethod.POST)
     public String doAdd(Phone phone,MultipartFile logo) throws IllegalStateException, IOException{
    	 String path="http://192.168.118.132/static/resource/img/";
    	 //获取当前的时间
    	 Date date = new Date();
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	 StringBuilder fileName=new StringBuilder(sdf.format(date));
    	 //生成四个随机数
    	 for(int i=0;i<4;i++){
    		 Random r=new Random();
    		 String str= String.valueOf(r.nextInt(10));	
    		 fileName.append(str);
    	 }
    	 fileName.append(".").append(FilenameUtils.getExtension(logo.getOriginalFilename()));
    	 String url=path+fileName.toString();
    	 System.out.println("用客户端生成一个web资源");
    	 //jersey三步走
    	 Client client=new Client();
    	  WebResource resource = client.resource(url);
    	  resource.put(String.class,logo.getBytes());
    	  
    	 phone.setImgurl(fileName.toString());
    	  service.add(phone);
    	 System.out.println("***************");
    	 //String path= request.getServletContext().getRealPath("/img/");
    	/* File file=new File(path+logo.getOriginalFilename());
    	 logo.transferTo(file);
    	 phone.setImgurl("img/"+logo.getOriginalFilename());
    	 */
    	 return "redirect:list.do";
     }
     public PhoneController(){
    	 
     }
     @RequestMapping(value="/update.do",method=RequestMethod.GET)
     public String goUpdate(int id,ModelMap map){
    	 Phone phone=service.getPhoneById(id);
    	 map.addAttribute("phone",phone);
    	 return "edit";
     }
     @RequestMapping(value="/update.do",method=RequestMethod.POST)
     public String doUpdate(Phone phone,MultipartFile logo) throws IllegalStateException, IOException{
    	 //图片是否为空
    	 if(!logo.isEmpty()){
    		 String path="http://192.168.118.132/static/resource/img/";
        	 //获取当前的时间
        	 Date date = new Date();
        	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        	 StringBuilder fileName=new StringBuilder(sdf.format(date));
        	 //生成四个随机数
        	 for(int i=0;i<4;i++){
        		 Random r=new Random();
        		 String str= String.valueOf(r.nextInt(10));	
        		 fileName.append(str);
        	 }
        	 fileName.append(".").append(FilenameUtils.getExtension(logo.getOriginalFilename()));
        	 String url=path+fileName.toString();
        	 System.out.println("用客户端生成一个web资源");
        	 //jersey三步走
        	 Client client=new Client();
        	 WebResource resource = client.resource(url);
        	 resource.put(String.class,logo.getBytes()); 
        	 phone.setImgurl(fileName.toString());
    		 
    	 }
    	 service.update(phone); 
    	 /*String path= request.getServletContext().getRealPath("/img/");
    	 File file=new File(path+logo.getOriginalFilename());
    	 logo.transferTo(file);
    	 phone.setImgurl("img/"+logo.getOriginalFilename());
    	 service.update(phone);*/
    	 return "redirect:list.do"; 	 
     }
     @RequestMapping(value="/del.do")
     public String del(int id){
    	 service.del(id);
    	 return "redirect:list.do"; 	 
     }
     
     
     
     
}
