import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static String next() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
	
	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}
	
	static HashMap<String, Integer> value;   // var -> 시작 주소
	static HashMap<String, Integer> sizeMap; // var -> 할당된 크기
	static List<int[]> range; // allocated ranges [start, end], always sorted by start
	
	
	static void processFree(String var) {
		Integer startAddr = value.get(var);
		if (startAddr == null || startAddr == 0) return;
		
		int allocSize = sizeMap.get(var);
        int endAddr = startAddr + allocSize - 1;
        
		int n = range.size();
		for (int i = 0; i < n; i++) {
			int[] cur = range.get(i);
			if (cur[0] == startAddr && cur[1] == endAddr) {
				range.remove(i);
				break;
			}
		}
		
		value.put(var, 0);
		sizeMap.put(var, 0);
	}

	static void alloc(String var, int startAddr, int size, int insertIdx) {
		int endAddr = startAddr + size - 1;
		
		if (endAddr > 100_000) {
			value.put(var, 0);
			sizeMap.put(var, 0);
			return;
		}
		
		value.put(var, startAddr);
		sizeMap.put(var, size);
		range.add(insertIdx, new int[] {startAddr, endAddr});
	}
	
	static void processMalloc(String var, int size) {
		int n = range.size();

        if (n == 0) {
            alloc(var, 1, size, 0);
            return;
        }
		
		// 맨 앞 빈 공간 확인
        if (range.get(0)[0] - 1 >= size) {
        	alloc(var, 1, size, 0);
        	return;
        }
        
        // 중간 빈 공간 확인
        for (int i = 0; i < n - 1; i++) {
            int startAddr = range.get(i)[1] + 1;
            int gap = range.get(i + 1)[0] - range.get(i)[1] - 1;

            if (gap >= size) {
                alloc(var, startAddr, size, i + 1);
                return;
            }
        }
        
        // 마지막 뒤쪽 확인
        int startAddr = range.get(n - 1)[1] + 1;
        alloc(var, startAddr, size, n);
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		value = new HashMap<>();
		sizeMap = new HashMap<>();
		range = new ArrayList<>();
		
		int N = nextInt();
		for (int i = 0; i < N; i++) {
			String cmd = next();
			
			if (cmd.charAt(0) == 'f') {
				String var = cmd.substring(5, 9);
				processFree(var);
			}
			else if (cmd.charAt(0) == 'p') {
				String var = cmd.substring(6, 10);
				sb.append(value.getOrDefault(var, 0)).append("\n");
			}
			else {
				String var = cmd.substring(0, 4);
				int s = cmd.indexOf('(');
				int e = cmd.indexOf(')');
				int size = Integer.parseInt(cmd.substring(s + 1, e));
				processMalloc(var, size);
			}
		}
		
		System.out.println(sb);
	}
}
