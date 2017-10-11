package com.websystique.springmvc;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		String[] sa = {"a", "b", "c"};
		for(String s :sa){
			if("b".equals(s)) continue;
			System.out.println(s);if("b".equals(s)) break;
			System.out.println(s+" again"); }
		SpringApplication.run(Application.class, args);
	}
}

