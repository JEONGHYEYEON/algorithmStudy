#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n - lost.size();
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    vector<int> newLost;
    //���� ü������ ���� ���Ѱ�� �̸� ���� ü�������� ����
    for (int i = 0; i < lost.size(); i++)
    {
        auto index = find(reserve.begin(), reserve.end(), lost[i]);
        if (index != reserve.end())
        {
            reserve.erase(index);
            answer++;
        }
        else
            newLost.push_back(lost[i]); //�������� ����Ʈ�� ����
    }
    //���� ���� ��� �յڷ� ������ �� �ִ��� Ȯ��
    for (auto l : newLost)
    {
        auto index = find(reserve.begin(), reserve.end(), l - 1);
        if (index != reserve.end())
        {
            reserve.erase(index);
            answer++;
        }
        else
        {
            index = find(reserve.begin(), reserve.end(), l + 1);
            if (index != reserve.end())
            {
                reserve.erase(index);
                answer++;
            }

        }
    }
    return answer;
}