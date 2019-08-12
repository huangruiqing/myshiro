package com.example.demo.model.base;

import com.example.demo.model.base.BaseJsonModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RespJsonData
 * @Description
 * @Author huangrq
 * @Date 2019/8/12 14:26
 */
public class RespJsonData<T> extends BaseJsonModel  {

    private Boolean success = true;
    private String message = "";
    private String errorCode = "";
    private List<T> data;

    public RespJsonData(){}
    public RespJsonData(List<T> data){
        this.data = data;
    }
    public RespJsonData(T data){
        List<T> tmp = new ArrayList<>(1);
        tmp.add(data);
        this.data = tmp;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<T> getData() {
        return data;
    }


}
