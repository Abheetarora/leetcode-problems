class Solution {
	public String largestNumber(int[] nums) {

		String s = Arrays.stream(nums)
			.mapToObj(Integer::toString)
			.sorted((a,b) -> (b+a).compareTo(a+b))
			.collect(Collectors.joining(""));

		return s.charAt(0) == '0' ? "0" : s;
	}
}