## CGI (Common Gateway Interface)

정적 웹 사이트의 요청에서는 application이 필요가 없다 항상 Client가 요청하는 정적페이지를 넘겨주면 되기 때문이다



하지만 동적 웹 사이트가 대두되면서 Client가 요청하는 다양한 값들(request)에 대한 데이터 처리가 필요하게 되었는데 이를 하게 되는것이 **Application** 이다



이때 Client의 요청을 받는 web sever와 다양한 request값들에 대해 요청을 수행하는 Application 간의 연결을 해주는게 CGI 이다



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



