<!doctype html>
<html lang="it">
  <head>
    
    <jsp:include page="./header.jsp" />
    
    <!-- Custom styles for this template -->
    <link href="./assets/css/global.css" rel="stylesheet">
    <style type="text/css">
    	body {
		  padding-top: 3.5rem;
		}	
    </style>
    
    <title>Gestione delle Automobili!</title>
  </head>
  <body>
  
	<jsp:include page="./navbar.jsp"></jsp:include>
  
  
	<main role="main">
	
		<div class="alert alert-danger alert-dismissible fade show ${message==null?'d-none': ''}" role="alert">
		  ${message}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none': ''}" role="alert">
		  ${successMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <a class="btn btn-primary " href="PrepareInsertAutomobileServlet">Add New</a>
		    </div>
		    <div class='card-body'>

 
					<form method="post" action="ListAutomobiliServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Marca  </label>
								<input type="text" name="marca" id="marca" class="form-control" placeholder="Inserire la marca" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Modello </label>
								<input type="text" name="modello" id="modello" class="form-control" placeholder="Inserire il modello" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Cilindrata </label>
								<input type="number" class="form-control" name="cilindrata" id="cilindrata" placeholder="Inserire la cilindrata" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di Immatricolazione</label>
                        		<input class="form-control" id="dataImmatricolazione" type="date" placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataImmatricolazione" required>
							</div>
							
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Cerca</button>
					

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	</main>
	
	<jsp:include page="./footer.jsp" />
  </body>
</html>