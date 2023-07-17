#include <string>
#include <vector>
#include <cmath>

using namespace std;

int getGap(int start, int end)
{
    int xGap = abs((start % 3 != 0 ? start / 3 : start / 3 - 1) - end / 3);
    int yGap = abs((start % 3 != 0 ? start % 3 - 1 : 2) - (end % 3 - 1));
    return xGap + yGap;
}

string solution(vector<int> numbers, string hand) {
    //��ȣ���� 2���� �迭�� �����ϸ� x�������� �� + y�� ������ �� = �̵��Ÿ�
    //x���� 3���� ������ y���� 3���� ���� ������ -1 ���̴�.
    int left = 10; //*�� ��ġ�� 10�� ��ġ
    int right = 12; //#�� ��ġ�� 12�� ��ġ
    string answer = "";
    for (int n : numbers)
    {
        n = n == 0 ? 11 : n; //0�� ��ġ�� 11�� ��ġ
        switch (n)
        {
        case 1:
        case 4:
        case 7:
            left = n;
            answer += "L";
            break;
        case 3:
        case 6:
        case 9:
            right = n;
            answer += "R";
            break;
        default:
            if (getGap(left, n) == getGap(right, n)) //�Ÿ��� ������
            {
                if (hand == "left")
                {
                    left = n;
                    answer += "L";
                }
                else
                {
                    right = n;
                    answer += "R";
                }
            }
            else if (getGap(left, n) < getGap(right, n))
            {
                left = n;
                answer += "L";
            }
            else
            {
                right = n;
                answer += "R";
            }
            break;
        }
    }
    return answer;
}