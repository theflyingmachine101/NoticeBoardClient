package org.noticeBoard;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.noticeBoard.entities.Notice;
import org.noticeBoard.entities.Student;
import org.noticeBoard.entities.Teacher;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	String baseURL="http://localhost:8080";
	HttpHeaders headers ;
	ModelAndView modelAndView;
	RestTemplate restTemplate;
	
	 public WebController() {
		restTemplate=new RestTemplate();
		 modelAndView=new ModelAndView("home.html");
		 headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		return modelAndView;
	}
	
	@RequestMapping("/get-notice-by-id")
	public ModelAndView getNoticeById()
	{
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		Notice notice=restTemplate.exchange(baseURL+"/getNotice/3",HttpMethod.GET, entity,Notice.class).getBody() ;
		System.out.println(notice.toString());
		return modelAndView;
	}
	
	
	
	@RequestMapping("/get-all-notice-by-tid")
	public  ModelAndView getAllNoticeByTeacher() {
			ResponseEntity<List<Notice>> noteResponse =
			        restTemplate.exchange(baseURL+"/getAllNotice/2",
			                    HttpMethod.GET,
			                    null,
			                    new ParameterizedTypeReference<List<Notice>>() {});
			List<Notice> allNotice = noteResponse.getBody();
			
			for(int i=0;i<allNotice.size();++i)
			{
			 System.out.println(allNotice.get(i).toString());	
			}
		
			return modelAndView;
	}
	
	
	@RequestMapping("/get-teacher-by-email")
	public ModelAndView getTeacherByEmail()
	{
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		Teacher teacher=restTemplate.exchange(baseURL+"/teacher/teacher2@t.com",HttpMethod.GET, entity,Teacher.class).getBody() ;
		System.out.println(teacher.toString());
		return modelAndView;
	}
	
	@RequestMapping("/get-student-by-email")
	public ModelAndView getStudentByEmail()
	{
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		Student student=restTemplate.exchange(baseURL+"/student/student1@s.com",HttpMethod.GET, entity,Student.class).getBody() ;
		System.out.println(student.toString());
		return modelAndView;
	}
	
	
	
	@RequestMapping("/add-teacher")
	public ModelAndView addTeacher()
	{
		Teacher teacher=new Teacher("t3","t3@t.com");
	    HttpEntity <Teacher> entity = new HttpEntity<Teacher>(teacher,headers);
		ResponseEntity<String>responseEntity=restTemplate.exchange(baseURL+"/teacher/addTeacher",
				HttpMethod.POST,
				entity,
				String.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK)
			System.out.println("Teacher Added");
		return modelAndView;
	}
	
	
	@RequestMapping("/add-student")
	public ModelAndView addStudent()
	{
		Student student =new Student("s3","s3@s.com");
	    HttpEntity <Student> entity = new HttpEntity<Student>(student,headers);
		ResponseEntity<String>responseEntity=restTemplate.exchange(baseURL+"/student/addStudent",
				HttpMethod.POST,
				entity,
				String.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK)
			System.out.println("Student Added");
		return modelAndView;
	}
	
	
	@RequestMapping("/add-notice")
	public ModelAndView addNotice()
	{
		Date date=new Date(2020,1,1);
		Time time=new Time(12, 12, 12);
		Notice notice =new Notice(2,"N2","Later",date,time);
	    HttpEntity <Notice> entity = new HttpEntity<Notice>(notice,headers);
		ResponseEntity<String>responseEntity=restTemplate.exchange(baseURL+"/teacher/addNotice",
				HttpMethod.POST,
				entity,
				String.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK)
			System.out.println("Notice Added");
		return modelAndView;
	}
	
	
	@RequestMapping("/update-notice")
	public ModelAndView updateNotice()
	{
		Date date=new Date(2020,1,1);
		Time time=new Time(12, 12, 12);
		Notice notice =new Notice(5,2,"N5","Later",date,time);
	    HttpEntity <Notice> entity = new HttpEntity<Notice>(notice,headers);
		ResponseEntity<String>responseEntity=restTemplate.exchange(baseURL+"/teacher/updateNotice",
				HttpMethod.PUT,
				entity,
				String.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK)
			System.out.println("Notice Updated");
		return modelAndView;
	}
	
	
	
	
	@RequestMapping("/delete-notice")
	public ModelAndView deleteNotice()
	{
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String>responseEntity=restTemplate.exchange(baseURL+"/teacher/deleteNotice/5",
				HttpMethod.DELETE,
				entity,
				String.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK)
			System.out.println("Notice Deleted");
		return modelAndView;
	}
	
	
}
