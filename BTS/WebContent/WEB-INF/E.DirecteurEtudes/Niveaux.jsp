<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<title>Liste des niveaux</title>
  	
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.min.css" type="text/css" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dataTables.bootstrap.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css" type="text/css" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.min.css" type="text/css" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstap.min.css" type="text/css" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css" type="text/css" >
		
	<style type="text/css">
	body{
			background-color:#fff;
		}
	/***************** Modal confirm **********************/
	.modal-confirm {		
		color: #636363;
		width: 325px;
	}
	.modal-confirm .modal-content {
		padding: 20px;
		border-radius: 5px;
		border: none;
	}
	.modal-confirm .modal-header {
		border-bottom: none;   
        position: relative;
	}
	.modal-confirm h4 {
		width:100%;
		text-align: center;
		font-size: 26px;
		margin: 30px 0 -15px;
	}
	.modal-confirm .form-control, .modal-confirm .btn {
		min-height: 40px;
		border-radius: 3px; 
	}
	.modal-confirm .close {
        position: absolute;
		top: -5px;
		right: -5px;
	}	
	.modal-confirm .modal-footer {
		border: none;
		text-align: center;
		border-radius: 5px;
		font-size: 13px;
	}	
	.modal-confirm .icon-box {
		color: #fff;		
		position: absolute;
		margin: 0 auto;
		left: 0;
		right: 0;
		top: -70px;
		width: 95px;
		height: 95px;
		border-radius: 50%;
		z-index: 9;
		/* background: #82ce34; */
		padding: 15px;
		text-align: center;
		box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
	}
	.modal-confirm .icon-box i {
		font-size: 58px;
		position: relative;
		top: 3px;
	}
	.modal-confirm.modal-dialog {
		margin-top: 80px;
	}
    .modal-confirm .btn {
        color: #fff;
        border-radius: 4px;
		text-decoration: none;
		transition: all 0.4s;
        line-height: normal;
        border: none;
        width:100%;
    }

/********************************************************************/
		.page-header h3{
		padding:10px;
		}
		.panel-primary{
		border:1px solid #3071a9 !important;
		}
		.panel-body{
			padding:20px;
		}
		.panel.with-nav-tabs .panel-heading{
		    padding: 5px 5px 0 5px;
		    background-color: #3071a9;
		}
		.panel.with-nav-tabs.panel-body{
		    padding: 10px 15px;
		}
		.panel.with-nav-tabs .nav-tabs{
			border-bottom: none;
		}
		.panel.with-nav-tabs .nav-justified{
			margin-bottom: -1px;
		}
		/*** PANEL PRIMARY ***/
		.with-nav-tabs.panel-primary .nav-tabs > a,
		.with-nav-tabs.panel-primary .nav-tabs > a:hover,
		.with-nav-tabs.panel-primary .nav-tabs > a:focus {
		    color: #fff;
		}
		.with-nav-tabs.panel-primary .nav-tabs > .open > a,
		.with-nav-tabs.panel-primary .nav-tabs > .open > a:hover,
		.with-nav-tabs.panel-primary .nav-tabs > .open > a:focus,
		.with-nav-tabs.panel-primary .nav-tabs > a:hover,
		.with-nav-tabs.panel-primary .nav-tabs >  a:focus {
			color: #fff;
			background-color: #3071a9;
			border-color: transparent;
		}
		.with-nav-tabs.panel-primary .nav-tabs > a.active,
		.with-nav-tabs.panel-primary .nav-tabs > a.active > a:hover,
		.with-nav-tabs.panel-primary .nav-tabs > a.active > a:focus {
			color: #428bca;
			background-color: #fff;
			border-color: #428bca;
			border-bottom-color: transparent;
		}
		.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu {
		    background-color: #428bca;
		    border-color: #3071a9;
		}
		.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > li > a {
		    color: #fff;   
		}
		.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > li > a:hover,
		.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > li > a:focus {
		    background-color: #3071a9;
		}
		.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > .active > a,
		.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > .active > a:hover,
		.with-nav-tabs.panel-primary .nav-tabs > li.dropdown .dropdown-menu > .active > a:focus {
		    background-color: #4a9fe9;
		}
		/********************************************************************/
			input.error {
		    border-color: #f00 !important;
			}
			small.required {
			    color:#f00;
			}
.modal-backdrop {
   /* display: none; */
}
	/**************** Data Table *******************/
	
		</style>	
  </head>
 <body>
	<div class="wrapper d-flex align-items-stretch">
		<nav id="sidebar" class="active">
			<h1><a href="index.html" class="logo"><span class="fa fa-cubes"></span></a></h1>
	      	<%@include file="MenuDirecteurEtudes.jsp" %>
		</nav>
	<!-- Page Content  -->
      <div id="content" class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid">

            <button type="button" id="sidebarCollapse" class="btn btn-primary">
              <i class="fa fa-bars"></i>
              <span class="sr-only">Toggle Menu</span>
            </button>
            <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fa fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="nav navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#"><span class="fa fa-home mr-2"></span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><span class="fa fa-envelope mr-2"></span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><span class="fa fa-bell mr-2"></span></a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
					    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">
					     <img src="${pageContext.request.contextPath}/Document/Download?file=${sessionScope.userPhoto}" class="rounded-circle" style="width:20px;height:20px;">
					       
					    </button>
					    <div class="dropdown-menu dropdown-menu-right" role="menu" >
					      <div class="dropdown-item text-center">
					      <img src="${pageContext.request.contextPath}/Document/Download?file=${sessionScope.userPhoto}" class="rounded-circle" style="width:60px;height:60px;">
					       
					      </div>
					      <h5 class="dropdown-header text-primary text-center">${sessionScope.userFirstName_Fr} &nbsp; ${sessionScope.userLastName_Fr}</h5>
					      <h5 class="dropdown-header text-muted text-center">${sessionScope.userRole}</h5>
					      <div class="dropdown-divider"></div>
					      <a class="dropdown-item" href="${pageContext.request.contextPath}/E.DirecteurEtudes/Profile?userId=${sessionScope.userID}">
					      		<span class="fa fa-id-card mr-2"></span>
					      		Profile
					      </a>
					      <div class="dropdown-divider"></div>
						  <a class="dropdown-item" href="${pageContext.request.contextPath}/Logout"> 
						      	<span class="fa fa-external-link-square-alt mr-2"></span>
						      	Déconnexion
						  </a>
					    </div>
					  </div>
                </li>
     
              </ul>
            </div>
          </div>
        </nav>
<!-- Start content -->
	
	<div class="container"> 
		<div class="row">
		<div class="col-md-9"> <!-- Col 1 -->
			<div class="alert bg-light text-secondary" role="alert">
	   			<i class="fa fa-cubes mr-2"></i>
	   			Niveaux
		        <a href="#" data-toggle="modal" data-target="#niveau_Add_Modal" class="btn btn-outline-info float-right" title="Ajouter un niveau"><i class="fa fa-plus"></i></a>
		        
			</div>
			<table id="data_table_niveaux" class="table table-striped table-bordered" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>N°</th>
						<th>Code</th>
						<th>Nom</th>
			            <th>Action</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<!-- Début : Modal Add New Niveau -->
				<div id="niveau_Add_Modal" class="modal" tabindex="-1" role="dialog">
					<div class="modal-dialog">
					<form id="niveau_Add_Form" method="POST" action="../Niveau/Add" >
				      	<div class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
				          	<div class="modal-header bg-info">
				        		<h4 class="modal-title text-white">
				        			Ajouter un niveau
				        		</h4>
				        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			    					<span aria-hidden="true">&times;</span>
			  					</button>
				        	</div>
				          	<div class="modal-body">
				          		<div class="form-group row">
						    		<label for="niveau_code" class="col-sm-3 control-label">Code</label>
								    <div class="col-sm-9">
								      <input id="niveau_code" type="text" class="form-control" name="code" placeholder="Code du niveau" required/>
								    </div>
						  		</div>
								<div class="form-group row">
								  <label for="niveau_Nom_Fr" class="col-sm-3 control-label">Nom du niveau</label>
								  <div class="col-sm-9">
								    <input id="niveau_Nom_Fr" type="text" class="form-control" name="nom_Fr" placeholder="Nom du niveau" required/>
								  </div>
								</div>
						  		<div class="form-group row">
								  <label for="niveau_Nom_Ar" class="col-sm-3 control-label">إسم المستوى</label>
								  <div class="col-sm-9">
								    <input id="niveau_Nom_Ar" type="text" class="form-control" name="nom_Ar" dir="rtl" placeholder="إسم المستوى بالعربية"/>
								  </div>
								</div>
				      	</div>
				        <div class="modal-footer ">
			        		<input type="submit" class="btn btn-primary" value="Enregistrer" />
					        <button type="button" class="btn btn-secondary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Annuler</button>
			      		</div>
				        </div>
				   	</form>
					</div>
			    </div>
			 <!-- Fin : Modal Add New Niveau -->
			 <!-- Début : Modal Update Niveau -->
				<div id="niveau_Update_Modal" class="modal" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true" data-backdrop="false">
					<div class="modal-dialog">
					<form id="niveau_Update_Form" method="POST" action="../Niveau/Update" >
				      	<div class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
				          	<div class="modal-header bg-info">
				        		<h4 class="modal-title text-white">
				        			Modifier le niveau
				        		</h4>
				        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			    					<span aria-hidden="true">&times;</span>
			  					</button>
				        	</div>
				          	<div class="modal-body">
				          		<div class="form-group row">
						    		<label for="niveau_code" class="col-sm-3 control-label">Code</label>
								    <div class="col-sm-9">
								      <input  type="hidden" class="form-control" name="id" />
								      <input id="niveau_code" type="text" class="form-control" name="code" placeholder="Code du niveau" required/>
								    </div>
						  		</div>
								<div class="form-group row">
								  <label for="niveau_Nom_Fr" class="col-sm-3 control-label">Nom du niveau</label>
								  <div class="col-sm-9">
								    <input id="niveau_Nom_Fr" type="text" class="form-control" name="nom_Fr" placeholder="Nom du niveau" required/>
								  </div>
								</div>
						  		<div class="form-group row">
								  <label for="niveau_Nom_Ar" class="col-sm-3 control-label">إسم المستوى</label>
								  <div class="col-sm-9">
								    <input id="niveau_Nom_Ar" type="text" class="form-control" name="nom_Ar" dir="rtl" placeholder="إسم المستوى بالعربية"/>
								  </div>
								</div>
				      	</div>
				        <div class="modal-footer ">
			        		<input type="submit" class="btn btn-primary" value="Enregistrer" />
					        <button type="button" class="btn btn-secondary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Annuler</button>
			      		</div>
				        </div>
				   	</form>
					</div>
			    </div>
			 <!-- Fin : Modal Update Niveau -->
			 <!-- Début : Modal Details Niveau -->
				<div id="niveau_Details_Modal" class="modal" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true" data-backdrop="false">
					<div class="modal-dialog">
				      	<div class="modal-content shadow-lg p-3 mb-5 bg-white rounded">
				          	<div class="modal-header bg-info">
				        		<h4 class="modal-title text-white">
				        			Détails du niveau
				        		</h4>
				        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			    					<span aria-hidden="true">&times;</span>
			  					</button>
				        	</div>
				          	<div class="modal-body">
				          		<ul class="list-group">
									<!-- Affichage dynamique des détails du niveau-->
								</ul>
							</div>
							<div class="modal-footer ">
								<button type="button" class="btn btn-secondary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Fermer</button>
							</div>
				        </div>
					</div>
			    </div>
			 <!-- Fin : Modal Details Niveau -->
		
		</div> <!-- /Col 1 -->
		<div class="col-md-3"> <!-- Col 2 -->
			<div class="panel with-nav-tabs panel-primary">
		     <div class="panel-heading">
					<nav class="nav nav-tabs flex-column flex-sm-row"  id="Tab-Content-2" role="tablist">
					    <a id="tab_Annonces" href="#content-tab-Annonces" class="nav-item nav-link active" data-toggle="tab" role="tab" aria-controls="content-tab-Annonces" aria-selected="false">
					        <span class="fa fa-bullhorn"></span> Annonces
					    </a>
					    <a  id="tab_Actualites" href="#content-tab-Actualites" class="nav-item nav-link" data-toggle="tab" role="tab" aria-controls="content-tab-Actualites" aria-selected="false">
					        <span class="fa fa-newspaper"></span> Actualites
					    </a>
					</nav>
			</div>
		    <div class="panel-body">
		    	<!-- Début : Tab content  2-->
				<div class="tab-content" id="Tab-Content-Communication">
						<!-- Content tab 1 	: Annonces-->
					  	<div id="content-tab-Annonces" class="tab-pane active" role="tabpanel" aria-labelledby="content-tab-Annonces">
					     <ul>
							<li>Annonce 1</li>
							<li>Annonce 2</li>
							<li>Annonce 3</li>
						 </ul>
					  	</div>
						<!-- /Content tab 1 : Annonces-->
						<!-- Content tab 2 	: Actualites-->
						<div id="content-tab-Actualites" class="tab-pane" role="tabpanel" aria-labelledby="content-tab-Actualites">
						 <ul>	
							<li>Actualité 1</li>
							<li>Actualité 2</li>
							<li>Actualité 3</li>
							<li>Actualite 4</li>
							<li>Actualité 5</li>
						 </ul>
						</div>
						<!-- /Content tab 2	: Actualites-->
				</div>
				<!-- Fin : Tab content 2 -->
			 </div>
		</div>
		</div> <!-- Col 2 -->
	</div><!-- /row 1 -->
	
	<!-- /Page Content  -->
</div>
</div>
</div>
<!-- Modal Success -->
	<div id="modalSuccess" class="modal" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-dialog-centered modal-confirm">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box bg-success">
					<i class="material-icons fa fa-check"></i>
				</div>				
				<h4 class="modal-title text-center">Succès !</h4>	
			</div>
			<div class="modal-body">
				<p class="text-center">
					<!-- On affiche ici le message obtenu du coté serveur -->
				</p>
			</div>
			<div class="modal-footer">
				<button class="btn btn-success btn-block" data-dismiss="modal">Fermer</button>
			</div>
		</div>
	  </div>
	</div>
<!-- Fin : Moad Success -->
<!-- Début : Modal error -->
	<div id="modalError" class="modal" tabindex="-1" role="dialog">
	  <div class="modal-dialog modal-dialog-centered modal-confirm">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box bg-danger">
					<i class="material-icons fa fa-exclamation-triangle"></i>
				</div>				
				<h4 class="modal-title text-center">Echec !</h4>	
			</div>
			<div class="modal-body">
				<p class="text-center">
					<!-- On affiche ici le message obtenu du coté serveur -->
				</p>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary btn-block" data-dismiss="modal">Fermer</button>
			</div>
		</div>
	  </div>
	</div>
<!-- Fin : Moad Error -->
<!-- Début : Moad Confirmation -->
<div id="modalConfirm" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-dialog-centered modal-confirm " role="document">
		<div class="modal-content">
		  <div class="modal-header">
				<div class="icon-box bg-warning">
					<i class="material-icons fa fa-exclamation-triangle"></i>
				</div>				
				<h4 class="modal-title text-center">Supprimer ?</h4>	
		  </div>
		  <div class="modal-body">
				<p class="text-center">
					Etes vous sûre de vouloir supprimer cet enregistrement ?
				</p>
		  </div>
		  <div class="modal-footer">
		    <button type="button" data-dismiss="modal" class="btn btn-warning  mr-auto" id="delete">Supprimer</button>
		    <button type="button" data-dismiss="modal" class="btn btn-secondary  ">Annuler</button>
		  </div>
		 </div>
  	</div>
</div>
<!-- Fin : Moad Confirmation-->
<!-- Début : Moad Loading Ajax -->
<div id="loading-image" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered modal-sm" >
        <div class="modal-content" style="width: 48px; color:orange;">
            <span class="fa fa-spinner fa-spin fa-3x"></span>
        </div>
    </div>
</div>
<!-- Fin : Moad Loading Ajax -->

	<script src="${pageContext.request.contextPath}/js/jquery.min.js" ></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js" ></script>
	
	<script src="${pageContext.request.contextPath}/js/popper.js" type="text/javascript"></script>
	
	
	<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>
    
    
    <script src="${pageContext.request.contextPath}/js/dataTables.buttons.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/buttons.flash.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jszip.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/pdfmake.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/vfs_fonts.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/buttons.html5.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/buttons.print.min.js" type="text/javascript"></script>
    
    
  	<script type="text/javascript">
  	
  	$(document).ready(function() {
  		/**************** Début : Ajax Load Animation *************************/
  		$(document).ajaxStart(function(){
  			$('#loading-image').show();
		 });
  		$(document).ajaxStop(function(){
  			$('#loading-image').hide();
		 });
		/*******************Fin : Ajax Load Animation *************************/
		  			
 		/************** DataTable du Tab : Niveaux **************/
  		// Initialisation du DataTable Niveaux
  		$('#data_table_niveaux').DataTable(
  			{	
  				"paging": true,
  				"autoWidth": true,
  				"columnDefs": [
  					{ "orderable": false, "targets": 3 }
  				],
  				dom: 'Bfrtip',
  		        buttons: [
  		            'copy', 
  		            'csv', 
  		            'excel', 
  		            'pdf', 
  		            'print'
  		        ]
  			}
  		);
  		/******* fonction pour charger la liste des Niveaux dans la TableData Niveaux ******/
		function populateNiveauDataTable(){
			var tableData = $('#data_table_niveaux').DataTable();
			//tableData.DataTable().rows().remove().draw();		// Vider la TableData 
			$.ajax({
				url : "../Niveau/List",
				type: "GET",
				dataType: 'json',
				success: function(response,textStatus ,jqXHR){
					for(i=0;i<response.length;i++){
						var rang =i+1;
						var btns='<div class="btn-group dropleft"> \
							  <button type="button" class="btn btn-outline-info btn-sm" title="Actions"><span class="fa fa-ellipsis-h"></span></button> \
							  <button type="button" class="btn btn-outline-info btn-sm dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> \
							    <span class="sr-only">Toggle Dropdown</span> \
							  </button> \
							  <div class="dropdown-menu shadow p-3 mb-5 bg-white rounded" id="dropdownCycle"> \
							    <div class="bg-info text-white px-3 py-1"><span class="fa fa-ellipsis-h mr-4"></span> Actions</div> \
						        <div class="dropdown-divider"></div> \
							  	<a class="dropdown-item niveau-details text-primary" href="#" niveauId="'+response[i].id+'"><span class="fa fa-info-circle mr-4"></span>Détails</a> \
							  	<a class="dropdown-item niveau-update text-primary" href="#" niveauId="'+response[i].id+'"><span class="fa fa-pen mr-4"></span>Modifier</a> \
							  	<a class="dropdown-item niveau-delete text-primary" href="#" niveauId="'+response[i].id+'"><span class="fa fa-trash mr-4"></span>Supprimer</a> \
							  </div> \
							</div> ';
						tableData.row.add( [
						             rang,
						             response[i].code,
						             response[i].nom_Fr,
						             btns
						         ] ).draw( false );
					}
			    },
			    error: function(response,textStatus ,jqXHR){
			    	$("#modalError .modal-body p").html("");
					$("#modalError .modal-body p").html(jqXHR.responseText);
			   		$('#modalError .modal-body p').modal('show'); 
			        }
			});
		};
		//Chargement des Niveaux dans le DataTable Niveaux
		populateNiveauDataTable();
		
		/********** Ajouter un nouveau Niveau **********************/
		//Effacer dabord le formulaire
		$('#niveau_Add_Modal').on('shown.bs.modal', function(evt){
			$('#niveau_Add_Form').trigger('reset');
		});
		//Envoyer le formulaire via ajax
		$("#niveau_Add_Form").submit(function(event){ 
			var post_url = $(this).attr("action"); 			//Lire l'action (URL) du formulaire
			var request_method = $(this).attr("method"); 	//Lire la méthode du formulaire  GET/POST 
			var form_data = $(this).serialize(); 			//Encoder les données du formulaire pour envoie
			$('#niveau_Add_Modal').modal('hide');			//Fermer la fenetre modal apres envoie du formulaire
			$.ajax({
				url : post_url,
				type: request_method,
				data : form_data,
				dataType: 'json',
				contentType: "application/x-www-form-urlencoded;charset=UTF-8",
				success: function(response,textStatus ,jqXHR){
					$("#modalSuccess .modal-body p").html("");
					$("#modalSuccess .modal-body p").html(response);
			   		$('#modalSuccess').modal('show');
			    	//setTimeout(function() { $('#modalSuccess').modal('hide'); }, 5000);
			    },
			    error: function(response,textStatus ,jqXHR){
		                  $("#modalError .modal-body p").html("");
					$("#modalError .modal-body p").html(jqXHR.responseText);
			   		$('#modalError').modal('show'); 
			        },
				complete: function (response,textStatus ,jqXHR) {
			    	
					//Effacer le DataTable Niveaux
					$('#data_table_niveaux').DataTable().rows().remove().draw();
		  			//Raffrichir le DataTable Niveaux
					populateNiveauDataTable();    
			    }
			});
			return false;
		});	
 			
 			/*********** Modification d'un Niveau ****************
 			/* 1 - Récuperer l' Id du Niveau séléctionner sur la DataTable Niveaux
 			/* 2 - Charger par ajax le Niveau concerné
 			/* 3 - Remplir les champs de formulaire de modification avec les données du Niveau concerné
 			/* 4 - Afficher le formulaire de modification
 			*****************************************************/
 			
 			$('#data_table_niveaux').on('click','.niveau-update', function(evt){
			$this = $(this);
			var id= $this.attr('niveauId');
			$.ajax({
				url : "../Niveau/Details?id="+id,
				type: "GET",
				dataType: 'json',
				contentType: "application/json; charset=UTF-8",
				success: function(response,textStatus ,jqXHR){
					$("#niveau_Update_Form input[name=id]").val(response.id);
					$("#niveau_Update_Form input[name=code]").val(response.code);
					$("#niveau_Update_Form input[name=nom_Fr]").val(response.nom_Fr);
					$("#niveau_Update_Form input[name=nom_Ar]").val(response.nom_Ar);
					$('#niveau_Update_Modal').modal('show');
			    },
			    error: function(response,textStatus ,jqXHR){
			    	$("#modalError .modal-body p").html("");
					$("#modalError .modal-body p").html(jqXHR.responseText);
			   		$('#modalError .modal-body p').modal('show'); 
			        }
			});
			
			return false;
		});
 			/* 5- Envoie du formulaire de modification */
 			
 			$("#niveau_Update_Form").submit(function(event){ 
			var post_url = $(this).attr("action"); 			//Lire l'action (URL) du formulaire
			var request_method = $(this).attr("method"); 	//Lire la méthode du formulaire  GET/POST 
			var form_data = $(this).serialize(); 			//Encoder les données du formulaire pour envoie
			$('#niveau_Update_Modal').modal('hide');			//Fermer la fenetre modal apres envoie du formulaire
			$.ajax({
				url : post_url,
				type: request_method,
				data : form_data,
				dataType: 'json',
				contentType: "application/x-www-form-urlencoded;charset=UTF-8",
				success: function(response,textStatus ,jqXHR){
					$("#modalSuccess .modal-body p").html("");
					$("#modalSuccess .modal-body p").html(response);
			   		$('#modalSuccess').modal('show');
			    	//setTimeout(function() { $('#modalSuccess').modal('hide'); }, 5000);
					
			    },
			    error: function(response,textStatus ,jqXHR){
                    $("#modalError .modal-body p").html("");
					$("#modalError .modal-body p").html(response);
			   		$('#modalError').modal('show'); 
			        },
			    complete: function (response,textStatus ,jqXHR) {
			    	
					//Effacer le DataTable Niveaux
					$('#data_table_niveaux').DataTable().rows().remove().draw();
		  			//Raffrichir le DataTable Niveaux
					populateNiveauDataTable();    
			    }   
			});
			return false;
		});	
 			/*********** Suppression d'un Niveau ****************
 			/* 1 - Récuperer l' Id du Niveau séléctionner sur la DataTable Niveaux
 			/* 2 - Supprimer par ajax le Niveau concerné
 			*****************************************************/
 			
 			$('#data_table_niveaux').on('click','.niveau-delete', function(evt){
			$this = $(this);
			var id= $this.attr('niveauId');
			$('#modalConfirm').modal('show');
			$('#modalConfirm').on('click', '#delete', function(e) {
				
					$.ajax({
						url : "../Niveau/Delete?id="+id,
						type: "GET",
						dataType: 'json',
						success: function(response,textStatus ,jqXHR){
							$("#modalSuccess .modal-body p").html("");
							$("#modalSuccess .modal-body p").html(response);
					   		$('#modalSuccess').modal('show');
					    	//setTimeout(function() { $('#modalSuccess').modal('hide'); }, 5000);
					    	
					    },
					    error: function(response,textStatus ,jqXHR){
					    	$("#modalError .modal-body p").html("");
							$("#modalError .modal-body p").html(jqXHR.responseText);
					   		$('#modalError').modal('show'); 
					    },
					    complete: function (response,textStatus ,jqXHR) {
					    	
							//Effacer le DataTable Niveaux
							$('#data_table_niveaux').DataTable().rows().remove().draw();
				  			//Raffrichir le DataTable Niveaux
							populateNiveauDataTable();    
					    }
					});
			  });
			
			
			return false;
		});
 			
 			/*********** Affichage des détails d'un Niveau ****************
 			/* 1 - Récuperer l' Id du Niveau séléctionné sur la DataTable Niveaux
 			/* 2 - Charger par ajax le Niveau concerné
 			/* 3 - Afficher les détails du Niveau concerné 
 			*****************************************************/
 			
 			$('#data_table_niveaux').on('click','.niveau-details', function(evt){
			$this = $(this);
			var id= $this.attr('niveauId');
			$.ajax({
				url : "../Niveau/Details?id="+id,
				type: "GET",
				dataType: 'json',
				contentType: "application/json; charset=UTF-8",
				success: function(response,textStatus ,jqXHR){
					var codeItem ='<li class="list-group-item"><span><strong>Code  </strong></span><span class="float-right">'+response.code+'</span></li>';
					var nom_FrItem ='<li class="list-group-item"><span><strong>Nom du niveau  </strong></span><span class="float-right">'+response.nom_Fr+'</span></li>';
					var nom_ArItem ='<li class="list-group-item"><span><strong>إسم المستوى  </strong></span><span class="float-right" dir="rtl">'+response.nom_Ar+'</span></li>';
					$("#niveau_Details_Modal .list-group").html("");
					$("#niveau_Details_Modal .list-group").append(codeItem);
					$("#niveau_Details_Modal .list-group").append(nom_FrItem);
					$("#niveau_Details_Modal .list-group").append(nom_ArItem);
					$('#niveau_Details_Modal').modal('show');
			    },
			    error: function(response,textStatus ,jqXHR){
			    	$("#modalError .modal-body p").html("");
					$("#modalError .modal-body p").html(jqXHR.responseText);
			   		$('#modalError .modal-body p').modal('show'); 
			        }
			});
			
			return false;
		});
 		
  	});
    </script>
   
</body>
</html>