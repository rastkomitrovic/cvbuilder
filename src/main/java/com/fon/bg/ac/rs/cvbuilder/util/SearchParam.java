package com.fon.bg.ac.rs.cvbuilder.util;

public class SearchParam {

    private SearchKey searchKey;

    private Object searchParam;

    public SearchParam(){

    }

    public SearchParam(SearchKey searchKey, Object searchParam) {
        this.searchKey = searchKey;
        this.searchParam = searchParam;
    }

    public SearchKey getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(SearchKey searchKey) {
        this.searchKey = searchKey;
    }

    public Object getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(Object searchParam) {
        this.searchParam = searchParam;
    }


    @Override
    public String toString() {
        return "SearchParam{" +
                "searchKey=" + searchKey +
                ", searchParam=" + searchParam +
                '}';
    }
}
