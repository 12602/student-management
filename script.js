let btn=document.querySelector("button");
let title=document.getElementById("title");
let description=document.getElementById("description");
let table=document.querySelector("table");

let count=2;
btn.addEventListener("click",(e)=>
{
    count++;

  
  table.innerHTML+="<tr><th>" +count+"</th>"+"<td>"+title.value+"</td><td>"+description.value+"</td></tr>";


})