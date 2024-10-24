// Simulated backend data
let channels = [];
let messages = [];

function registerUser() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    // Store user data (in a real app, you'd send this to your backend)
    console.log(`User registered: ${username}`);
}

function createChannel() {
    const channelName = prompt("Enter channel name:");
    if (channelName) {
        channels.push(channelName);
        updateChannelList();
    }
}

function updateChannelList() {
    const channelList = document.getElementById('channelList');
    channelList.innerHTML = '';
    channels.forEach(channel => {
        const li = document.createElement('li');
        li.textContent = channel;
        channelList.appendChild(li);
    });
}

function sendMessage() {
    const message = document.getElementById('message').value;
    if (message) {
        messages.push(message);
        updateMessageList();
        document.getElementById('message').value = ''; // Clear input
    }
}

function updateMessageList() {
    const messageList = document.getElementById('messageList');
    messageList.innerHTML = '';
    messages.forEach(msg => {
        const li = document.createElement('li');
        li.textContent = msg;
        messageList.appendChild(li);
    });
}
