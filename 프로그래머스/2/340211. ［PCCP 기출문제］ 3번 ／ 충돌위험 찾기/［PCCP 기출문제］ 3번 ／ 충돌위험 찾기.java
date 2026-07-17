import java.util.*;
class Solution {
    
    List<List<Pos>> posLists;
    int[][] points;
    
    public int solution(int[][] points, int[][] routes) {
        this.points = points;
        posLists = new ArrayList<>();
        
        // 모든 로봇의 이동 경로상의 좌표 저장
        int maxTime = 0;
        for (int[] route : routes) {
            List<Pos> pos = getPosList(route);
            posLists.add(pos);
            maxTime = Math.max(maxTime, pos.size());
        }
        
        // 위험한 상황의 횟수 계산
        int answer = 0;
        int robotCount = routes.length;
        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> count = new HashMap<>();
            for (int i = 0; i < robotCount; i++) {
                List<Pos> robotPos = posLists.get(i);
                if (t < robotPos.size()) {
                    String key = robotPos.get(t).y + ":" + robotPos.get(t).x;
                    count.put(key, count.getOrDefault(key, 0) + 1);
                    if (count.get(key) == 2) answer++;
                }
            }     
        }
        return answer;
    }
    
    private List<Pos> getPosList(int[] route) {
        List<Pos> temp = new ArrayList<>();
        
        int startPoint = route[0] - 1;
        temp.add(new Pos(points[startPoint][0], points[startPoint][1]));
        
        for (int i = 0; i < route.length - 1; i++) {
            temp.addAll(getPosByTwo(route[i], route[i + 1]));
        }
        return temp;
    }
    
    private List<Pos> getPosByTwo(int p1, int p2) {
        List<Pos> temp = new ArrayList<>();
        int y1 = points[p1 - 1][0];
        int x1 = points[p1 - 1][1];
        int y2 = points[p2 - 1][0];
        int x2 = points[p2 - 1][1];
        
        int curY = y1;
        int curX = x1;
        
        while (curY != y2) {
            if (curY < y2) {
                curY++;
            } 
            else {
                curY--;
            } 
            temp.add(new Pos(curY, curX));
        }
        
        while (curX != x2) {
            if (curX < x2) {
                curX++;
            } else {
                curX--;
            }
            temp.add(new Pos(curY, curX));
        }
        return temp;
    }
    
    static class Pos {
        int y, x;
        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}