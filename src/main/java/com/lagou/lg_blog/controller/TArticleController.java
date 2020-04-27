package com.lagou.lg_blog.controller;


import com.lagou.lg_blog.bean.TArticle;
import com.lagou.lg_blog.service.TArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangsong
 * @since 2020-04-26
 */
@Controller
public class TArticleController {

    @Autowired
    private TArticleService tArticleService;

    @RequestMapping("/index")
    public String goToIndex(WebRequest webRequest) {
        System.out.println("index");
        List<TArticle> tArticles = tArticleService.getBaseMapper().selectList(null);
        webRequest.setAttribute("articles", tArticles, RequestAttributes.SCOPE_REQUEST);
        return "index";
    }
}
