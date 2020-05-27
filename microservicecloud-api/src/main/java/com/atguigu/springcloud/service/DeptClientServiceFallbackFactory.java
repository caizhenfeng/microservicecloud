package com.atguigu.springcloud.service;
 
import java.util.List;
 
import org.springframework.stereotype.Component;
 
import com.atguigu.springcloud.entities.Dept;
 
import feign.hystrix.FallbackFactory;
 
@Component//不要忘记添加，不要忘记添加（把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{

	@Override
	public DeptClientService create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id)
			               .setDname("该ID："+id+"没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
			               .setDb_source("no this database in MySQL");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
	/*
  @Override
  public DeptClientService create(Throwable throwable)

  {
   return new DeptClientService() {
     @Override
     public Dept get(long id)
     {
       return new Dept().setDeptno(id)
               .setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
               .setDb_source("no this database in MySQL");
     }
 
     @Override
     public List<Dept> list()
     {
       return null;
     }
 
     @Override
     public boolean add(Dept dept)
     {
       return false;
     }
   };
  }
  */
}
 
 
 
