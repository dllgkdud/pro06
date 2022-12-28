package com.shop2.myapp.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shop2.myapp.service.BoardService;

@Controller
@RequestMapping("/products/")
public class ProductsController {
	
	@Resource
	private BoardService boardService;
	
	@GetMapping("list")
	public String ProductList(Model model) throws Exception {
		return "products/list";
	}

	@GetMapping("add")
	public String testLoad5(Model model) throws Exception {
		return "products/add";
	}
	//경로(관리자 서버)
	@Value("${part4.upload.path}")
    private String uploadPath;
	//경로(배포 서버)
	@Value("${part5.upload.path}")
    private String uploadPath2;
	//경로(PC)
	@RequestMapping(value="url.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
    public List<String> getData(Model model, MultipartHttpServletRequest req){
		
        List<MultipartFile> multipartFileList = new ArrayList<>(); 
        List<String> fileQt = new ArrayList<String>();
        try {
            MultiValueMap<String, MultipartFile> files = req.getMultiFileMap();
            for (Map.Entry<String, List<MultipartFile>> entry : files.entrySet()) {
                List<MultipartFile> fileList = entry.getValue();
                for (MultipartFile file : fileList) {
                    if (file.isEmpty()) continue;
                    multipartFileList.add(file);
                    String originalName = file.getOriginalFilename();
                    String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
                    //날짜 폴더 생성
                    String folderPath = makeFolder();
                    String uuid = UUID.randomUUID().toString();
                    //UUID
                    //저장할 파일 이름 중간에 "_"를 이용하여 구분
                    String saveName = uploadPath + File.separator + folderPath +File.separator + uuid + "_" + fileName;                    
                    Path savePath = Paths.get(saveName);
                    //images안의 디렉토리 경로와 파일 이름 별도로 저장하여 서비스로 전달하기 위한 이름 
                    String singleFileName = File.separator + folderPath +File.separator + uuid + "_" + fileName;
                    fileQt.add(singleFileName);
                    //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로정의)
                    file.transferTo(savePath);
                }
            }
        } catch (Exception e){
	        e.printStackTrace();
        }
        return fileQt;
    }
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		//LocalDate를 문자열로 포멧
		String folderPath = str.replace("/",File.separator);
		File uploadPathFoler = new File(uploadPath, folderPath);
        
		if(uploadPathFoler.exists() == false){
			uploadPathFoler.mkdirs();
		}
		return folderPath;
	}
}
