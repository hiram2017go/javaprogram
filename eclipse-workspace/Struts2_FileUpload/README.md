## 使用struts2操作文件上传
1.包含struts2相关jar包及common-fileupload.jar 和 common-io.jar包。
2.设置相关属性，并且下面的2和3属性前缀必须与1属性相同
```java
  1 private File file; //从jsp的form表单中的file封装为此处的file

	2 private String fileContentType;

	3 private String fileFileName; //这个属性和fileContentType必须与File这个属性的前缀相同

	4 private String savePath;
```

3.上面的几个属性，如果有多个文件各个参数都可以使用数组。File[] files,String[] fileContentType

4.default.properties 其中包含属性上传文件类型 解析器 struts.multipart.parser  
  还需要处理的参数struts.multipart.saveDir 设置保存临时目录


---------------------

1.这里的这个参数比较重要
```xml
<struts>
	<constant name="struts.devMode" value="true"/>
	<constant name="struts.multipart.saveDir" value="D:\\Temp"></constant> <!-- 上传后这个临时文件放在哪里，上传完成后会把文件移动到目的文件夹，将临时文件删除掉 -->
	<package name="struts2-fileupload" namespace="/" extends="struts-default">
	 	<action name="upload" class="com.zyy.action.FileAction">
	 		<result name="success">/Success.jsp</result>

	 		<param name="savePath">/upload</param> <!-- 必须加了这句话，才能将tmp文件转存为正常文件 -->
	 	</action>
	</package>
</struts>
```

获取文件夹名称的也比较重要
```java
public String execute() throws Exception {
  String path = this.getSavePath();
  String fileName = this.fileFileName; //如果使用this.getFile().getName() 得到的是临时文件夹名

  String pathName = path+"\\"+fileName;
  System.out.println("name="+pathName);

  FileInputStream in = new FileInputStream(this.getFile());
  FileOutputStream out = new FileOutputStream(pathName);

  byte[] b = new byte[in.available()];

  in.read(b);
  out.write(b);

  in.close();
  out.close();

  return SUCCESS;
}
}
```
