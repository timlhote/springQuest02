package com.wildcodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class MyProjectApplication {
	private String[] doctors = {"William Hartnell","Patrick Troughton","Jon Pertwee","Tom Baker", "Paul McGann", "Christopher Eccleston", "David Tennant", "Matt Smith", "Jodie Whittaker"};
	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "";
	}

	@RequestMapping("/doctor")
	@ResponseBody
	public String doctors() {
		String html = "";
		html+="<ul>";

		for(int i=0;i <doctors.length;i++) {
			html += "<li><a href=\"/author/" + i + "\">"+doctors[i]+"</a></li>";
		}
		html+="</ul>";
		return html;
	}

	@RequestMapping("/doctor/{id}")
	@ResponseBody
	public String authorWithId(@PathVariable("id") int id) {

		return "The actor is " + doctors[id%doctors.length];
	}
}