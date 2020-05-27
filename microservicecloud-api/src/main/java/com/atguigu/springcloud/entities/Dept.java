package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@SuppressWarnings("serial")//告诉编译器忽略指定的警
@NoArgsConstructor
@Data
@Accessors(chain=true)//chain的中文含义是链式的，设置为true，则setter方法返回当前对象。如下
public class Dept implements Serializable {
	private Long deptno;//主键
	private String dname;//部门名称
	private String db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	public Dept(String dname)
	{
		super();
		this.dname = dname;
	}
//	public static void main(String[] args) {
//		Dept dept=new Dept();
//		System.out.println(dept.setDname("HT").setDeptno(11L));链式写法，@Accessors(chain=true)的作用
//	}
}
