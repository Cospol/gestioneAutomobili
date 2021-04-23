<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	
	<title>Conferma eliminazione</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Conferma eliminazione
		    </div>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Titolo</dt>
				  <dd class="col-sm-9">${visualizza_automobile_attr.marca}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Genere:</dt>
				  <dd class="col-sm-9">${visualizza_automobile_attr.modello}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Pagine:</dt>
				  <dd class="col-sm-9">${visualizza_automobile_attr.cilindrata}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Pubblicazione:</dt>
				  <dd class="col-sm-9"><fmt:formatDate value="${visualizza_automobile_attr.dataImmatricolazione}" pattern="MM/dd/yyyy" /></dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <form action="ExecuteDeleteAutomobileServlet" method="post">
			        <a href="ListAutomobiliServlet" class='btn btn-outline-secondary' style='width:80px'>
			            <i class='fa fa-chevron-left'></i> Back
			        </a>
		        	<input type="hidden" name="idInput"  value="${visualizza_automobile_attr.id}" >
		        	<button type="submit" class="btn btn-outline-danger">Rimuovi</button>
				</form>
		    </div>
		</div>	
		
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>