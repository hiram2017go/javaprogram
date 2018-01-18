hibernate中使用大数据类型，存储图片和超大文本时分别使用Blob和Clob.
但是hibernate升级到hibernate4之后，上面的方法被弃用了。使用Spring框架中方式去处理.
/*Blob pic = Hibernate.createBlob(in);
			Clob resume = Hibernate.createClob("this is a resume!");*/

			/*
			 * hibernate升级到hibernate4之后，上面的方法被弃用了。

			byte[] fileArray = org.springframework.util.FileCopyUtils.copyToByteArray(file);  
			cardInfo.setPhotoFile(fileArray);  */
