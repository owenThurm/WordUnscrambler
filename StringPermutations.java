class Solution {
    public List<List<Character>> permute(char[] characters) {
        if(nums.length == 0) return new ArrayList(Arrays.asList(new ArrayList()));
        if(nums.length == 1) return new ArrayList(Arrays.asList(new ArrayList(Arrays.asList(nums[0]))));
        if(nums.length == 2) return new ArrayList(Arrays.asList(new ArrayList(Arrays.asList(nums[0], nums[1])), new ArrayList(Arrays.asList(nums[1], nums[0]))));
        List<List<Character>> permutations = new ArrayList();
        for(Character character : characters) {
            //get all of the permutations of the rest of the list and add this num to the beginning
            List<List<Character>> restPerms = permute(this.remove(characters, character));
            for(int i=0; i<this.remove(characters, character).length; i++) System.out.print(this.remove(characters, character)[i]);
            System.out.println();
            for(List<Integer> perm : restPerms) {
                perm.add(0, character);
            }
            //add those permutations to the list of permutations
            permutations.addAll(restPerms);
        }
        return permutations;
    }
    
    public char[] remove(char[] nums, char num) {
        char[] removed = new char[nums.length-1];
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != num) {
                removed[j] = nums[i];
                j++;
            }
        }
        return removed;
    }


    public static void main(String[] args) {

        System.out.prinln(permute(new char[] {a, b, c}));

    }
}