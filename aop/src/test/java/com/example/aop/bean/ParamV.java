package com.example.aop.bean;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * .....
 *
 * @author : lufy
 * @version v1.0
 * @date : 2019/5/25
 */
public class ParamV implements Serializable {
    private static final long serialVersionUID = 8L;

    @NotBlank(message = "瓜皮")
    private transient String name = "lufy";

    private String add="hello";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
