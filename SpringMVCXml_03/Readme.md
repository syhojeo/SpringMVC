# xml을 이용한 SpringMVC 설정

Spring에서의 web.xml 설정은 DispatcherServlet을 설정하는것과 같다



## dispatcherservlet



![mvc context hierarchy](https://docs.spring.io/spring-framework/docs/current/reference/html/images/mvc-context-hierarchy.png)



DispatcherServlet이 여러개일 경우 공통으로 사용할 빈들을 Root WebApplicationCOntext에 선언해두고 공유하게 한다



### Root WebApplicationContext

- contextLoaderListener 에 의해 생성된다
- 서비스 계층이나 DAO를 포함한, 웹 환경에 독립적인 빈들을 담아둔다.

- 서로 다른 서블릿컨텍스트에서 공유해야 하는 빈들을 등록해놓고 사용할 수 있다.

- Servlet context에 등록된 빈들을 이용 불가능하고 servlet context와 공통된 빈이 있다면 servlet context 빈이 우선된다.
- WebApplication 전체에 사용가능한 DB연결, 로깅 기능들이 이용된다.



### Servlet WebApplicationContext

- DispatcherServlet에 의해 생성된다

- servlet Context 에서만 사용가능

- DispatcherServlet이 직접 사용하는 컨트롤러를 포함한 웹 관련 빈을 등록하는 데 사용한다.

- DispatcherServlet은 독자적인 WebApplicationContext를 가지고 있고, 모두 동일한 Root WebApplicationContext를 공유한다.
- 

### ContextLoaderListener 의 역할

- ContextLoaderListener 와 DispatcherServlet은 각각 WebApplicationcontext를 생성하는데, 스프링에서 사용되는 Context간의 계층 관계를 연결해준다

- 웹 어플리케이션이 시작되고 종료되는 시점에 Servlet Context가 생성하는 이벤트를 연결
- Servlet WebApplicationContext 에서는 Root WebApplicationContext를 참조 가능하지만, 그 반대는 참조가 불가



### web.xml

web.xml에서의 설정은 Spring WebApplicationContext를 구성하는 작업이며 

Servlet WebApplicationContext(Dispatcher Servlet) 를 등록해서 스프링을 서블릿 컨테이너(Apache Tomcat)에서 동작하도록 하는것이다



# 세부 설정

## 1. Servlet Mapping

특정 servlet을 요청할 때, 전체 경로를 url에 써주면 너무 복잡하고, 보안에도 취약하기 때문에 간단하게 경로를 표현하여 매핑한다

.xml, annotation 으로 사용하는 두가지 방법이 있다



![서블릿 매핑 구조](https://github.com/syhojeo/SpringMVC/blob/main/SpringMVCXml_03/ServletMapping%20%EA%B5%AC%EC%A1%B0.png)

## web.xml 에서 Front Controller(기본 서블릿) 설정하기

FrontController: https://java117.tistory.com/2?category=806352

### step1 서블릿 지정

```xml
<servlet>
	<servlet-name>서블릿의 별칭</servlet-name>
    <servlet-class>사용할 서블릿의 저장위치</servlet-class>
    <!-- FrontController 가 Controller들에게 연결해줄 수 있도록 해주는 servlet설정 파일 명시 -->
    <init-param>
    	<param-name>XML 파일의 별칭</param-name>
        <param-value>xml 파일의 경로</param-value>
    </init-param>
    <!-- 	
 		서블릿은 브라우저의 요청이 있을때 init()을 통해 생성되지만 이는 최초요청에 대해서 실행시간이
		길어질 수 있는 단점이 존재한다
		때문에 브라우저의 요청이 아닌 톰켓 컨테이너가 실행되면서 미리 서블릿을 실행하는
		load-on-startup 방식을 사용한다
	-->
    <load-on-startup>1</load-on-startup> <!-- 우선순위 1로 지정 -->
</servlet>
```



### step2 서블릿 mapping

```xml
<servlet-mapping>
	<servlet-name>서블릿 별칭</servlet-name> <!-- 위에서 지정한 별칭과 같은 값이어야 한다 -->
    <!-- 브라우저 뒤에 붙을 servlet의 경로 지정 -->
    <!-- FrontController 이기 때문에 / 를 사용하여 모든 요청을 다 받아줘야한다 -->
    <url-pattern>servlet의 경로</url-pattern> 
</servlet-mapping>
```



## servlet-context.xml 에서 Page Controller설정 (inti-param 에서 설정한 xml 파일)

```xml
<!-- 스캔할 패키지 내부의 클래스 중 Controller 어노테이션을 가지고 있는 클래스를 Controller로 로딩-->
<annotation-driven></annotation-driven>

<!-- 스캔할 bean들이 모여있는 패키지를 지정 -->
<context:component-sacn base-package="경로"></context:component-sacn>

<!-- jsp를 view 기술로 사용할 경우 viewResolver를 사용-->
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<beans:property name="prefix" value="/WEB-INF/views/"></beans:property>
	<beans:property name="suffix" value=".jsp"></beans:property>
</beans:bean>

<!-- 정적 파일(이미지, 사운드, 동영상, JS, CSS 등) 경로 세팅-->
<resources location="/resources/" mapping="/**"></resources>
```





## 2. Bean을 정의할 xml 파일 지정 (web.xml)

```xml
<context-param>
	<param-name>별칭</param-name>
    <param-value>경로</param-value> <!-- 경로 ex)/WEB-INF/config/root-context.xml-->
</context-param>
```



## 3. listener 설정

```xml
<!-- 
	servlet Context의 이벤트 (생성, 소멸 )감시 => 웹 어플리케이션의 생명주기 감시
	서블릿 생성과 관련 없이 서버 전체를 기동하고 종료될때 한번씩 실행된다 
-->
<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
```

참고: https://nameybs.tistory.com/81



Servlet Container(e.g. tomcat)에 루트 웹 애플리케이션 컨텍스트(`Application Context`)를 등록하는 방법을 제공합니다.

- Servlet Container의 시작과 종료 시에 발생하는 이벤트를 처리하는 리스너를 등록하기 위해 `ServletContextListener` 인터페이스를 구현한 리스너를 사용하는데 그 구현체가 바로 `ContextLoaderListener` 입니다.

Application Context에 대한 실제 초기화 작업을 수행합니다.

이 리스너(Listener)만 등록하면 자동으로 디폴트 루트 애플리케이션 컨텍스트를 생성해줍니다.

- 디폴트 설정
  - `XmlWebApplicationContext`
  - XML 설정파일 위치 : /WEB-INF/applicationContext.xml



참고: https://jeong-pro.tistory.com/222 



## 4. 파라미터 인코딩 필터 설정

![서블릿 필터](https://github.com/syhojeo/SpringMVC/blob/main/SpringMVCXml_03/servlet%20filter.png)

```xml
<!-- 
	Servlet Filter
	servlet으로 요청이 들어오기 전후에 필터링을 거쳐서 특정기능을 수행 하는기능
	공통적인 기능들을 서블릿이 호출되기 전에 수행(전처리)되게 하고 싶거나
	서블릿이 호출 되고 난 뒤에 수행(후처리) 하고 싶으면 공통적인 기능들을 서블릿 필터로 구현하면 된다.
-->

<!--  -->
<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>
	
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern><!-- 모든 요청 -->
	</filter-mapping>
```

