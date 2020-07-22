package com.example.simple.secutiry;


import com.alibaba.fastjson.JSON;
import com.example.simple.core.ret.RetResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * 访问不能访问的资源时候，返回401未授权访问
 *
 * @author xian
 */
@Component
public class ErrorAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = 5200068540912465653L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // 设置 Json 格式返回
        response.setContentType("application/json;charset=UTF-8");
        // 设置 HTTP 状态码为 401
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // PrintWriter 输出 Response 返回信息
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        // 将对象输出为 JSON 格式。可以通过重写 MyResponse 的 toString() ，直接通过 myResponse.toString() 即可
        writer.write(mapper.writeValueAsString(RetResponse.makeErrRsp("未授权访问")));
    }

}