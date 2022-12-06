var datetag = document.getElementsByClassName("dateId"); 

for(var i = 0; i < datetag.length; i++){
    var dateValue = datetag[i].innerHTML;

    var date = new Date(dateValue); 
    var dd = String(date.getDate()).padStart(2, "0");
    var mm = String(date.getMonth() + 1).padStart(2, "0"); //January is 0!
    var yyyy = date.getFullYear();
    date = dd + "/" + mm + "/" + yyyy;

    datetag[i].innerHTML = date; 
}
