# NameValueQuery

This is a very simplistic API for querying simple name / value data, and currently supplies one implementation using RPN.

## RPNQuery

Queries some data using an [RPN](https://en.wikipedia.org/wiki/Reverse_Polish_notation) based query string.

If you have even used a HP calculator like "HP 15c" for example then you understand RPN. This uses the same RPN principles, but is not a calculator :-).

The order of things are: `value value operation`, or `value value operation value value operation operation` in which the last operation is operating on the results of first two, and will take the stack down to one entry, which is where you want to end up. This avoids the need for parentesis grouping. You can also add to the query by adding to the end. If you are not familiar with RPN then it definately looks a bit weird :-). 

There are values and there are operations. Values can be named data reference or a constant. When a value is seen it is added to a query stack. When an operation is seen it is applied to the last 2 entries on the stack. Both entries are then replaced by the result of the operation, thus moving backwards in a shrinking stack. Operations will resolve to a boolean value.

Further down in this document there is an example of data, and a query against it that shows the state of the stack for each data and operation.

### Functionallity

User provides a stack of data and operations. Operations always work on top 2 stack entries, which are removed by an operation and operation result is added.

#### Operations ( /... )

- **/=** _equals _

-  **/!=** _not equals_

- **/()** _contains_

- **/!()** _ does not contain_ 

- **/<** _less than_ 

- **/<=** _less than or equals_
 
- **/>** _greater  than_ 

- **/>=** _greater than or equals_
 
- **/T** _True  (Only true & true)_

- **/F** _False  (Anything but true & true)_

##### Values

- **T** _True_

- **F** _False_

- **'...'** _String constant_

- **name** _Field value reference_

- **1, 100, 5.8, 78.3f, 9843275677723.4567658d, ...** _Any number_ 

<!-- @PageBreak -->

#### Example

##### Sample Data

I use JSON as example format, but data can be a simple java.util.Map, java.util.Properties, or whatever.

    {
        "name": "MyServiceId2,
        "type": "service",
        "qwe": 92,
        "rty": 236
    }

##### Sample Query

    "name 'MyServiceId' /= qwe 100 /< /= rty 100 /> /T"
    
    
Slightly longer version:
    
    "name 'MyServiceId' /= qwe 100 /< /= rty 100 /> /= type 'service' /= /T"
    
This query checks that name is 'MyServiceId' and that qwe is less than 100 and that rty is greater than 100.

##### Evaluation

Operations work on last 2 stack entries which are replaced by result.

    Value & op             Stack
    ---------------        ---------------------------
    
    name                   'MyServiceId'
    'MyServiceId'          'MyServiceId' 'MyServiceId'
    /=                     T
    qwe                    T 92
    100                    T 92 100
    /<                     T T
    /=                     T
    rty                    T 236
    100                    T 236 100
    />                     T T
    /T                     T

Longer Version additions

    type                   T 'service'
    'service'              T 'service' 'service'
    /=                     T T
    /T                     T

## Code Style

I have worked with Java since version 1.0, and C before that. The style of braces have always been to start '{' at the end of the line and end with '}' at the beginning of next line.

    public class Palsternacka {
        public Palsternacka() {
            Some code
        }
    
        ...
    }

I then quite a while back started to put an empty line after '{' just to make space and make things easier to read. 

    public class Palsternacka {
    
        public Palsternacka() {
        
            Some code
        }
    
        ...
    }

I have now come in contact with C# and I reacted att first that C# code tended to put the '{' by itself on the next line. I first thought that looked weird and was annoyed, but the more I looked at C# code the more I realized that this style forces some space and make things more readable. It is also easier to see that braces are matched since they align very clearly. Even though this still feels strange and unfamiliar (the brain likes familiarity) it improves code readability, so I have decided to ignore my brains complaints and go with this style.

    public class Palsternacka
    {
        public PalsterNacka()
        {
             Somne code
        }
    
        ...
    }
    