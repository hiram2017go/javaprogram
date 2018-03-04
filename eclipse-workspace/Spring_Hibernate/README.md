# Spring Hibernate
-------
Struts --> mvc .  Hibernate ---> orm
-------
对应代码运行有问题.

执行查询类 extends HibernateTemplate
获取列表时直接就可以使用super.find("from User");就可以了。
继承后因为超类还是使用了sessionfactory,所以配置中还需要sessionfactory.
----------------------
通过IOC(控制反转)达到松耦合的目的。获得依赖对象的过程被反转。
注入：在加载bean的时候完成变量的赋值。


---------------------
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{
public Collection loadProductsByCategory(String category) throws DataAccessException{
  return getHibernateTemplate().find("from test.Product product where product.category=?", category);
}

}
