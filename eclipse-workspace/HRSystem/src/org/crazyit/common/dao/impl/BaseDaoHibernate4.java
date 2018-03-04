package org.crazyit.common.dao.impl;

import org.crazyit.common.dao.BaseDao;
import org.hibernate.*;

import java.io.Serializable;
import java.util.List;

public class BaseDaoHibernate4<T> implements BaseDao<T> {
    //DAO组建进行持久化操作底层以来的SessionFactory组件
    private SessionFactory sessionFactory;

    //依赖注入SessionFactory所需的setter方法
    public void SessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(Class<T> entityClazz, Serializable id) {
        return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
    }

    @Override
    public Serializable save(T entity) {
        return getSessionFactory().getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    @Override
    public void delete(Class<T> entityClazz, Serializable id) {
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entityClazz.getSimpleName()
                        + " en where en.id = ?")
                .setParameter("0" , id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    protected List<T> find(String hql){
        return (List<T>) getSessionFactory().getCurrentSession().createQuery(hql).list();
    }

    @Override
    public List<T> findAll(Class<T> entityClazz) {
        return find("select en from "
                + entityClazz.getSimpleName() + " en");
    }

    @Override
    public long findCount(Class<T> entityClazz) {
        List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
        if(l != null && l.size() == 1){
            return (Long)l.get(0);
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    protected List<T> find(String hql, Object... params ){
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        for(int i = 0, len = params.length; i < len; i++){
            query.setParameter(i + "", params[i]);
        }

        return (List<T>)query.list();
    }

    /**
     * 使用hql 语句进行分页查询操作
     * @param hql 需要查询的hql语句
     * @param pageNo 查询第pageNo页的记录
     * @param pageSize 每页需要显示的记录数
     * @return 当前页的所有记录
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql, int pageNo, int pageSize){
        return getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    /**
     * 使用hql 语句进行分页查询操作
     * @param hql 需要查询的hql语句
     * @param params 如果hql带占位符参数，params用于传入占位符参数
     * @param pageNo 查询第pageNo页的记录
     * @param pageSize 每页需要显示的记录数
     * @return 当前页的所有记录
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params){
        Query query = getSessionFactory().getCurrentSession()
                .createQuery(hql);

        for(int i = 0, len = params.length; i < len; i++){
            query.setParameter(i + "", params[i]);
        }

        return query.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize).list();
    }
}
