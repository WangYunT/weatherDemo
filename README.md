## 项目介绍 ##
    

本项目通过学习《从天气项目看 Spring Cloud 微服务治理》，达到从单体到微服务，演绎服务拆分与系统重构，让你掌握构建微服务的核心思想和实用技术。

---
## 软件及jar 版本 ##
springboot : **2.0.0.M3**
spring cloud : **Finchley.M2**
STS: **3.9.1.RELEASE**
maven: **3.5.2**
JDK：**1.8**
Redis ： **3.2.100**
Apache httpcomponents : **4.5.7**

---

## 所用技术 ##



 1. 微服务架构中服务发现机制的用意
    采用**Eureka Server**、**Eureka Client**技术实现服务注册与发现功能
    
 2. 微服务架构中作为服务消费方的原理与实现方式
    采用**Ribbon**、**OpenFeign**技术实现服务负载均衡和高可用
 3. 微服务架构中 API在微服务架构中的作用
    采用**Zuul**技术，实现了API网关
 4. 微服务架构中配置管理的重要性
    采用**Config Server**、**Config Client**技术来实现微服务的配置管理
 5. 微服务架构中 熔断机制的重要性
    采用**Hystrix**技术来实现微服务的熔断机制
 6. 微服务架构中自动扩展的重要性
    介绍了自动扩展常用算法和原理，同时来讲解市面上常见的实现微服务的自动扩展的开源技术

架构图
==

![cmd-markdown-logo](https://coding.imooc.com/static/module/class/content/img/177/section2-img.png)



同时，以天气预报系统为例，演绎微服务架构
====================

  ![架构图](https://coding.imooc.com/static/module/class/content/img/177/section3-img.png)
x

## 主要章节课程介绍 ##

第二章课程目标：
从一个天气预报系统讲起（springboot的项目搭建）
使用Redis提升并发访问能力(提升应用的并发访问能力；减少服务调用；)
实现天气预报数据的同步（定时器）
给天气预报一个面子(天气预报的功能，1、按照不同的城市来查询天气，2、查询近几天的天气信息）
第三章 主讲微服务概念及设计原则
第四章 天气服务项目改造
第五章 spring cloud简介，入门配置，子项目介绍（注意spring boot注意spring cloud的版本兼容）
第六章 服务的注册与发现
