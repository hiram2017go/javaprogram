## 普通方式上传文件

1.导入common-fileupload.jar和common-io.jar两个包。
2.使用Servlet进行操作文件.

3.上传与保存相关代码:
```java
    FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			List item = upload.parseRequest(request);
			Iterator iter = item.iterator();
			while(iter.hasNext()) {
				FileItem fileItem = (FileItem)iter.next();
				if(fileItem.isFormField()) { //普通的表单提交
					System.out.print(fileItem.getFieldName()+";");
				}else {
					System.out.println(fileItem.getFieldName()+";");
					System.out.println(fileItem.getName());
					int idx = fileItem.getName().lastIndexOf("\\");
					String fileName = fileItem.getName().substring(idx);
					String path = this.getServletContext().getRealPath("\\upload");
					System.out.println("path="+path);
					File f = new File(path+"\\"+fileName);

					try {
						fileItem.write(f);
					} catch (Exception e) {
						// TODO: handle exception
					}finally {
					}
				}
			}


		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出了异常:"+e.getMessage());
		}
```
具体的可以参考common-fileupload.jar源码或查看其文档.

4.上传的类型需要为:
method="post" enctype="multipart/form-data"
