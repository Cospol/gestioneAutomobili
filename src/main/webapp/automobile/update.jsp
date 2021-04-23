<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Aggiorna automobile</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	 
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Aggiorna automobile</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteUpdateAutomobileServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Marca <span class="text-danger">*</span></label>
								<input type="text" name="marca" id="marca" class="form-control" placeholder="Inserire la marca" value="${modifica_automobile_attr.marca }" required >
							</div>
							
							<div class="form-group col-md-6">
								<label>Modello <span class="text-danger">*</span></label>
								<input type="text" name="modello" id="modello" class="form-control" placeholder="Inserire il modello" value="${modifica_automobile_attr.modello}" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Cilindrata <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="cilindrata" id="cilindrata" placeholder="Inserire cilindrata" value="${modifica_automobile_attr.cilindrata}" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di immatricolazione<span class="text-danger">*</span></label>
								<fmt:formatDate var="dataParsed" pattern = "yyyy-MM-dd" value = "${modifica_automobile_attr.dataImmatricolazione}" />
                        		<input class="form-control" id="dataImmatricolazione" type="date" value = "${dataParsed}" 
                            		title="formato : gg/mm/aaaa"  name="dataImmatricolazione" required>
							</div>
							 <input type="hidden" name="id" id="idAutomobile"  value="${modifica_automobile_attr.id}" >
							
						</div>
							
						<button type="submit" id="buttonUpdate" class="btn btn-primary">Modifica</button>
					
					</form>

			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>