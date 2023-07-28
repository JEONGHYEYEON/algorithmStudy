package algorithmStudy;

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] result = new int[4];
        String[] kakao = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<survey.length; i++){
            if(choices[i]>4)  // ����. ���ڸ� key��, ������ value���ؼ� map�� ����
                map.put(cToS(survey[i], 1), map.getOrDefault(cToS(survey[i], 1), 0) + choices[i]-4);
            else  // ����
                map.put(cToS(survey[i], 0), map.getOrDefault(cToS(survey[i], 0), 0) + Math.abs(choices[i]-4));
        }
        
        for(int i=0; i<8; i++)
            if(map.get(kakao[i])==null)
                map.put(kakao[i], 0); // �������� ������ ���������(null�̸�) 0���� �߰�����
        
        
        for(int i=0; i<8; i=i+2){
            if(map.get(kakao[i]) >= map.get(kakao[i+1]))  
                answer = answer + kakao[i];
            else
                answer = answer + kakao[i+1];
        }
        
        return answer;
    }
    
    public String cToS(String s, int i){ // char�� String���� ��ȯ
        return String.valueOf(s.charAt(i)); // (+���� Ǭ �ڿ� �߰�+ �ٸ���� Ǯ�� ���� map�� ĳ������ ���� �� ����....)
    }
}