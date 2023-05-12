<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="home.css"></link>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head> 
<% 
	
	if(session==null&&session.getAttribute("uid")==null){
		
		response.sendRedirect("login.jsp");
		}
	 %>
<body>
	
	
	<div id="header">
    <div id="header1">
      <div class="inhead homeRed">
        <button style = "font-size:30px">KVS Agro Products</button>
      </div>
      <div class="inhead billing">
        <button>BILLING</button>
      </div>
      <div class="inhead listRed">
        <button>LIST</button>
      </div>
      <div class="inhead updateproduct">
        <button>UPDATE PRODUCTS</button>
      </div>
      <div class="inhead salesShow">
        <button>SALES</button>
      </div>
    </div>
    <div id="header2">
      
      <div class="inhead addproduct">
        <button>ADD PRODUCTS</button>
      </div>
      <div class="inhead logout">
        <button>LOGOUT</button>
      </div>
    </div>
  </div>
  
  <!-- billing by date -->
  <div class="container sales" style="display:none">
    <div class="check-bill-container">
      <div class="d-flex justify-content-around">
        <input aria-label="Text input with radio button" placeholder="Start Date(YYYY-MM-DD)" type="date" class="check-bill-input-box form-control" id="startDate" value="2023-09-01" style="margin-right: 10px; width:50%">
        <input aria-label="Text input with radio button" placeholder="End Date(YYYY-MM-DD)" type="date" class="check-bill-input-box form-control" id = "endDate" value="2023-09-18" style=" width:50%">
      <button type="submit" style = "width:7%" onclick = "showBillsByDate()"><i class="fa-solid fa-folder-magnifying-glass" ></i></button>
        </div>
    </div>
    <div id="selectBill"></div>
</div>
  <!-- billing by date end here -->
	<div>
	<div id="updatelist" style = "display:none"></div>
	
	</div>
	
	<div class = "listShow" ></div>
	
	<div class = "sales" style="display:none">jlkjlkjlkj</div>
	
	<!-- rough work -->
	


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">UPDATE PRODUCT</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div id="ProductUpdateInventory"></div>
      </div>
    </div>
  </div>
</div>
	
	
	
	<div id="addproduct" style = "display:none">
	<div>
		<div><input type="text" id= "pname" name = "pname" placeholder="product name"/></div>
		<div><input type="number" id = "aprice" name = "actprice" placeholder="actual price"/></div>
		<div><input type = "number" id = "rprice" name = "reprice" placeholder= "retail price"/></div>
		<div><input type = "number" id = "percent" name = "percent" placeholder = "gst percent" min = "0" max = "100"/></div>
		<div><input type = "number" id = "stock" name = "stock" placeholder = "stock"/></div>
		<div><button onclick = "addProduct()">Add</button></div>	
	</div>
	</div>
	
	<div id="customerbilling" style = "display:none">
		<div>
			<div><input type="text" id = "cname" name = "cname"></div>
			<div><input type="number" id = "cphone" name = "cphone" min="6666666666" max="9999999999"></div>
			<div><input type="text" id = "caddress" name = "caddress"></div>
			<div><button onclick = "addCustomer()">add</button>
			<button>cancel</button></div>
		</div>
	</div>
	
</body>
 <script src="inventory.js"></script>
</html>