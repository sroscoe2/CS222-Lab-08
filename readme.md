# Programming II

## Lab 08

TO: The 222 Recursion Engineers, Inc.

FROM: Artistic Algorithmics, Ltd.

Dear 222 Recursion Engineers:

We are seeking proposals for how best to approach several problems facing our company.

We heard your organization may be able to provide assistance, so we are reaching out to request your input.

1. We are creating an artistic mural comprising of fibonacci numbers. However, to do so, we need to calculate successive numbers in the sequence. We've heard only using recursion to do so is inefficient and slow. Please write a Java class that **computes the nth Fibonacci number with memoization**, to the following specifications:
    1. The class must have a field which **saves the Fibonacci numbers to a HashMap.** You may declare and instantiate the HashMap all in one line like so: `private static Map<Integer, BigInteger> fibMap = new HashMap<>();`
    2. If the parameter $n$ does not satisfy the base case, it should be checked if $n$ is part of the HashMap. You can so so by calling `BigInteger fibNumber = fibMap.get(n)`. 
        1. If `fibNumber` is *not* null, then it is already in the map and should simply be returned.
        2. If `fibNumber` *is* null, then it is not part of the map, and you must calculate it recursively, and save it to the variable called `fibNumber`. Once you do so, you must put it in the map using `fibMap.put(n,fibNumber)` Then return `fibNumber`.
    3. Please write a short `public static void main(String[] args)` method which tests your method on very large integers. 
2. In our collaboration with local primary schools, the children are interested in whether a number is prime (divisible only by 1 and itself). Furthermore, we are expressly concerned with the difference between a recursive solution and an iterative one. Please write a Java class with **two methods**, one which finds prime numbers recursively and the other which does so iteratively. Include a short `main()` method to test functionality of your program.
3. The local animal shelter has several dogs which express excitement when they hear palindromes, which are words that are the same backwards as forwards. Please write a Java class that recursively computes whether a given word is a palindrome. The shelter volunteers wish to know which of the following words or phrases are palindromes:

    1. racecar
    2. plural
    3. civic
    4. machine
    5. people
    6. tacocat
    7. aibohphobia
    8. tense
    9. plant
    10. deleveled
    11. rotator

4. Professional chess players have taken an interest in Pascal's Triangle, a symmetrical structure featuring rows of numbers. The outer edge of the triangle is entirely 1s. A new, non-1 number in each row is calculated by adding the two numbers which are diagonally above the number to compute. Please write a Java class which includes a recursive method that prints Pascal's Triangle up to a given row $n$. Exact spacing *is not required*, just the numbers. An example of Pascal's Triangle can be seen below:

```text
        1
      1   1
    1   2   1
  1   3   3   1
1   4   6   4   1
```

5. For our more uninformed board members, include a text file that explains what recursion is. Include a description of the main components of recursion, and brainstorm why a recursive solution would be used instead of an iterative one.

Our submission requirements are as follows. Please **create a new Java project** that is named `firstNameLI-CS222-Lab-08`. For each request above, please write a separate, appropriately named Java class. Zip your project folder and submit it to Canvas by **Tuesday, November 12 at 11:59pm**, so we may discuss it at our next board meeting. The reward for satisfactorily meeting all the requests is 50 points (10 points per part), plus 5 points extra credit if a formal letter format is used to summarize your addresses to our requests.

We appreciate your assistance.

Cordially,

<p align="left">
<img src="gideonSignature.png" alt="Gideon Gael's signature" width="20%">
</p>

Gideon Gael

CEO, Artistic Algorithmics, Ltd.
