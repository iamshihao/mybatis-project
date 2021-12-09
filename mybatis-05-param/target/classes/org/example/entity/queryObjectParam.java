package org.example.entity;

public class queryObjectParam {

    String paramName;
    Integer paramId;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    @Override
    public String toString() {
        return "queryParam{" +
                "paramName='" + paramName + '\'' +
                ", paramId=" + paramId +
                '}';
    }
}
