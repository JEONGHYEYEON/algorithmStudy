#include <string>
#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    vector<int> buger = { 1,2,3,1 };
    int index = 0;
    for (int i = 0; i < ingredient.size(); i++)
    {
        if (ingredient[i] == 1 && i + buger.size() <= ingredient.size())
            for (int j = 0; j < buger.size(); j++)
            {
                if (buger[j] != ingredient[i + j]) //������ᰡ �ƴϰų� ���� ��ᰡ �����ϰų� ��ᰡ �ٸ��� �Ѿ
                    break;
                else if (j == buger.size() - 1) //������ ������ �ϼ�
                {
                    ingredient.erase(ingredient.begin() + i, ingredient.begin() + i + j + 1);
                    i = i - 3 > 0 ? i - 3 : -1; //�ϼ��� �ϸ� ��ó������ �ٽ� ã�°��� �ƴ϶� �ϼ��� ��ġ���� �ڷ� 2��°���� ã���� �ȴ�. �׺��� ������ �̹� ������� ���̱� ����
                    answer++;
                }
            }
    }
    return answer;
}