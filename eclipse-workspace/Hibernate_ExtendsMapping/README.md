# hibernate 关联映射
## 1.多对一单一映射
包含2个数据表 CustomerTbl客户表及OrderTbl订单表，其中订单表中包含客户id，是CustomerTbl中id外键。
```sql
CREATE TABLE `CustomerTbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `OrderTbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `orderNumber` varchar(255) DEFAULT NULL,
  `customerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpvcy7fsd3qo0qq5yweivuhc4v` (`customerID`),
  CONSTRAINT `FKpvcy7fsd3qo0qq5yweivuhc4v` FOREIGN KEY (`customerID`) REFERENCES `CustomerTbl` (`id`),
  CONSTRAINT `ordertbl_fk` FOREIGN KEY (`customerID`) REFERENCES `CustomerTbl` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
```
相关类包含在com.zyy.singlem2onebean下。

hbm为：

```xml
  Customer.hbm.xml
  <hibernate-mapping>
      <class name="com.zyy.singlemto1bean.Customer" table="CustomerTbl" lazy="false"> <!-- laze=false 延迟加载，加载订单时把客户也加载出来 -->
          <id name="id" type="java.lang.Integer">
              <column name="ID" />
              <generator class="native" />
          </id>
          <property name="name" type="java.lang.String">
              <column name="NAME" />
          </property>
          <property name="email" type="java.lang.String">
              <column name="EMAIL" />
          </property>
      </class>
  </hibernate-mapping>

Order.hbm.xml
<hibernate-mapping>
    <class name="com.zyy.singlemto1bean.Orders" table="OrderTbl">
        <id name="id" type="java.lang.Integer">
            <column name="ID" />
            <generator class="native" />
        </id>
        <property name="name" type="java.lang.String">
            <column name="NAME" />
        </property>
        <property name="orderNumner" type="java.lang.String">
            <column name="orderNumber" />
        </property>
        <many-to-one name="customer" class="com.zyy.singlemto1bean.Customer">
            <column name="CustomerId" />  <!-- 外键 -->
        </many-to-one>
    </class>
</hibernate-mapping>
```

示例：
```java
//对象之间的导航 (有订单了，可以从订单汇总获取到用户.)--单向关联。
  Orders o = (Orders)get(Orders.class,new Integer(1));
  Customer c = o.getCustomer();
  System.out.println(c.getEmail());
实际查询语言:
  Hibernate: select orders0_.ID as ID1_1_0_, orders0_.NAME as NAME2_1_0_, orders0_.orderNumber as orderNum3_1_0_, orders0_.CustomerId as Customer4_1_0_ from OrderTbl orders0_ where orders0_.ID=?
Hibernate: select customer0_.ID as ID1_0_0_, customer0_.NAME as NAME2_0_0_, customer0_.EMAIL as EMAIL3_0_0_ from CustomerTbl customer0_ where customer0_.ID=?
```

## 2.多对一的双向关联 (较少用)
### 均在com.zyy.twowaymto1bean中。
还是相同的两张表，客户表CustomerTbl和订单表OrderTbl，实现客户类中增加客户的订单类，为1对多形式。
区别在于：Customer2.hbm.xml
```xml
<hibernate-mapping>
    <class name="com.zyy.twowaymto1bean.Customer2" table="CustomerTbl">
        <id name="id" type="java.lang.Integer">
            <column name="ID" />
            <generator class="native" />
        </id>
        <property name="name" type="java.lang.String">
            <column name="NAME" />
        </property>

        <property name="email" type="java.lang.String">
            <column name="EMAIL" />
        </property>

        <!-- <set name="Orders" table="OrderTbl" inverse="false" lazy="true">  集合外键  系统自动生成的
            <key>
                <column name="ID" />
            </key>
            <element type="string">
                <column name="ORDERS" />
            </element>
        </set> -->

        <set name="orders" table="OrderTbl" lazy="false">
        	<key column="CustomerID"></key>  <!-- 集合外键 ,此处表示当前CustomerTbl表对应Orders表中的字段-->
        	<one-to-many  class="com.zyy.twowaymto1bean.Orders2"/>
        </set>
    </class>
</hibernate-mapping>

```
执行实例:通过用户表获取用户的订单：
```java
Customer2 c2 = (Customer2)get(Customer2.class, new Integer(1));
		Set set = c2.getOrders();
		Iterator it = set.iterator();

		while(it.hasNext()) {
			Orders2 o2 = (Orders2)it.next();
			System.out.println(o2.getCustomer().getName()+":"+o2.getName()+":"+o2.getOrderNumner());
		}

实际执行的hql语句：
Hibernate: select customer2x0_.ID as ID1_0_0_, customer2x0_.NAME as NAME2_0_0_, customer2x0_.EMAIL as EMAIL3_0_0_ from CustomerTbl customer2x0_ where customer2x0_.ID=?
Hibernate: select orders0_.CustomerID as Customer4_1_0_, orders0_.ID as ID1_1_0_, orders0_.ID as ID1_1_1_, orders0_.NAME as NAME2_1_1_, orders0_.orderNumber as orderNum3_1_1_, orders0_.CustomerId as Customer4_1_1_ from OrderTbl orders0_ where orders0_.CustomerID=?
```

## 3.一对一单向映射
所有实现在com.zyy.single1to1bean包中实现。包含2个数据表市民表CitizenTbl及身份证表CardTbl，其中CardTbl中的id为CitizenTbl表中id的外键.
```sql
CitizenTbl:
CREATE TABLE `CitizenTbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CardTbl:
CREATE TABLE `CardTbl` (
  `id` int(11) NOT NULL,
  `serial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idcardtbl_fk` FOREIGN KEY (`id`) REFERENCES `CitizenTbl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
```
对应hbm配置文件
```xml
Citizen.hbm.xml
<hibernate-mapping>
    <class name="com.zyy.single1to1bean.Citizen" table="CitizenTbl">
        <id name="id" type="java.lang.Integer">
            <column name="id" />
            <generator class="native" />
        </id>
        <property name="name" type="java.lang.String">
            <column name="name" />
        </property>
    </class>
</hibernate-mapping>

Card.hbm.xml
<hibernate-mapping>
    <class name="com.zyy.single1to1bean.Card" table="CardTbl">
        <id name="id" type="java.lang.Integer">
            <generator class="foreign">
            	<param name="property">citizen</param>   <!--  属性为Card中的属性citizen为外键foreign -->
            </generator>
        </id>
        <property name="serial" type="java.lang.String">
            <column name="serial" />
        </property>

        <one-to-one name="citizen" class="com.zyy.single1to1bean.Citizen"></one-to-one>  <!-- 一对一对应关系,citizen为Card类与Citizen的一对一的关系. -->
    </class>
</hibernate-mapping>

```

## 4.一对一双向映射
 在Citizen2类中增加Card2属性，获取市民信息时可以获取到其身份证。
xml文件card2.hbm.xml与上面的方式相同
 ```xml
 Citizen2.hbm.xml
 <hibernate-mapping>
    <class name="com.zyy.twoway1to1bean.Citizen2" table="CitizenTbl">
        <id name="id" type="java.lang.Integer">
            <column name="id" />
            <generator class="native" />
        </id>
        <property name="name" type="java.lang.String">
            <column name="name" />
        </property>
        <one-to-one name="card" class="com.zyy.twoway1to1bean.Card2"/>
    </class>
</hibernate-mapping>

 ```

 同样是在映射文件中添加one-to-one属性。
