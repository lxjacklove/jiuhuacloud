package com.atjiuhua.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data//该注解可以为类提供读写功能，省去了get,set方法
@AllArgsConstructor//为该类产生一个全参全成员属性赋值构造方法
@NoArgsConstructor//为该类产生一个空参构造方法
public class CommonRusult<T> {
    private Integer code;
    private String message;
    private T data;

}
