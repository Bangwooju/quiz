package kr.co.kccworld.bwj;

import java.util.Arrays;


/*#문제5
1번부터 N번까지 후보에 대해서 투표를 진행했습니다. 예를 들어 투표 결과가 [1, 5, 4, 3, 2, 5, 2, 5, 5, 4]라면 순서대로 [1번, 5번, 4번, 3번, 2번, 5번, 2번, 5번, 5번, 4번] 후보에 투표했음을 나타냅니다. 이때, 가장 많은 표를 받은 후보의 번호를 구하려고 합니다.

주어진 solution 메소드는 후보의 수 N과 투표를 진행한 결과가 담긴 배열 votes가 매개변수로 주어졌을 때, 가장 많은 표를 받은 후보의 번호를 return 하는 메소드입니다. 그러나, 코드 일부분이 잘못되어있기 때문에, 몇몇 입력에 대해서는 올바르게 동작하지 않습니다. 주어진 코드에서 _**한 줄**_만 변경해서 모든 입력에 대해 올바르게 동작하도록 수정하세요.

---
#####매개변수 설명
후보의 수 N과 투표 결과가 들어있는 배열 votes가 solution 메소드의 매개변수로 주어집니다.
* N은 1 이상 10 이하의 자연수입니다.
* votes의 길이는 1 이상 100 이하입니다.
* votes의 원소는 1 이상 N이하의 자연수입니다.

---
#####return 값 설명
가장 많은 표를 받은 후보의 번호를 배열에 담아 return 해주세요
* 만약 가장 많은 표를 받은 후보가 2개 이상이라면, 그 후보들의 번호를 모두 배열에 담아 오름차순 정렬하여 return 해주세요.
*/
public class test1 {
	    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
	    public static void main(String[] args) {
	        Solution sol = new Solution();
	        int N1 = 5;
	        int[] votes1 = {1,5,4,3,2,5,2,5,5,4};
	        int[] ret1 = sol.solution(N1, votes1);
	 
	        // Press Run button to receive output. 
	        System.out.println("Solution: return value of the method is " + Arrays.toString(ret1) + " .");
	        

	        int N2 = 4;
	        int[] votes2 = {1, 3, 2, 3, 2};
	        int[] ret2 = sol.solution(N2, votes2);
	 
	        // Press Run button to receive output. 
	        System.out.println("Solution: return value of the method is " + Arrays.toString(ret2) + " .");
	    }
}


class Solution {
    public int[] solution(int N, int[] votes) {
        int voteCounter[] = new int[11];
        for (int i = 0; i < votes.length; i++) {
            voteCounter[votes[i]] += 1;
        }
        
        int maxVal = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (maxVal < voteCounter[i]) {
                maxVal = voteCounter[i];
                cnt = 1;
            }
            else if(maxVal == voteCounter[i]){
                cnt += 1;
            }
        }
        int answer[] = new int[cnt];
        for (int i = 1, idx = 0; i <= N; i++){
            if (voteCounter[i] == maxVal) {
                answer[idx] = i;
                idx += 1;
            }
        }
        return answer;
    }
}
