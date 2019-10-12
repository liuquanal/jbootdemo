package com.aquanz.jboot.demo.codegened.service.provider;

import com.aquanz.jboot.demo.codegened.model.TNotes;
import com.aquanz.jboot.demo.codegened.service.TNotesService;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.aop.annotation.Bean;
import io.jboot.components.cache.annotation.Cacheable;
import io.jboot.service.JbootServiceBase;


@Bean
public class TNotesServiceProvider extends JbootServiceBase<TNotes> implements TNotesService {

    @Override
    @Cacheable(name = "myCache", key = "page:#(page)-#(pageSize)")
    public Page<TNotes> paginate(int page, int pageSize) {
        return super.paginate(page, pageSize);
    }
}