## mybatis
### 环境准备
- idea，jdk17
- 导入user.sql到数据库
- 修改my/db.properties下的数据库文件
- 启动my/SimpleTest.java程序，成功查询数据，环境准备OK
**新增了些测试文件主要是为了在看源码比较迷糊的地方，直接debug进来，提高阅读效率**
### idea使用小技巧
- ctr + B 查看类和方法在哪里被使用；ctr + alt + B 查看类和方法的实现类，不会跳到接口，一步到位。
- ctr + alt + ← 返回上一步； ctr + alt + → 下一步  基本可以告别鼠标。
### 1、构建
#### 1 解析mybatis-config文件、解析mapper.xml文件
#### 2 解析SQL，生成MapperStatement
### 2、执行
#### 1 解析SQL，参数填充
#### 2、数据映射
### 3、缓存
#### 1 一级缓存，二级缓存
#### 2 事务中缓存的问题