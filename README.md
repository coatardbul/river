# river 
sail的服务端：
1.银行联行号信息 2.区域映射信息 3用户信息 
包括feign的调用，文件下载
swagger页面
http://localhost:9001/river/swagger-ui.html#/


2020.04.20
增加银行联行号信息表，从网络上爬取联行号信息  
将区域信息加载到本场缓存中   
监听缓存相关表的更新，插入操作，将表的修改更新到缓存中 
监听每个http请求所用的时间 
对每个请求中参数统一处理，返回的异常信息处理  
  

2020.04.23  
自定义注解  
相关注解使用

2020.04.27
自定义异常的使用
对返回的异常数据进行处理包装

2020.04.28
压力测试工具
@Bean使用  
在类上的注解有时候不管用

2020.04.29
mybatis日志不打印   


2020.05.01
rabbitMQ的使用
事务的使用

2020.05.02
统一异常处理
2020.05.11
1.token认证及身份校验
2.前后端分离时项目中的数据加密（加密盐，私钥加密公钥解密）