## mybatis source code learn
### 环境准备
- idea，jdk17
- 导入user.sql到数据库
- 修改my/db.properties下的数据库文件
- 启动my/SimpleTest.java程序，成功查询数据，环境准备OK  

**新增了些测试文件主要是为了在看源码比较迷糊的地方，直接debug进来，提高阅读效率**<br>

---
### idea使用小技巧
- ctr + B 查看类和方法在哪里被使用；ctr + alt + B 查看类和方法的实现类，不会跳到接口，一步到位。
- ctr + alt + ← 返回上一步； ctr + alt + → 下一步  基本可以告别鼠标。
---
### [1 构建.md](https://github.com/aqiang0/mybatis_source_code_learning-/blob/master/doc/1%20%E6%9E%84%E5%BB%BA.md)
#### 1 解析mybatis-config.xml文件   
这一步主要是解析mybatis-config.xml文件，解析<configuration/>标签内容，把解析数据注入到Configuration对象对应属性中，解析属性包括：  
- properties（属性）
- settings（设置）
- typeAliases（类型别名）
- typeHandlers（类型处理器）
- objectFactory（对象工厂）
- plugins（插件）
- environments（环境配置）
- environment（环境变量）
- transactionManager（事务管理器）
- dataSource（数据源）
- databaseIdProvider（数据库厂商标识）
- mappers（映射器）   
具体属性含义可参照[mybatis配置属性](https://mybatis.net.cn/configuration.html)
#### 2 解析mapper.xml文件，生成MapperStatement       
这一步主要解析mapper.xml文件 ***代码入口XMLConfigBuilder.mapperElement()*** 把解析数据注入到Configuration对象对应属性中，解析属性包括：   
- select标签
- insert、update、delete标签
- resultMap标签
- cache缓存标签   
具体标签含义可参照[mybatis XML映射器](https://mybatis.net.cn/sqlmap-xml.html)
---
### [2、执行](https://github.com/aqiang0/mybatis_source_code_learning-/blob/master/doc/2%20%E6%89%A7%E8%A1%8C.md)
#### 1 解析SQL，参数填充
把SQL中？和${}替换成参数值，获取prepareStatement，执行SQL查询。
#### 2、数据映射  
把查询结果映射到定义的实体类中  

---
### [3、缓存](https://github.com/aqiang0/mybatis_source_code_learning-/blob/master/doc/3%20%E7%BC%93%E5%AD%98.md)
#### 1 一级缓存，二级缓存
#### 2 mybatis缓存问题

---