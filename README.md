# Bowling Score Counter

This program counts the score of completed bowling matches. It recieves it's input through a text file. I wrote it in Java.

## Getting Started

You cant test the program in Cloud9, but, if you want to download the folder to test the program locally, read the next steps. If not, jump to the section "Running the Tests".

### Prerequisites

It's necessary to have Java installed. Here's a [link](https://www.java.com/en/download/help/download_options.xml "https://www.java.com/en/download/help/download_options.xml") with detailed information on the process.

### Installing

First, right click the folder and select "Download" to download the file `bowling.zip`. Next, extract it.

Open up the terminal and locate yourself in the extracted folder. Now, write the following command:

```
javac *.java
```

The program will be compiled and ready to be used.

## Running the Integrated Tests

Inside the folder is a text file named `test.txt` which contains some examples of scores from completed matches. Feel free to view it's content.

To run the program with these tests, write the following command in the terminal:

```
java Main test.txt
```

It should output this:

```
1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(10, 0) (9, 1)  (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (9, 1)  (10, 0) (10, 0) (10, 10)        259

1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 10)        300

1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(10, 0) (7, 3)  (9, 0)  (10, 0) (0, 8)  (8, 2)  (0, 6)  (10, 0) (10, 0) (10, 0) (8, 1)          167

1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (0, 0)          270

1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(0, 0)  (0, 0)  (0, 0)  (0, 0)  (0, 0)  (0, 0)  (0, 0)  (0, 0)  (0, 0)  (0, 0)  (0, 0)          0

1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(4, 5)  (1, 4)  (9, 1)  (10, 0) (10, 0) (4, 5)  (7, 1)  (9, 1)  (0, 8)  (9, 1)  (10, 0)         132
```

### Tests for the Input Format

If you open the file `test.txt`, you can see the first three input lines are formatted like the example given in the email. The remaining three are used to test how the program handles different formats.

Inside the file `Main.java`, the following lines control this:

```
Scanner sc = new Scanner(in);
sc.useDelimiter("[\\[\\],\\s]+");
```

The function `useDelimiter` recieves as input a regular expression saying that any non-null combination of brackets `[` `]`, commas `,` or any kind of whitespace will serve to split the scanner's input string.

With that being said, the program can't handle any other type of character, it'll produce an error. Apart from that, as long as there are at least 20 numbers (two rolls for each of the ten frames), it'll work perfectly.

Note that it works with at least 20 numbers and not 22, that means the bonus frame is not a necessary input. If there's no bonus frame as input, then the program counts them as two rolls of zero. This is tested in the fifth test, where there are 20 rolls of 0.

Here are the lines which handle this:

```
bonus = new Frame(sc.hasNextInt() ? sc.nextInt() : 0,
                    sc.hasNextInt() ? sc.nextInt() : 0);
```

### Tests for the Point Counter

Let's take a look at the output generated after running the tests.

1. The first test is the example given in the email.

```
1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(10, 0) (9, 1)  (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (9, 1)  (10, 0) (10, 0) (10, 10)        259
```

2. The second test corresponds to a "perfect match". That is, doing only strikes.

```
1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 10)        300
```

3. The third test is the example given in the [link](http://slocums.homestead.com/gamescore.html "http://slocums.homestead.com/gamescore.html") given in the email.

```
1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(10, 0) (7, 3)  (9, 0)  (10, 0) (0, 8)  (8, 2)  (0, 6)  (10, 0) (10, 0) (10, 0) (8, 1)          167
```

4. The fourth test is similar to the second one, only that there are no points obtained in the bonus frame. This test is to see if the program handles correctly counting the extra points for strikes when the bonus frame is involved.

```
1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (10, 0) (0, 0)          270
```

5. This test is more about testing the input format, as explained before.

6. This test are just random rolls chosen by me. I checked to see if the given score was correct using this [online counter](http://www.bowlinggenius.com/ "http://www.bowlinggenius.com/").

```
1       2       3       4       5       6       7       8       9       10      Bonus           Total Points
(4, 5)  (1, 4)  (9, 1)  (10, 0) (10, 0) (4, 5)  (7, 1)  (9, 1)  (0, 8)  (9, 1)  (10, 0)         132
```

## New Tests

If you want to run your own tests, then you have two options:

* Modify the file `test.txt` and add a new line for each completed match. Then, just run the command stated before.

* Create another `.txt` file and add a new line for each completed match. Then, the command to execute would be:

```
java Main <new file>.txt
```

Keep in mind that, like I said before, the program will only read the numbers correctly if they are separated by brackets, commas or white spaces.

## About the Code

### Efficiency

The steps in the program go as follows:

1. Open the input text file and read it line by line, each line being the scores obtained in a completed match.
2. Iterate through this line to populate an array of Frame objects.
3. Loop through this array to count the total points, checking for each frame if it's a strike or a split.
4. Display the results.

I think this way it's easier to read and find possible errors.

#### File Reading

I have understood that the implemented way of reading the text file is one of the most efficient.

```
try (BufferedReader br = new BufferedReader(new FileReader(new File(args[0])))) {
    String line;
    while ((line = br.readLine()) != null) {
        ...
    }
} catch (Exception e) {
    System.err.println(e.getMessage());
}
```

#### Iterating and Populating

Similarly, I have understood that using the class `Scanner` is one of the most efficient ways to read numbers.

The safest way to do this is calling the method `hasNextInt()` before calling the method `nextInt()`. However, under the assumption that there are 10 pairs of numbers being inputted, I can save time and directly read the next numbers without checking if there are any. With the bonus frame, I thought a possible input could be a match where there was no strike or split in the tenth frame, so maybe there wouldn't be any bonus frame input.

#### Counting Points

This part is possibly the bulk of the program. It consists of looping through the array of frames, adding it's points to the total sum and checking if it's a strike or a split.

* If it's a strike, the program looks for the next frame and adds to the total counter the sum of it's rolls. It this next frame was **not** the bonus frame, then it checks if it's a strike as well. If it is, then it adds to the total counter the points obtained in the first roll. This is because, in reality, there's only one roll in a strike.

* If it's a split, the program looks for the next frame and adds to the total counter the points from it's first roll.

This method could be made more efficient using some algorithm like Divide & Conquer, but, considering the efforts involved for it, I believe this is the best choice. Also, as said before, I think it's easier to read.

#### Displaying Results

It consists of loops and `System.out` methods. It's not pretty, but, then again, coding a formatted output never really is.

It might be more efficient if it used a `StringBuilder`.

### Error Handling

Little to none. The program works properly under the assumptions that the input text file has atleast 20 numbers and no other characters apart from brackets and commas. The only error it shows if there is no file passed as an argument or if it doesn't exist.

### Scalability

This program could handle matches with different numbers of frames under some changes.

* Use a dynamic data structure for the frames, instead of an array. For example, an ArrayList.
* In the input file, it's possible it would be necessary to pass, for each match, the number of frames. Just so as to know if the last frame corresponds to the bonus or if there is no bonus frame as input.


### More Ideas

Of course, there's work for improvement. A big improvement would be to add the total sum of points as you're reading through the input. However, although I initially thought of solving the test this way, I think it would take much more time and wouldn't result so readable to others.

## Thank You

Hope to hear from you soon ^^