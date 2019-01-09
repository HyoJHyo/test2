package com.joyful.kingdom.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Created by chakankim@gmail.com on 2016-01-12.
 */
public class DateUtil {
    /**
     * 월의 해당 주의 날짜 배열을 얻어온다.
     * @param yyyymm
     * @param weekSeq
     * @return
     */
    public static int[] getRangeDateOfWeek(String yyyymm, int weekSeq) {
        int rangeDateOfWeek [] = new int[7];

        int startDayOfWeek = dayOfWeek(yyyymm.substring(0, 4), yyyymm.substring(4, 6), "1");

        if( startDayOfWeek == 0 || weekSeq > 1 ){
            Calendar cal = converterDate(yyyymm+"01");
            int lastDateOfMonth = getLastDateOfMonth(new SimpleDateFormat("yyyyMM").format(cal.getTime()));

            int startDate = 1 + ((weekSeq-1)*7) - startDayOfWeek;
            for( int i=0; i<7; i++ ){
                if( startDate > lastDateOfMonth ){
                    startDate = 1;
                }
                rangeDateOfWeek[i] = startDate++;
            }
        }else{
            Calendar cal = converterDate(yyyymm+"01");
            cal.add(Calendar.MONTH, -1);
            int lastDateOfBeforeMonth = getLastDateOfMonth(new SimpleDateFormat("yyyyMM").format(cal.getTime()));

            int startDate = (lastDateOfBeforeMonth + 1) - startDayOfWeek;
            for( int i=0; i<7; i++ ){
                if( startDate > lastDateOfBeforeMonth ){
                    startDate = 1;
                }
                rangeDateOfWeek[i] = startDate++;
            }
        }
        return rangeDateOfWeek;
    }
    /**
     * 특정날짜의  요일의 숫자를 리턴
     * 0:일요일 ~ 6:토요일
     * @return
     */
    public static int dayOfWeek(String sYear, String sMonth, String sDay) {

        int iYear = Integer.parseInt(sYear);
        int iMonth = Integer.parseInt(sMonth) - 1;
        int isDay = Integer.parseInt(sDay);

        GregorianCalendar gc = new GregorianCalendar(iYear, iMonth, isDay);

        return gc.get(gc.DAY_OF_WEEK) - 1;
    }


    public static String getWeeknum(){
    	Calendar cal = Calendar.getInstance(); // 양력 달력
    	
    	// 주일날을 기준으로 모든 것을 정한다.
        Calendar c = new GregorianCalendar(cal.get(Calendar.YEAR),0,1);
        
        int gap = 0;
        // 1월 1일이 주일이면 1을 빼지 않는다.
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) gap = 0;
        else gap = 1;
        
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        
        
        String week = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR) - gap);
        return week;
    }
    
    /**
     * String 형식의 날자를 Calendar 로 변환 해준다.
     *
     * @param yyyymmdd
     * @return
     */
    public static Calendar converterDate(String yyyymmdd) {
        Calendar cal = Calendar.getInstance(); // 양력 달력
        if (yyyymmdd == null)
            return cal;

        String date = yyyymmdd.trim();
        if (date.length() != 8) {
            if (date.length() == 4)
                date = date + "0101";
            else if (date.length() == 6)
                date = date + "01";
            else if (date.length() > 8)
                date = date.substring(0, 8);
            else
                return cal;
        }

        cal.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
        cal.set(Calendar.MONTH, Integer.parseInt(date.substring(4, 6)) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(6)));

        return cal;
    }

    public static String getFirstOfWeek (int type) {
        Calendar c = Calendar.getInstance(); //객체 생성 및 현재 일시분초...셋팅
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        String ntime = new String();
        if (type == 1) ntime = String.valueOf(c.get(Calendar.YEAR)) ;
        else if(type == 2) ntime = String.valueOf(c.get(Calendar.MONTH)+1);
        else if(type == 3) ntime = String.valueOf(c.get(Calendar.DATE));

        return ntime;
    }


    // 특정 달을 입력하면,
    // 그 달에 해당되는 분기가 반환되는 메서드
    public static int quarterYear(int month) {
        return (int) Math.ceil( month / 3.0 );
    }



    /**
     * 해당 월의 마지막일을 구한다.
     * @return
     */
    public static int getLastDateOfMonth() {
        return getLastDateOfMonth(new Date());
    }
    public static int getLastDateOfMonth(Date date) {
        return getLastDateOfMonth(new SimpleDateFormat("yyyyMM").format(date));
    }
    public static int getLastDateOfMonth(String yyyymm) {
        int year = Integer.parseInt(yyyymm.substring(0, 4));
        int month = Integer.parseInt(yyyymm.substring(4, 6)) - 1;

        Calendar destDate = Calendar.getInstance();
        destDate.set(year, month, 1);

        return destDate.getActualMaximum(Calendar.DATE);
    }

    /*
       몇 주차 구하기 ymd ==: 2017-09-10
    */
    public static int getWeekNum(String ymd) {
        int weekNum = 0;
        if (ymd.length() < 10) return 0;
		String[] arymd = ymd.split("[-]");
		if (arymd.length == 3) {
            int year    = Integer.parseInt(arymd[0]);
            int month   = Integer.parseInt(arymd[1]) - 1;
            int day     = Integer.parseInt(arymd[2]);

            Calendar toDay = Calendar.getInstance();
            toDay.set(year, month, day);
            weekNum = toDay.get(Calendar.WEEK_OF_YEAR);
		}

        return weekNum;
    }
}