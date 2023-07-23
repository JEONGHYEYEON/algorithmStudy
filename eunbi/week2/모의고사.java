package algorithmStudy;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] arr = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        for(int i=0; i<3; i++){
            for(int j=0; j<answers.length; j++){
                if(answers[j]==arr[i][j%(arr[i].length)]) // �����̸�
                    map.put(i+1, map.getOrDefault(i+1, 0) + 1); // �ʿ� �߰� (key : �л���ȣ / value : ���� ����)
            } 
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); // ���� ���� ���� ����

        answer[0] = list.get(0).getKey();
        
        int i=1;
        if(list.size()>0){
            while(i<list.size() && list.get(i).getValue().intValue()==list.get(i-1).getValue().intValue()){
                answer[i] = list.get(i).getKey(); // ���� ��(���� ���� ���� ��)�� ���� ���� ���ٸ� �߰�
                i++;
            }
        } // intValue ��� ���� : integer ������..��¼�� �ذ����� 
                
        return Arrays.copyOfRange(answer, 0, i);
    }
}