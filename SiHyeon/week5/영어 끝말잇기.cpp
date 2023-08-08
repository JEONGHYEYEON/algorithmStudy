#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer = { 0,0 };
    string str;
    for (int i = 0; i < words.size(); i++)
    {
        int findIndex = str.find(words[i]);
        //�ܾ �ѱ���, �մܾ�� ���̾����� �ܾ�, ��ġ�� �ܾ� üũ
        if (words[i].size() == 1
            || (!str.empty() && str[str.size() - 2] != words[i][0]
                || findIndex != string::npos && str[findIndex - 1] == '\"'))
        {
            answer[0] = i % n + 1;
            answer[1] = (i + n) / n;
            break;
        }
        str += "\"" + words[i] + "\""; //"" ���� �ܾ ������ ��ġ�°� üũ�Ҷ� helloone �̸� loo��� �ܾ ���� ������ ����� ����
    }

    return answer;
}