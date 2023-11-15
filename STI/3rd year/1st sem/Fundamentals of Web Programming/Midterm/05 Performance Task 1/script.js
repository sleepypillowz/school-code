// Loops and Iteration

// #1
// a.
userAge = prompt("Please enter your age:");
        
if (userAge >= 25) {
    alert("You are indeed 25 years old or even older!");
} else if (userAge < 25) {
    alert("You are younger than 25.");
}

// b.
userAge = prompt("Please enter your age:");

if (userAge < 100) {
    alert("you've inputted a valid age");
}

else if (userAge >= 100) {
    alert("that's an impressive age!");
}

// #2
// a.
for (let i = 0; i <= 30; i++) {
    console.log(i);
}

// b.
for (let i = 2; i <= 40; i+=2) {
    console.log(i);
}

// c.
for (let i = 40; i >= 10; i--) {
    if (i % 3 == 0) {
        console.log(i);
    }
}
