package com.example.aop.bean;

import javax.validation.constraints.NotBlank;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/5/25
 */
public class ParamV {
    @NotBlank(message = "瓜皮")
    private String name = "lufy";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
