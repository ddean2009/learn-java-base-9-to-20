/**
 * @author wayne
 * @version module-info,  2020/5/4 10:31 下午
 */
module com.flydean.controller {
    uses com.flydean.service.ModuleService;
    requires com.flydean.service;
//    requires static com.flydean.serviceb;
    requires lombok;
    requires slf4j.api;
}
