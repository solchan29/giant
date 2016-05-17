package com.checkup.api.notice.service;

import com.checkup.api.notice.vo.NoticeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by asus1 on 2015-12-01.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class NoticeServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(NoticeServiceTest.class);

    @Inject
    private NoticeService noticeService;

    @Test
    public void testRead() throws Exception{
        List<NoticeVO> list = noticeService.selectNoticeList();

        for(NoticeVO noticeVO : list){
            System.out.println(noticeVO.getnCode());
        }
    }
}
