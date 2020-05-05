/**
 * @author wayne
 * @version module-info,  2020/5/4 10:22 下午
 */

module com.flydean.serviceb {
    requires transitive com.flydean.service;
    provides com.flydean.service.ModuleService with com.flydean.serviceb.ModuleServiceB;
    exports com.flydean.serviceb;
}