package com.checkup.api.notice.service;

import com.checkup.api.notice.dto.NoticeDTO;
import com.checkup.api.notice.vo.NoticeVO;

import java.util.List;

/**
 * Created by asus1 on 2015-11-30.
 */
public interface NoticeService {

    boolean registerNotice(NoticeDTO noticeDTO) throws Exception;

    List<NoticeVO> selectNoticeList() throws Exception;

    NoticeVO selectNotice(String nCode) throws Exception;
    
    boolean modifyNotice(NoticeDTO noticeDTO) throws Exception;
        
    boolean removeNotice(String nCode) throws Exception;

}