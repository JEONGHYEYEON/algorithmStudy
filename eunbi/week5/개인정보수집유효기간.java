package algorithmStudy;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[][] date = new int[privacies.length][3];
        int[] dday = {Integer.parseInt(today.substring(2, 4)), Integer.parseInt(today.substring(5, 7)), Integer.parseInt(today.substring(8, 10))}; // ���� ��¥ ����
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for(String i : terms) // key : ��� ����, value : ��ȿ�Ⱓ
            map.put(i.charAt(0), Integer.parseInt(i.substring(2)));
        
        for(int i=0; i<privacies.length; i++){
            date[i][0] = Integer.parseInt(privacies[i].substring(2,4)); // ��
            date[i][1] = Integer.parseInt(privacies[i].substring(5,7)); // ��
            date[i][2] = Integer.parseInt(privacies[i].substring(8,10)); // ��
            if(date[i][1] + map.get(privacies[i].charAt(11)) > 12){ // ��� ��ȿ�Ⱓ�� ����
                date[i][0] = date[i][0] + (date[i][1] + map.get(privacies[i].charAt(11))) / 12;
                date[i][1] = (date[i][1] + map.get(privacies[i].charAt(11))) % 12;
                if(date[i][1] == 0){
                    date[i][0]--;
                    date[i][1] = 12;
                }
            }
            else
                date[i][1] = date[i][1] + map.get(privacies[i].charAt(11)); // �޸� ����
        }
        
        for(int i=0; i<date.length; i++){
            if(dday[0] > date[i][0]) // �� ��. ���� ���� ũ�� �ı�
                list.add(i+1);
            else if(dday[0] == date[i][0]){ // �� ��. ���� ������ ���� ����
                if(dday[1] > date[i][1]) // �� ��. ���� ���� ũ�� �ı�
                    list.add(i+1);
                else if(dday[1] == date[i][1]) // ���� ���ٸ�
                    if(dday[2] >= date[i][2]) // �� ��. ���� ���ų� ũ�� �ı�
                        list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
            
        return answer;
    }
}