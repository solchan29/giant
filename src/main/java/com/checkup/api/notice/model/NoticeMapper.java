package com.checkup.api.notice.model;

import com.checkup.api.notice.vo.NoticeVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by asus1 on 2015-11-27.
 */
public interface NoticeMapper {
    @Insert("INSERT INTO notice (n_title, \n" +
            "                    n_content, \n" +
            "                    n_date) \n" +
            "  VALUE (#(nTitle),\n" +
            "         #(nContent),\n" +
            "         now())")
    public void createNotice(NoticeVO noticeVO) throws Exception;

    @Select("SELECT n_code AS nCode,\n" +
            "  n_title AS nTitle,\n" +
            "  n_content AS nContent,\n" +
            "  n_date AS nDate\n" +
            "FROM notice\n" +
            "WHERE n_code = #{nCode}")
    public NoticeVO readNotice(String nCode) throws Exception;

    @Select("SELECT n_code AS nCode,\n" +
            "  n_title AS nTitle,\n" +
            "  n_content AS nContent,\n" +
            "  n_date AS nDate\n" +
            "FROM notice\n" +
            "WHERE n_use = 'Y'\n")
    public List<NoticeVO> readNoticeList() throws Exception;

    @Update("UPDATE notice\n" +
            "SET n_title = #{nTitle}\n" +
            ",n_content = #{nContent}\n" +
            "WHERE 1=1\n" +
            "AND n_code = #{nCode}")
    public void updateNotice(NoticeVO noticeVO) throws Exception;

    @Delete("UPDATE tbl_customer_user\n" +
            "SET n_use = 'N'\n" +
            "WHERE 1=1\n" +
            "WHERE n_code = #{nCode}")
    public void deleteNotice(String nCode) throws Exception;
}
