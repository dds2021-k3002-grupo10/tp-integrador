package com.disenio.dto;

import com.disenio.model.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;

public class DTOResponse implements Serializable {
    @JsonView(Views.External.class)
    Integer status;
    @JsonView(Views.External.class)
    Object data;
    @JsonView(Views.External.class)
    String msg;

    //Constructors
    public DTOResponse() {
        this.data = new ArrayList<>();
        this.msg = "";
    }


    public DTOResponse(HttpStatus status, Serializable data, String msg) {
        this.status = status.value();
        this.data = data;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status.value();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
