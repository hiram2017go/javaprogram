## 本项目为hibernate与struts1.x实现的一个简单的java论坛系统。
    //因为要获取到SystemMember QuestionType，所以要加载到暑假，需要将SystemMember.hbm.xml QuestionType.hbm.xml 设置lazy=false
    List list = dao.listQuestion();
    for(int i = 0; i< list.size();i++) {
    Question q = (Question)list.get(i);
     System.out.println(q.getSm().getName()); //否则加载用户信息和问题类型会出错
    }


   **   //而下面使用fetch查询到不需要使用lazy=false **

   public List questionDetailList() {
    String hql = "from Question as q left join fetch q.sm left join fetch q.qt";
    
    return super.list(hql);
  }

   
    List list = dao.questionDetailList();
//    for(int i = 0; i< list.size();i++) {
//      Question q = (Question)list.get(i);
//      System.out.println("-----"+q.getSm().getName());
//
//      System.out.println("==="+q.getQt().getName());
//    }


## 使用事务提交时多个表，按照顺序提交就行

｀｀｀java
Session session = SessionUtil.getSession();
		Transaction tran = session.beginTransaction();
		String hql = "update Question as q set q.answerCount = q.answerCount + 1 where q.id = ?";
		
		try {
			Query q = session.createQuery(hql);
			q.setInteger(0, a.getQ().getId());
			session.save(a);
			q.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		}finally {
			SessionUtil.closeSession();
		}
｀｀｀