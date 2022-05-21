# Spring MVC에서의 Dynamic Web Page 동작 구조



## 1. 동적 웹에서의 클라이언트 요청처리 방법 (Web Server, WAS)

![1](https://github.com/syhojeo/SpringMVC/blob/main/image/1.png)

# Web Server

클라이언트가 서버에 페이지 요청(request)을 하면 요청을 받아 정적 콘텐츠(html., png, css등)를 응답(response) 해준다



## Web Server의 기능

1. 정적인 요청일 경우

   클라이언트가 정적인 요청을 할 경우 정적인 콘텐츠를 응답해준다

2. 동적인 요청일 경우

   클라이언트가 동적인 요청을 할 경우 WAS로 처리를 이관한 뒤 WAS에서 처리한 결과를 클라이언트에게 정적인 상태로 응답한다

**대표적인 web server: Apache, WebtoB, Nginx, IIS 등**



# WAS (Web Application Server)

DB조회가 필요하거나 사용자의 입력을 받아 서버에서 가변적으로 로직을 수행하는 등의 **동적인 처리** 가 필요한 동적인 요청을 위해 만들어 졌다

Web Container의 JSP/Servlet을 통해 구동 환경을 제공하고, 프로그래밍 언어(Java)를 통해 JSP, ASP, PHP 등을 작성한뒤 HTML 문서로 만들고 Web Server로 전달한다



## WAS 작동 프로세스

1. Web Server로 요청이 오면 Web Container(Servlet Container)가 응답
2. 컨테이너는 web.xml을 참조하여 해당 서블릿에 대한 쓰레드를 생성하고, HttpServletRequest와 HttpServletResponse객체를 생성하여 전달한다

![1](https://github.com/syhojeo/SpringMVC/blob/main/image/2.png)

3. Servlet Container는 JSP/Servlet 호출한다
4. 호출된 Servlet의 작업을 담당하게 된 쓰레드는 doPost() 또는 doGet()을 호출한다
5. 호출된 doPost(), doGet() 메서드는 생성된 동적 페이지를 Response 객체에 담아 컨테이너에 전달한다
6. 컨테이너는 전달받은 Response 객체를 HTTPResponse형태로 바꿔 Webserver에 전달한다
7. 컨테이너는 생성되었던 스레드를 종료하고, HttpServletRequest, HttpServletResponse 객체를 소멸시킨다

참고.

https://coding-factory.tistory.com/741

https://gmlwjd9405.github.io/2018/10/27/webserver-vs-was.html



## 2. Servlet이란 무엇인가?  ( Servlet과 DispatcherServlet)

## CGI (Common Gateway Interface) 와 Servlet, JSP

정적 웹 사이트의 요청에서는 application이 필요가 없다 항상 Client가 요청하는 정적페이지를 넘겨주면 되기 때문이다



하지만 동적 웹 사이트가 대두되면서 Client가 요청하는 다양한 값들(request)에 대한 데이터 처리가 필요하게 되었는데 이를 하게 되는것이 **Application** 이다



이때 Client의 요청을 받는 web sever와 다양한 request값들에 대해 요청을 수행하는 Application 간의 연결을 해주는게 CGI 이다

![1](https://github.com/syhojeo/SpringMVC/blob/main/image/3.png)

기능

프로그램의 표준 출력 결과를 클라이언트에게 전송

=> 웹 브라우저용 출력화면을 만들어준다



CGI의 프로그래밍에는 Servlet과 Jsp 가 존재한다



### Servlet 

servlet은 웹 요청과 응답의 흐름을 간단한 메서드 호출만으로 체게적으로 다룰 수 있게 해준다

자바 기반의 확장 CGI 프로그래밍 언어로써 웹 애플리케이션 프로그래밍 기술이다



**실행 조건**

실행하기 위해서는 JDK와 서블릿 컨테이너가 필요하며 대표적인 서블릿 컨테이너로 Tomcat, Resin, Web Sphere등이 있다



![서블릿.png](https://github.com/syhojeo/SpringMVC/blob/main/servlet.png)



### JSP (Java Server Page)

자바 언어로 작성된 확장 CGI 기반의 스크립트 언어

JSP 는 동적으로 생성될 때 HTML 코드가 스크립트 형태로 작성된다 이를 통해 서블릿에 비해 쉽고 빠르게 웹 애플리케이션을 구현할 수 있다



JSP 로 작성된 코드는 호출시 서블릿으로 자동 변환되어 컴파일 과정을 거친 후 실행 가능 상태로 된다



# Dispatcher Servlet (Front Controller)

HTTP 프로토콜로 들어오는 모든 요청을 가장 먼저 받아 적합한 컨트롤러에 위임해주는 Front Controller 이다

Dispatcher Servlet은 요청이 들어왔을때 공통작업을 처리한 후에 해당 요청을 처리해야하는 컨트롤러를 찾아서 위임해준다

## Dispatcher Servlet 동작 과정

![1](https://github.com/syhojeo/SpringMVC/blob/main/image/4.png)

1. Dispatcher Servlet이 클라이언트의 요청을 받는다

2. 받은 요청에 대한 공통적인 작업을 처리 한 후에 Handler Mapping을 통하여 해당 요청에 알맞는 Controller의 경로를 찾는다

3. Handler Adapter 를 사용하여 해당 controller에게 요청을 위임한다

4. 비지니스 로직을 수행 후  Handler Adapter는결과를 반환받고 ModelAndView 객체로 변환후 DispatcherServlet으로 결과를 반환한다

5. 최종적으로 Dispatcher Servlet은 결과를 사용자에게 보여줄 view를 찾기 위해 ViewResolver 빈 객체를 사용한다

   때문에 ModelAndView 는 사용자에게 보여줄 View 이름또한 담고 있으며 이를 가지고 response를 생성 요청하여 웹 브라우저에 JSP를 실행시켜준다



### 전체 처리 과정

![1](https://github.com/syhojeo/SpringMVC/blob/main/image/5.png)



참고.

https://mangkyu.tistory.com/18



##  3. Root WebApplication context 와 servlet WebApplication context

![mvc context hierarchy](https://docs.spring.io/spring-framework/docs/current/reference/html/images/mvc-context-hierarchy.png)

## Web Application Contxt

Web ApplicationContext 는 ApplicationContext를 확장한 WebApplicationContext 인터페이스의 구현체이다

Web ApplicationContext 는 ApplicationContext를 상속받는다

## Application Context

빈의 생성과 관계설정 같은 제어를 담당하는 IoC(Inversion of Control) 컨테이너인 Bean Factory 가 존재한다

하지만 빈생성과 관계설정 이외의 추가 기능을 사용하기 위해서 Bean Factory를 상속받아 확장한 Application Context를 주로 사용한다

Application Context는 별도의 설정 정보를 참고하고, IoC 를 적용하여 빈의 생성, 관계설정 등의 제어작업을 총괄한다

다만 직접 오브젝트를 생성하고 관계를 맺어주는 코드는 존재하지 않고,

** 생성 정보와 연관관계 정보에 대한 설정을 읽어 처리한다** ex) @Configuration 과 같은 Annotation 이 대표적인 IoC 설정정보이다



![1](https://github.com/syhojeo/SpringMVC/blob/main/image/6.png)



1. Application Context는 @Configuration이 붙은 클래스들을 설정 정보로 등록
2. @Bean이 붙은 메소드의 이름으로 Bean 목록 생성
3. 클라이언트가 Bean을 요청했을때 Bean 목록에서 요청한 이름이 있는지 찾고, 있다면 빈 생성 메서드(@Bean)을 호출하여 객체를 생성하고 돌려준다



참고

https://linked2ev.github.io/spring/2019/09/15/Spring-5-%EC%84%9C%EB%B8%94%EB%A6%BF%EA%B3%BC-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90%EC%84%9C-Context(%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8)%EB%9E%80/

https://mangkyu.tistory.com/151

https://jeong-pro.tistory.com/222



# Web Application 동작원리

![1](https://github.com/syhojeo/SpringMVC/blob/main/image/7.png)

1. WAS 가 구동되면서 web.xml 로딩

2. web.xml 에 등록되어 있는 ContextLoaderListener 생성

    ContextLoaderListener 는 ServletContextListener 인터페이스를 구현하고 있으며, Application Context를 생성하는 역할을 수행한다

3. 생성된 ContextLoader는 root-context.xml 를 loading 한다

4. root-context.xml에 등록 되어 있는 Spring Container 가 구동된다

   이때 개발자가 작성한 비즈니스 로직에 대한 부분과 DAO, VO 객체들이 생성됨

   -----------------------------------------------------------------------------------------------------------------

5. 클라이언트로 부터 웹 어플리케이션 요청이 들어온다

6. DispatcherServlet이 생성

7. DispatcherServlet은 servlet-context.xml을 loading 한다 이후 DispatcherServlet은 HandlerMapping을 통해 Controller로 위임 처리한다

8. 두번째 Spring Container가 구동되며 응답에 맞는 PageController들이 동작한다

   이때 첫번째 Spring Container가 구동되면서 생성된 DAO, Vo, servicempl 클래스들과 협업하여 알맞은 작업을 처리하게 된다

9. 처리후 controller는 view이름을 리턴하고 ViewResolver를 통해 사용자에게 보여준다

참고

https://m.blog.naver.com/sunju635/221822089143

Spring container 란?







### application context 와 servlet context 의 라이프사이클 차이  pageContext? context는 무엇인가

https://jypthemiracle.medium.com/servletcontainer%EC%99%80-springcontainer%EB%8A%94-%EB%AC%B4%EC%97%87%EC%9D%B4-%EB%8B%A4%EB%A5%B8%EA%B0%80-626d27a80fe5





### modelAttribute, Command Object

https://medium.com/webeveloper/modelattribute-%EC%99%80-%EC%BB%A4%EB%A7%A8%EB%93%9C-%EA%B0%9D%EC%B2%B4-command-object-42c14f268324



### /*와 /의 차이점 (web.xml mapping)



### Root Web Application Context의 여러가지 Bean DI 방법

https://programmingrecoding.tistory.com/25