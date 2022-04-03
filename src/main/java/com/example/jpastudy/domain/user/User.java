package com.example.jpastudy.domain.user;

import com.example.jpastudy.domain.base.BaseObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseObject {
    private String name;
    private Integer age;
}
