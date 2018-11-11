package edu.tju.scs.tinynetbackend.dto;

public class ErrorReport {
    private int errno;
    private String errmsg;
    private ResponseData data;

    protected ErrorReport() {}

    public ErrorReport(int errno, String errmsg, ResponseData data) {
        this.errno = errno;
        this.errmsg = errmsg;
        this.data = data;
    }

    public ErrorReport(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }
}
