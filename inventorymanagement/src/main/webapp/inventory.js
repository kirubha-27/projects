let k=0;
//for add product---------------
const addProductClass = document.querySelector(".addproduct");
const addProductId = document.querySelector("#addproduct");
//-----------------------
//list redirect
const listRedirect = document.querySelector(".listRed");
//for logout
const logout = document.querySelector(".logout");
//home redirect
const homeRedirect = document.querySelector(".homeRed");
//billing
const billing = document.querySelector(".billing");
const billingId = document.querySelector("#customerbilling");
//update list
const updateList = document.querySelector("#updatelist");
const updateProduct = document.querySelector(".updateproduct");
//show list
const listShow = document.querySelector(".listShow");
//sales
const sales = document.querySelector(".sales");
const salesShow = document.querySelector(".salesShow")
// functions-------------------------------

addProductClass.onclick = function(){
	addProductId.style.display = "block";
	updateList.style.display = "none";
	billingId.style.display = "none";
	listShow.style.display = "none"
	sales.style.display = "none";
}

const xml = new XMLHttpRequest();

function addProduct(){
	
	const xml = new XMLHttpRequest();
	const name = document.getElementById("pname").value;
	const aprice = document.getElementById("aprice").value;
	const rprice = document.getElementById("rprice").value;
	const percent = document.getElementById("percent").value;
	const stock = document.getElementById("stock").value;
	xml.onreadystatechange = function(){
		if(xml.readyState===4){
			if(xml.responseText==="success"){
				console.log(6);
				alert("successfully added")
				location.href("http://localhost:8081/inventorymanagement/AddProductServlet");
			}else{
				alert("wrong inputs");
			}
		}
	}
	
	xml.open("POST","http://localhost:8081/inventorymanagement/AddProductServlet");
	xml.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xml.send(`name=${name}&aprice=${aprice}&rprice=${rprice}&percent=${percent}&stock=${stock}`);
	//location.href = "home.jsp";
}
//list show
function showList(){
	const xml = new XMLHttpRequest();
	console.log("hi")
	xml.onreadystatechange = function(){
		if(xml.readyState===4){
			let name = JSON.parse(xml.responseText);
			console.log(name);
			let result = "<table class='table table-dark table-hover'><tr><th>SNO</th><th>PNO</th><th>Product Name</th><th>RETAIL</th><th>ACTUAL</th><th>GST</th><th>GST PERCENT</th><th>STOCK</th>";
			let j = 1;
			for(let i=0;i<name.length;i++){
				let price = ((name[i].rprice*name[i].gpercent)/100)+name[i].rprice;
				result+=`<tr><td>${j}</td>`;
				result+=`<td>${name[i].pid}</td>`;
				result+=`<td>${name[i].name}</td>`;
				result+=`<td>${name[i].rprice}</td>`;
				result+=`<td>${name[i].aprice}</td>`;
				result+=`<td>${price}</td>`;
				result+=`<td>${name[i].gpercent}</td>`;
				result+=`<td>${name[i].stock}</td>`;
			}
			result+="</table>";
			console.log(result);
			listShow.innerHTML = result;
			
		}
	}
	
	xml.open("GET","http://localhost:8081/inventorymanagement/getProductServlet?type=byId");
	xml.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xml.send();
	
}

//addcustomer
function addCustomer(){
	let products = [];
	let stocks = [];
	let price = [];
	let gst = [];
	let total = []; 
	const name = document.getElementById("cname").value;
	const address = document.getElementById("caddress").value;
	const phone = document.getElementById("cphone").value;
	
	
	
	result =`<div id="root">
        <div class="App">
            <div class="container">
                <div class="d-flex justify-content-center justify-content-between m-2"><p>Name : <b>${name}</b></p>
                    <p>City :<b>${address}</b></p><p>Phone : <b>${phone}</b></p>
                    <p>Borrow : <mark>0</mark></p>
                </div></div>
                
                <div class="search-box">
                    <div class="search-box-input-1 input-group" style = "margin-left: 30%;">
                        <input style= "max-width: 40%;" placeholder="Search Product" aria-label="Search Product" aria-describedby="basic-addon1" id="srch" class="search-box-input-2 form-control" value="g">
                        <button type="button" class="search-input-btn btn btn-primary"><svg stroke="currentColor" fill="currentColor" stroke-width="0" version="1.1" viewBox="0 0 16 16" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M15.504 13.616l-3.79-3.223c-0.392-0.353-0.811-0.514-1.149-0.499 0.895-1.048 1.435-2.407 1.435-3.893 0-3.314-2.686-6-6-6s-6 2.686-6 6 2.686 6 6 6c1.486 0 2.845-0.54 3.893-1.435-0.016 0.338 0.146 0.757 0.499 1.149l3.223 3.79c0.552 0.613 1.453 0.665 2.003 0.115s0.498-1.452-0.115-2.003zM6 10c-2.209 0-4-1.791-4-4s1.791-4 4-4 4 1.791 4 4-1.791 4-4 4z"></path></svg></button>
                    </div>
                </div>`;
	
	billingId.innerHTML = result;
	
}
//sales
salesShow.onclick = function(){
	updateList.style.display = "none";
	addProductId.style.display = "none";
	listShow.style.display = "none"
	billingId.style.display = "none";
	sales.style.display = "block";
}
//update product
updateProduct.onclick=function(){
	const xml = new XMLHttpRequest();
	
	updateList.style.display = "block";
	addProductId.style.display = "none";
	listShow.style.display = "none"
	billingId.style.display = "none";
	sales.style.display = "none";
	console.log("hello");
	
	xml.onreadystatechange = function(){
		if(xml.readyState===4){
			let name = JSON.parse(xml.responseText);
			console.log(name);
			let result = "<table class='table table-dark table-hover'><tr><th>SNO</th><th>PNO</th><th>Product Name</th><th>RETAIL</th><th>ACTUAL</th><th>GST</th><th>GST PERCENT</th><th>STOCK</th><th>DELETE<th>EDIT</th>";
			let j = 1;
			for(let i=0;i<name.length;i++){
				let price = ((name[i].rprice*name[i].gpercent)/100)+name[i].rprice;
				result+=`<tr><td>${j}</td>`;
				result+=`<td>${name[i].pid}</td>`;
				result+=`<td>${name[i].name}</td>`;
				result+=`<td>${name[i].rprice}</td>`;
				result+=`<td>${name[i].aprice}</td>`;
				result+=`<td>${price}</td>`;
				result+=`<td>${name[i].gpercent}</td>`;
				result+=`<td>${name[i].stock}</td>`;
				let pid = 'A'+name[i].pid;
				result+=`<td><button id=${pid} onclick="deleteFunc(${name[i].pid})" style="border:none; background:transparent" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fa-solid fa-trash" style="color: #green;"></i></button></td>`;
				result+=`<td><button id=${pid} onclick="editFunc(${name[i].pid})" style="border:none; background:transparent" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fa-solid fa-file-pen" style="color: green;"></i></button></td></tr>`;
				j++;
			}
			result+="</table>";
			console.log(result);
			updateList.innerHTML = result;
			
		}
	}
	
	xml.open("GET","http://localhost:8081/inventorymanagement/UpdateProductServlet?");
	xml.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xml.send();
}

function editFunc(productId){
	const xml = new XMLHttpRequest();
	console.log(productId);
	xml.onreadystatechange = function() {
		if (xml.readyState == 4) {
			
			const result = JSON.parse(xml.responseText);
			console.log('from');
			console.log(result);
			
			let price = ((result[0].rprice*result[0].gpercent)/100)+result[0].rprice;
			let productUpdateInventory = document.getElementById("ProductUpdateInventory");
			productUpdateInventory.innerHTML = `
				<div class="container ">
				<div class="row justify-content-center ">
					

									<div class="input-group mb-3 mt-3">
										<span class="input-group-text " id="inputGroup-sizing-default">Name</span>
										<input type="text" value=${result[0].name} class="form-control" id="updateProductNameInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> Actual Price</span>
										<input type="number" value=${result[0].rprice} class="form-control" id="updateActualPriceInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> MRP</span>
										<input type="number" value=${result[0].aprice} class="form-control" id="updateRetailPriceInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> GST%</span>
										<input type="number" value=${result[0].gpercent} class="form-control" id="updateGSTPercentInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
									  <div class="input-group mb-3">
										<span class="input-group-text" id="inputGroup-sizing-default"> Stock</span>
										<input type="number" value=${result[0].stock} class="form-control" id="updateStockInput" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
									  </div>
								
				
				</div>
		</div>
		<div class="modal-footer">
		  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		  <button type="button"onclick="update(${productId})" class="btn btn-primary">Save changes</button>
			`;
		}
		

	}
	xml.open("GET", "http://localhost:8081/inventorymanagement/EditProductServlet?pid=" + productId);
	xml.setRequestHeader("Content-Type", "application/x-www-from-urlencoded");
	xml.send();

}
function update(productId){
	const xml = new XMLHttpRequest();
	console.log(productId+"gg");
	let name = document.getElementById("updateProductNameInput").value;
	console.log(name);
	let rePrice = document.getElementById("updateActualPriceInput").value;
	console.log(rePrice);
	let actPrice = document.getElementById("updateRetailPriceInput").value;
	console.log(actPrice);
	let percent = document.getElementById("updateGSTPercentInput").value;
	console.log(percent);
	let stock = document.getElementById("updateStockInput").value;
	console.log(stock);
	let inStock = false;
	if(stock>0){
		inStock = true;
	}
	xml.onreadystatechange = function(){
		if(xml.readyState===4){
			
			if(xml.responseText==="failure"){
				alert("failure");
				
				
				
				
			}else{
				document.querySelector(".modal-backdrop").style.display = "none";
				document.querySelector(".modal").style.display = "none";
				
				setTimeout(function(){alert("success");},100);
				
				let name = JSON.parse(xml.responseText);
			console.log(name);
			let result = "<table class='table table-dark table-hover'><tr><th>SNO</th><th>PNO</th><th>Product Name</th><th>RETAIL</th><th>ACTUAL</th><th>GST </th><th>GST %</th><th>STOCK</th><th>delete</th><th>editttytyt</th>";
			let j = 1;
			for(let i=0;i<name.length;i++){
				let price = ((name[i].rprice*name[i].gpercent)/100)+name[i].rprice;
				result+=`<tr><td>${j}</td>`;
				result+=`<td>${name[i].pid}</td>`;
				result+=`<td>${name[i].name}</td>`;
				result+=`<td>${name[i].rprice}</td>`;
				result+=`<td>${name[i].aprice}</td>`;
				result+=`<td>${price}</td>`;
				result+=`<td>${name[i].gpercent}</td>`;
				result+=`<td>${name[i].stock}</td>`;
				let pid = 'A'+name[i].pid;
				result+=`<td><button id=${pid} onclick="deleteFunc(${name[i].pid})" style="border:none; background:transparent" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fa-solid fa-trash" style="color: #green;"></i></button></td>`;
				result+=`<td><button id=${pid} onclick="editFunc(${name[i].pid})" style="border:none; background:transparent" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fa-solid fa-file-pen" style="color: green;"></i></button></td></tr>`;
				j++;
			}
			result+="</table>";
			console.log(result);
			updateList.innerHTML = result;
			}
			
		}
	}
	
	xml.open("POST","http://localhost:8081/inventorymanagement/ProductEditServlet");
	xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xml.send(`productId=${productId}&name=${name}&reprice=${rePrice}&actPrice=${actPrice}&percent=${percent}&stock=${stock}&inStock=${inStock}`);
}

// logout function
logout.onclick = function(){
	location.href = "http://localhost:8081/inventorymanagement/LogoutServlet";
}

//home redirect
homeRedirect.onclick = function(){
	location.href = "http://localhost:8081/inventorymanagement/home.jsp";
}
//billing
billing.onclick = function(){
	sales.style.display = "none";
	addProductId.style.display = "none";
	updateList.style.display = "none";
	billingId.style.display = "block";
	listShow.style.display = "none";
}

function showBillsByDate(){
	const xml = new XMLHttpRequest();
	const startDate = document.getElementById("startDate").value;
	const endDate = document.getElementById("endDate").value;
	
	console.log(startDate);
	console.log(endDate);
	
	xml.onreadystatechange = function(){
		if(xml.readyState===4){
			
			
				
			let result = "";	
			let names = JSON.parse(xml.responseText);
			console.log(names);
			for(let i=0;i<names.length;i++){
				let bill = names[i].billNumber;
				let j = i;
				let priceCal = 0;
				let gstCal = 0;
				let total = 0;
				let gstPrice = 0;
				let curTotal = 0;
				result += `<div className="d-flex"  style="display: flex; font-size: 15px; justify-content: space-evenly;"> <p>Date : <b>${names[i].date}</b></p><p>Name : <b>${names[i].customerName}</b></p><p>Address : <b>${names[i].address}</b></p><p>Bill No : <b>${names[i].billNumber}</b></p></div>  <table borderless style="border: 1px solid black; font-size: 15px; width:85%; margin:0 auto"><tr style="border-bottom:1px solid black; text-align: center"><th style="border-right: 1px solid black">#</th><th style="border-right: 1px solid black">Name</th><th style="border-right: 1px solid black">Qty</th><th style="border-right: 1px solid black">Rate</th><th style="border-right: 1px solid black">Price</th><th style="border-right: 1px solid black">GST %</th><th style="border-right: 1px solid black">GST</th><th style="border-right: 1px solid black">G.Total</th></tr>`;
				while(j<names.length&&names[j].billNumber===bill){
					gstPrice = ((names[j].rprice*names[j].gpercent)/100);
					curTotal = names[j].rprice+gstPrice;
					result += `<tr style="border-bottom:1px solid black; text-align: center"> <td style="border-right: 1px solid black"></td>`;
                    result += `<td style="border-right: 1px solid black">${names[j].name}</td>`;
                    result += `<td style="border-right: 1px solid black">${names[j].quantity}</td>`;
		            result += `<td style="border-right: 1px solid black" >${names[j].aprice}</td>`;
                    result += `<td style="border-right: 1px solid black" >${names[j].rprice}</td>`;
	                result += `<td style="border-right: 1px solid black" >${names[j].gpercent}</td>`;
	                result += `<td style="border-right: 1px solid black" >${gstPrice}</td>`;
                    result += `<td style="border-right: 1px solid black" >${curTotal}</td></tr>`;
                    priceCal += names[j].rprice;
                    gstCal += gstPrice;
                    total += curTotal;
                    j++;
				}
				i=j-1;
				result += `<tr className='p-3'><td style="border-right: 1px solid black" colSpan="4"><b>Total(&#8377;)</b></td><td style="border-right: 1px solid black"><b>&#8377; ${priceCal}</b></td><td style="border-right: 1px solid black"></td><td style="border-right: 1px solid black"><b>&#8377; ${gstCal}</b></td><td style="border-right: 1px solid black"><b>&#8377; ${total}</b></td></tr></table><div><table style="font-size: 15px; width:85%; margin:20px auto"><tbody style="text-align:center;"><td className="pt-2" style="border:1px solid black">Farmer Signature(For Agriculture use)</td><td className="pt-2" style="border:1px solid black">Retailer Signature</td> </tbody></table></div><hr/>`;
			}
			
			if(result!=="")
			document.getElementById("selectBill").innerHTML = result;
			else
			document.getElementById("selectBill").innerHTML = "no result found";
		}
	}
	
	xml.open("GET",`http://localhost:8081/inventorymanagement/showBillServlet?startDate=${startDate}&endDate=${endDate}`);
	xml.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xml.send();
	
}
//list
listRedirect.onclick = function(){
	addProductId.style.display = "none";
	updateList.style.display = "none";
	billingId.style.display = "none";
	listShow.style.display = "block"
	sales.style.display = "none";
	showList();
}