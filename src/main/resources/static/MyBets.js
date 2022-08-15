

//create a bet
function create(){
    let betType = document.getElementById("description").value;
    let result = document.getElementById("outcome").value;
    let profitLoss = document.getElementById("profitLoss").value;
   
    
  
    fetch("/Bets/createBets?", {
            method: "POST",
            body: JSON.stringify({
            "description": betType,
            "outcome": result,
            "profitLoss": profitLoss,
            
                
           
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


function deleteBet(){
    let id = document.getElementById("deleteBetId").value;
    
    fetch(`/Bets/deleteBets?id=${id}`, {
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

function update(){
    let id = document.getElementById("betID").value;
    let betType = document.getElementById("betType2").value;
    let result = document.getElementById("outcome2").value;
    let profitLoss = document.getElementById("profitLoss2").value;
   
    
  
    fetch(`/Bets/updateBets?id=${id}`, {
            method: "PUT",
            body: JSON.stringify({
            "description": betType,
            "outcome": result,
            "profitLoss": profitLoss,
                
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

function readALLBets(){

fetch("/Bets/getAll").then( res => {
    res.json().then(body => {
        body.forEach(i => {

            let item = document.createElement("p");
            item.innerHTML = `${i.id}, ${i.description}, ${i.outcome}, ${i.profitLoss}`;
            document.body.appendChild(item);

        })
    })
}).catch(err => {
    console.log(err)
    document.body.innerHTML= `<p>Error: ${err.message}</p>`
})

}