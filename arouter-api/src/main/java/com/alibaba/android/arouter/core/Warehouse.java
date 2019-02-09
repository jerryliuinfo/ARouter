package com.alibaba.android.arouter.core;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Storage of route meta and other data.
 *
 * @author zhilong <a href="mailto:zhilong.lzl@alibaba-inc.com">Contact me.</a>
 * @version 1.0
 * @since 2017/2/23 下午1:39
 */
class Warehouse {
    // Cache route and metas
    /**
     * key:  "module" (groupName)
     * value: "class com.alibaba.android.arouter.routes.ARouter$$Group$$module" Class<? extends IRouteGroup>
     */
    static Map<String, Class<? extends IRouteGroup>> groupsIndex = new HashMap<>();
    /**
     * key:   Path
     * value: RouteMeta
     */
    static Map<String, RouteMeta> routes = new HashMap<>();

    // Cache provider
    /**
     * key:   com.alibaba.android.arouter.demo.testservice.HelloServiceImpl.class
     * value: IProvider 用于存放Class对应的IProvider实现类 例如HelloServiceImpl
     */
    static Map<Class, IProvider> providers = new HashMap<>();
    /**
     * key:   "com.alibaba.android.arouter.demo.testservice.HelloService" ->
     * value: "RouteMeta{type=PROVIDER, rawType=null, destination=class com.alibaba.android.arouter.demo.testservice.HelloServiceImpl, path='/yourservicegroupname/hello'}"
     */
    static Map<String, RouteMeta> providersIndex = new HashMap<>();

    // Cache interceptor
    /**
     * key  : "7"
     * value: "class com.alibaba.android.arouter.demo.testinterceptor.Test1Interceptor"
     */
    static Map<Integer, Class<? extends IInterceptor>> interceptorsIndex = new UniqueKeyTreeMap<>("More than one interceptors use same priority [%s]");
    static List<IInterceptor> interceptors = new ArrayList<>();

    static void clear() {
        routes.clear();
        groupsIndex.clear();
        providers.clear();
        providersIndex.clear();
        interceptors.clear();
        interceptorsIndex.clear();
    }
}
