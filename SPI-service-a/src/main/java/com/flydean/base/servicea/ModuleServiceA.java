package com.flydean.base.servicea;


import com.flydean.base.service.ModuleService;

/**
 * @author wayne
 * @version ModuleServiceA,  2020/5/4 10:34 下午
 */
public class ModuleServiceA implements ModuleService {

    public ModuleService getModuleService(){
        return new ModuleServiceA();
    }
}
