package com.test.sp.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.lang.annotation.*;
/**
 * 
 *
 * @param 
 * @return
 * @throws 
 * @date 2019-09-17
 * @author choiseongjun
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}