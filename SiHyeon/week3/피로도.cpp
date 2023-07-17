#include <string>
#include <vector>

using namespace std;

int dfs(int k, int count, vector<vector<int>> dungeons, int visited[])
{
    static int max = 0;
    for (int i = 0; i < dungeons.size(); i++)
    {
        //�湮������ ���� �ּ��Ƿε� ���� ���� ��� ��, �湮 ������ ���
        if (!visited[i] && k >= dungeons[i][0])
        {
            visited[i] = true;
            max = dfs(k - dungeons[i][1], count + 1, dungeons, visited);
            visited[i] = false;
        }
    }
    return count > max ? count : max;
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    int visited[8] = { false, };
    answer = dfs(k, 0, dungeons, visited);
    return answer;
}