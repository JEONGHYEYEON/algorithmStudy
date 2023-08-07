#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    unordered_map<string, int> rank;
    for (int i = 0; i < players.size(); i++)
    {
        rank.insert(make_pair(players[i], i));
    }
    for (auto c : callings)
    {
        //��� ��ü
        string player = players[rank[c] - 1];
        players[rank[c] - 1] = c;
        players[rank[c]] = player;
        //���� ��ü
        rank[c] -= 1;
        rank[player] += 1;
    }
    return players;
}