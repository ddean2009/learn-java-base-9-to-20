package com.flydean.base.serviceb;


import com.flydean.base.service.ModuleService;

/**
 * @author wayne
 * @version ModuleServiceB,  2020/5/4 10:35 下午
 */
public class ModuleServiceB implements ModuleService {

    public ModuleService getModuleService(){
        return new ModuleServiceB();
    }
}
