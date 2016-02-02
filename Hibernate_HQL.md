##Hibernate HQL##


1. **from语句**
	- **from objectName**直接查找类名
	- **from objectName o**使用 **o** 来替代 **objectName**（别名）

----------

2. **select语句**
	- **select s.name,s.tel,s.address from Seller s** 使用   **select** 来精确查找 **Seller** 类中的信息同时使用了别名 **s** ，返回的类型为 **Object[]**
	- **select s.name from Seller s** 如果查找单个类中的属性返回类型则为 **Object**
	- **select new list(s.name,s.tel,s.address) from Seller s** 返回值为 **list** 集合
	- **select new map(s.name,s.tel,s.address) from Seller s** 返回值为 **map**
	
			List<Map> maps = query.list();
			
			for(Map map : maps){
				System.out.println("name:" + map.get("0"));
				System.out.println("tel:" + map.get("1"));
				System.out.println("address:" + map.get("2"));
			}
	- **select new map(s.name as name,s.tel as tel,s.address as address) from Seller s** 使用别名来获取 **map** 中的 **key** 值
	
			List<Map> maps = query.list();
			
			for(Map map : maps){
				System.out.println("name:" + map.get("name"));
				System.out.println("tel:" + map.get("tel"));
				System.out.println("address: " + map.get("address"));
			}
	- **select new Seller(s.name,s.tel,s.address) from Seller s** 使用自定义类型获取返回值，**new Seller(s.name,s.tel,s.address)** 需要你在 **Seller** 类中定义一个参数一致的构造方法，这样获取的返回值就为 **Seller** 类
	- **select distinct c.sex from Customer c**使用 **distinct** 关键字来消除查询结果的重复项

----------

3. **where子句**
	- 比较运算 **=、<>、<、>、>=、<=**
		1. **from Commodity c where c.price>400** 输出价格大于400的结果
		2. **from Commodity c where c.description is null** 输出描述（description）为空的结果
		3. **from Commodity c where c.description <> null** 输出描述（description）不为空的结果
	- 范围运算 **[not] in (列表)、[not] between 值1 and 值2**
		1. **from Customer c where c.age in (20,40)** 输出年龄位于20至40之间的结果
		2. **from Customer c where c.age between 20 and 40** 输出年龄位于20至40之间的结果
	- 字符串模式匹配 **like关键字、通配符%（任意字符）、_(一个字符）**
		1. **from Customer c where c.name like '张_'** 输出为张姓并且为两个字的结果
		2. **from Customer c where c.name like '%北京%'** 输出为字符串中含有北京字符的结果
	- 逻辑运算符 **and、or、not**
		1. **from Commodity c where c.price between 100 and 5000 and c.category like '%电脑%'** 输出为价格（c.price)介于100至5000同时类型(c.category)含有电脑字符串商品的结果
		2. **from Commodity c where c.price between 100 and 5000 or c.category like '%电脑%'** 输出为价格(c.price)介于100至5000或者类型(c.category)含有电脑字符串商品的结果
	- 集合运算 **is [not] empty(集合[不]为空)、member of(元素属于集合)**
		1. **from Order o where o.orderItems is empty** 查询 **o.orderItems** 为空的结果
	- 四则运算
		1. **from Commodity c where c.price*5 > 3000** 查询结果为5件价格总和大于3000的商品
	- 查询单个对象
		1. **from Customer c where c.name = '张三'** 返回张三的实例对象
				
				String hql = "from Customer c where c.name = '张三'";
				Query query = session.createQuery(hql);
				
				Customer c = (Customer)query.uniqueResult();
				System.out.println(c.getName());

----------

4. **order by子句**
	- **from Commodity order by price asc** 查询结果为按价格升序排序
	- **from Commodity order by seller.id asc,price desc,name asc** 返回的结果，首先按 **seller.id** 升序排列，如果 **seller.id** 相同，则按照 **price** 降序排列，如果前两个都相同，则按照第三个方式排序