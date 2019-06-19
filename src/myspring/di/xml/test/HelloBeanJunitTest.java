package myspring.di.xml.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import junit.framework.Assert;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import static org.junit.Assert.*;

public class HelloBeanJunitTest {
	
	ApplicationContext context;
	
	@Before
	public void init() {
		// 1. IoC 컨테이너 생성
		// 1. ApplicationContext 객체 생성
		context = new GenericXmlApplicationContext("classpath:config/beans.xml");
	}
	
	@Test
	public void test2() {
		//2. Hello Bean 가져오기
		Hello hello1 = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
		
		assertSame(hello1, hello2);
	}

	@Test @Ignore
	public void test1() {
		// TODO Auto-generated method stub
		
		//2. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		//System.out.println(hello.sayHello());
		assertEquals("Hello Spring", hello.sayHello());
		
		// 3. Hello의 print() 호출
		hello.print();

		//4. StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer",Printer.class);
		//System.out.println(printer.toString());
		assertEquals("Hello Spring", printer.toString());
		
		Hello hello2 = (Hello) context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
		
	}

}
