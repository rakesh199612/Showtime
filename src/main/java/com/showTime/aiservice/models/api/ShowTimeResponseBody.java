package com.showTime.aiservice.models.api;

public class ShowTimeResponseBody<T> {

    private T data;
    private ResultStatusInfo resultStatusInfo;

    public T getData(){
        return data;
    }
    public void setData(T data){this.data=data;}

    public void setResultStatusInfo(ResultStatusInfo resultStatusInfo){this.resultStatusInfo=resultStatusInfo;}

    public ResultStatusInfo getResultStatusInfo() {
        return resultStatusInfo;
    }
}
