
# coding: utf-8

# # Abstact Data Type

# In general, we can talk about data as e set of values distribuited within certain rules, or better said *"The rapresentation of the values"* are set to be accessed in a certain way so that we can abstract data to be used on purpose: here it comes the ecapsulation concept that helps us to create a complex systems working both indipendently and together, where methods can be treat appart and the system is managed by a model, so that called "An Abstract Model"
# So as many programmers already know here some Abstract Data Type (ADT) been used mainly where data are manipulated:
# - List
# - Stack
# - Queue
# - Tree

# ## List
# It is a particular array where elements are always sorted due to the following two methods:
# - get(index) : get an i-element and shift the arrary
# - push(element) : make an insertion in the ordered position and shift the array
# 
# Here an impletation in python :

# In[2]:

class List:
    def __init__(self):
        self.len = 0
        self.array = []
    def get(self, index):
        c = self.array[index]
        self.array = self.array[:index] + self.array[index+1:]
        self.len -= 1
        return c
        
    def push(self, element):
        if self.len == 0:
            self.array.append(element)
            self.len += 1
        else:
            j = 0
            while j < self.len:
                if element < self.array[j]:
                    break
                else:
                    j += 1
            self.array.append(0)
            for k in range(self.len, j, -1):
                self.array[k] = self.array[k-1]
            self.array[j] = element
            self.len += 1

V = List()
V.push(2); V.push(4); V.push(6); V.push(1); V.push(5)
index = 2
print("V before: " + str(V.array) )
print("Get element " + str(index)+ ": " + str(V.get(index)) )
print("V after: " + str(V.array) )


# As you can see we have abstracted a List in away that from the user of this ADT should use only *get* and *psuh* methods in order to manipulate data inside the list. This is what abstraction can help for us because the user can manipulate data on purpose, wich purpose ? I show how ADT help us on purpose, but first let's tak e a look to other basci ADT.

# ## Stack
# This is largely used in many systems most of them to holding data to be manipulated as an afterthought. For example in run-time the state of the main running function, goes to be added to the stack when another sub-rutine is called, what happens is that when the sub-rutine return or end running, the main execution of the program goes back to the mian function loading back the state saved at run-time. It is also used to evaluate a math expression nested one by one between parenthesis: the main expression goes to evaluate when another sub-expression has to be evaluated, so basiclly it store the main expresion into the stack, than evaluate the sub-expression or store another sub-expression into the stack until there are no more sub-expression so that it pop out from the stack the last added, evaluate that, pop out from the stack an upper expression replacing the previous result where the sub-expression was placed, and so on to the main expression.
# 
# Here an example of implementation of the stack in python:

# In[3]:

class Stack():
    def __init__(self):
        self.storage = []
        self.len = 0
    def empty(self):
        return self.len == 0
    def push(self, element):
        self.len += 1
        self.storage.append(element)
    def pop(self):
        self.len -= 1
        return self.storage.pop()
    def flush(self):
        self.__init__()


# In[4]:

S = Stack()
for j in range(1,5):
    S.push(j)
    print( "push(" + str(j) + ") => "  + str(j) )
while not S.empty():
    print("pop() => " + str(S.pop()) )


# As you can see the class give to us two main methods: pop and push to manipulate the data inside the stack. Pushing or popping elements follows a First-In-First-Out (FIFO) policy.
# 
# Lets write a simple math-evaluator where the stack is going be usefull to evaluate a math expression:
# 
# First we define a recursive function to parse this simple math-expression with a deep level of 4: $(2+(3*(4-(3*2)+7)-1)/2)-9$

# In[5]:

def parse(math, stack, rep_char):
    # stop recursing
    if len(math) == 0:
        return ""

    # normalization math ~ (...)
    if math[0] == '(' and math[-1] == ')':
        math = math[1:-1]
    state = 'S'
    b = ""
    n_exp = 0
    j = 0
    give = ""
    replacement = False
    while True:
        s = math[j]
        if state == 'S':
            if s == '(':
                state = 'B'
                n_exp += 1
            else:
                state = 'A'

        elif state == 'A':
            if s == '(':
                state = 'B'
                n_exp += 1
            elif s == ')' :
                state = 'A'
                n_exp -= 1
                if n_exp == 0:
                    replacement = True
                    b += ')'
                    stack.push(math.replace(b, rep_char))
                    give = b
                    b = ""
            else:
                state = 'A'

        elif state == 'B':
            if s == '(':
                state = 'B'
                n_exp += 1
            elif s == ')':
                state = 'A'
                n_exp -= 1
                if n_exp == 0:
                    replacement = True
                    b += ')'
                    stack.push(math.replace(b, rep_char))
                    give = b
                    b = ""
            else:
                state = 'B'

        elif state == 'E':
            break
        j += 1
        if n_exp > 0:
            b += s
        if j == len(math):
            break
    if replacement == False:
        S.push(math)
    return parse(give, S, rep_char)


# Basically this function stacks sub-expression one by one meanwhile it reach the deepest sub-expression in the string. It scans char by char the string throwing between 3 states:
# - **S** : START
# - **A** : first and last deep recurring with relative operations
# - **B** : more than one deep recurring operations
# 
# It works as *Turing Machine* as operations of staccking and *char-substitution* throwing among *states*.
# 
# How to use it ? First we flush the stack in order to use it as new, than we write the math expression and than we parse the expression:
# 
# *Note: The Replacement Character rep_char will be used later to get back sub-expression for their evaluation*

# In[6]:

S.flush()
rep_char = 'R'
math_expression = "(2+(3*(4-(3*2)+7)-1)/2)-9"
parse(math_expression, S, rep_char)
print("Stack after parsing: " + str(S.storage) )


# As you can see, the deepest level reachs the expression $(3*2)$ wich will be the first sub-math-expression to be evaluated, than to be replaced to the *Replacement Character* on the next value held in the stack.
# And now the magic of getting back the expressions, use the replace-character and evaluate the whole expression with a nice while loop

# In[7]:

print("Char Replacement on stack: " + '\''+rep_char+'\'')
ris = ""
while True:
    op = S.pop()
    if rep_char not in op:
        ris = str(eval(op))
    else:
        op = op.replace(rep_char, ris)
        ris = str(eval(op))
    print("Stack Operation on : " + op)
    if S.empty():
        break

print("--- Result-->> "+'[['+ris+']]')


# Ok, but all this stuf could be done simply doing :

# In[8]:

print( "Fast Result: " + str(eval(math_expression)) )


# As you can see it produce the same result as the *eval()* funtion basically does the same thing, but this article is just to show how a stack and recursive function can be used, further more the algorithms does not work for consecutive expression to be stacced. 
# If we want ot be more speific we should be able to build a complete parser where we need to properly get numbers and operator to be evaluate, so basically the same algorithm without using *eval()* and *.replace()* functions.
# 
# Back to the use of the stack, think for example when you navigate on your preferred browser: when you trigger the browser-event to open a link to another page, a new record of the current page is allocated in the *stack pages*, so that when you press the *BACK* button of your browser, the stack pop out the previous page and so on ...

# ## Tree, set, dictionary
# Trees are widly used for example when:
# - The operating system needs to store files in a folder
# - An html page needs to render or select specific html element inside the document
# - Any OO compiler needs to parse nested class of a program
# - A process returns and have to give back control to a the previous process
# - the function *find* in linux terminal needs to check recursively for a file within folders
# - ...
# 
# The main features of trees are :
# - the **Root**
# - the **Height**
# - each element but the root has a parent element
# - each element can have one or more  child element
# 
# A particular tree is the binary tree where each node have only two children : *left-child* and *right-child*.
# 
# Another very similar ADT, is the
# **Graph**, but it differs because every element can get linked to any other element indipendent from parent and child relashions.
# 
# For example all the data stored by *Facebook* is representated by a Graph where each element is identified by an id and it contains varius *key-value* elements and each node of the graph can get relation with any other element: for example when two account become friends, the *friend-list* of each one   gets the id account of the other and viceversa so that they have enstablished a relation by key-values of rach other.
# 
# Binary trees are used for searching algorithms, for example in *"binary search"* each tree element can have one or two child, so that a vector or array get acquired in a shape of a tree where each node is an element of the array following the policy that all right child is grather than the left child so that the minimum is on the very left end of the tree and the max is on the very right end of the tree.
# 
# ADT can be simply a *set* which is an array where you can put and get elements without any relation appart of they are elements of the same type, than you can check as a set that an element *"belongs"* to the set; elements are unique within a set, they do not admit duplicates.
# 
# A very usefull ADT is a dictionary: it is  a set of *key-value* data where each element has fast access by a unique key. Usually dictionaries are implemented at low level to be really fast getting access on element by an id as a result of a simple math operation that avoid scanning big array of data. They differ from sets because they can contain element of any type.

# In[ ]:



