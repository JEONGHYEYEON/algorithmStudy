#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    for (int i = 1; i < number.size() && k > 0; i++) //k���� 0���� ũ�� number�� ������ ���� ������ ��ȸ�Ѵ�
    {
        if (number[i - 1] < number[i])
        {
            number.erase(i - 1, 1);
            i = 0;
            k--;
        }
    }
    answer = number.erase(number.size() - k, k); //�� ���Ƶ� k���� ���� ���� ������ ���ش�
    return answer;
}