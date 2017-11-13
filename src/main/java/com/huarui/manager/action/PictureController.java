package com.huarui.manager.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.huarui.common.utils.FastDFSClient;

@Controller
public class PictureController {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private FastDFSClient fc;
	
	@RequestMapping(value="/pic/upload")
	@ResponseBody
	public Map fileUpload(MultipartFile uploadFile) {
		Map map = new HashMap<>();
		try {
			//1 获得信息
			byte[] bs = uploadFile.getBytes();
			//获得文件的扩张名
			String strExt = uploadFile.getOriginalFilename()
					.substring(uploadFile.getOriginalFilename().lastIndexOf(".")+1);
			//FastDFSClient fc = new FastDFSClient("classpath:conf/client.conf");
			String url = fc.uploadFile(bs, strExt);
			url = IMAGE_SERVER_URL+url;
			map.put("error", 0);
			map.put("url",url);
			//System.out.println(url);
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("error", 1);
			map.put("message","上传失败");
			//System.out.println("上传失败");
		}
		
		return map;
	}

}
