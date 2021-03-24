



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

function showCreateActivityForm(){
    document.getElementById()
}


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