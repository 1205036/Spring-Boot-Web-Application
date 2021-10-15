package com.repository.springbootwebapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.repository.springbootwebapp.entity.FileRepository;
import com.repository.springbootwebapp.repository.FileRepositoryRepository;

@Controller
public class FileRepositoryController {
	
	@Autowired
	private FileRepositoryRepository frr;
	@Autowired
	ResourceLoader resourceLoader;
	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	String data;
	
	@GetMapping({"/showfilerepository","/","/list"})
	public ModelAndView showFileRepository() {
		
		//System.out.println("1");
		ModelAndView mav = new ModelAndView("list-filerepository");
		List<FileRepository> list = frr.findAll();
		//System.out.println("2");
		//System.out.println("This is the list: "+ frr.findAll());
		//for( FileRepository f : list) {
			//System.out.println(f.getId());
			
		//}
		mav.addObject("filerepository", list);
		return mav;
		
	}
	
	
	@GetMapping("/showFileContent")
	public ModelAndView showUpdateForm(@RequestParam Long id,@RequestParam String keyword,@RequestParam String filename) {
		ModelAndView mav = new ModelAndView("view-files");
		
		
	 
	    try
	    {
	    	//System.out.println("1");
	    	//System.out.println("classpath:"+"/"+keyword+"/"+filename);
	    	String path="classpath:"+"/"+keyword+"/"+filename;
	    	Resource resource = resourceLoader.getResource(path);
		    InputStream inputStream = resource.getInputStream();
	        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
	        data = new String(bdata, StandardCharsets.UTF_8);
	       //LOGGER.info(data);
	       //System.out.println(data);
	        
	    
	        
	    } 
	    catch (IOException e) 
	    {
	        LOGGER.error("IOException", e);
	    }
		
		//Employee employee = eRepo.findById(employeeId).get();
		mav.addObject("filecontent", data);
		//System.out.println("I am here");
		return mav;
	}

}
