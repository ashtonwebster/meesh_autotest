# meesh_autotest

The canonical output for the 420 project shows the most recent 10 submissions.  But sometimes you want to get all of them,
and you don't want to have to copy-paste a hundred times to get them.  This program will (hopefully?) pull down the
input and output for an arbitrary range of canonical tests and download them to two new directories (input/ and output/).

##Warning
This code is not perfect and was written in about 20 minutes.  It is liable to destroy your computer, your family, and (worst of
all) your directory structure, so use with care.

##Instructions
0. **Clone the repository.**

  `git clone https://github.com/ashtonwebster/meesh_autotest.git`

0. **Install python dependencies.**
  ```
  sudo pip install requests
  sudo pip install lxml
  ```
0. **Figure out what id's you want.**

  Let's say that you want to get the most recent 10 ids.  Go to the canonical and click on the most recent submission:

    https://cmsc420.cs.umd.edu/meeshquest/part2/input/204/

  In this example, the id is 204.  So if you wanted the most recent 10, you would get between 195 and 204.

0. **Run the program with the bounds as parameters.**

  `python meesh_autotest.py 196 204`

  Two new folders will be populated and you will be spammed with a lot of output saying that the ssl certificate is invalid. 
But hopefully you will see two folders named input and output filled with the corresponding output for the ids specified.

##The Java Test Driver
I wrote some java code to use the results you get from this in the java_tests_driver folder. Here is what it contains.

Note: I haven't really tested these instructions.  You may have to play around with them.  Please post problems in the "Issues" tab on github for this project.

0.  **AvlG tests.**
You are probably going to have to play around with the imports to get these to work for your code.  These include a fuzzer (generates random inputs and function calls) among some other small tests.  

0. **Running arbitrary Input**
In order to run an arbitray input, my methods was as follows:

Set up directory structure like so:

```
meesh_part2
    src/
    diff/
    inputs/
    others_inputs/
    actual_output/
    expected_output/
```

  * Copy the output from the canonical download script to "expected_output"
  * Copy your tests to "input"" 
  * Copy other people's tests (from the canonical download?) to "others_inputs"
  * The results of running the inputs on your code will be placed in "actual_output"
  * Once everything is set up in the directory, 
    * To Test one specific input, use RunInputTest.java
    * To Test against everyone's inputs, use RunOthersInput.java.  (WARNING: this may create hundreds of images in your root project directory.  Use with care.) 
    * Run DiffAll.java to populate the "diff" folder with one file for each input test, showing the differences.

##Unsolicited Advice
  * Vimdiff is my best friend for comparing output
  * A second not spent on the current 420 project is a second wasted

  