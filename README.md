## 坑

### 1、mybatis逆向工程

**问题1**：数据库链接提示
> According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established

**解决**：在mysql连接字符串url中加入ssl=true或者false即可
> url=jdbc:mysql://127.0.0.1:3306/class?characterEncoding=utf8&useSSL=true

**问题2**：对实体 "characterEncoding" 的引用必须以 ';' 分隔符结尾

**解决**：“&”定义与解析的原因
> url=jdbc:mysql://127.0.0.1:3306/class?useUnicode=true&amp;characterEncoding=utf-8

**问题3**：mybatis逆向工程运行成功却没有生成相应的包和文件

**解决**：逆向工程中的路径问题，windows和mac等的文件系统路径不同,mac和Linux下应该使用./，windows下应该使用.\​

### 2、spring配置

**问题1**：spring配置文件出现
> URI is not registered ( Setting | Project Settings | Schemas and DTDs )

**解决**：IDEA -> preferences -> languages & frameworks -> Schemas and DTDs 添加对应URI