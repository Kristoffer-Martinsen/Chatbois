
class Chat {
    constructor() {
        this.chat = document.querySelector("#chat");
        this.message = document.querySelector("#message");
        
        this.name = new URL(document.URL).searchParams.get("name");
        //this.loadChat(this.name);
        
        this.message.onchange = event => {
            fetch('api/messages/add?name=' + this.name, 
            {
                method: 'POST',
                body: JSON.stringify(new Message('kris', event.target.value)),
                headers: {'Content-Type' : 'application/json; charset=UTF-8'}
            })
                    .then(response => {
                        if(response.ok) {
                            return response.json();
                        }
                        
                        throw new Error("Failed to send message " + event.target.value);
            })
                    .then(message => {
                        this.message.value = "";
            })
                    .catch(exception => console.log("Error: " + exception));
        };
        
        
        this.worker = new Worker("worker.js");
        this.worker.postMessage({"name" : this.name});
        
        this.worker.onmessage = event => {
            this.chat.innerHTML = '';
            let ul = document.createElement('ul');
            event.data.map(message => {
                let li = document.createElement('li');
                li.innerHTML = `${message.user} - ${message.text}`;
                ul.appendChild(li);
            });
            this.chat.appendChild(ul);
            this.chat.scrollTop = this.chat.scrollHeight;
        };   
    }
}

class Message {
    constructor(user, text) {
        this.user = user;
        this.text = text;
        this.version = new Date();
    }
}

let chat = new Chat();