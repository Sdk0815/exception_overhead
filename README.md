# Exception Overhead

### Objective

The purpose of this program is to reveal the overhead of exceptions
compare to regular "return" statement, and I'm glad if it helps
to reduce such a code to use an exception as an easy way to
exit from the functions/loops.

### Measurement Result

Below is the result of the program on my desktop machine
(Mac mini 2014, Intel Core i5 2.6GHz, Oracle JRE 1.8.0_77) :

```
--- regular return ---
Result: 100000
27 msec elapsed
--- exit by exception ---
Result: 100000
1604 msec elapsed
```

Now you'll be scared to use an exception to exit the code in regular code path. :)