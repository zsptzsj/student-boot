package com.roadjava.student.bean.res;

import com.roadjava.student.bean.enums.CodeEnum;
import lombok.Data;

@Data
public class Result<T> {
//    响应码
    private Integer code = CodeEnum.SUCCESS.getCode();
//    响应信息
    private String msg = CodeEnum.SUCCESS.getMsg();
//    用于判断是否成功或失败
    private Boolean success = Boolean.TRUE;
    private T data;
    private Long total;
    private Result(){}
//    成功
    public static <T> Result<T> buildEmptySuccess(){
        return new Result<>();
    }
    public static <T> Result<T> buildSuccess(T t){
        Result<T> result = buildEmptySuccess();
        result.setData(t);
        return result;
    }

    public static <T> Result<T> buildSuccess(T t,Long total){
        Result<T> result = buildSuccess(t);
        result.setTotal(total);
        return result;
    }
    //失败类的方法
    public static <T> Result<T> buildFailure(String msg){
        Result<T> result = new Result<>();
        result.setCode(null);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> buildFailure(Integer code, String msg){
        Result<T> result = new Result<>();
        result.setCode(null);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> buildFailure(CodeEnum codeEnum){
        Result<T> result = new Result<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        result.setSuccess(false);
        return result;
    }
    public boolean isSuccess(){
        return success;
    }
    public boolean isFailed(){
        return !isSuccess();
    }
}
