//this runs but doesnt work right
//and the code's bad too

import java.util.*;

import java.util.Arrays;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
    //total numbers of zero;
    int tnz=0;

    //sort
    Arrays.sort(nums);

    //last zero position(would be the index of first positive if there's no 0)
    int lzp=0;

    for(int i:nums)System.out.print(i+",");
    System.out.print("\n");
    
    //find the last zero position and num of 0
    for(int i=0;i<nums.length;i++){
      if(nums[i]<0)lzp++;
      else if(nums[i]==0)tnz++;
    }
    System.out.print("num of 0: "+tnz+"\n");
    System.out.print("last position of 0: "+lzp+"\n");

    //array to list
    List<Integer>fh=new ArrayList<Integer>();

    //list stores list
    List<List<Integer>> ok = new ArrayList<List<Integer>>();
    
    //三种情况：左边大于右边，右边大于左边，左边等于右边
    for(int i=0;i<lzp;i++){
        
        for(int j=lzp;j<nums.length;j++){
            if(nums[j]==0) continue;
            if (nums[i]==0)continue;
            //case 1
            if(nums[i]+nums[j]<0){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[k]+nums[j]+nums[i]==0){
                        fh.add(nums[i]);
                        fh.add(nums[j]);
                        fh.add(nums[k]);
                        ok.add(fh);
                        System.out.print(fh+"\n");
                        fh.clear();

         
                    }
                }
            }
            //case 2
            else if(nums[i]+nums[j]>0){
                for(int k=i+1;k<lzp-tnz+1;k++){
                    if(nums[k]+nums[j]+nums[i]==0){
                        fh.add(nums[i]);
                        fh.add(nums[j]);
                        fh.add(nums[k]);
                        ok.add(fh);
                        System.out.print(fh+"\n");
                        fh.clear();

             
                    }
                    
                }
            }
            //case 3
            else if(nums[i]+nums[j]==0 && tnz>0){
                        fh.add(nums[i]);
                        fh.add(0);
                        fh.add(nums[j]);
                        System.out.print(fh+"\n");
                        ok.add(fh);
                        fh.clear();

                        tnz--;
     
                        
                    }
                    
                }
            }
        while(tnz>3){
          fh.add(0);
          fh.add(0);
          fh.add(0);
            ok.add(fh);
          System.out.print(fh);
          fh.clear();
          tnz-=3;
        }
   return ok;
        }
    
    
    

    }

