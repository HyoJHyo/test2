package com.sec.game.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by chakankim@gmail.com on 2015-12-06.
 */
public class CommonUtil {

    /**
     * 인증 코드 생성
     * @param codeLen 전체 인증코드 길이
     * @param codeItemSize 코드 하나의 숫자 범위
     * @return
     */
    public static List<Integer> AuthCodeGenterator(int codeLen, int codeItemSize){
        List<Integer> authCodeList = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i < codeLen; i++){
            authCodeList.add(random.nextInt(codeItemSize));
        }
        return authCodeList;
    }
    
    public static boolean isMobile (HttpServletRequest request) {
        // 모바일 여부 확인
        String header = request.getHeader("User-Agent").toLowerCase().replaceAll(" ", "");
        if (header.indexOf("mobile") != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * null > String 
     * @param arg
     * @return
     */
    static public String nvl(Object arg){
		return nvl(arg, "");
	}
    
    /**
     * null > String
     * @param arg
     * @param ch
     * @return
     */
    static public String nvl(Object arg, String ch){
		if(arg == null) return ch;
		String str = String.valueOf(arg);
		if(str.trim().equals("") || str.trim().equalsIgnoreCase("null")) return ch;
		return str;
	}
    /**
     * null > 0, String > int
     * @param arg
     * @return
     */
    static public int nvlInt(Object arg){
		return nvl(arg, 0);
	}
    static public int nvl(Object arg, int i){
		if(arg == null) return i;
		int returnValue;
		try{
			returnValue = Integer.valueOf(nvl(arg, "0"));
		}catch(Exception e){
			return i;
		}
		if(returnValue == 0) returnValue = i;
		return returnValue;
	}
	    
	
    static public String mkEducationView(int type, String id, String x) {
	    String str = "";
	    String val = "";
	    String icon = "";
	
	    if (x.equals("0")){
	        val = "X";
	        icon = "<i class=\"fa fa-fw fa-close\"></i>";
	    } else {
	        val = "O";// fa-circle-o
	        icon = "<i class=\"fa fa-fw fa-circle-o\"></i>";
	    } 
	
	    str = "<button type=\"button\" onclick=\"changeTrain('"+type+"','"+id+"','"+x+"');\">" + icon + "</button>";
	    return str;
	}
	
    static public String mkAttendSelectBox(String id, String selType) {
	    //console.log ("selType ::" + selType);
	    // 0, 1 (문자) ,2(전화) ,3(연락안함)
	    String str = "<select style=\"width:60px\" onchange=\"changeAttend('"+id+"', this)\" >";
	        str = str + "<option value='0'>선택</option>";
	        
	        if (selType.equals("1")) {
	            str = str + "<option value='1' selected>O</option>";
	        } else {
	            str = str + "<option value='1'>O</option>";
	        }
	        
	        if (selType.equals("2")) {
	            str = str + "<option value='2' selected>X (문자)</option>";
	        } else {
	            str = str + "<option value='2' >X (문자)</option>";
	        }
	        
	        if (selType.equals("3")) {
	            str = str + "<option value='3' selected>X (전화)</option>";
	        } else {
	            str = str + "<option value='3'>X (전화)</option>";
	        } 
	        
	        if (selType.equals("4")) {
	            str = str + "<option value='4' selected>X (연락안함)</option>";                        
	        } else {
	            str = str + "<option value='4'>X (연락안함)</option>";  
	        }
	        str = str + "</select>";
	
	        return str;
	} 
	
    static public String mkAttendTypeSelectBox (String id, String selType) {
	    //console.log ("selType ::" + selType);
	    // 0, 1 (문자) ,2(전화) ,3(연락안함)
	    String str = "<select style=\"width:60px\" onchange=\"changeAttendType('"+id+"', this)\" >" ;
	        str = str + "";
	        
	        if (selType.equals("출석")) {
	            str = str + "<option selected>출석</option>";
	        } else {
	            str = str + "<option>출석</option>";
	        }
	        
	        if (selType.equals("장결")) {
	            str = str + "<option selected>장결</option>";
	        } else {
	            str = str + "<option >장결</option>";
	        }
	        
	        if (selType.equals("해외")) {
	            str = str + "<option selected>해외</option>";
	        } else {
	            str = str + "<option>해외</option>";
	        } 
	        
	        str = str + "</select>";
	
	        return str;
	} 
    
    static public String viewAttendWeek (String at) {
    	if (at.equals("1")) return "O";
    	else return "X";
    }
	
//
//    /**
//     * 특정 날짜에 대하여 요일을 구함(일 ~ 토)
//     * @param date
//     * @param dateType
//     * @return
//     * @throws Exception
//     */
//    public static String getDateDay(String date, String dateType, String locale) {
//        String day = "" ;
//        SimpleDateFormat dateFormat = new SimpleDateFormat(dateType) ;
//        Date nDate = null;
//        try {
//            nDate = dateFormat.parse(date);
//            Calendar cal = Calendar.getInstance() ;
//            cal.setTime(nDate);
//
//            int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
//
//            String[] dayOfWeek = locale.equalsIgnoreCase("en") ? CommonConstants.DAYOFWEEK_ENG: CommonConstants.DAYOFWEEK_KOR;
//
//            switch(dayNum){
//                case 1:
//                    day = dayOfWeek[0];
//                    break ;
//                case 2:
//                    day = dayOfWeek[1];
//                    break ;
//                case 3:
//                    day = dayOfWeek[2];
//                    break ;
//                case 4:
//                    day = dayOfWeek[3];
//                    break ;
//                case 5:
//                    day = dayOfWeek[4];
//                    break ;
//                case 6:
//                    day = dayOfWeek[5];
//                    break ;
//                case 7:
//                    day = dayOfWeek[6];
//                    break ;
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return day ;
//    }

}
