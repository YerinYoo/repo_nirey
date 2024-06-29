package com.recorded.infra.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestController {
	
	// 요청 경로에 대한 매핑 설정
	@RequestMapping(value = "publicCorona1JsonNodeList")
	public String publicCorona1JsonNodeList(Model model) throws Exception {
		
		// 외부 API의 URL
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=Uqu3WdrY%2B46svsZTlFgc%2FxxhVXBsNL9lDCX5ajmWHtYgMLWyo1lK6fI2Mu69WPOwA073gHx%2FLwXDZob5iVwD5A%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		// URL 객체 생성
		URL url = new URL(apiUrl);
		// HTTP 연결 생성
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		// HTTP GET 요청 설정
		httpURLConnection.setRequestMethod("GET");
		
		// HTTP 응답 코드를 기준으로 BufferedReader 선택
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		// 읽어온 데이터를 저장할 StringBuilder
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		// 한 줄씩 읽어 StringBuilder에 추가
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		// BufferedReader 닫기
		bufferedReader.close();
		// HTTP 연결 종료
		httpURLConnection.disconnect();

		// JSON 데이터를 처리할 ObjectMapper 생성
		ObjectMapper objectMapper = new ObjectMapper();
		// StringBuilder에 저장된 JSON 데이터를 JsonNode로 파싱
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		// JSON 데이터에서 필요한 값을 추출하여 출력
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
		
		// 모델에 JsonNode 추가
		model.addAttribute("node", node);
		
		// 뷰 이름 반환
		return "adm/infra/v1/test/publicCorona1JsonNodeList";
	}
}
