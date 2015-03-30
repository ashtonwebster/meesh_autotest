from lxml import html
import requests
import os
import errno
import sys

if (len(sys.argv) != 3):
    print "usage: python meesh_autotest.py <lower_bound_id> <upper_bound_id>"
    exit()

url = "https://cmsc420.cs.umd.edud/meeshquest/part2/input/"
try: 
    os.makedirs("input")
except OSError:
    if not (os.path.isdir("input")):
	   raise

try: 
    os.makedirs("output")
except OSError:
    if not (os.path.isdir("output")):
	   raise


for x in range(int(sys.argv[1]), int(sys.argv[2])):
    print "getting id " + str(x)
    page = requests.get('https://cmsc420.cs.umd.edu/meeshquest/part2/input/' + str(x), verify=False)
    tree = html.fromstring(page.text)
    filename = (tree.xpath('/html/body/div[2]/div/h4[1]/text()')[0].split("Uploaded As: ")[1])
    input_filename = "input/" + filename
    #print filename
    input = tree.xpath('//div[@class="container theme-showcase"]/div[@class="jumbotron"]/pre/text()')[0]
    #print input[0]
    f = open(input_filename, 'w')
    f.write(input)
    f.close()

    output_filename = "output/" + filename
    output = tree.xpath('/html/body/div[2]/div/textarea/text()')[0]
    #print output
    f = open(output_filename, 'w')
    f.write(output)
    f.close()


