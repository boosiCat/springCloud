package com.common.accessory;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/*	@Valid和@Validated区别：
 * 	使用@Valid注解，对RequestParam对应的参数进行注解，是无效的，需要使用@Validated注解来使得验证生效
 */
@Configuration
public class ValidatorConfiguration {

    /**
     * 针对@Valid注解修改【快速失败返回模式】，只要有一个错误就返回
     */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)//failFast的意思只要出现校验失败的情况，就立即结束校验，不再进行后续的校验。
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }

    /**
     * 针对@Validated注解修改【快速失败返回模式】，只要有一个错误就返回
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
        methodValidationPostProcessor.setValidator(validator());
        return methodValidationPostProcessor;
    }
}
