package com.aquanz.jboot.demo.controller;

import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

/**
 * 首页控制器
 *
 * @author a.q.z 2019/10/12 下午8:59
 */

@RequestMapping("/")
public class IndexController extends JbootController {
    public void index() {
        renderText("hello,world!");
    }
}
