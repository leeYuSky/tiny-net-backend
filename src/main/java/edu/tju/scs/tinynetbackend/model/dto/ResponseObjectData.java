package edu.tju.scs.tinynetbackend.model.dto;

public class ResponseObjectData extends  ResponseData {


    private Object obj;

    public ResponseObjectData(Object obj)
    {
        this.obj=obj;
    }


    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }



}
