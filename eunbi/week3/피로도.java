package algorithmStudy;

import java.util.*;

class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>(); // ��� ���� ����

    public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length]; // �湮�� �ε������� Ȯ��
        
        dfs(visit, 0, dungeons, k, 0);
        Collections.sort(list, Collections.reverseOrder()); // �������� ����

        return list.get(0); // �� �հ��� ���� ���� ������ �湮�� �� �ִ� Ƚ��
    }
    public void dfs(boolean[] visit, int index, int[][] dungeons, int k, int ans){        
        if(index == dungeons.length){
            list.add(ans);
            return ;
        }
        for(int i=0; i<dungeons.length; i++){
            if(visit[i] == false){
                if(k >= dungeons[i][0]){ //�ʿ� �Ƿε� ���� ���� ��
                    visit[i] = true;  // �湮 ǥ��
                    dfs(visit, index+1, dungeons, k - dungeons[i][1], ans+1); // ���ȣ��
                    visit[i] = false; // �������·� ����
                }
                else
                    dfs(visit, index+1, dungeons, k, ans);//�ʿ� �Ƿε� ���� ���� ������ ���� ��� ȣ��
            }
        }
    }
}

