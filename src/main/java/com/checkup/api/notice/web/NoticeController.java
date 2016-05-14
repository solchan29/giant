package com.checkup.api.notice.web;

import com.checkup.api.notice.dto.NoticeDTO;
import com.checkup.api.notice.service.NoticeService;
import com.checkup.api.notice.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asus1 on 2015-12-02.
 */

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map<String, Object> registerNotice(@RequestBody NoticeDTO noticeDTO, HttpServletRequest request) throws Exception{
        Map<String, Object> returnVal = new HashMap<String, Object>();
        if(noticeService.registerNotice(noticeDTO)){
            returnVal.put("message","success");
        }else {
            returnVal.put("message","fail");
        }
        return returnVal;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    List<NoticeVO> getCustomerList(HttpServletRequest request) throws Exception{
        return noticeService.selectNoticeList();
    }

    // 嫄곕옒泥� �젙蹂� 吏곸썝
    @RequestMapping(value = "/{nCode}", method = RequestMethod.GET)
    public @ResponseBody
    NoticeVO getCustomerUserInfo (@PathVariable("nCode") String nCode, HttpServletRequest request) throws Exception{
        return noticeService.selectNotice(nCode);
    }
    
    @RequestMapping(value = "/{nCode}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map<String, Object> modifyCustomerUser(@RequestBody NoticeDTO noticeDTO, @PathVariable("nCode") String nCode, HttpServletRequest request)throws Exception{
        noticeDTO.setnCode(nCode);
    	Map<String, Object> returnVal = new HashMap<String, Object>();
    	if(noticeService.modifyNotice(noticeDTO)) {
            returnVal.put("message", "success");
    	}else {
    		returnVal.put("message", "fail");
		}
    	return returnVal;
    }
    
    @RequestMapping(value = "/{nCode}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map<String, Object> removeCustomer(@PathVariable("nCode") String nCode, HttpServletRequest request)throws Exception{
    	Map<String, Object> returnVal = new HashMap<String, Object>();
    	if(noticeService.removeNotice(nCode)){
    		returnVal.put("message", "success");
    	}else {
    		returnVal.put("message", "fail");
		}
    	return returnVal;
    }
        
}
