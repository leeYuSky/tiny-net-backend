package edu.tju.scs.tinynetbackend.dto;

import java.util.List;

public class ResponseListData {

    private List<Object>list;

    public ResponseListData(List<Object> list)
    {
        this.list=list;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
