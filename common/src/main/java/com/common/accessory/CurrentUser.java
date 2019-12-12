package com.common.accessory;

import java.lang.annotation.*;

/**
 * 当前用户Java对象注解类.
 */
@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {

}
