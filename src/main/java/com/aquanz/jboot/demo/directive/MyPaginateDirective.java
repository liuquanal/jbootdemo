package com.aquanz.jboot.demo.directive;

import io.jboot.web.directive.JbootPaginateDirective;
import io.jboot.web.directive.annotation.JFinalDirective;

/**
 * 翻页标签定义
 *
 * @author a.q.z 2019/10/13 上午12:29
 */

@JFinalDirective("myPaginate")
public class MyPaginateDirective extends JbootPaginateDirective {
    protected String getPageAttrName() {
        return "pageData"; //这个值要和Controller里setAttr的第一个参数值相同
    }
}
