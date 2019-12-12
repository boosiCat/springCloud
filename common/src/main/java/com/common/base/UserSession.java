package com.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class UserSession implements Serializable {

    @ApiModelProperty(name = "userId", value = "用户id", hidden = true)
    private Long userId;

    @ApiModelProperty(name = "telephone", value = "用户手机号", hidden = true)
    private String telephone;

    @ApiModelProperty(name = "name", value = "用户姓名", hidden = true)
    private String name;

    @ApiModelProperty(name = "headImg", value = "用户头像", hidden = true)
    private String headImg;
}
