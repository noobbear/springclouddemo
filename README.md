## 1、demo说明

jasypt作为配置加解密工具

### 2、依赖版本
```xml
    <properties>
        <java.version>8</java.version>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <spring-boot.version>2.7.6</spring-boot.version>
        <spring-cloud-alibaba.version>2021.0.5.0</spring-cloud-alibaba.version>
        <spring-cloud.version>2021.0.5</spring-cloud.version>
        <jasypt-spring-boot-starter.version>3.0.5</jasypt-spring-boot-starter.version>
        <mybatis-spring-boot-starter.version>2.3.2</mybatis-spring-boot-starter.version>
    </properties>
```
### 3、默认使用nacos作为配置中心 (测试版本=2.x)
```yaml
#样例配置文件 demo.yaml
demo:
 config:
  value: nacos value
```
### 4、jasypt 插件使用
> 插件配置

```xml
    <plugin>
        <groupId>com.github.ulisesbocchio</groupId>
        <artifactId>jasypt-maven-plugin</artifactId>
        <version>3.0.5</version>
    </plugin>
```
通过IDEA执行执行命令
```shell
mvn jasypt:encrypt-value -Djasypt.encryptor.password="your jasypt password" -Djasypt.plugin.value="text to encrypt"
mvn jasypt:decrypt-value -Djasypt.encryptor.password="your jasypt password" -Djasypt.plugin.value="pwd to decrypt"
```

## 5、运行说明

> 直接运行cn.example.demo.DemoApplication
> 访问样例接口 GET localhost:8080/test
