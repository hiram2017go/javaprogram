# 结合struts 实现hibernate数据存储处理
基本跟Hibernate_interinate 相同，一个表对应多个类处理
sql语句:
```sql
CREATE TABLE `DicTbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
```

dic.hbm.xml文件内容:
```xml
<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<!-- Generated 2018-1-18 17:26:53 by Hibernate Tools 3.5.0.Final -->
<hibernate-mapping>
    <class name="com.zyy.bean.Dic" table="DicTbl">
    	<id name="id">
    		<generator class="native"></generator>
    	</id>

    	<discriminator column="category" type="string"/>
    	<property name="name" column="name" type="string"/>

    	<subclass name="com.zyy.bean.Major" discriminator-value="M"/>
    	<subclass name="com.zyy.bean.Region" discriminator-value="R"/>
    	<subclass name="com.zyy.bean.Position" discriminator-value="P"/>

    </class>
</hibernate-mapping>

```
