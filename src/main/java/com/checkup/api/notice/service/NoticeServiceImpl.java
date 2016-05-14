package com.checkup.api.notice.service;

import com.checkup.api.notice.dto.NoticeDTO;
import com.checkup.api.notice.model.NoticeMapper;
import com.checkup.api.notice.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by asus1 on 2016-05-13.
 */

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public boolean registerNotice(NoticeDTO noticeDTO) throws Exception {
        try {
            NoticeVO noticeVO = new NoticeVO();

            noticeVO.setnCode(noticeDTO.getnCode());
            noticeVO.setnTitle(noticeDTO.getnTitle());
            noticeVO.setnContent(noticeDTO.getnContent());

            noticeMapper.createNotice(noticeVO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<NoticeVO> selectNoticeList() throws Exception {
        List<NoticeVO> returnVal = noticeMapper.readNoticeList();
        return returnVal;
    }

    @Override
    public NoticeVO selectNotice(String nCode) throws Exception {
        return noticeMapper.readNotice(nCode);
    }

    @Override
    public boolean modifyNotice(NoticeDTO noticeDTO) throws Exception{
        try {
            String nCode = noticeDTO.getnCode();
            NoticeVO noticeVO = noticeMapper.readNotice(nCode);
            noticeVO.setnTitle(noticeDTO.getnTitle());
            noticeVO.setnContent(noticeDTO.getnContent());

            noticeMapper.updateNotice(noticeVO);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeNotice(String nCode) throws Exception{
        try {
            noticeMapper.deleteNotice(nCode);

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
