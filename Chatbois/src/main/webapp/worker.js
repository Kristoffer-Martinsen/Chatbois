/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getMessages() {
    fetch('api/messages?name=' + this.name).
            then(response => {
                if(response.ok) {
                    return response.json();
                }
                throw new Error("Failed to load message from" + this.name);
    })
            .then(messages => {
                postMessage(messages);
    })
            .catch(e => console.log(e));
    
    setTimeout("getMessages()", 1000);
}

self.addEventListener("message", event => {
    this.name = event.data.nameM
}, false);

getMessages();
