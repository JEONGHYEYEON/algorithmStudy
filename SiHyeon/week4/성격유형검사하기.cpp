#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    map<char, int> types;
    char s_type[] = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };
    for (auto s : s_type) //�ʱ�ȭ
        types.insert(pair<char, int>(s, 0));
    for (int i = 0; i < survey.size(); i++)
    {
        if (choices[i] >= 4) //���� Ȯ���ؼ� 4�� �̻��̸� �ڿ� Ÿ�Կ� ���� �߰�
            types[survey[i].at(1)] += choices[i] % 4;
        else
            types[survey[i].at(0)] += 4 - (choices[i] % 4);
    }
    for (int i = 0; i < 8; i += 2)
    {
        //Ÿ�Ժ� ���� �� �� ū Ÿ�� ����
        answer += types[s_type[i]] >= types[s_type[i + 1]] ? s_type[i] : s_type[i + 1];
    }
    return answer;
}