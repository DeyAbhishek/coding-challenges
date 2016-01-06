/*
Design and implement a calculater that can calculate expressions like:
+ 2 4 
* 8 ( + 7 12)
( + 7 ( * 8 12 ) ( * 2 (+ 9 4) 7 ) 3 )

(PS:all items are space delimetered.)

Example answers
+ 2 4 => 2 + 4 = 6
* 8 ( + 7 12) => 8 * ( 7 + 12 ) = 152
*/

//Alorithm:
/*
Scan the given prefix expression from right to left
for each symbol
 {
  if operand then
    push onto stack
  if operator then
   {
    operand1=pop stack
    operand2=pop stack
    compute operand1 operator operand2
    push result onto stack
   }
 }
return top of stack as result
*/
/*
Applying the above algorithm:
− × ÷ 15 − 7 + 1 1 3 + 2 + 1 1 =
− × ÷ 15 − 7 + 1 1 3 + 2 2     =
− × ÷ 15 − 7 + 1 1 3 4         =
− × ÷ 15 − 7 2     3 4         =
− × ÷ 15 5         3 4         =
− × 3              3 4         =
− 9                  4         =
5
*/
/*
Source: Polish Notation (PN)
*/
