//create a bet
function createUser(){
    let name= document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let age = document.getElementById("age").value;
   
    
  
    fetch("/Users/createUser?", {
            method: "POST",
            body: JSON.stringify({
            "name": name,
            "email": email,
            "age": age
            
                
           
            }),
            headers: {
                "Content-Type": "application/json"
            }
        } 
    ).then(res => {
        res.json().then(body => {
            console.log(body);
           });
        })
    .catch(err =>{
        console.log(err);
        document.body.innerHTML= `<p>Error: ${err.message}</p>`;
    })

}


function deleteUser(){
    let id = document.getElementById("deleteUserId").value;
    
    fetch(`/Users/deleteUser?id=${id}`, {
            method: "PUT",
            
        } 
    ).then(res => {
        res.json().then(body => {
            console.log(body);
           });
        })
    .catch(err =>{
        console.log(err);
        document.body.innerHTML= `<p>Error: ${err.message}</p>`;
    })
}

//update

function updateUser(){
    let id = document.getElementById("userID").value;
    let name = document.getElementById("name2").value;
    let email = document.getElementById("email2").value;
    let age = document.getElementById("age2").value;
   
    
  
    fetch(`/Users/updateUsers?id=${id}`, {
            method: "PUT",
            body: JSON.stringify({
                "name": name,
                "email": email,
                "age": age
                
            }),
            headers: {
                "Content-Type": "application/json"
            }
        } 
    ).then(res => {
        res.json().then(body => {
            document.body.innerHTML = JSON.stringify(body)

           });
        })
    .catch(err =>{
        console.log(err);
        document.body.innerHTML= `<p>Error: ${err.message}</p>`;
    })

}

function readALLUsers(){

fetch("/Users/getAll").then( res => {
    res.json().then(body => {
        body.forEach(i => {

            let item = document.createElement("p");
            item.innerHTML = `${i.id}, ${i.name}, ${i.email}, ${i.age}`;
            document.body.appendChild(item);

        })
    })
}).catch(err => {
    console.log(err)
    document.body.innerHTML= `<p>Error: ${err.message}</p>`
})

}