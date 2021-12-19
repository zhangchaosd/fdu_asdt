## 1. 项目结构

<img src="graph.png" >


## 2. 项目运行


启动之前需要先打包好各个服务，电脑需要安装 maven：
~~~
cd .\employee-server\
mvn clean package
cd ..
~~~
~~~
cd .\user-server\
mvn clean package
cd ..
~~~
~~~
cd .\task-server\
mvn clean package
cd ..
~~~
~~~
cd .\taskCompletion-server\
mvn clean package
cd ..
~~~
启动项目：
~~~
docker-compose build
docker-compose up -d
~~~
停止项目：
~~~
docker-compose down
~~~

## 测试

要使用 testREST.txt 文件进行测试，需要安装 vscode 插件 REST Client。
或者用 postman 测试。