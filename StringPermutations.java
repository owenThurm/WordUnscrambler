import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;


class Solution {
    public static List<List<Character>> permute(char[] characters) {
        if(characters.length == 0) return new ArrayList(Arrays.asList(new ArrayList()));
        if(characters.length == 1) return new ArrayList(Arrays.asList(new ArrayList(Arrays.asList(characters[0]))));
        if(characters.length == 2) return new ArrayList(Arrays.asList(new ArrayList(Arrays.asList(characters[0], characters[1])), new ArrayList(Arrays.asList(characters[1], characters[0]))));
        List<List<Character>> permutations = new ArrayList();
        for(Character character : characters) {
            //get all of the permutations of the rest of the list and add this num to the beginning
            List<List<Character>> restPerms = permute(remove(characters, character));
            for(int i=0; i< remove(characters, character).length; i++) System.out.print(remove(characters, character)[i]);
            System.out.println();
            for(List<Character> perm : restPerms) {
                perm.add(0, character);
            }
            //add those permutations to the list of permutations
            permutations.addAll(restPerms);
        }
        return permutations;
    }
    
    public static char[] remove(char[] nums, char num) {
        char[] removed = new char[nums.length-1];
        int j = 0;
        boolean removedAlready = false;
        for(int i=0; i<nums.length; i++) {
            if(removedAlready || nums[i] != num) {
                removed[j] = nums[i];
                j++;
            } else removedAlready = true;
        }
        return removed;
    }


    public static void main(String[] args) {

        System.out.println(Boolean.parseBoolean("FaLSe"));
/*
         try {
             File permsFile = new File("Strings.txt");
             FileWriter writer = new FileWriter(permsFile, true);
             String permutationString = permute(new char[] { 'm', 'i', 'l', 'u', 'e', 's', 's'}).toString().replaceAll(", ", "").replaceAll("]", " ").replaceAll("\\[", "");

             System.out.println(permutationString.substring(0, 4));
             writer.write(permutationString);
             writer.close();
         } catch(IOException e) {
             throw new IllegalStateException("IO Exception!", e);
         }


*/




    }
}