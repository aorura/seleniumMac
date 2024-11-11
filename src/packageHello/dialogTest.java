package packageHello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dialogTest {

    public static void main(String[] args) {
        // ChromeDriver 경로 설정
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver"); // 여기에 ChromeDriver 경로를 설정하세요.
        
        // WebDriver 인스턴스 생성
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Korail 웹사이트 열기
            driver.get("https://www.letskorail.com/ebizprd/EbizPrdTicketpr21100W_pr21110.do");

            // 2. 출발역 서울역 선택 (출발역 드롭다운 메뉴)
            WebElement departureStation = driver.findElement(By.id("dptRsStnCd"));
            departureStation.sendKeys("서울역");

            // 3. 도착역 구포역 선택 (도착역 드롭다운 메뉴)
            WebElement arrivalStation = driver.findElement(By.id("arriveRsStnCd"));
            arrivalStation.sendKeys("구포역");

            // 4. 출발 날짜 11월 8일로 설정
            WebElement departureDate = driver.findElement(By.id("dptDt"));
            departureDate.sendKeys("2023-11-08");

            // 5. KTX 예약 버튼 클릭
            WebElement searchButton = driver.findElement(By.id("btnSearch"));
            searchButton.click();

            // 6. 결과 대기 (검색 후 결과가 로드되도록 기다림)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".trainList")));

            // 7. 첫 번째 KTX 예약 선택 (필요에 따라 조정 가능)
            WebElement firstTrain = driver.findElement(By.cssSelector(".trainList .trainItem"));
            firstTrain.click();

            // 8. 예약 페이지가 로드될 때까지 대기
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("trainInfo")));

            // 추가적인 예약 정보 입력 및 최종 예약 버튼 클릭은 상황에 맞게 조정
            // 예: 예약을 위한 추가 버튼 클릭, 개인 정보 입력 등...

            // 예약 과정이 완료되었음을 알리는 메시지 표시
            System.out.println("KTX 예약이 완료되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 9. 드라이버 종료
            driver.quit();
        }
    }
}