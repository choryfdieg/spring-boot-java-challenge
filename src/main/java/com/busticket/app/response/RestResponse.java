package com.busticket.app.response;

public final class RestResponse<T>{

    private static final int SUCCESS = 1;
    private static final int FAILURE = 99;
    private int code;
    private String description;
    private T resultObject;

    public RestResponse() {

    }

    public RestResponse(T resultObject){
        this.resultObject = resultObject;
        this.code = 1;
    }

    public RestResponse(T resultObject, String description){
        this.description = description;
        this.resultObject = resultObject;
        this.code = 1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getResultObject() {
        return resultObject;
    }

    public RestResponse<T> setResultObject(T resultObject) {
        this.resultObject = resultObject;
        return this;
    }


}
