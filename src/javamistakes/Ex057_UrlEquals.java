package javamistakes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/*
    URL.equals()
    - java.net.URL 클래스의 equals()는 예상과 다른 방식으로 동작할 것이다.
    - URL은 기본적으로 문자열이므로 두 URL이 같은지 확인하기 위하여 equals()를 사용한다면 예기치 못한 방향으로 동작할 수 있다.

    - URL.equals()는 실제 네트워크 요청을 보내 URL의 호스트 IP 주소를 확인하고 IP 주소가 같을 때만 동일하다고 판단하는 방식으로 동작한다.
      - 네트워크 요청은 상황에 따라 오래 걸릴 수도 있다.
      - 가상 호스팅이 보편화된 현대 인터넷 환경을 전혀 고려하지 않고 있다. (가상 호스팅 환경은 서로 관련이 없는 수많은 웹사이트가 동일한 IP 주소를 공유하고 있을 수도 있다.)

    - 실수 방지 가이드
      - URL 객체를 맵의 키로 사용하거나 셋의 원소로 담지 않는다.
      - URL대신 URI를 사용할 수 있다면, URI를 사용하는 것이 좋다.
        - URI는 실제로 네트워크 요청을 보내지 않는다. (단, 단순 문자열로 비교를 하지 않는 것은 동일하다.)
 */
public class Ex057_UrlEquals {

    public static void main(String[] args) throws MalformedURLException {
        // 아래 코드는 URL.equals() 와 관련이 없어 보일지도 모르만, contains() 메서드를 호출할 때 내부적으로 equals()가 호출된다.
        List<URL> urls = List.of(new URL("https://naver.com"), new URL("https://google.com"));
        URL urlToFind = new URL("https://naver.com");
        if (urls.contains(urlToFind)) {
            System.out.println("Found!");
        }
    }

}
