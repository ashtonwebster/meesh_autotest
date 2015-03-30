# meesh_autotest

The canonical output for the 420 project shows the most recent 10 submissions.  But sometimes you want to get all of them,
and you don't want to have to copy-paste a hundred times to get them.  This program will (hopefully?) pull down the
input and output for an arbitrary range of canonical tests and download them to two new directories (input/ and output/).

##Warning
This code is not perfect and was written in about 20 minutes.  It is liable to destroy your computer, your family, and (worst of
all) your directory structure, so use with care.

##Instructions 
0) clone

git clone https://github.com/ashtonwebster/meesh_autotest.git

1) Install python dependencies

sudo pip install requests
sudo pip install lxml

2) Figure out what id's you want.  
Let's say that you want to get the most recent 10 ids.  Go to the canonical and click on the most recent submission:

https://cmsc420.cs.umd.edu/meeshquest/part2/input/204/

In this example, the id is 204.  So if you wanted the most recent 10, you would get between 195 and 204.

3) Run the program with the bounds as parameters

python meesh_autotest.py 196 204

4) Two new folders will be populated and you will be spammed with a lot of output saying that the ssl certificate is invalid. 
But hopefully you will see two folders named input and output filled with the corresponding output for the ids specified.

