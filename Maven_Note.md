##Maven Note

- **Maven主干目录**
	- src
		- main
			- java
				- package
		- test
			- java
				- package
		- resources

----------

- **Maven命令**
	- `mvn -v` 查看maven版本
	- `mvn -compile` 编译
	- `mvn -test` 测试
	- `mvn -package` 打包
	- `mvn -clean` 删除target
	- `mvn -install` 安装jar包到本地仓库中

----------

- **创建目录的两种方式**
	
	1.archetype:generate 按照提示进行选择

	2.archetype:generate -DgroupId=组织名，公司网址的反写+项目名  
	　　　　　　　　　　-DartifactId=项目名-模块名  
	　　　　　　　　　　-Dversion=版本号  
	　　　　　　　　　　-Dpackage=代码所存在的包名

----------

- **国内镜像仓库**

	更改conf/settings.xml文件

		<mirror>
			<id>maven.net.cn</id>
			<mirrorOf>central</mirrorOf>
			<name>central mirror in china</name>
			<url>http://maven.net.cn/content/groups/public</url>
		</mirror>
		
	原始本地仓库的位置`C:\Users\yunwei\.m2\repository`  
	更改本地仓库位置为`E:\libs\repo`
		
		<localRepository>E:/libs/repo</localRepository>  

