// There are numbers from 1 to N in an array. out of these, one of the number gets duplicated and one is missing. 
// The task is to find out the duplicate number. 
// Conditions: you have to do it in O(n) time without using any auxilary space (array, bitsets, maps etc..).


public int[] computeMissingNumberAndDuplicate(int[] input)
{
  //Say, int[] input= {1, 2, 3, 4, 5, 3, 7};  //6 has been replaced by 3. diff will be -3
  int n = input.length;
  int expectedSum = n * (n + 1) / 2;
  int actualSum = 0;
  int[] res = new int[2];
  int a = 0;
  for(int i = 0; i < n; i++){
  a ^= input[i];  
  actualSum += input[i];
  }
  //now,  a = 3 ^ 6
  int diff = expectedSum - actualSum;

  
  if (diff == 0) throw new Exception("Wrong Input");
  
  else if(diff < 0){
  diff = -diff;
  for(int i = diff + 1; diff <= n; i++){
  if (i ^ (i - diff) ^ a == 0)
  res[0] = i; // MISSING number
  res[1] = i - diff; // DUP
  }
  }
  
  else{
  for(int i = 1; i <= n - diff; i++){
  if(i ^ (i + diff) ^ a == 0){
  res[0] = i;  //MISSING
  res[1] = i + diff;  // DUP
  }
  }
  }
  
  return res;
  
}
