
sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"afreed/util/service",
	"sap/m/MessageBox"],function(Controller,service,MessageBox){
	return Controller.extend("afreed.controller.Main",{
		onInit : function(){
			var oJModel = new sap.ui.model.json.JSONModel();
			oJModel.setData({
				"postPayload" : {
					"companyName": "",
					"firstName": "",
					"lastName": "",
					"email": "",
					"website": "",
					"status": "A"
				},
				"vendor" : {}
				
			});
		this.getView().setModel(oJModel);
			
		},
		onPress : function(){
			//alert("todo : we will call a microservice to load data");
			var that=this;
			service.callService("/newVendor","GET",{}).then(function(data){
				//console.log(data);
					var oTable=that.getView().byId("idTable");
					var oModel = that.getView().getModel();
					oModel.setProperty("/vendor",data._embedded.vendor);
					//var oJModel = new sap.ui.model.json.JSONModel();
					//oJModel.setData(data._embedded);
					//oJModel.setData(data._embedded);
					//that.getView().setModel(oJModel);
			}).catch(function(){
				
			});
			
			
			/* jQuery.ajax("/newVendor",{
				type : "GET",
				success : function(data){
					//console.log(data);
					var oTable=that.getView().byId("idTable");
					var oJModel = new sap.ui.model.json.JSONModel();
					//oJModel.setData(data._embedded);
					oJModel.setData(data._embedded);
					that.getView().setModel(oJModel);
					
				},
				error : function(err){
					
				}
			});*/
		},
		onSave : function(){
			var oModel = this.getView().getModel();
			var payload = oModel.getProperty("/postPayload");
			service.callService("/newVendor","POST",payload).then(function(){
				MessageBox.confirm("Saved Successfully");
			}).catch(function(){
				MessageBox.error("Not Saved");
			});
		}
	}
	)
});


