package com.recorded.common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.recorded.common.constants.Constants;

public class UtilDateTime {

	
	//현재 시간 불러오기 (지역 별, 기준 시간이 다른 여러 지역에 위치한 서버에서는 사용할 수 없음)
	public static LocalDateTime nowLocalDateTime() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		return localDateTime;
	}
	
	//현재 시각의 타임스탬프를 구함, 밀리세컨드 단위로 불러옴
	public static Date nowDate() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT_BASIC));
		//DateTimeFormatter : 시간과 날짜를 원하는 형식에 맞춰 출력해줌
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATETIME_FORMAT_BASIC);
        Date date = simpleDateFormat.parse(localDateTimeString);
		return date;
	}
	
	//nowString : 날짜를 문자열로 변수에 저장함
	public static String nowString() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT_BASIC));
		return localDateTimeString;
	}
	
	//calculate 구문 시작
	//calculate : 날짜 혹은 시간의 계산을 하겠다고 변수명에 선언함

	//불러온 LocalDateTime의 시간 및 날짜를 기본 값으로 잡고 해당 값에서 +- 날짜 계산을 함
	public static String calculateDayString(LocalDateTime localDateTime, int day) throws Exception {
		LocalDateTime localDateTimeNew;
	
		
		if(day >= 0) {
			localDateTimeNew = localDateTime.plusDays(day); 
		} else { 
			//DatetimeFormatBasic에서 기간을 -30으로 잡았음 이때 -30한 날짜가 0 이하의 수가 나온다면 전 달로 넘기게 해줌
			//abs가 잡는 절대값은 월을 제외한 일, 따라서 일에 해당하는 값은 그대로 두고 월 값만 이전 값으로 돌려줌
			//Constants내부 [public static final int DATE_INTERVAL = -30;] 구문의 -30이 abs.(day)의 (day) 값으로 적용됨
			localDateTimeNew = localDateTime.minusDays(Math.abs(day));
		}

		String localDateTimeNewString = localDateTimeNew.format(DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT_BASIC));
		return localDateTimeNewString;
	}
	
	//불러온 LocalDateTime의 시간 및 날짜를 기본 값으로 잡고 해당 값에서 +- 날짜 계산을 하며 불러온 날짜값의 시간을 00:00:00으로 절대적으로 매겨줌
	public static String calculateDayReplace00TimeString(LocalDateTime localDateTime, int day) throws Exception {
		LocalDateTime localDateTimeNew;
		
		if(day >= 0) {
			localDateTimeNew = localDateTime.plusDays(day); 
		} else {
			localDateTimeNew = localDateTime.minusDays(Math.abs(day));
		}
		
		String localDateTimeNewString = localDateTimeNew.format(DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT_BASIC));
		localDateTimeNewString = localDateTimeNewString.substring(0, 10) + " 00:00:00";
		return localDateTimeNewString;
	}
	
	//불러온 LocalDateTime의 시간 및 날짜를 기본 값으로 잡고 해당 값에서 +- 날짜 계산을 하며 불러온 날짜값의 시간을 로컬 타임으로 매겨줌
	public static LocalDateTime calculateDayLocalDateTime(LocalDateTime localDateTime, int day) throws Exception {
		LocalDateTime localDateTimeNew;
		//LocalDateTime : 현재 로컬 컴퓨터의 날짜와 시간을 반환
		
		if(day >= 0) {
			localDateTimeNew = localDateTime.plusDays(Math.abs(day)); 
		} else {
			localDateTimeNew = localDateTime.minusDays(Math.abs(day));
		}
		
		return localDateTimeNew;
	}
	
	
	public static Date calculateDayDate(LocalDateTime localDateTime, int day) throws Exception {
		LocalDateTime localDateTimeNew;
		
		if(day >= 0) {
			localDateTimeNew = localDateTime.plusDays(Math.abs(day)); 
		} else {
			localDateTimeNew = localDateTime.minusDays(Math.abs(day));
		}
		
		String localDateTimeNewString = localDateTimeNew.format(DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT_BASIC));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATETIME_FORMAT_BASIC);
        Date date = simpleDateFormat.parse(localDateTimeNewString);
		
		return date;
	}
	
	//LocalDateTime.now()를 이용하여 현재 위치한 지역의 시간을 now 값으로 잡음
	//String localDateTimeString : date 형식의 날짜 및 시간을 String 타입 및 원하는 형식으로 변환해줌 (Constants.TIME_FORMAT_BASIC)구문에서 지정한 형식으로
	public static String addNowTimeString(String date) {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern(Constants.TIME_FORMAT_BASIC));
		return date + " " + localDateTimeString;
	}
	
	
	//불러온 날짜의 시간을 00:00:00으로 설정해줌 >> shStartDate에 쓰일 듯
	public static String add00TimeString(String date) {
		return date + " 00:00:00";
	}

	//불러온 날짜의 시간을 23:59:59으로 설정해줌 >> shEndDate에 쓰일 듯
	public static String add59TimeString(String date) {
		return date + " 23:59:59";
	}
	
	//param = 불려오는 플러그인을 위한 매개변수
	//dateParam = 날짜  값을 가진 파라미터 사용 
	public static String dateToString(Date dateParam) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateRt = simpleDateFormat.format(dateParam);
		return dateRt;
	}
	
	//dateTimeParam = 날짜와 시간 값을 가진 파라미터 사용
	public static String dateTimeToString(Date dateTimeParam) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTimeRt = simpleDateFormat.format(dateTimeParam);
		return dateTimeRt;
	}
	
	//로컬 컴퓨터의 날짜와 시간을 받아온 후, 현재 연도를 붙여줌?????
	public static String nowYearString() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern("yyyy"));
		return localDateTimeString;
	}	
}