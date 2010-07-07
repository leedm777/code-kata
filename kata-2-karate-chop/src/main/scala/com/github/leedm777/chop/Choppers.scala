package com.github.leedm777.chop

object Choppers {
    def fullRecursive(needle: Int, haystack: Array[Int]): Int = {
        def f(n: Int): Int =
            if (n >= haystack.size) -1
            else if (haystack(n) == needle) n
            else f(n + 1);
        f(0);
    }

    def binaryRecursive(needle: Int, haystack: Array[Int]): Int = {
        def f(begin: Int, end: Int): Int = {
            if (begin == (end - 1)) {
                if (needle == haystack(begin)) begin else -1
            } else {
                val mid = (begin + end) / 2
                val midVal = haystack(mid)
                if (needle < midVal) f(begin, mid) else f(mid, end)
            }
        }
        if (haystack.isEmpty) -1 else f(0, haystack.size)
    }
}