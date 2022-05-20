# Spring MVC에서의 Dynamic Web Page 동작 구조



## 1. 동적 웹에서의 클라이언트 요청처리 방법 (web server, web application server)

![1](https://github.com/syhojeo/SpringMVC/blob/main/image/1.png)





https://coding-factory.tistory.com/741



## 2. dispatcherServlet과 Servlet

https://mangkyu.tistory.com/18



 단 **HandlerAdapter**가 그냥 반환하는 것이 아니라 **ModelAndView** 객체로 변환합니다.

이를 받은 **DispatcherServlet**은 결과를 사용자에게 보여줄 뷰를 찾기 위해 **ViewResolver** 빈 객체를 사용합니다.

즉 **ModelAndView**는 사용자에게 보여줄 뷰 이름을 담고있습니다. 마지막으로 **DispatcherServlet**은 응답 결과 생성을 요청하여 웹 

웹 브라우저에게 신속하게 **JSP**실행 합니다. 

##  3. Root WebApplication context 와 servlet WebApplication context

https://linked2ev.github.io/spring/2019/09/15/Spring-5-%EC%84%9C%EB%B8%94%EB%A6%BF%EA%B3%BC-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90%EC%84%9C-Context(%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8)%EB%9E%80/

https://jeong-pro.tistory.com/222





### application context 와 servlet context 의 라이프사이클 차이

https://jypthemiracle.medium.com/servletcontainer%EC%99%80-springcontainer%EB%8A%94-%EB%AC%B4%EC%97%87%EC%9D%B4-%EB%8B%A4%EB%A5%B8%EA%B0%80-626d27a80fe5





### modelAttribute, Command Object

https://medium.com/webeveloper/modelattribute-%EC%99%80-%EC%BB%A4%EB%A7%A8%EB%93%9C-%EA%B0%9D%EC%B2%B4-command-object-42c14f268324



### /*와 /의 차이점 (web.xml mapping)



### Root Web Application Context의 여러가지 Bean DI 방법

https://programmingrecoding.tistory.com/25