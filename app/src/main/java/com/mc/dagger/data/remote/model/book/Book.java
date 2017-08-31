package com.mc.dagger.data.remote.model.book;

/**
 * Created by zhangzhenguo on 2017/8/31.
 */

public class Book {
    private long id;

    /**
     * 编码
     */
    private String bookCode;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 书价格
     */
    private String bookPrice;

    /**
     * 描述
     */
    private String bookDescription;

    /**
     * 添加时间
     */
    private long addTime;

    /**
     * 最近修改时间
     */
    private long updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookCode='" + bookCode + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
