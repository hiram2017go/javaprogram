本程序处理的是继承映射相关代码：
# 为了区分更清楚，采用不同的包进行编写，其实类结构都相同，只是hbm.xml映射文件不同。不同的包表示不同的映射对应关系.
## 1.表与子类独立的一对一关系：
  两个表：booktbl 和 clothes：
  ```sql
  CREATE TABLE `booktbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pagecount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `clothestbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
  ```

  因为存在相同的两个属性id和name，所以使用一个父类包含这两个属性，另外的两个独有的属性子类自己包含。
```java
public class Product {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}


public class Book extends Product {
	private int pagecount;

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

}

public class Clothes extends Product {
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

```
hbm映射文件使用各自独有的进行保存:
```xml
<hibernate-mapping>
   <class name="com.zyy.extendsbean.Book" table="booktbl">
   		<id name="id">
   			<generator class="native"></generator>
   		</id>

   		<property name="name" column="name" type="java.lang.String"></property>
   		<property name="pagecount" column="pagecount" type="int"></property>
   </class>
</hibernate-mapping>

<hibernate-mapping>
    <class name="com.zyy.extendsbean.Clothes" table="clothestbl">
    	<id name="id">
    		<generator class="native"></generator>
    	</id>

    	<property name="name" type="java.lang.String" column="name"></property>
    	<property name="size" type="int" column="size"></property>
    </class>
</hibernate-mapping>
```
--------

## 2.每个子类对应一张子表，并与主类共享主表。

Product、Book、Clothes三个类与上边的相同，只是映射改为主表映射。数据表中使用3张表，主表及2子表，并且进行外键映射.
```sql
CREATE TABLE `producttbl2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


CREATE TABLE `booktbl2` (
  `id` int(11) NOT NULL,
  `pagecount` int(11) DEFAULT NULL,
  KEY `book_fk` (`id`),
  CONSTRAINT `book_fk` FOREIGN KEY (`id`) REFERENCES `producttbl2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `clothestbl2` (
  `id` int(11) NOT NULL,
  `size` int(11) DEFAULT NULL,
  KEY `clothes_fk` (`id`),
  CONSTRAINT `clothes_fk` FOREIGN KEY (`id`) REFERENCES `producttbl2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```

此种方式只使用主表映射，所以hbm.xml只创建主表的:
```xml
<hibernate-mapping>
    <class name="com.zyy.maintablbean.Product2" table="producttbl2">
        <id name="id">
        	<generator class="native"></generator>
        </id>

        <property name="name" column="name" type="java.lang.String"></property>

        <joined-subclass name="com.zyy.maintablbean.Book2" table="booktbl2">
        	<key column="id"/>  <!-- 子表对应外键 -->
        	<property name="pagecount" column="pagecount" type="int"></property>
        </joined-subclass>

        <joined-subclass name="com.zyy.maintablbean.Clothes2" table="clothestbl2">
        	<key column="id"></key>
        	<property name="size" column="size" type="int"></property>
        </joined-subclass>
    </class>
</hibernate-mapping>
```
**分别插入Book2 和 Clothes2 实际的hibernate语句为:**
```sql
Hibernate: insert into producttbl2 (name) values (?)
Hibernate: insert into booktbl2 (pagecount, id) values (?, ?)
和
Hibernate: insert into producttbl2 (name) values (?)
Hibernate: insert into clothestbl2 (size, id) values (?, ?)
```
---------------------

## 3.表与类的一对多关系
一张表product3增加一个字段category区分是书籍还是衣服。
```sql
CREATE TABLE `producttbl3` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pagecount` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL, --进行区分的标识
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```
三个类结构还是同上三张继承表,只是修改hbm.xml映射文件
```xml
<hibernate-mapping>
    <class name="com.zyy.categorybean.Product3" table="producttbl3">
    	<id name="id">
    		<generator class="native"></generator>
    	</id>

    	<discriminator column="category" type="string" /> <!-- 用来做区分的字段 -->

    	<property name="name" column="name" type="string"/>
    	<subclass name="com.zyy.categorybean.Book3" discriminator-value="B">
    		<property name="pagecount" column="pagecount" type="int"></property>
    	</subclass>

    	<subclass name="com.zyy.categorybean.Clothes3" discriminator-value="C">
    		<property name="size" column="size" type="int"></property>
    	</subclass>

    </class>
</hibernate-mapping>
```

实际执行的hibernate操作语句:
```sql
Hibernate: insert into producttbl3 (name, pagecount, category) values (?, ?, 'B')
Hibernate: insert into producttbl3 (name, size, category) values (?, ?, 'C')
```
