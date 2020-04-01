package com.cc.ribbon.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

/**
 * 自定义负载均衡策略
 *
 * @author YL.huang
 * @date 03/09/2020
 */
public class MyRule extends RoundRobinRule {

    @Override
    public Server choose(Object key) {
        System.out.println("MyRule choose " + key + " ... ");
        return super.choose(key);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        System.out.println("MyRule setLoadBalancer  ... ");
        super.setLoadBalancer(lb);
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        System.out.println("MyRule getLoadBalancer  ... ");
        return super.getLoadBalancer();
    }

}
