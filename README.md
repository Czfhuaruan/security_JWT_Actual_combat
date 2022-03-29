注：引用了开源项目https://gitee.com/fxzcloud/online1010.git

#security_JWT_Actual_combat

####~~~~介绍
本项目是基于security和jwt实现认证及鉴权服务

后端的主要技术架构是：SpringBoot + SpringCloud + MyBatis-Plus + HttpClient + MySQL + Maven+EasyExcel+ redis+nacos

前端的架构是：Node.js + Vue.js +element-ui+NUXT+ECharts

####~~~~项目配置
前端：安装cnpm或npm或yarn，以及node.js(10-14)

后端：安装mysql5.7.x,maven3.6.X,redis3.x.x,nacos2.0

####~~~~模块介绍

######common模块（重点！！！！！！）

common_utils（工具类）：包括MD5密码加密，R和ResponseUtil及ResultCode用于各种请求处理

service_base(服务基础处理类) ：包括redis解决乱码和存储异常配置，以及服务日志（异常处理）   

spring_security(security+jwt创建配置类) ： 包括token创建，filter定义，security配置

######db

数据库表

######infrastructure模块

api_gateway（网关配置类）：包括服务路由定义，及nacos注册中心配置

######service模块

service_acl (用户管理服务) ：包括登录服务以及用户权限管理模块

##部署步骤

前端：
建议使用（vs-code）克隆https://gitee.com/fxzcloud/vue-1010.git，
选择vue-admin-1010项目查看它的README.md，进行构建启动（步骤简单，有一定vuex基础就可以了）。

后端：
clone本项目，引进pom的依赖，修改配置文件中的mysql，nacos,redis的配置，先后启动mysql,nacos，redis
，然后启动api_gateway服务，最后启动service_acl服务，可在nacos监控页面中看到这两个服务注册成功，就可以进行测试。


