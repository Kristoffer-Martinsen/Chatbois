
class Chat {
    constructor() {
        this.chat = document.querySelector("#chat");
        this.message = document.querySelector("#message");
        this.picture = document.querySelector("#picture");
        
        this.name = new URL(document.URL).searchParams.get("name");

        this.message.onchange = event => {
            fetch('api/messages/add?name=' + this.name, 
            {
                method: 'POST',
                body: JSON.stringify(new Message(this.name, event.target.value)),
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

function getInputData(e) {
    if(e.target.files && e.target.files[0]) {
        upload(e.target.files[0]);  
    }
}

function upload(file) {
    let fileName = file.name;
    let image = null;
    let reader = new FileReader();
    
    reader.onload = function(event) {
        let imageInput = event.target.result;
        postImage(imageInput);
        console.log(imageInput);
    };
    reader.readAsDataURL(file);
}

function postImage(dataString) {
    fetch('api/messages/add?name=' + this.name, 
            {
                method: 'POST',
                body: JSON.stringify(dataString),
                headers: {'Content-Type' : 'application/json; charset=UTF-8'}
            })
}


class Message {
    constructor(user, text) {
        this.user = user;
        this.text = text;
        this.version = new Date();
    }
}

class Image {
    constructor(dataString, imageName) {
        this.dataString = dataString;
        this.imageName = imageName;
    }
}


let chat = new Chat();