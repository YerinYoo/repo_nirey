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
	
	@RequestMapping(value = "publicCorona1JsonNodeList")
	public String publicCorona1JsonNodeList(Model model) throws Exception {
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=Uqu3WdrY%2B46svsZTlFgc%2FxxhVXBsNL9lDCX5ajmWHtYgMLWyo1lK6fI2Mu69WPOwA073gHx%2FLwXDZob5iVwD5A%3D%3D&numOfRows=3&pageNo=1&type=json";
				
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		//ObjectMapper를 생성하고, objectMapper를 이용하여 json으로 받아온 결과를 보여줌 | toString() 말고도 다양한 방법이 있음 
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		//json 객체는 node를 이용해서 데이터를 뽑음 
		//header or body 내의 value를 찍음 
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		//get(0)을 통해 순환하는 코드임을 알 수 있음 
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
		
		model.addAttribute("node", node);
		
//		model.addAttribute(node);
		
		return "adm/infra/v1/test/publicCorona1JsonNodeList";
	}




//postman request ex.회원가입 
	//Body 중 x-www-form-urlencoded
	//key : memberID, memberPwd 



	

}
