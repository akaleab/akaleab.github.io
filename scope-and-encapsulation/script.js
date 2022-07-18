(function () {
  // Exercise 1: 
  //   Define a filter function on the String object.The function accepts an array of strings that
  // specifies a list of banned words.The function returns the string after removing all the
  // banned words.
  //     Example:
  //   console.log("This house is not nice!".filter('not'));
  //   Output: "This house is nice!"

  String.prototype.filter = function (...bannedWords) {
    return this.split(' ').filter(word => !bannedWords.includes(word)).join(' ');
  }
  console.log("This house is not nice!".filter('not'));

  // Exercise 2:
  // Write a BubbleSort algorithm on the Array object.Bubble sort is a simple sorting algorithm
  // that works by repeatedly stepping through the list to be sorted,
  //     Example: [6, 4, 0, 3, -2, 1].bubbleSort();
  //   Output: [-2, 0, 1, 3, 4, 6]

  Array.prototype.bubbleSort = function () {
    const sortedArray = this;
    let swap;
    do {
      swap = false;
      for (let i = 1; i < sortedArray.length; ++i) {
        if (sortedArray[i - 1] > sortedArray[i]) {
          [sortedArray[i], sortedArray[i - 1]] = [sortedArray[i - 1], sortedArray[i]];
          swap = true;
        }
      }
    } while (swap)
    return sortedArray;
  };

  console.log([6, 4, 0, 3, -2, 1].bubbleSort());

  // Exercise 3:
  // Create an object called Teacher derived from a Person function constructor, and implement
  // a method called teach that receives a string called subject, and prints out: [teacher's name]
  // is now teaching[subject].Create a Teacher object and call its teach method.
  // Also do the same thing using Object.create.When using Object.create you will need a
  // factory function instead of a function constructor in order to pass parameters such as
  // ‘name’ to be set in the prototype.
  class Person {
    constructor(name) {
      this.name = name;
    }
  };

  class Teacher extends Person {
    constructor(name) {
      super(name);
    }
    teach(subject) {
      console.log(`${this.name} is now teaching ${subject}`);
    }
  }

  let teacher = new Teacher("Jane");
  teacher.teach("Maths");


  // Exercice 4

  class Person {

    constructor(name, age) {
      this.name = name;
      this.age = age;
    }

    greeting() {
      console.log(`Greetings, my name is ${this.name} and I am ${this.age} years old`);
    }

    salute() {
      console.log(`Good morning!, and in case I dont see you, good afternoon, good evening and good night`);
    }

  };

  class Student extends Person {

    constructor(name, age, major) {
      super(name, age);
      this.major = major;
    }

    greeting() {
      console.log(`Hey, my name is ${this.name} and I am studying ${this.major}`);
    }


  };

  class Professor extends Person {

    constructor(name, age, department) {
      super(name, age);
      this.department = department;
    }

    salute() {
      console.log(`Good day, my name is ${this.name} and I am in the ${this.department} department`);
    }

  };

  let student = new Student('Jane', 19, 'Math');
  let prof = new Student('Mark', 45, 'Physics');

  student.greeting();
  student.salute();

  prof.greeting();
  prof.salute();

})();