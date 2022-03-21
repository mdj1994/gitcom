package com.union.construction_web.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseController {

    Logger log = LoggerFactory.getLogger(Serializers.Base.class);

    /**
     * 	POST로 요청
     *  @return JSONObject
     *  @Description  URL, JSON형태의 String고 URL에 POST형식으로 요청
     */
    public JSONObject sendPost(String sendUrl, String jsonValue) {
        JSONObject jsonObj = null;
        JSONParser jsonParser = new JSONParser();
        OutputStreamWriter osw = null;
        BufferedReader br = null;


        try {
            log.info(sendUrl+" : POST Connection START");

            //연결 할 URL
            URL url = new URL(sendUrl);
            //URL에 연결
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //POST 방식 설정
            conn.setRequestMethod("POST");
            //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션.
            conn.setDoOutput(true);
            // InputStream으로 서버로 부터 응답을 받겠다는 옵션.
            conn.setDoInput(true);
            //JSON 형태로 전달 설정
            conn.setRequestProperty("Content-Type", "application/json;utf-8");
            conn.setRequestProperty("Accept", "application/json");
            //서버에 연결되는 TimeOut 시간 설정
            conn.setConnectTimeout(40000);
            //InputStream 읽어 오는 TimeOut 시간 설정
            conn.setReadTimeout(40000);

            //URL에 jsonValue을 전송
            osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
            osw.write(jsonValue.toString());
            osw.flush();


            //코드를 받음 (성공 : 200,실패 : 404)
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK) {
                //DATA를 읽어옴
                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                //읽어온 DATA를 JSON Objcet 형식으로 변환
                jsonObj = (JSONObject) jsonParser.parse(br);
            }else {
                log.error("API 연결 안 됨. CODE : "+responseCode);
            }


        } catch (MalformedURLException e) {
            //log.error(e.getMessage());
            log.error(sendUrl + " : MalformedURLException ERROR");
        } catch (IOException e) {
//            log.error(e.getMessage());
            log.error(sendUrl + " : IOException ERROR");
        } catch (org.json.simple.parser.ParseException e) {
            log.error(sendUrl + " : ParseException ERROR");
        } finally {
            try {
                if(osw != null) osw.close();
            } catch (IOException e) {
//                log.error(e.getMessage());
                log.error(sendUrl + " : OutputStreamWriter close ERROR ");
            }
            try {
                if(br != null ) br.close();
            } catch (IOException e) {
//                log.error(e.getMessage());
                log.error(sendUrl + " : BufferedReader close ERROR ");
            }
        }
        log.debug(sendUrl + " : POST Connection END");
        return jsonObj;
    }

    /**
     * 	Get로 요청
     *  @return JSONObject
     *  @Description  URL, JSON형태의 String고 URL에 POST형식으로 요청
     */
    public JSONObject sendGet(String sendUrl, String jsonValue) {
        JSONObject jsonObj = null;
        JSONParser jsonParser = new JSONParser();
        OutputStreamWriter osw = null;
        BufferedReader br = null;


        try {

            log.info(sendUrl+" : Get CONNECTION START");

            //연결 할 URL
            URL url = new URL(sendUrl);
            //URL에 연결
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //POST 방식 설정
            conn.setRequestMethod("GET");

            //코드를 받음 (성공 : 200,실패 : 404)
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK) {
                //DATA를 읽어옴
                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                //읽어온 DATA를 JSON Objcet 형식으로 변환
                jsonObj = (JSONObject) jsonParser.parse(br);
            }else {
                log.error("API 연결 안 됨. CODE : "+responseCode);
            }


        } catch (MalformedURLException e) {
            //log.error(e.getMessage());
            log.error(sendUrl + " : MalformedURLException ERROR");
        } catch (IOException e) {
//            log.error(e.getMessage());
            log.error(sendUrl + " : IOException ERROR");
        } catch (org.json.simple.parser.ParseException e) {
            log.error(sendUrl + " : ParseException ERROR");
        } finally {
            try {
                if(osw != null) osw.close();
            } catch (IOException e) {
//                log.error(e.getMessage());
                log.error(sendUrl + " : OutputStreamWriter close ERROR ");
            }
            try {
                if(br != null ) br.close();
            } catch (IOException e) {
//                log.error(e.getMessage());
                log.error(sendUrl + " : BufferedReader close ERROR ");
            }
        }
        log.debug(sendUrl + " : POST Connection END");
        return jsonObj;
    }
}
