## How to build and run the project

#### Pre-requisites
- java 8 to be installed
- make to be installed for building the project


#### Build the project
navigate to project root and run the make command

 ```
 $ make
 ```


run the program as follow once the build is successfull

```
$ java Driver Loans.csv output.csv
```

The program expects 2 cmd parameters the first one being the input file to be processed
and the second one being the name of the output file where the results will be written.

To clean, cleaning build artefacts
```
$ make clean
```
#### Assumptions
- The input file must have a the first line as the heading which will be skipped
for processing
- The data in the input file must be strictly organised as follow,
MSISDN,Network,Date,Product,Amount if fields are rearranged the program will crash
or produce unexpected results.
- No missing fields are tolerated in the input data, otherwise we might have unexpected results
- The amount field in the input data should only contain decimal values
- The Date in the input data should have only the following format e.g 16-Apr-2016 otherwise unxpected results
will occur.
- The network names in the data are to be consistent, Network 1 is not the same as neTwork 2


#### Implementation Details

This is a fully object oriented approach to solve the problem, in this section we will walk through
all the classes used, to give a clear idea of their purpose.

**Attribute** - This class represent the all the attributes of our data to be aggregated for example Network, Products.
It contains instance variables count and total, which keeps track of the number of occurrence and total amount of the attribute
of that particular name.

**MonthAttribute** - This is a child class of ***Attribute*** through inheritance, the reason for this class is that, the month attribute
is different in terms of how we name attributes of this type, its name is derived from Date. For a network attribute, we could create it and name it with exactly the network name
from the data e.g Network 1, but we cannot name the month 16-Apr-2016 this way but rather this way Apr-2016. So this class is specialised and has got a
constructor which names it appropriately

**AttributeHash** - This is a class which servers as a data structure to store Attributes and aggregate (process) them as efficient as possible.
This is implemented using a HashMap which has a constant look up time and the ability to have only one key. When we are iterating our inputs, we are continually creating Attributes object and insert them in appropriate  attribute map,
if an attribute of that particular name is existing we increase the attribute count and total. As a result we will have unique set of attributes with their count and total values.

**Driver** - This class does is the point of entry where all the necessary logic is bootstrapped


