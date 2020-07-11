package com.flydean.base;


import com.flydean.base.service.ModuleService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

/**
 * @author wayne
 * @version ModuleController,  2020/5/4 10:33 下午
 */
@Slf4j
public class ModuleController {

    public static void main(String[] args) {
        List<ModuleService> moduleServices = ServiceLoader
                .load(ModuleService.class).stream()
                .map(ServiceLoader.Provider::get)
                .collect(toList());
        log.info("{}", moduleServices);
    }
}
