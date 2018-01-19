## hibernate 中hql的使用

### 查询时可以不取别名，直接用属性select。
eg:select id,name from User;

```sql
String sql = " from User as u where u.id > 5";
Query query = session.createQuery(sql);

必须使用User获取,不能使用Object来获取
for(int i = 0; i < list.size(); i++) {
			User u = (User)list.get(i);
			System.out.println("用户id:"+u.getId()+",name="+u.getName()+",pass="+u.getPassword());
		}
```
-----
### 使用Object获取
```sql
String sql = "select count(*),min(id) from User where id > 5";
Query query = session.createQuery(sql);

for(int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[])list.get(i);
			for(int j = 0; j < obj.length; j++) {
				System.out.print(obj[j]+",");
			}
			System.out.println("");
		}
```
-----
### 使用类返回:
需要 new 一个类，添加**new**,并且添加此类的构造函数.

```sql
String sql = "select new User(id,name,password) from User where id > 5";
Query query = session.createQuery(sql);

必须使用User来获取

for(int i = 0; i < list.size(); i++) {
			User u = (User)list.get(i);
			System.out.println("用户id:"+u.getId()+",name="+u.getName()+",pass="+u.getPassword());
		}
```
-----
### 添加参数
```sql
String sql = "select new User(id,name,password) from User where id > :id";
Query query = session.createQuery(sql);
query.setInteger("id", 10);

或另外一种：
String sql = "select new User(id,name,password) from User where id > ?";
Query query = session.createQuery(sql);
query.setInteger(0, 12);
```

-----
### 从配置文件中获取查询语句

```sql
<hibernate-mapping>
    <class name="com.zyy.bean.User" table="usertbl">	<!-- 表名是大小写匹配的 -->
        <id name="id" type="int">
            <column name="ID" />
            <generator class="native" />
        </id>
        <property name="name" type="java.lang.String">
            <column name="NAME" />
        </property>
        <property name="password" type="java.lang.String">
            <column name="PASSWORD" />
        </property>
    </class>

    <query name="querygt12">from User as user where user.id = :id </query>
</hibernate-mapping>

查询语句:
Query query = session.getNamedQuery("queryEqual12");
query.setInteger("id", 12);

```
-----
### 删除或更新方法

```sql
public static void delete() {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		Transaction tran = session.beginTransaction();

		try {
			String sql = "delete User as u where u.id = :id";
			Query query = session.createQuery(sql);
			query.setInteger("id", 5);
			query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tran.rollback();
		}finally {
			session.close();
		}

	}

  更新：String sql = "update User as u set u.name = :name where u.id = :id";
  ```

--------

### hibernate5.0 新的查询:
```java
public static void getQuery() {

		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();
		String hql = "from User";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> list = query.getResultList();

		for(User u : list) {
			System.out.println("name="+u.getName()+":"+u.getId());
		}

	}
```

### left join

hibernate 中 left join 在hql  用之前，比如 A left join B必须关联为 a对象有b对象的应用，且在a.hbm,xml文件中有对b的配置.否则会报nullPointerException等错误

```java
public static void leftJoin() {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();

		String hql = "selct o from Orders as  o left join o.customer as c ";
		Query query = session.createQuery(hql);
		System.out.println("left join 搞起来......");

		List list = query.list();
		for(int i = 0; i < list.size(); i++) {
			Orders o = (Orders)list.get(i);
			System.out.println("id="+o.getId()+",name="+o.getName());
		}

	}
```


### fetch 查询

**一个"fetch"连接允许仅仅使用一个选择语句就将相关联的对象或一组值的集合随着他们的父对象的初始化而被初始化，这种方法在使用到集合的情况下尤其有用，对于关联和集合来说，它有效的代替了映射文件中的外联接 与延迟声明（lazy declarations）.
一个fetch连接通常不需要被指定别名, 因为相关联的对象不应当被用在 where 子句 (或其它任何子句)中。同时，相关联的对象 并不在查询的结果中直接返回，但可以通过他们的父对象来访问到他们。**


```java
public static void leftEfetchJoin() {
		HibernateUtil util = new HibernateUtil();
		Session session = util.getSession();

		String hql = "from Orders as o left join fetch o.customer";
		Query query = session.createQuery(hql);
		System.out.println("left join 搞起来......");
		List list = query.list();
		for(int i = 0; i < list.size(); i++) {
			Orders order =(Orders)list.get(i);
			Customer customer = order.getCustomer();
			System.out.print("oid="+order.getId()+",orderno="+order.getOrderNumber()+",name="+order.getName());
			if(customer != null )
			{
				System.out.print(".不是空的:");
				System.out.println("cid="+customer.getId()+",email="+customer.getEmail());
			}
			else {
				System.out.println("空的");
			}
			System.out.println("");
		}

	}
```

实际执行的SQL语句:
```sql
Hibernate: select orders0_.ID as ID1_1_0_, customer1_.ID as ID1_0_1_, orders0_.NAME as NAME2_1_0_, orders0_.orderNumber as orderNum3_1_0_, orders0_.customerID as customer4_1_0_, customer1_.NAME as NAME2_0_1_, customer1_.EMAIL as EMAIL3_0_1_ from OrderTbl orders0_ left outer join CustomerTbl customer1_ on orders0_.customerID=customer1_.ID

```
