const dateControl = document.querySelector('input[type="date"]');
document.querySelector('input[type="date"]').valueAsNumber = Date.now();
dateControl.value = Date.now();
console.log(dateControl.value); // prints "2017-06-01"
console.log(dateControl.valueAsNumber); // prints 1496275200000, a JavaScript timestamp (ms)


var today = new Date().toISOString().split('T')[0];
document.getElementsByName('date')[0].setAttribute('min', today);





