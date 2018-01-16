1.创建数据库表对应类
@GeneratedValue(strategy=GenerationType.IDENTITY) 主键标识使用这个，如果用auto，数据表id是自动增加的第二次执行会报错.
2.在hibernate.cfg.xml中session-facttory中添加<mapping class="com.zyy.bean.AnnotionUser"/>

3.使用标注获取session，但是此处需要使用Configuration获取conf,否则一直会报错：Exception in thread "main" java.lang.NoSuchFieldError: namingStrategy
Configuration conf = new Configuration().configure();
		Session session = conf.buildSessionFactory().openSession();
