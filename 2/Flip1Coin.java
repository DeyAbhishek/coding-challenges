// Return maximum number of adjacent pair of coins with same face (either head or tail)
// when only one coin is flipped.

function solution(A) {  //A -> array of coins
  var reversed = false, adjacency = 0, i = 1;

  for(i = 1; i < A.length-1; i++) {
    if(A[i] == A[i-1]) {
      adjacency++;
    }
    else if(A[i-1] == A[i+1] && !reversed) {
      reversed = true;
      adjacency += 2;
      i++;
    }
  }

  if(reversed) {
    if(A[A.length-1] == A[A.length-2]) {
      adjacency++;
    }
  } else {
    if(A[A.length-1] != A[A.length-2]) {
      adjacency++;
    } else if(A[0] != A[1]) {
      adjacency += 2;
    }
  }

  return adjacency;
}
