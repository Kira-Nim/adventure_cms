


function fetchEvents(id){

    //fetch er en del af det som svarer til JS std library. Med fetch sendes en http get request til givne sti.
    // Responset vil blive gemt i et Promise obj. Responset vil indeholde en header og indeholde en body med en json String.
    // .then() er en metode som kan kaldes på et promise. Den tager en metode som parameter og gør noget med denne metode på responset, når det er klar.
    // I dette tilfælde kaldes .json() på responset.
    // .json() er en metode som kan kaldes på en Json String for at lave denne String om til et Json obj.
    // i indmadsmetoden returnere et json obj, som videre returneres fra .then i form af et promise som der i dette tilfælde kaldes endnu en metode på.
    // Endelig køres den sidste .then() metode på resultatet af den første .then().
    // Denne tager en metode som parameter. Denne metode tager returnværdien fra den første .then som parameter og kalder denne parameter for events.
    fetch("getActivityEvents/" + id)
        .then(response => {
            return response.json();
        })
        .then(events => {

            // Get element with id = "activity_" + id.
            var select = document.getElementById("activity_" + id);

            // If The eventlist have not already been fetched.
            if(select.length <= 1) {

                for (eventVal of events) {

                    // Create element of type <option> (what kind of tag) and set text and value attribute on option the tag.
                    var option = document.createElement("option");
                    option.text = eventVal.dateTimeString; // det som er imellem tags'ne
                    option.value = eventVal.id; // værdien som denne option repræsenterer (et Event obj)

                    //Insert the option we made above in this element.

                    select.appendChild(option); //appendChild er en metode som laver en option inde i select tagget.
                }
            }
        });

}





/*

const form  = document.getElementsByTagName('form')[0];
const title = document.getElementById('title');
const titleError = document.querySelector('#title + span.error');

title.addEventListener('input', function(event){

    // Each time the user types something, we check if the
    // form fields are valid.

    if (title.validity.valid) {
        // In case there is an error message visible, if the field
        // is valid, we remove the error message.

        titleError.textContent = ''; // Reset the content of the message
        titleError.className = 'error'; // Reset the visual state of the message
    } else {
        // If there is still an error, show the correct error
        showError();
    }
});

form.addEventListener('submit', function (event) {
    // if the email field is valid, we let the form submit

    if(!email.validity.valid) {
        // If it isn't, we display an appropriate error message
        showError();
        // Then we prevent the form from being sent by canceling the event
        event.preventDefault();
    }
});

function showError() {
    if(title.validity.valueMissing) {
        // If the field is empty
        // display the following error message.
        titleError.textContent = 'You need to enter an e-mail address.';
    } else if(title.validity.typeMismatch) {
        // If the field doesn't contain an email address
        // display the following error message.
        titleError.textContent = 'Entered value needs to be an e-mail address.';
    } else if(title.validity.tooShort) {
        // If the data is too short
        // display the following error message.
        titleError.textContent = `Email should be at least ${ email.minLength } characters; you entered ${ email.value.length }.`;
    }

    // Set the styling appropriately
    emailError.className = 'error active';
}

*/













function clearValue(idInput){
    var emptyString = "";
     document.getElementById(idInput).value = emptyString;

}



























/*
/!*function showActivityPopUp(){
    document.getElementById('activityPopUp').style.display = "block";

}*!/

// Get the modal and activator
var CreateActivitypopUpBox = document.getElementById("activityPopUp");

var CreateActivityBox = document.getElementById("CreateActivityBox");
var closePlus = document.getElementsById("ClosePlus");

// When the user clicks the button, open the modal
CreateActivityBox.onclick = function() {
    CreateActivitypopUpBox.style.display = "block";
}

closePlus.onclick = function(){
    CreateActivitypopUpBox.style.color = "red";
}

/!*function nutSureYet(event){
    if (event.target === activityPopUpBox) {
        activityPopUpBox.style.display = "none";
    }
}*!/
*/







// https://levelup.gitconnected.com/all-possible-ways-of-making-an-api-call-in-plain-javascript-c0dee3c11b8b
/*  fetch('https://jsonplaceholder.typecode.com/users')
        .then(response => {
            return response.json()};
        })
        .then(users => {
            console.log(users);
        });*/

/*
https://stackoverflow.com/questions/5182772/append-option-to-select-menu/5182815#5182815
    var option = document.createElement("option");
    option.text = "Text";
    option.value = "myvalue";
    var select = document.getElementById("id-to-my-select-box");
    select.appendChild(option);*/

/*
Forskellige måder at lave for-loop i JS:
    var a = ["a", "b", "c"];
    a.forEach(entry => {
        console.log(entry);
    });

    const a = ["a", "b", "c"];
    for (const val of a) {
        console.log(val);
    }

    OG den gode gamle måde
 */