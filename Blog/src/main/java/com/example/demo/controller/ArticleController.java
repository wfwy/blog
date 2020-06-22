package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/5 20:00
 */
@Controller
@ResponseBody
public class ArticleController {
    @Resource
    ArticleService articleService;

    /**
     * 通过id查看
     * @param id
     * @return
     */
    @GetMapping(value = "/api/article")
    public Result selArticle(@RequestParam(value = "id") int id){
        return ResultFactory.buildSuccessResult(articleService.selArticle(id));
    }

    /**
     * 查找全部
     * @param pageSize
     * @param pageNum
     * @return
     */
    @GetMapping(value = "/api/listArticle")
    public Result ListArticle(@RequestParam (value = "pageSize") int pageSize,
                              @RequestParam (value = "pageNum") int pageNum,
                              @RequestParam (value = "selArticle",required=false) String selArticle){
        return ResultFactory.buildSuccessResult(articleService.findPage(pageSize,pageNum,selArticle));
    }
    /**
     * 通过名字动态查找
     * @param pageSize
     * @param pageNum
     * @return
     */
    @GetMapping(value = "/api/listByName")
    public Result ListByName(@RequestParam (value = "pageSize") int pageSize,
                              @RequestParam (value = "pageNum") int pageNum,
                               @RequestParam (value = "type",required=false) String article_type){
        return ResultFactory.buildSuccessResult(articleService.findPagebyname(pageSize,pageNum,article_type));
    }
    /**
     * 查找最新三条
     */
    @GetMapping(value = "/api/listNewArticle")
    public Result ListNewArticle(){
        return ResultFactory.buildSuccessResult(articleService.listNewArticle());
    }
    /**
     * 点击量
     * @param article
     * @return
     */
    @PutMapping(value = "/api/updateHits")
    public Result updateHits(@RequestBody Article article){
        articleService.updateHits(article);
        return ResultFactory.buildSuccessResult("成功");
    }
    /**
     * 后台
     */
    @GetMapping(value = "/api/listArticles")
    public Result ListArticles(){
        return ResultFactory.buildSuccessResult(articleService.listArticles());
    }
    /**
     * 修改
     */
    @PutMapping(value = "/api/updateById")
    public Result UpdateByid(@RequestBody Article article){
        articleService.updateById(article);
        return ResultFactory.buildSuccessResult("修改成功");
    }
    /**
     *删除
     */
    @DeleteMapping(value = "/api/delByid")
    public Result delById(@Param(value = "id") int id){
        articleService.delById(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }
    /**
     * 添加
     * @param article
     * @return
     */
    @PostMapping(value = "/api/addArticle")
    public Result addArticle(@RequestBody Article article){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        article.setAuthor(username);
        articleService.addArticle(article);
        return ResultFactory.buildSuccessResult("添加成功");
    }

    /**
     * 后台条件查找
     * @param article_type
     * @param article_title
     * @return
     */
    @GetMapping(value = "/api/selectArticle")
    public Result selectArticle(@RequestParam(value = "article_type",required=false) String article_type,
                                @RequestParam(value = "article_title",required=false) String article_title){
        System.out.println(article_title);
        System.out.println(article_type);
        return ResultFactory.buildSuccessResult(articleService.selectArticle(article_type,article_title));
    }
}
