(ns wc.wc-test
  (:require [clojure.test :refer :all]
            [wc.core :refer :all]))

(def content (str " I am your\n" "best friend    \n" "   \n" "what     ever. dude"))

(def lines [" I am your", "best friend    ", "   ", "what     ever. dude"])

; 4 lines containing 8 words. For each line there is an artificial \n included, thus 51 characters.
(def stats {:lines 4 :words 8 :characters 51})

(deftest test-extract-words
  (testing "Returns a seq containing the words"
    (testing "of correct length"
      (let [words (extract-words lines)
            num-words (count words)]
            (is (= num-words (:words stats))))))
    (testing "containing correct words"
      (let [words (extract-words lines)]
            (is (= words ["I" "am" "your" "best" "friend" "what" "ever." "dude"])))))

(deftest test-format-stats
  (let [test-filename "Testfile"
        expected-text-without-filename "       4       8      51 "
        expected-text-with-filename (str expected-text-without-filename test-filename)]
    (testing "Returns the correct formatted stats with a filename"
      (is (= (format-stats stats test-filename) expected-text-with-filename))
    (testing "Returns the correct formatted stats without a filename"
      (is (= (format-stats stats "") expected-text-without-filename))))))
