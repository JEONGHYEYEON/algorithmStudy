package algorithmStudy;

import java.util.*;

class Solution {
    public int solution(int[] ing) {
        int answer = 0;        
        List<Integer> list = new ArrayList<Integer>();
        for(int i : ing)
            list.add(i);
        
        for(int i=0; i<list.size()-3; i++){
            if(list.get(i)==1 && list.get(i+1)==2 && list.get(i+2)==3 && list.get(i+3)==1){
                answer++;
                for(int j=0; j<4; j++)
                    list.remove(i);
                if(i<=2)    
                    i=-1;  // 0�� �ε������� �ٽ� üũ
                else
                    i=i-4; // �� ��ġ�κ��� ��ĭ ������ üũ ex) 1231234�̰� i=3�� ��
            }
        }
       
        return answer;
    }
}