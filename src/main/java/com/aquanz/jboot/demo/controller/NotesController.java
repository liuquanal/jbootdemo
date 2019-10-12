package com.aquanz.jboot.demo.controller;

import com.aquanz.jboot.demo.codegened.model.TNotes;
import com.aquanz.jboot.demo.codegened.service.TNotesService;
import com.jfinal.aop.Inject;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

/**
 * 纸条控制器
 *
 * @author a.q.z 2019/10/13 上午12:19
 */

@RequestMapping("/notes")
public class NotesController extends JbootController {

    @Inject
    private TNotesService notesService;

    public void index() {
        int page = getParaToInt("page", 1);
        Page<TNotes> notesPage = notesService.paginate(page, 5);
        setAttr("pageData", notesPage);
        render("/notes.html");
    }
}
