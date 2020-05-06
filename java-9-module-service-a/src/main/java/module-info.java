/**
 * @author wayne
 * @version module-info,  2020/5/4 10:22 下午
 */

module com.flydean.servicea {
    requires com.flydean.service;
//    requires transitive com.flydean.service;
    provides com.flydean.service.ModuleService with com.flydean.servicea.ModuleServiceA;
    exports com.flydean.servicea;
}