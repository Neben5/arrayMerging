## Introduction:
This program merges the given sorted arrays into one larger sorted array, removing duplicates.
## Fulfillments:
This program completes the task in O(N*log(K)) time, and removes duplicates.
## Errors:
None so far as my testing has shown. IO exceptions may occur in nonstandard environments.
## Overview: 
Main just reads the input file and passes it to Sorter. Sorter then merges an array into the first, iterating until every array has been merged using a modified mergesort merge. This is returned to Main, where it written to output.txt
## Challenges:
Was working hard on a deadline for shooter/hood/turret code for my FRC team, had code done but forgot deadline for assigment because of it. Also had to scrap an early version of my code simply because it was too messy to use.
## Acknowledgments:
My dad helped hunt down a nullpointerexception that I was too tired to find at one point. Also GeeksForGeeks helped me a ton in organizing my code with this graphic:

![GeeksForGeeks](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20190620135819/Merge-two-sorted-arrays1.png)