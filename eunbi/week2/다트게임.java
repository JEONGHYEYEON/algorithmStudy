package algorithmStudy;

import java.util.*;

class Solution {
    public int solution(String dartResult) { 
        int answer = 0;
        int temp = 0;  
        int j = 0;    // score �ε���  
        ArrayList<Integer> score = new ArrayList<Integer>();

        for(int i=0; i<dartResult.length(); i++){
            if(Character.isDigit(dartResult.charAt(i))){  // ���ڰ� �������� Ȯ��
                if(Character.isDigit(dartResult.charAt(i+1))){  // �� ���� ���ڵ� ������ ���(10�ΰ��)
                    temp = Integer.parseInt(dartResult.substring(i, i+2));  
                    i++; // �� ��� 1�� ������Ŵ. 10�̹Ƿ� 1 ���� 0�� ���ؼ� �ǳʶپ�� �ϹǷ�
                }
                else
                    temp = dartResult.charAt(i) - '0';
                score.add(temp);  // ����Ʈ�� ���� �߰�
                j++; // ����Ʈ �ε��� ����
            }
            else if(dartResult.charAt(i)=='#')
                score.set(j-1, score.get(j-1) * (-1));
            else if(dartResult.charAt(i)=='*'){
                score.set(j-1, score.get(j-1) * 2);
                if(j>=2)  // *�� �� ó���� ������ ���� �ƴ϶�� (1S* �̷� ��찡 �ƴ� ��, ex 1S2D*)
                    score.set(j-2, score.get(j-2) * 2);   // �� �� �͵� ����
            }
            else
                score.set(j-1, (int) sdt(dartResult.charAt(i), score.get(j-1))); // �� ��, S D T �� ��� �Լ�ȣ��
        }
        
        for(int i = 0; i<score.size(); i++)  // ����Ʈ�� ������ ���� ������
            answer += score.get(i);
        
        return answer;
    }
    
    public double sdt(char c, int score){  // S D T�� ��쿡 ���� ���
        if(c == 'S')
            return score;
        else if(c == 'D')
            return Math.pow(score, 2);
        else
            return Math.pow(score, 3);
    }
}
