package myspring.di.xml.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import static org.junit.Assert.*;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {
	
	@Autowired
	ApplicationContext context;
	
	/*@Before
	public void init() {
		// 1. IoC 컨테이너 생성
		// 1. ApplicationContext 객체 생성
		context = new GenericXmlApplicationContext("classpath:config/beans.xml");
	}*/
	
	@Test @Ignore
	public void test2() {
		//2. Hello Bean 가져오기
		Hello hello1 = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
		
		assertSame(hello1, hello2);
	}

	@Test
	public void test1() {
		// TODO Auto-generated method stub
		
		//2. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello2");
		//System.out.println(hello.sayHello());
		assertEquals("Hello Spring12", hello.sayHello());
		
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		
		for (String value : list) {
			System.out.println(value);
		}

		//4. StringPrinter Bean 가져오기
		Printer printer = context.getBean("printer",Printer.class);
		//System.out.println(printer.toString());
		assertEquals("Hello Spring12", printer.toString());
		
		//Hello hello2 = (Hello) context.getBean("hello", Hello.class);
		//System.out.println(hello == hello2);
		
	}

}
