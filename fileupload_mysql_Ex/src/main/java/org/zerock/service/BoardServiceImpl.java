package org.zerock.service;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jdk.internal.jline.internal.Log;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public void insertFile(HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		
		while(iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			
			if(multipartFile.isEmpty() == false) {
				Log.info("++++++++++File Start++++++++++");
				Log.info("Name : "+multipartFile.getName());
				Log.info("File Name : "+multipartFile.getOriginalFilename());
				Log.info("size : "+multipartFile.getSize());
				Log.info("++++++++++File End++++++++++");
			}
		}
	}
	
}
