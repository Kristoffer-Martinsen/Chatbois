/*
class User {
    constructor() {
        this.user = document.querySelector("#username");
        
        this.user.onchange = event => {
            this.user = document.getElementById("username").value;
        };
    } 
}
let user = new User();
*/
function login() {
    window.location.href = "/Chatbois/chat.html?name=" + document.querySelector("#username").value; 
}
