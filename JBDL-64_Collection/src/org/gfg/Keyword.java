package org.gfg;

public class Keyword {

    private String keyword;
    private int count;

    public Keyword(String keyword, int count) {
        this.keyword = keyword;
        this.count=count;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
