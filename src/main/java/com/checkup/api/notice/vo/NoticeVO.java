package com.checkup.api.notice.vo;

/**
 * Created by asus1 on 2015-11-27.
 */
public class NoticeVO {
    private String nCode;
    private String nTitle;
    private String nContent;
    private String nDate;

    public String getnCode() {
        return nCode;
    }

    public void setnCode(String nCode) {
        this.nCode = nCode;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public String getnDate() {
        return nDate;
    }

    public void setnDate(String nDate) {
        this.nDate = nDate;
    }

    @Override
    public String toString() {
        return "NoticeVO{" +
                "nCode='" + nCode + '\'' +
                ", nTitle='" + nTitle + '\'' +
                ", nContent='" + nContent + '\'' +
                ", nDate='" + nDate + '\'' +
                '}';
    }
}
