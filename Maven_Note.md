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

----------

-**pom.xml解析**

	<groupId>反写的公司网址+项目名</groupId>
	<artifactId>项目名+模块名</artifactId>
	<version>
		第一个0表示大版本号
		第二个0表示分支版本号
		第三个0表示小版本号
		0.0.1
		snapshot快照
		alpha内部测试
		beta公测
		Release稳定
		GA正式发布
	</version>
	
	<packaging>默认是jar war zip pom</packaging>
	<name>项目描述名</name>
	<url>项目的地址</url>
	<description>项目描述</description>
	<developers>开发人员信息</developers>

	<dependencies>
		<dependency>依赖</dependency>
	</dependencies>

	<dependencyManagement>
		<dependencies>
			<dependency>依赖管理</dependency>
		</dependencies>
	</dependencyManagement>

	插件列表
	<build>
		<plugins>
			<plugin>
				<groupId></groupId>
				<artifactId></artifactId>
				<version></version>
			</plugin>
		</plugins>
	</build>



