# xml을 이용한 SpringMVC 설정

## 1. Servlet Mapping

특정 servlet을 요청할 때, 전체 경로를 url에 써주면 너무 복잡하고, 보안에도 취약하기 때문에 간단하게 경로를 표현하여 매핑한다

.xml, annotation 으로 사용하는 두가지 방법이 있다



![서블릿 매핑 구조](https://github.com/syhojeo/SpringMVC/blob/main/SpringMVCXml_03/ServletMapping%20%EA%B5%AC%EC%A1%B0.png)

## web.xml 에서 Front Controller(기본 서블릿) 설정하기

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



## servlet-context.xml 설정 (inti-param 에서 설정한 xml 파일)

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



## 4. 파라미터 인코딩 필터 설정

![서블릿 필터](https://github.com/syhojeo/SpringMVC/blob/main/SpringMVCXml_03/servlet%20filter.png)

```xml
<!-- 
	Servlet Filter
	servlet으로 요청이 들어오기 전에 필터링을 거쳐서 특정기능을 수행 후 servlet에서 요청을 처리하는 것
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

