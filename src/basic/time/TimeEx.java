package basic.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeEx {

    public static void main(String[] args) throws InterruptedException {
        /* Calendar / Date 단점 */
        // 헷갈리는 월 지정 : 월은 0부터 시작되어 2023.09.01을 설정하기 위해서는 9가 아닌 8을 입력해야한다.
        Calendar cal = Calendar.getInstance();
        cal.set(2023, 8, 1);
        System.out.println(cal.getTime()); // Fri Sep 01 12:35:21 KST 2023

        // 일관성 없는 요일 상수 (Calendar의 일요일은 상수값 1을, Date의 일요일은 상수값 0을 가진다.)
        System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 1
        Date date = cal.getTime();
        System.out.println(date.getDay()); // 0

        // 오류에 둔감한 TimeZone (존재하지 않는 TimeZone ID를 적어도 컴파일 시점에 오류를 잡지 못한다.)
        TimeZone zone1 = TimeZone.getTimeZone("Asia/Seoul");
        System.out.println(zone1.getID()); // Asia/Seoul
        TimeZone zone2 = TimeZone.getTimeZone("Seoul/Asia");
        System.out.println(zone2.getID()); // GMT



        /* LocalDate */
        LocalDate curDate = LocalDate.now(); // 2023-09-09
        System.out.println(curDate);
        LocalDate targetDate = LocalDate.of(2023, 8, 1); // 2023-08-01. 캘린더와 다르게 month의 값이 직관적이다.
        System.out.println(targetDate);



        /* LocalTime */
        LocalTime curTime = LocalTime.now();
        System.out.println(curTime); // 13:19:06.503453
        LocalTime targetTime = LocalTime.of(8, 10, 2, 3);
        System.out.println(targetTime); // 08:10:02.000000003



        /* LocalDateTime */
        LocalDateTime curDateTime = LocalDateTime.now();
        System.out.println(curDateTime); // 2023-09-09T13:20:31.646277
        LocalDateTime targetDateTime = LocalDateTime.of(2023, 9, 1, 10, 30, 59, 1);
        System.out.println(targetDateTime); // 2023-09-01T10:30:59.000000001




        /* ZonedDateTime */
        ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(utcDateTime); // 2023-09-09T04:21:07.926983Z[UTC]
        ZonedDateTime londonDateTime = ZonedDateTime.now(ZoneId.of("Europe/London"));
        System.out.println(londonDateTime); // 2023-09-09T05:21:07.927609+01:00[Europe/London]
        ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(seoulDateTime); // 2023-09-09T13:21:07.928687+09:00[Asia/Seoul]



        /* Instant */
        Instant instant1 = Instant.now();
        Thread.sleep(1000);

        Instant instant2 = Instant.now();

        if (instant1.isBefore(instant2)) {
            System.out.println("instant1이 빠르다.");
        } else if (instant2.isAfter(instant1)) {
            System.out.println("instant1이 느리다.");
        } else {
            System.out.println("동일한 시간이다.");
        }

        System.out.println("차이(nanos): " + instant1.until(instant2, ChronoUnit.NANOS));
        /* 실행결과
            instant1이 빠르다.
            차이(nanos): 1005076000
         */



        /* 날짜와 시간 조작하기 */
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);                    // 현재. 2023-09-09T13:30:33.210107
        System.out.println(now.minusYears(1L));     // 년 뺴기. 2022-09-09T13:30:33.210107
        System.out.println(now.minusMonths(1L));    // 달 뺴기. 2023-08-09T13:30:33.210107
        System.out.println(now.minusDays(1L));      // 일 빼기. 2023-09-08T13:30:33.210107
        System.out.println(now.minusWeeks(1L));     // 주 빼기. 2023-09-02T13:30:33.210107
        System.out.println(now.plusYears(1L));      // 년 더하기. 2024-09-09T13:30:33.210107
        System.out.println(now.plusMonths(1L));     // 달 더하기. 2023-10-09T13:30:33.210107
        System.out.println(now.plusWeeks(1L));      // 주 더하기. 2023-09-16T13:30:33.210107
        System.out.println(now.plusDays(1L));       // 일 더하기. 2023-09-10T13:30:33.210107

        System.out.println(now.minusHours(1L));     // 시간 뺴기. 2023-09-09T12:30:33.210107
        System.out.println(now.minusMinutes(1L));   // 분 빼기. 2023-09-09T13:29:33.210107
        System.out.println(now.minusSeconds(1L));   // 초 빼기. 2023-09-09T13:30:32.210107
        System.out.println(now.minusNanos(1L));     // 나노초 빼기. 2023-09-09T13:30:33.210106999
        System.out.println(now.plusHours(1L));      // 시간 더하기. 2023-09-09T14:30:33.210107
        System.out.println(now.plusMinutes(1L));    // 분 더하기. 2023-09-09T13:31:33.210107
        System.out.println(now.plusSeconds(1L));    // 초 더하기. 2023-09-09T13:30:34.210107
        System.out.println(now.plusNanos(1L));      // 나노초 더하기. 2023-09-09T13:30:33.210107001

        // 년도 상대 변경
        targetDateTime = now.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("이번 해의 첫 번째 일 : " + targetDateTime); // 2023-01-01T13:35:30.096807
        targetDateTime = now.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("이번 해의 마지막 일 : " + targetDateTime); // 2023-12-31T13:35:30.096807
        targetDateTime = now.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("다음 해의 첫 번째 일 : " + targetDateTime); // 2024-01-01T13:35:30.096807

        // 월 상대 변경
        targetDateTime = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("이번 달의 첫 번째 일 : " + targetDateTime); // 2023-09-01T13:35:30.096807
        targetDateTime = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("이번 달의 마지막 일 : " + targetDateTime); // 2023-09-30T13:35:30.096807
        targetDateTime = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("다음 달의 첫 번째 일 : " + targetDateTime); // 2023-10-01T13:35:30.096807

        // 요일 상대 변경
        targetDateTime = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("이번 달의 첫 번째 월요일 : " + targetDateTime); // 2023-09-04T13:35:30.096807
        targetDateTime = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("돌아오는 월요일 : " + targetDateTime); // 2023-09-11T13:35:30.096807
        targetDateTime = now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        System.out.println("지난 월요일 : " + targetDateTime); // 2023-09-04T13:35:30.096807



        /* 날짜와 시간 비교 */
        LocalDateTime startDateTime = LocalDateTime.of(2023, 9, 1, 9, 0, 0);
        System.out.println(startDateTime); // 2023-09-01T09:00

        LocalDateTime endDateTime = LocalDateTime.of(2023, 12, 31, 23, 59, 59);
        System.out.println(endDateTime); // 2023-12-31T23:59:59

        // 종료까지 남은 기간을 until()과 between()을 사용해서 구할 수 있다.
        long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS); // 남은 연도 차이
        long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS); // 남은 달 차이
        long remainWeek = startDateTime.until(endDateTime, ChronoUnit.WEEKS); // 남은 주 차이
        long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS); // 남은 일 차이
        long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS); // 남은 시간 차이
        long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES); // 남은 분 차이
        long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS); // 남은 초 차이
        System.out.println("연 : " + remainYear); // 0
        System.out.println("월 : " + remainMonth); // 3
        System.out.println("주 : " + remainWeek); // 17
        System.out.println("일 : " + remainDay); // 121
        System.out.println("시간 : " + remainHour); // 2918
        System.out.println("분 : " + remainMinute); // 175139
        System.out.println("초 : " + remainSecond); // 10508399

        remainYear = ChronoUnit.YEARS.between(startDateTime, endDateTime);
        remainMonth = ChronoUnit.MONTHS.between(startDateTime, endDateTime);
        remainWeek = ChronoUnit.WEEKS.between(startDateTime, endDateTime);
        remainDay = ChronoUnit.DAYS.between(startDateTime, endDateTime);
        remainHour = ChronoUnit.HOURS.between(startDateTime, endDateTime);
        remainMinute = ChronoUnit.MINUTES.between(startDateTime, endDateTime);
        remainSecond = ChronoUnit.SECONDS.between(startDateTime, endDateTime);
        System.out.println("연 : " + remainYear); // 0
        System.out.println("월 : " + remainMonth); // 3
        System.out.println("주 : " + remainWeek); // 17
        System.out.println("일 : " + remainDay); // 121
        System.out.println("시간 : " + remainHour); // 2918
        System.out.println("분 : " + remainMinute); // 175139
        System.out.println("초 : " + remainSecond); // 10508399

        // Priod 클래스로 날짜 차이를 구할 수 있다.
        Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
        System.out.println("종료까지 남은 기간: " + period.getYears() + "년 " + period.getMonths() + "월 " + period.getDays() + "일"); // 종료까지 남은 기간: 0년 3월 30일

        // Duration 클래스로 시간 차이를 구할 수 있다.
        Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());
        System.out.println("종료까지 남은 기간: " + duration.getSeconds() + "초 " + duration.getNano() + "나노 초"); // 종료까지 남은 기간: 53999초 0나노 초



        /* 날짜 포맷 */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formattedString = LocalDateTime.now().format(formatter);
        System.out.println(formattedString); // 2023년 09월 09일

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedString = LocalDateTime.now().format(formatter);
        System.out.println(formattedString); // 2023-09-09

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
        formattedString = LocalDateTime.now().format(formatter);
        System.out.println(formattedString); // 2023-09-09 오후 01:50:33

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedString = LocalDateTime.now().format(formatter);
        System.out.println(formattedString); // 2023-09-09 13:51:11

        formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        formattedString = LocalDateTime.of(2023, 7, 31, 23, 58, 59).format(formatter);
        System.out.println(formattedString); // 2023년 07월 31일 23시 58분 59초
    }

}
