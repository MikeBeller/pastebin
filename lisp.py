# Value types:
#
# * Cons -- represented by a 2-tuple of values
# * Nil -- represented by python None
# * Int -- represented by a python int
#
# There are two global variables defining the environment:
#
# * Base -- the base environment, binding symbols to values, e.g. in
#           s-expr notation "('double (lambda (x) (+ x x)))"
# * Symbol -- a list of interned symbols -- they are interned by
#           only allowing a single instance of a symbol name to
#           exist in the list, therefore we can check for equality
#           of symbols by just checking for pointer equality.



