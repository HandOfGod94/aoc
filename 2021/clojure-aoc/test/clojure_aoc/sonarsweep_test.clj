(ns clojure-aoc.sonarsweep-test
  (:require [clojure.test :refer :all]
            [clojure-aoc.sonarsweep :refer :all]
            [clojure.java.io :as io]))

(deftest calc-increment-test
  (testing "with sample input"
    (is (= 2 (calc-increment "1" "2" "3")))
    (is (= 7 (calc-increment "199" "200" "208" "210" "200" "207" "240" "269" "260" "263"))))
  (testing "with empty input"
    (is (= 0 (calc-increment))))
  (testing "with strictly decreasing"
    (is (= 0 (calc-increment "3" "2" "1"))))
  (testing "with monotonically increase"
    (is (= 2 (calc-increment "3" "4" "4" "2" "2" "5"))))
  (testing "with all the values same"
    (is (= 0 (calc-increment "2" "2" "2" "2"))))
  (testing "read from testdata file and assert"
    (with-open [rdr (io/reader "test/clojure_aoc/sonarsweep-testdata.txt")]
      (is (= 1462 (calc-increment (line-seq rdr)))))))

(deftest calc-increment-window-test
  (testing "with sample input"
    (is (= 0 (calc-increment-window "1" "2" "3")))
    (is (= 5 (calc-increment-window "199" "200" "208" "210" "200" "207" "240" "269" "260" "263"))))
  (testing "when input is not multiple of window size"
    (is (= 2 (calc-increment-window "1" "2" "3" "4" "5"))))
  (testing "with empty input"
    (is (= 0 (calc-increment-window))))
  (testing "with input smaller than window size"
    (is (= 0 (calc-increment-window "1" "2"))))
  (testing "when window sum is same"
    (is (= 0 (calc-increment-window "1" "2" "3" "1"))))
  (testing "when window sum is decreasing"
    (is (= 0 (calc-increment-window "4" "3" "2" "1"))))
  (testing "read from testdata file and assert"
    (with-open [rdr (io/reader "test/clojure_aoc/sonarsweep-testdata.txt")]
      (is (= 1497 (calc-increment-window (line-seq rdr)))))))
