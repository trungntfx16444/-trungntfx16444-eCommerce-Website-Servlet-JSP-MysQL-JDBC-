'use strict'

//create btn login element
const btn = document.querySelector(".btn__login");

// check valid
function validateForm() {
  let x = document.forms["myForm"]["username"].value;
  let y = document.forms["myForm"]["password"].value;
  if (x == "") {
    alert(`Username must be filled out`);
    return false;
  }
  if (y == "") {
    alert(`Password must be filled out`);
    return false;
  }
}

btn.addEventListener('click', function() {
	validateForm();
});
