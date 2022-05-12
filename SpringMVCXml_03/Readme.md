# xml을 이용한 SpringMVC 설정

## 1. Servlet Mapping

특정 servlet을 요청할 때, 전체 경로를 url에 써주면 너무 복잡하고, 보안에도 취약하기 때문에 간단하게 경로를 표현하여 매핑한다

.xml, annotation 으로 사용하는 두가지 방법이 있다



## web.xml 에서 설정하기

### step1 서블릿 지정

```xml
<servlet>
	<servlet-name>서블릿의 별칭</servlet-name>
    <servlet-class>사용할 서블릿의 저장위치</servlet-class>
    <!-- SpringMVC 설정을 위한 xml 파일 지정-->
    <init-param>
    	<param-name>XML 파일의 별칭</param-name>
        <param-value>xml 파일의 경로</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
```



### step2 서블릿 mapping

```xml
<servlet-mapping>
	<servlet-name>서블릿 별칭</servlet-name> <!-- 위에서 지정한 별칭과 같은 값이어야 한다 -->
    <url-pattern>servlet의 경로</url-pattern> <!-- 브라우저 뒤에 붙을 servlet의 경로 지정-->
</servlet-mapping>
```

