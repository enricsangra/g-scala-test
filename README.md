# g-scala-test

## lsc

Longest common (discontiguous) sequence. It can be executed through LscSolver.lsc method. Accepts two strings as parameters.

**Execution cost**  

n*m, being n and m the lengths of the strings or n^2 being n the longest.

**Improvements**  

It could be possible to add information about the execution in the same table (the common string up to the cell) but that would increase the space cost which I tried to keep at minimum. That would affect the abstraction and make it less generic as well.

It is probably a good idea to test the traits separately to increment the reliability but as it was an abstraction after the code was written, it is tested through the end to end in the solver.

Maybe too much abstraction for the problem itself.


## expession generator
Converts a bag of positive integers and a target number into an expression that evaluates with the target as result using each number in the bag at most once. It uses +, * and - as operators in the expressions and every intermediate result must be greater than 0.

This can be executed using the main method. It will require a list of integers separated by spaces and a target. Follow the guide in the console using *sbt run*.

It only returns one of the possible results or none if it doesn't exist.

**Execution cost**  

Worst case would be all combinations of numbers checked which tends to n^2 being n the amount of integers in the bag.

**Improvements**  

The execution could be potentially done in two steps with a AST generator and an interpreter to check if the value is right. This allows more flexibility but it needs more time to execute.

Analyse a way to stop the generation of combinations once a match to the target is found.


