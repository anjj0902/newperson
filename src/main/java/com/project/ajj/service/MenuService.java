package com.project.ajj.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.ajj.dao.MenuDaoInterface;
@Service
public class MenuService implements MenuServiceInterface {
	   @Autowired
	   MenuDaoInterface cddi;
	@Override
	public int save(HttpServletRequest req) throws Exception {
		 HashMap param = new HashMap();
	      
	      boolean isMultipart = ServletFileUpload.isMultipartContent(req);                   // multipart로 전송되었는가를 체크
	       if (isMultipart) {                                                                                            // multipart로 전송 되었을 경우
	        File temporaryDir = new File("c:\\tmp\\");                                                 //업로드 된 파일의 임시 저장 폴더를 설정
	        String realDir = req.getRealPath("/resources/upload/");                //톰켓의 전체 경로를 가져오고 upload라는 폴더를 만들고 거기다
	        DiskFileItemFactory factory = new DiskFileItemFactory();                                   
	        
	        ServletFileUpload upload = new ServletFileUpload(factory);                               
	        upload.setSizeMax(10 * 1024 * 1024);                                                             //최대 파일 크기(10M)
	        List<FileItem> items = upload.parseRequest(req);                                      //실제 업로드 부분(이부분에서 파일이 생성된다)
	        
	        Iterator iter=items.iterator(); 
	        
	        int count = 0;
	        //Iterator 사용
	        while (iter.hasNext()) {
	            FileItem fileItem = (FileItem) iter.next(); // 파일을 가져온다

	            if (fileItem.isFormField()) { // 업로드도니 파일이 text형태인지 다른 형태인지 체크
	                                    // text형태면 if문에 걸림
	               
	               if(fileItem.getFieldName().equals("menu")){
	                  param.put("name", fileItem.getString("UTF-8"));
	               }else if(fileItem.getFieldName().equals("menu_type")){
	                  param.put("menu_type", fileItem.getString("UTF-8"));
	               }else if(fileItem.getFieldName().equals("menu_name")){
	            	  param.put("menu_name",fileItem.getString("UTF-8"));
	               }
	               
	               
	            } else { // 파일이면 이부분의 루틴을 탄다
	               count++;
	               
	               if (fileItem.getSize() > 0) { // 파일이 업로드 되었나 안되었나 체크
	                                       // size>0이면 업로드 성공
	                  String fileName = fileItem.getName();

	                  try {
	                     File uploadedFile = new File(realDir, fileName); // 실제
	                     
	                     param.put("image_name"+count, fileName);
	                                                            // 디렉토리에
	                                                            // fileName으로
	                                                            // 카피
	                                                            // 된다.
	                     fileItem.write(uploadedFile);
	                     fileItem.delete(); // 카피 완료후 temp폴더의 temp파일을 제거
	                  } catch (IOException ex) {
	                  }
	               }
	            }
	         }
	      } else {
	         System.out.println("인코딩 타입이 multipart/form-data 가 아님.");
	      }
	      
	      
	      cddi.save(param);
	      
	      return 0;

	}

	@Override
	public List getMenu(String menu_type){
		
		System.out.println("dao return:##################################"+cddi.getMenu(menu_type));
		return cddi.getMenu(menu_type);
	}

	@Override
	public HashMap<String, Object> menuselect(HashMap<String, Object> param) {
	    System.out.println("service menu:"+param);
		HashMap<String,Object> map =new HashMap<String, Object>();
		map.put("data",cddi.menuselect(param));
		System.out.println("service test :"+cddi.menuselect(param));
		return map;
	}
	

}
