package com.github.leedm777.chop

import org.scalatest.Spec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ChopTest extends Spec with ShouldMatchers {
    describe("Chopper") {
        describe("(full recursive)") {
            it("should work") {shouldWork(Choppers.fullRecursive); }
        }
        describe("(binary recursive)") {
            it("should work") {shouldWork(Choppers.binaryRecursive); }
        }
        describe("(binary iterative)") {
            it("should work") {shouldWork(Choppers.binaryIterative); }
        }
    }

    def shouldWork(chop: (Int, Array[Int]) => Int) {
        chop(3, Array()) should be(-1);
        chop(3, Array(1)) should be(-1);
        chop(1, Array(1)) should be(0);

        chop(1, Array(1, 3, 5)) should be(0);
        chop(3, Array(1, 3, 5)) should be(1);
        chop(5, Array(1, 3, 5)) should be(2);
        chop(0, Array(1, 3, 5)) should be(-1);
        chop(2, Array(1, 3, 5)) should be(-1);
        chop(4, Array(1, 3, 5)) should be(-1);
        chop(6, Array(1, 3, 5)) should be(-1);

        chop(1, Array(1, 3, 5, 7)) should be(0);
        chop(3, Array(1, 3, 5, 7)) should be(1);
        chop(5, Array(1, 3, 5, 7)) should be(2);
        chop(7, Array(1, 3, 5, 7)) should be(3);
        chop(0, Array(1, 3, 5, 7)) should be(-1);
        chop(2, Array(1, 3, 5, 7)) should be(-1);
        chop(4, Array(1, 3, 5, 7)) should be(-1);
        chop(6, Array(1, 3, 5, 7)) should be(-1);
        chop(8, Array(1, 3, 5, 7)) should be(-1);
    }
}