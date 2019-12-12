package com.common.accessory;

import com.common.base.UserSession;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 用于方法参数上标签获取当前登录用户的信息.
 * <p>
 */
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    /**
     * 当supportsParameter返回true时，才会调用resolveArgument方法。
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        UserSession user = new UserSession();
        Long userId = Long.valueOf(webRequest.getHeader("x-user-id"));
        user.setUserId(userId);
        /**
         * 其他
         */
        return user;

    }

}
