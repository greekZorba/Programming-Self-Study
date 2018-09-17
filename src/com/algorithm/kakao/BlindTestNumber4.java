package com.algorithm.kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlindTestNumber4 {

	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // n 셔틀 운행 횟수
		int t = Integer.parseInt(br.readLine()); // t 셔틀 운행 간격
		int m = Integer.parseInt(br.readLine()); // m 버스에 탈 수 있는 최대 크루 수
		String timetable = br.readLine(); // 크루들이 도착하는 타임테이블

		/* 계산을 위해 입력값 변형 */
		timetable = timetable.substring(2, timetable.length()-2).replace("\"", "");
		String[] inputArray = timetable.split(", ");
		String shouldArriveTime = calculateShuttleTime(n, t, m, inputArray);

		bw.write(shouldArriveTime);
		bw.flush();

	}

	private static String calculateShuttleTime(int n, int t, int m, String[] crewLine){ // 도착해야하는 시간을 계산해주는 메서드
		List<Integer> sumMinutes = new ArrayList<>();

		for(int i=0; i<crewLine.length; i++){

			int hour = Integer.parseInt(crewLine[i].substring(0, 2))*60;
			int minute = Integer.parseInt(crewLine[i].substring(crewLine[i].length()-2, crewLine[i].length()));
			sumMinutes.add(hour+minute);
		}
		Collections.sort(sumMinutes); // 오름차순 배열

		int departureTime = 540; // 출발 시간
		int crewCount = 0; // 버스에 타는 크루 수
		List<Integer> lastBus = new ArrayList<>(); // 마지막 셔틀버스

		for(int i=1; i<=n; i++){

			while(crewCount < m && !sumMinutes.isEmpty() && sumMinutes.get(0) <= departureTime){

				if(departureTime >=sumMinutes.get(0) && sumMinutes.get(0) <= 1080){
					if(i == n){
						lastBus.add(sumMinutes.get(0));
					}
					sumMinutes.remove(0);
					crewCount++;
				}else if(sumMinutes.get(0) > 1080){
					sumMinutes.remove(0);
				}
			}
			departureTime += t;
			crewCount = 0;
		}
		departureTime -= t; // 마지막 셔틀시간으로 돌림
		int result = lastBus.size() >= m ? lastBus.get(m-1)-1 : departureTime;

		return parseMinuteToTime(result);
	}

	private static String parseMinuteToTime(int arriveMinutes){ // 분을 출력형식("00:00")으로 만들어줌

		sb.append("\"");

		String hours = arriveMinutes/60 <10 ? "0"+String.valueOf(arriveMinutes/60) : String.valueOf(arriveMinutes/60);
		sb.append(hours); // 시

		sb.append(":");

		String minute = arriveMinutes%60 <10 ? "0"+String.valueOf(arriveMinutes%60): String.valueOf(arriveMinutes%60);
		sb.append(minute); // 분
		sb.append("\"");

		return sb.toString();
	}


}
