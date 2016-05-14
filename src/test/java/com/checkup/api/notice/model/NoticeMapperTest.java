package com.checkup.api.notice.model;

import com.checkup.api.notice.vo.NoticeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by asus1 on 2015-11-27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class NoticeMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(NoticeMapperTest.class);

    @Inject
    private NoticeMapper mapper;

    @Test
    public void testRead() throws Exception{
        NoticeVO noticeVO = mapper.readNotice("1");
        logger.info(noticeVO.toString());
    }
}
