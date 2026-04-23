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
	static LinkedList<int[]> range; // allocated ranges [start, end], always sorted by start
	
	static void processFree(String var) {
		Integer startAddr = value.get(var);
		if (startAddr == null || startAddr == 0) return;
		
		int allocSize = sizeMap.get(var);
        int endAddr = startAddr + allocSize - 1;
        
        ListIterator<int[]> it = range.listIterator();
		while (it.hasNext()) {
			int[] cur = it.next();
			if (cur[0] == startAddr && cur[1] == endAddr) {
				it.remove();
				break;
			}
		}
		
		value.put(var, 0);
		sizeMap.put(var, 0);
	}

	static void alloc(String var, int startAddr, int size, ListIterator<int[]> it) {
		int endAddr = startAddr + size - 1;
		
		if (endAddr > 100_000) {
			value.put(var, 0);
			sizeMap.put(var, 0);
			return;
		}
		
		value.put(var, startAddr);
		sizeMap.put(var, size);
		
		it.add(new int[] {startAddr, endAddr});
	}
	
	static void processMalloc(String var, int size) {
		ListIterator<int[]> it = range.listIterator();
		
		// 빈 리스트면 iterator 위치에 바로 add
		if (!it.hasNext()) {
			alloc(var, 1, size, it);
			return;
		}
		
		int[] first = it.next();
		
		// 맨 앞 빈 공간 확인
        if (first[0] - 1 >= size) {
        	it.previous();  // add를 첫 원소 앞에 하기 위해 한 칸 뒤로
        	alloc(var, 1, size, it);
        	return;
        }
        
        int[] prev = first;
        
        // 중간 빈 공간 확인
        while (it.hasNext()) {
        	int[] cur = it.next();
        	
        	int startAddr = prev[1] + 1;
        	int gap = cur[0] - prev[1] - 1;
        	
        	if (gap >= size) {
        		it.previous();
        		alloc(var, startAddr, size, it);
        		return;
        	}
        	
        	prev = cur;
        }
        
        // 마지막 뒤쪽 확인
        int startAddr = prev[1] + 1;
        alloc(var, startAddr, size, it);
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		value = new HashMap<>();
		sizeMap = new HashMap<>();
		range = new LinkedList<>();
		
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
