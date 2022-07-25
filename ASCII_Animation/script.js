// 4 Define a function sum() and a function multiply() that sums and multiplies (respectively) all the numbers in an array of numbers

function sum(...numbers) {
  return numbers.reduce((total, next) => total + next, 0);
}

function multiply(...numbers) {
  return numbers.reduce((total, next) => total * next, 1);
}

console.log(sum(1, 2, 3, 4, 5)); // 15
console.log(multiply(1, 2, 3, 4, 5)); // 120

// 5 Define a function reverse() that computes the reversal of a string.
function reverse(param) {
  return param.split("").reverse().join("");
}

console.log(reverse("hello")); //  "olleh"

//  7 Write a function filterLongWords() that takes an array of words and an integer i and returns the array of words that are longer than i.


function filterLongWords(words, i) {
  return words.filter(word => word.length > i);
}

console.log(filterLongWords(["hello", "world", "hey", "there"], 3)); // ["hello", "world", "there"]